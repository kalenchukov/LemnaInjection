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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
	public void injectWithSelfType()
	{
		class Experimental
		{
			@Converter(converter = SingleGenderConverter.class)
			public Gender field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("M"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Gender.M);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в тип данных свой тип данных.
	 */
	@Test()
	public void injectWithSelfTypeArrayFromNull()
	{
		class Experimental
		{
			@Converter(converter = SingleGenderConverter.class)
			public Gender field;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", values);

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isNull();
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с использованием неподходящего собственного конвертера типа данных.
	 */
	@Test
	public void injectWithSelfNegativeConverter()
	{
		class Experimental
		{
			@Converter(converter = SingleGenderConverter.class)
			public Gender[] field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("M", "F"));

		Experimental experimental = new Experimental();

		assertThatExceptionOfType(InvalidConverterException.class).isThrownBy(() -> {
			Injectable injector = new Injection(experimental);
			injector.inject(value);
		});
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в тип данных {@code Gender[]}.
	 */
	@Test
	public void injectWithSelfArrayType()
	{
		class Experimental
		{
			@Converter(converter = ArrayOfGenderConverter.class)
			public Gender[] field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("M", "F"));
		Gender[] expected = new Gender[] {Gender.M, Gender.F};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в {@code Array} из своего типа данных.
	 */
	@Test
	public void injectWithSelfArrayTypeNull()
	{
		class Experimental
		{
			@Converter(converter = ArrayOfGenderConverter.class)
			public Gender[] field;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", values);
		Gender[] expected = new Gender[] {null};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением своего типа данных в {@code Collection}.
	 */
	@Test
	public void injectWithSelfTypeInCollection()
	{
		class Experimental
		{
			@Converter(converter = CollectionOfGenderConverter.class)
			public Collection<Gender> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new Gender[]{Gender.M, Gender.F}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением своего типа данных в {@code List}.
	 */
	@Test
	public void injectWithSelfTypeInList()
	{
		class Experimental
		{
			@Converter(converter = ListOfGenderConverter.class)
			public List<Gender> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new Gender[]{Gender.M, Gender.F}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в {@code List} из своего типа данных.
	 */
	@Test
	public void injectWithSelfTypeInListNull()
	{
		class Experimental
		{
			@Converter(converter = ListOfGenderConverter.class)
			public List<Gender> field;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", values);

		Experimental experimental = new Experimental();

		assertThatExceptionOfType(IllegalValueException.class).isThrownBy(() -> {
			Injectable injector = new Injection(experimental);
			injector.inject(value);
		});
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением своего типа данных в {@code Set}.
	 */
	@Test
	public void injectWithSelfTypeInSet()
	{
		class Experimental
		{
			@Converter(converter = SetOfGenderConverter.class)
			public Set<Gender> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("M", "F"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Set.of(new Gender[]{Gender.M, Gender.F}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением дублирующих значений своего типа данных в {@code Set}.
	 */
	@Test
	public void injectWithSelfTypeInSetFromDuplicate()
	{
		class Experimental
		{
			@Converter(converter = SetOfGenderConverter.class)
			public Set<Gender> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("F", "F"));

		Experimental experimental = new Experimental();

		assertThatExceptionOfType(IllegalValueException.class).isThrownBy(() -> {
			Injectable injector = new Injection(experimental);
			injector.inject(value);
		});
	}
}