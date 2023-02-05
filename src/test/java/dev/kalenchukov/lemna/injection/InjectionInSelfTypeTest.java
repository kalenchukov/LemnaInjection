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
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class InjectionInSelfTypeTest
{
	/**
	 * Проверка внедрения в тип данных {@code Gender}.
	 */
	@Test()
	public void testInjectionSelfType()
	{
		class Experimental
		{
			@Converter(converter = SingleGenderConverter.class)
			public Gender variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("M"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Gender.M, experimental.variable);
	}

	/**
	 * Проверка внедрения {@code null} в тип данных {@code Gender}.
	 */
	@Test()
	public void testInjectionSelfTypeArrayFromNull()
	{
		class Experimental
		{
			@Converter(converter = SingleGenderConverter.class)
			public Gender variable;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", values);

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertNull(experimental.variable);
	}

	/**
	 * Проверка использования неподходящего собственного конвертера типа данных.
	 */
	@Test(expected = InvalidConverterException.class)
	public void testInjectionSelfNegativeConverter()
	{
		class Experimental
		{
			@Converter(converter = SingleGenderConverter.class)
			public Gender[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);
	}

	/**
	 * Проверка внедрения в тип данных {@code Gender[]}.
	 */
	@Test
	public void testInjectionSelfArrayType()
	{
		class Experimental
		{
			@Converter(converter = ArrayOfGenderConverter.class)
			public Gender[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Gender[]{Gender.M, Gender.F}, experimental.variable);
	}

	/**
	 * Проверка внедрения {@code null} в массив из своего типа данных {@code Gender}.
	 */
	@Test
	public void testInjectionSelfArrayTypeNull()
	{
		class Experimental
		{
			@Converter(converter = ArrayOfGenderConverter.class)
			public Gender[] variable;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", values);

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Gender[]{null}, experimental.variable);
	}

	/**
	 * Проверка внедрения своего типа данных {@code Gender} в коллекцию {@code Collection}.
	 */
	@Test
	public void testInjectionSelfTypeInCollection()
	{
		class Experimental
		{
			@Converter(converter = CollectionOfGenderConverter.class)
			public Collection<Gender> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Gender[]{Gender.M, Gender.F}), experimental.variable);
	}

	/**
	 * Проверка внедрения своего типа данных {@code Gender} в коллекцию {@code List}.
	 */
	@Test
	public void testInjectionSelfTypeInList()
	{
		class Experimental
		{
			@Converter(converter = ListOfGenderConverter.class)
			public List<Gender> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Gender[]{Gender.M, Gender.F}), experimental.variable);
	}

	/**
	 * Проверка внедрения {@code null} в коллекцию {@code List} из своего типа данных {@code Gender}.
	 */
	@Test(expected = IllegalValueException.class)
	public void testInjectionSelfTypeInListNull()
	{
		class Experimental
		{
			@Converter(converter = ListOfGenderConverter.class)
			public List<Gender> variable;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", values);

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);
	}

	/**
	 * Проверка внедрения своего типа данных {@code Gender} в коллекцию {@code Set}.
	 */
	@Test
	public void testInjectionSelfTypeInSet()
	{
		class Experimental
		{
			@Converter(converter = SetOfGenderConverter.class)
			public Set<Gender> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Set.of(new Gender[]{Gender.M, Gender.F}), experimental.variable);
	}

	/**
	 * Проверка внедрения дублирующих значений {@code Gender} в коллекцию {@code Set}.
	 */
	@Test(expected = IllegalValueException.class)
	public void testInjectionSelfTypeInSetFromDuplicate()
	{
		class Experimental
		{
			@Converter(converter = SetOfGenderConverter.class)
			public Set<Gender> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("F", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);
	}
}