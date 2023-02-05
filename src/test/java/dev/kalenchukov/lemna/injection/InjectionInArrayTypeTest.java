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

import static org.junit.jupiter.api.Assertions.*;

public class InjectionInArrayTypeTest
{
	/**
	 * Проверка внедрения в массив одиночного типа данных {@code Integer[]}.
	 */
	@Test
	public void testInjectionArrayIntegerType()
	{
		class Experimental
		{
			public Integer[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("1", "11"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Integer[]{1, 11}, experimental.variable);
	}
	
	/**
	 * Проверка внедрения в массив одиночного типа данных {@code Short[]}.
	 */
	@Test
	public void testInjectionArrayShortType()
	{
		class Experimental
		{
			public Short[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("2", "22"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Short[]{2, 22}, experimental.variable);
	}

	/**
	 * Проверка внедрения в массив одиночного типа данных {@code Float[]}.
	 */
	@Test
	public void testInjectionArrayFloatType()
	{
		class Experimental
		{
			public Float[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("3.0", "3.30"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Float[]{3.0F, 3.30F}, experimental.variable);
	}

	/**
	 * Проверка внедрения в массив одиночного типа данных {@code Double[]}.
	 */
	@Test
	public void testInjectionArrayDoubleType()
	{
		class Experimental
		{
			public Double[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("4.59", "59.40"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Double[]{4.59, 59.40}, experimental.variable);
	}

	/**
	 * Проверка внедрения в массив одиночного типа данных {@code Long[]}.
	 */
	@Test
	public void testInjectionArrayLongType()
	{
		class Experimental
		{
			public Long[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("1698756", "345345346"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Long[]{1698756L, 345345346L}, experimental.variable);
	}

	/**
	 * Проверка внедрения в массив одиночного типа данных {@code String[]}.
	 */
	@Test
	public void testInjectionArrayStringType()
	{
		class Experimental
		{
			public String[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();;
		data.put("variable", List.of("text", "TEXT"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new String[] {"text", "TEXT"}, experimental.variable);
	}

	/**
	 * Проверка внедрения в массив одиночного типа данных {@code Character[]}.
	 */
	@Test
	public void testInjectionArrayCharacterType()
	{
		class Experimental
		{
			public Character[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("A", "B"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Character[]{'A', 'B'}, experimental.variable);
	}

	/**
	 * Проверка внедрения в массив одиночного типа данных {@code Boolean[]}.
	 */
	@Test
	public void testInjectionArrayBooleanType()
	{
		class Experimental
		{
			public Boolean[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("true", "false"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Boolean[]{true, false}, experimental.variable);
	}

	/**
	 * Проверка внедрения в массив одиночного типа данных {@code Byte[]}.
	 */
	@Test
	public void testInjectionArrayByteType()
	{
		class Experimental
		{
			public Byte[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("27", "45"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Byte[]{27, 45}, experimental.variable);
	}

	/**
	 * Проверка внедрения {@code null} в массив одиночного типа данных.
	 */
	@Test
	public void testInjectionArrayTypeNull()
	{
		class Experimental
		{
			public Integer[] variable;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", values);

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Integer[]{null}, experimental.variable);
	}

	/**
	 * Проверка внедрения дублирующих значений в массив одиночного типа данных.
	 */
	@Test
	public void testInjectionArrayTypeDuplicate()
	{
		class Experimental
		{
			public Integer[] variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("10", "10"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertArrayEquals(new Integer[]{10, 10}, experimental.variable);
	}
}