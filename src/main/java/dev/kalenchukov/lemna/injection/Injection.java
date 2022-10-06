/*
 * Copyright 2022 Алексей Каленчуков
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
import dev.kalenchukov.lemna.injection.converters.ConverterRepository;
import dev.kalenchukov.lemna.injection.exceptions.IllegalValueException;
import dev.kalenchukov.lemna.injection.exceptions.InvalidConverterException;
import dev.kalenchukov.lemna.injection.exceptions.UnknownConverterException;
import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.notation.converting.NotationConverter;
import dev.kalenchukov.notation.converting.resources.NotationType;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Внедряет данные в поля класса.
 */
public class Injection implements Injectable
{
	/**
	 * Локализация.
	 */
	@NotNull
	private Locale locale = new Locale("ru", "RU");

	/**
	 * Тип нотации названий полей класса в данных.
	 */
	@NotNull
	private NotationType notationType = NotationType.CAMEL_CASE;

	/**
	 * Объект класса в который необходимо внедрять данные.
	 */
	@NotNull
	private final Object object;

	/**
	 * Репозиторий конвертеров типов данных.
	 */
	@NotNull
	private final ConverterRepository converterRepository = new ConverterRepository();

	/**
	 * Логгер для данного класса.
	 */
	@NotNull
	private static final Logger LOG = Logger.getLogger(Injection.class);

	/**
	 * Локализованные тексты логирования.
	 */
	@NotNull
	private ResourceBundle localeLogs = ResourceBundle.getBundle(
		"lemna/injection/localizations/logs",
		locale
	);

	/**
	 * Локализованные тексты исключений.
	 */
	@NotNull
	private ResourceBundle localeExceptions = ResourceBundle.getBundle(
		"lemna/injection/localizations/exceptions",
		locale
	);

	/**
	 * Конструктор для {@code Injection}.
	 *
	 * @param object Объект класса в который необходимо внедрить данные.
	 */
	public Injection(@NotNull final Object object)
	{
		Objects.requireNonNull(object);

		this.object = object;
	}

	/**
	 * @see Injectable#setLocale(Locale)
	 */
	public void setLocale(@NotNull Locale locale)
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
	 * @see Injectable#setNotationType(NotationType)
	 */
	@Override
	public void setNotationType(@NotNull final NotationType notationType)
	{
		Objects.requireNonNull(notationType);

		this.notationType = notationType;
	}

	/**
	 * @see Injectable#getNotationType()
	 */
	@NotNull
	@Override
	public NotationType getNotationType()
	{
		return this.notationType;
	}

	/**
	 * @see Injectable#inject(Map)
	 */
	@Override
	public void inject(@NotNull final Map<@NotNull String, @Nullable String @Nullable []> data)
		throws IllegalValueException, UnknownConverterException, InvalidConverterException
	{
		Objects.requireNonNull(data);

		LOG.debug(String.format(
			localeLogs.getString("60001"),
			this.object.getClass().getName()
		));

		if (data.size() > 0)
		{
			this.findPersonalConverters();

			for (Field field : this.object.getClass().getDeclaredFields())
			{
				final String[] value = data.get(
					NotationConverter.to(field.getName(), this.notationType)
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
	 * @param field Поле класса в которое необходимо внедрить значение.
	 * @param value Коллекция значений которые необходимо внедрить в поле класса.
	 *
	 * @throws IllegalValueException Если передано некорректное значение для внедрения в данное поле класса.
	 * @throws UnknownConverterException Если для типа поля не реализован персональный конвертер.
	 * @throws InvalidConverterException Если конвертер некорректный.
	 */
	private void injectValueField(@NotNull final Field field, @Nullable final String @Nullable [] value)
		throws IllegalValueException, UnknownConverterException, InvalidConverterException
	{
		Objects.requireNonNull(field);
		Objects.requireNonNull(value);

		final boolean has = this.converterRepository.getConverters().containsKey(
			field.getGenericType().getTypeName()
		);

		if (!has) {
			throw new UnknownConverterException(String.format(
				localeExceptions.getString("70002"),
				field.getGenericType().getTypeName(),
				this.object.getClass().getName()
			));
		}

		Class<? extends Converting<?>> converter = this.converterRepository.getConverters().get(
			field.getGenericType().getTypeName()
		);

		try
		{
			Method method = converter.getDeclaredMethod("convert", String[].class);

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
	private void findPersonalConverters()
	{
		for (Field field : this.object.getClass().getDeclaredFields())
		{
			final Converter[] annotationsConverter = field.getAnnotationsByType(Converter.class);

			if (annotationsConverter.length == 0) {
				return;
			}

			for (Converter annotationConverter : annotationsConverter)
			{
				this.converterRepository.addConverter(
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
	}
}
