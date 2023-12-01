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

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс проверки методов класса {@link Injection} с объектами типа {@code Array}.
 *
 * @author Алексей Каленчуков
 */
public class InjectionInArrayTypeTest
{
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Integer[]}.
	 */
	@Test
	public void injectWithArrayIntegerType()
	{
		class Experimental
		{
			public Integer[] field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("1", "11"));
		Integer[] expected = new Integer[] {1, 11};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Short[]}.
	 */
	@Test
	public void injectWithArrayShortType()
	{
		class Experimental
		{
			public Short[] field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("2", "22"));
		Short[] expected = new Short[] {2, 22};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Float[]}.
	 */
	@Test
	public void injectWithArrayFloatType()
	{
		class Experimental
		{
			public Float[] field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("3.0", "3.30"));
		Float[] expected = new Float[] {3.0F, 3.30F};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Double[]}.
	 */
	@Test
	public void injectWithArrayDoubleType()
	{
		class Experimental
		{
			public Double[] field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("4.59", "59.40"));
		Double[] expected = new Double[] {4.59, 59.40};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Long[]}.
	 */
	@Test
	public void injectWithArrayLongType()
	{
		class Experimental
		{
			public Long[] field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("1698756", "345345346"));
		Long[] expected = new Long[] {1698756L, 345345346L};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code String[]}.
	 */
	@Test
	public void injectWithArrayStringType()
	{
		class Experimental
		{
			public String[] field;
		}

		Map<String, List<String>> value = new HashMap<>();;
		value.put("field", List.of("text", "TEXT"));
		String[] expected = new String[] {"text", "TEXT"};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Character[]}.
	 */
	@Test
	public void injectWithArrayCharacterType()
	{
		class Experimental
		{
			public Character[] field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("A", "B"));
		Character[] expected = new Character[] {'A', 'B'};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Boolean[]}.
	 */
	@Test
	public void injectWithArrayBooleanType()
	{
		class Experimental
		{
			public Boolean[] field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("true", "false"));
		Boolean[] expected = new Boolean[] {true, false};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Byte[]}.
	 */
	@Test
	public void injectWithArrayByteType()
	{
		class Experimental
		{
			public Byte[] field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("27", "45"));
		Byte[] expected = new Byte[] {27, 45};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в {@code Array}.
	 */
	@Test
	public void injectWithArrayTypeNull()
	{
		class Experimental
		{
			public Integer[] field;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", values);
		Integer[] expected = new Integer[] {null};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением дублирующих значений в {@code Array}.
	 */
	@Test
	public void injectWithArrayTypeDuplicate()
	{
		class Experimental
		{
			public Integer[] field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("10", "10"));
		Integer[] expected = new Integer[] {10, 10};

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).containsSequence(expected);
	}
}