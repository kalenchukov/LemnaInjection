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
import dev.kalenchukov.lemna.injection.exceptions.IllegalValueException;
import dev.kalenchukov.lemna.injection.exceptions.InvalidConverterException;
import dev.kalenchukov.lemna.injection.supports.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link Injection} с объектами собственного типа.
 *
 * @author Алексей Каленчуков
 */
public class InjectionInSelfTypeTest
{
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в тип данных {@code Gender}.
	 */
	@Test()
	public void injectionSelfType()
	{
		class Experimental
		{
			@Converter(converter = SingleGenderConverter.class)
			public Gender variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("M"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(Gender.M, experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в тип данных свой тип данных.
	 */
	@Test()
	public void injectionSelfTypeArrayFromNull()
	{
		class Experimental
		{
			@Converter(converter = SingleGenderConverter.class)
			public Gender variable;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", values);

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertNull(experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с использованием неподходящего собственного конвертера типа данных.
	 */
	@Test
	public void injectionSelfNegativeConverter()
	{
		class Experimental
		{
			@Converter(converter = SingleGenderConverter.class)
			public Gender[] variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("M", "F"));

		Experimental experimental = new Experimental();

		assertThrows(InvalidConverterException.class, () -> {
			Injectable injector = new Injection(experimental);
			injector.inject(value);
		});
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в тип данных {@code Gender[]}.
	 */
	@Test
	public void injectionSelfArrayType()
	{
		class Experimental
		{
			@Converter(converter = ArrayOfGenderConverter.class)
			public Gender[] variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertArrayEquals(new Gender[]{Gender.M, Gender.F}, experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в {@code Array} из своего типа данных.
	 */
	@Test
	public void injectionSelfArrayTypeNull()
	{
		class Experimental
		{
			@Converter(converter = ArrayOfGenderConverter.class)
			public Gender[] variable;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", values);

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertArrayEquals(new Gender[]{null}, experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением своего типа данных в {@code Collection}.
	 */
	@Test
	public void injectionSelfTypeInCollection()
	{
		class Experimental
		{
			@Converter(converter = CollectionOfGenderConverter.class)
			public Collection<Gender> variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(List.of(new Gender[]{Gender.M, Gender.F}), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением своего типа данных в {@code List}.
	 */
	@Test
	public void injectionSelfTypeInList()
	{
		class Experimental
		{
			@Converter(converter = ListOfGenderConverter.class)
			public List<Gender> variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(List.of(new Gender[]{Gender.M, Gender.F}), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в {@code List} из своего типа данных.
	 */
	@Test
	public void injectionSelfTypeInListNull()
	{
		class Experimental
		{
			@Converter(converter = ListOfGenderConverter.class)
			public List<Gender> variable;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", values);

		Experimental experimental = new Experimental();

		assertThrows(IllegalValueException.class, () -> {
			Injectable injector = new Injection(experimental);
			injector.inject(value);
		});
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением своего типа данных в {@code Set}.
	 */
	@Test
	public void injectionSelfTypeInSet()
	{
		class Experimental
		{
			@Converter(converter = SetOfGenderConverter.class)
			public Set<Gender> variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(Set.of(new Gender[]{Gender.M, Gender.F}), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением дублирующих значений своего типа данных в {@code Set}.
	 */
	@Test
	public void injectionSelfTypeInSetFromDuplicate()
	{
		class Experimental
		{
			@Converter(converter = SetOfGenderConverter.class)
			public Set<Gender> variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("F", "F"));

		Experimental experimental = new Experimental();

		assertThrows(IllegalValueException.class, () -> {
			Injectable injector = new Injection(experimental);
			injector.inject(value);
		});
	}
}