/*
 * Copyright © 2022-2023 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.kalenchukov.lemna.injection;

import dev.kalenchukov.lemna.injection.annotations.Converter;
import dev.kalenchukov.lemna.injection.repositories.ConverterRepository;
import dev.kalenchukov.lemna.injection.exceptions.IllegalValueException;
import dev.kalenchukov.lemna.injection.exceptions.InvalidConverterException;
import dev.kalenchukov.lemna.injection.exceptions.UnknownConverterException;
import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.notation.Notations;
import dev.kalenchukov.notation.types.NotationType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Внедряет данные в поля класса.
 *
 * @author Алексей Каленчуков
 */
public class Injection implements Injectable
{
	/**
	 * Локализация.
	 */
	@NotNull
	private Locale locale;

	/**
	 * Тип нотации названий полей класса в данных.
	 */
	@NotNull
	private NotationType notationType;

	/**
	 * Объект класса в который необходимо внедрять данные.
	 */
	@NotNull
	private final Object object;

	/**
	 * Репозиторий конвертеров типов данных.
	 */
	@NotNull
	private final ConverterRepository converterRepository;

	/**
	 * Локализованные тексты логирования.
	 */
	@NotNull
	private ResourceBundle localeLogs;

	/**
	 * Локализованные тексты исключений.
	 */
	@NotNull
	private ResourceBundle localeExceptions;

	/**
	 * Логгер для данного класса.
	 */
	@NotNull
	private static final Logger LOG = LogManager.getLogger(Injection.class);

	/**
	 * Конструктор для {@code Injection}.
	 *
	 * @param object объект класса в который необходимо внедрить данные.
	 * @throws NullPointerException если в качестве {@code object} передан {@code null}.
	 */
	public Injection(@NotNull final Object object)
	{
		Objects.requireNonNull(object);

		this.object = object;
		this.locale = new Locale("ru", "RU");
		this.notationType = NotationType.CAMEL_CASE;
		this.converterRepository = new ConverterRepository();
		this.localeLogs = ResourceBundle.getBundle(
			"lemna/injection/localizations/logs",
			this.locale
		);
		this.localeExceptions = ResourceBundle.getBundle(
			"lemna/injection/localizations/exceptions",
			this.locale
		);

		this.converterRepository.addConverters(
			this.findPersonalConverters()
		);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param locale {@inheritDoc}
	 * @throws NullPointerException если в качестве {@code locale} передан {@code null}.
	 */
	@Override
	public void setLocale(@NotNull final Locale locale)
	{
		Objects.requireNonNull(locale);

		if (!this.locale.equals(locale))
		{
			this.locale = locale;

			localeLogs = ResourceBundle.getBundle(
				"lemna/injection/localizations/logs",
				this.locale
			);

			localeExceptions = ResourceBundle.getBundle(
				"lemna/injection/localizations/exceptions",
				this.locale
			);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public Locale getLocale()
	{
		return this.locale;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param notationType {@inheritDoc}
	 * @throws NullPointerException если в качестве {@code notationType} передан {@code null}.
	 */
	@Override
	public void setNotationType(@NotNull final NotationType notationType)
	{
		Objects.requireNonNull(notationType);

		this.notationType = notationType;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public NotationType getNotationType()
	{
		return this.notationType;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param data {@inheritDoc}
	 * @throws NullPointerException если в качестве {@code data} передан {@code null}.
	 * @throws IllegalValueException {@inheritDoc}
	 * @throws UnknownConverterException {@inheritDoc}
	 * @throws InvalidConverterException {@inheritDoc}
	 */
	@Override
	public void inject(@NotNull final Map<@NotNull String, @Nullable List<@Nullable String>> data)
		throws IllegalValueException, UnknownConverterException, InvalidConverterException
	{
		Objects.requireNonNull(data);

		LOG.debug(String.format(
			localeLogs.getString("60001"),
			this.object.getClass().getName()
		));

		if (data.size() > 0)
		{
			for (Field field : this.object.getClass().getDeclaredFields())
			{
				final List<String> value = data.get(
					Notations.to(field.getName(), this.notationType)
				);

				if (value == null)
				{
					LOG.debug(String.format(
						localeLogs.getString("60003"),
						field.getName()
					));

					continue;
				}

				field.setAccessible(true);

				this.injectValueField(field, value);

				field.setAccessible(false);
			}
		}
		else
		{
			LOG.debug(String.format(
				localeLogs.getString("60006"),
				this.object.getClass().getName()
			));
		}

		LOG.debug(String.format(
			localeLogs.getString("60002"),
			this.object.getClass().getName()
		));
	}

	/**
	 * Внедряет значение в поле класса.
	 *
	 * @param field поле класса в которое необходимо внедрить значение.
	 * @param value коллекция значений которые необходимо внедрить в поле класса.
	 * @throws NullPointerException если в качестве {@code field} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code value} передан {@code null}.
	 * @throws IllegalValueException если передано некорректное {@code value} для внедрения в данное поле класса.
	 * @throws UnknownConverterException если для типа {@code field} не реализован персональный конвертер.
	 * @throws InvalidConverterException если конвертер некорректный.
	 */
	private void injectValueField(@NotNull final Field field, @Nullable final List<@Nullable String> value)
		throws IllegalValueException, UnknownConverterException, InvalidConverterException
	{
		Objects.requireNonNull(field);
		Objects.requireNonNull(value);

		Class<? extends Converting<?>> converter = this.converterRepository.getConverter(
			field.getGenericType().getTypeName()
		);

		if (converter == null) {
			throw new UnknownConverterException(String.format(
				localeExceptions.getString("70002"),
				field.getGenericType().getTypeName(),
				this.object.getClass().getName()
			));
		}

		try
		{
			Method method = converter.getDeclaredMethod("convert", List.class);

			field.set(
				this.object,
				method.invoke(
					converter.getConstructor().newInstance(),
					(Object) value
				)
			);
		}
		catch (InvocationTargetException exception)
		{
			throw new IllegalValueException(String.format(
				localeExceptions.getString("70001"),
				field.getName(),
				this.object.getClass().getName()
			));
		}
		catch (IllegalArgumentException | NoSuchMethodException |
			IllegalAccessException | InstantiationException exception)
		{
			throw new InvalidConverterException(String.format(
				localeExceptions.getString("70003"),
				converter.getName(),
				this.object.getClass().getName()
			));
		}

		LOG.debug(String.format(
			localeLogs.getString("60004"),
			field.getName()
		));
	}

	/**
	 * Ищет персональные конвертеры для типов данных.
	 */
	@NotNull
	private Map<@NotNull String, @NotNull Class<? extends Converting<?>>> findPersonalConverters()
	{
		LOG.debug(localeLogs.getString("60007"));

		Map<String, Class<? extends Converting<?>>> personalConverters = new HashMap<>();

		for (Field field : this.object.getClass().getDeclaredFields())
		{
			final Converter[] annotationsConverters = field.getAnnotationsByType(Converter.class);

			for (Converter annotationConverter : annotationsConverters)
			{
				personalConverters.putIfAbsent(
					field.getGenericType().getTypeName(),
					annotationConverter.converter()
				);

				LOG.debug(String.format(
					localeLogs.getString("60005"),
					annotationConverter.converter().getTypeName(),
					field.getGenericType().getTypeName()
				));
			}
		}

		LOG.debug(localeLogs.getString("60008"));

		return personalConverters;
	}
}
