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

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class InjectionInSingleTypeTest
{
	/**
	 * Проверка внедрения в одиночный тип данных {@code Integer}.
	 */
	@Test
	public void testInjectionIntegerType()
	{
		class Experimental
		{
			public Integer variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("1"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Integer.valueOf(1), experimental.variable);
	}

	/**
	 * Проверка внедрения в одиночный тип данных {@code Short}.
	 */
	@Test
	public void testInjectionShortType()
	{
		class Experimental
		{
			public Short variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("2"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Short.valueOf((short) 2), experimental.variable);
	}

	/**
	 * Проверка внедрения в одиночный тип данных {@code Float}.
	 */
	@Test
	public void testInjectionFloatType()
	{
		class Experimental
		{
			public Float variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("3.0"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Float.valueOf(3.0F), experimental.variable);
	}
	
	/**
	 * Проверка внедрения в одиночный тип данных {@code Double}.
	 */
	@Test
	public void testInjectionDoubleType()
	{
		class Experimental
		{
			public Double variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("4.59"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Double.valueOf(4.59), experimental.variable);
	}

	/**
	 * Проверка внедрения в одиночный тип данных {@code Long}.
	 */
	@Test
	public void testInjectionLongType()
	{
		class Experimental
		{
			public Long variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("1698756"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Long.valueOf(1698756L), experimental.variable);
	}

	/**
	 * Проверка внедрения в одиночный тип данных {@code String}.
	 */
	@Test
	public void testInjectionStringType()
	{
		class Experimental
		{
			public String variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("text"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals("text", experimental.variable);
	}

	/**
	 * Проверка внедрения в одиночный тип данных {@code Character}.
	 */
	@Test
	public void testInjectionCharacterType()
	{
		class Experimental
		{
			public Character variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("A"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Character.valueOf('A'), experimental.variable);
	}

	/**
	 * Проверка внедрения в одиночный тип данных {@code Boolean}.
	 */
	@Test
	public void testInjectionBooleanType()
	{
		class Experimental
		{
			public Boolean variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("true"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(true, experimental.variable);
	}

	/**
	 * Проверка внедрения в одиночный тип данных {@code Byte}.
	 */
	@Test
	public void testInjectionByteType()
	{
		class Experimental
		{
			public Byte variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("27"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Byte.valueOf((byte) 27), experimental.variable);
	}

	/**
	 * Проверка внедрения {@code null} в одиночный тип данных.
	 */
	@Test
	public void testInjectionNull()
	{
		class Experimental
		{
			public Integer variable;
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
}