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

package dev.kalenchukov.lemna.injection.converters;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.converters.arrays.*;
import dev.kalenchukov.lemna.injection.converters.collections.*;
import dev.kalenchukov.lemna.injection.converters.lists.*;
import dev.kalenchukov.lemna.injection.converters.sets.*;
import dev.kalenchukov.lemna.injection.converters.singles.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;

/**
 * Класс репозиторий всех конвертеров типа данных.
 */
public final class ConverterRepository
{
	/**
	 * Коллекция конвертеров типа данных.
	 */
	@NotNull
	private final Map<@NotNull String, @NotNull Class<? extends Converting<?>>> converters = new HashMap<>();

	/**
	 * Конструктор для {@code ConverterRepository}.
	 */
	public ConverterRepository()
	{
		this.addConvertersSimple();
		this.addConvertersArray();
		this.addConvertersCollection();
		this.addConvertersList();
		this.addConvertersSet();
	}

	/**
	 * Возвращает коллекцию конвертеров типа данных.
	 *
	 * @return Коллекцию конвертеров типа данных.
	 */
	@UnmodifiableView
	@NotNull
	public Map<@NotNull String, @NotNull Class<? extends Converting<?>>> getConverters()
	{
		return Collections.unmodifiableMap(this.converters);
	}

	/**
	 * Добавляет конвертер типа данных.
	 *
	 * @param forType Тип данных для которого используется конвертер.
	 * @param converter Класс конвертера типа данных.
	 */
	public void addConverter(@NotNull final String forType,
							 @NotNull final Class<? extends Converting<?>> converter)
	{
		Objects.requireNonNull(forType);
		Objects.requireNonNull(converter);

		if (!this.converters.containsKey(forType)) {
			this.converters.put(forType, converter);
		}
	}

	/**
	 * Добавляет конвертеры простых типов данных.
	 */
	private void addConvertersSimple()
	{
		this.addConverter(Short.class.getTypeName(), ShortConverter.class);
		this.addConverter(Integer.class.getTypeName(), IntegerConverter.class);
		this.addConverter(Long.class.getTypeName(), LongConverter.class);
		this.addConverter(String.class.getTypeName(), StringConverter.class);
		this.addConverter(Boolean.class.getTypeName(), BooleanConverter.class);
		this.addConverter(Float.class.getTypeName(), FloatConverter.class);
		this.addConverter(Double.class.getTypeName(), DoubleConverter.class);
		this.addConverter(Character.class.getTypeName(), CharacterConverter.class);
		this.addConverter(Byte.class.getTypeName(), ByteConverter.class);
	}

	/**
	 * Добавляет конвертеры типов данных в {@code Array}.
	 */
	private void addConvertersArray()
	{
		this.addConverter(Short[].class.getTypeName(), ArrayOfShortConverter.class);
		this.addConverter(Integer[].class.getTypeName(), ArrayOfIntegerConverter.class);
		this.addConverter(Long[].class.getTypeName(), ArrayOfLongConverter.class);
		this.addConverter(String[].class.getTypeName(), ArrayOfStringConverter.class);
		this.addConverter(Boolean[].class.getTypeName(), ArrayOfBooleanConverter.class);
		this.addConverter(Float[].class.getTypeName(), ArrayOfFloatConverter.class);
		this.addConverter(Double[].class.getTypeName(), ArrayOfDoubleConverter.class);
		this.addConverter(Character[].class.getTypeName(), ArrayOfCharacterConverter.class);
		this.addConverter(Byte[].class.getTypeName(), ArrayOfByteConverter.class);
	}

	/**
	 * Добавляет конвертеры типов данных в {@code Collection}.
	 */
	private void addConvertersCollection()
	{
		this.addConverter(Collection.class.getTypeName() + "<" + Short.class.getTypeName() + ">", CollectionShortConverter.class);
		this.addConverter(Collection.class.getTypeName() + "<" + Integer.class.getTypeName() + ">", CollectionIntegerConverter.class);
		this.addConverter(Collection.class.getTypeName() + "<" + Long.class.getTypeName() + ">", CollectionLongConverter.class);
		this.addConverter(Collection.class.getTypeName() + "<" + String.class.getTypeName() + ">", CollectionStringConverter.class);
		this.addConverter(Collection.class.getTypeName() + "<" + Boolean.class.getTypeName() + ">", CollectionBooleanConverter.class);
		this.addConverter(Collection.class.getTypeName() + "<" + Float.class.getTypeName() + ">", CollectionFloatConverter.class);
		this.addConverter(Collection.class.getTypeName() + "<" + Double.class.getTypeName() + ">", CollectionDoubleConverter.class);
		this.addConverter(Collection.class.getTypeName() + "<" + Character.class.getTypeName() + ">", CollectionCharacterConverter.class);
		this.addConverter(Collection.class.getTypeName() + "<" + Byte.class.getTypeName() + ">", CollectionByteConverter.class);
	}

	/**
	 * Добавляет конвертеры типов данных в {@code List}.
	 */
	private void addConvertersList()
	{
		this.addConverter(List.class.getTypeName() + "<" + Short.class.getTypeName() + ">", ListShortConverter.class);
		this.addConverter(List.class.getTypeName() + "<" + Integer.class.getTypeName() + ">", ListIntegerConverter.class);
		this.addConverter(List.class.getTypeName() + "<" + Long.class.getTypeName() + ">", ListLongConverter.class);
		this.addConverter(List.class.getTypeName() + "<" + String.class.getTypeName() + ">", ListStringConverter.class);
		this.addConverter(List.class.getTypeName() + "<" + Boolean.class.getTypeName() + ">", ListBooleanConverter.class);
		this.addConverter(List.class.getTypeName() + "<" + Float.class.getTypeName() + ">", ListFloatConverter.class);
		this.addConverter(List.class.getTypeName() + "<" + Double.class.getTypeName() + ">", ListDoubleConverter.class);
		this.addConverter(List.class.getTypeName() + "<" + Character.class.getTypeName() + ">", ListCharacterConverter.class);
		this.addConverter(List.class.getTypeName() + "<" + Byte.class.getTypeName() + ">", ListByteConverter.class);
	}

	/**
	 * Добавляет конвертеры типов данных в {@code Set}.
	 */
	private void addConvertersSet()
	{
		this.addConverter(Set.class.getTypeName() + "<" + Short.class.getTypeName() + ">", SetShortConverter.class);
		this.addConverter(Set.class.getTypeName() + "<" + Integer.class.getTypeName() + ">", SetIntegerConverter.class);
		this.addConverter(Set.class.getTypeName() + "<" + Long.class.getTypeName() + ">", SetLongConverter.class);
		this.addConverter(Set.class.getTypeName() + "<" + String.class.getTypeName() + ">", SetStringConverter.class);
		this.addConverter(Set.class.getTypeName() + "<" + Boolean.class.getTypeName() + ">", SetBooleanConverter.class);
		this.addConverter(Set.class.getTypeName() + "<" + Float.class.getTypeName() + ">", SetFloatConverter.class);
		this.addConverter(Set.class.getTypeName() + "<" + Double.class.getTypeName() + ">", SetDoubleConverter.class);
		this.addConverter(Set.class.getTypeName() + "<" + Character.class.getTypeName() + ">", SetCharacterConverter.class);
		this.addConverter(Set.class.getTypeName() + "<" + Byte.class.getTypeName() + ">", SetByteConverter.class);
	}
}
