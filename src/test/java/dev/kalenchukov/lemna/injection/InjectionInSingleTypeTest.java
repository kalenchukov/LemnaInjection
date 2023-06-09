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

/**
 * Класс проверки методов класса {@link Injection} со стандартными одиночными типами объектов.
 *
 * @author Алексей Каленчуков
 */
public class InjectionInSingleTypeTest
{
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Integer}.
	 */
	@Test
	public void injectionIntegerType()
	{
		class Experimental
		{
			public Integer variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("1"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(Integer.valueOf(1), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Short}.
	 */
	@Test
	public void injectionShortType()
	{
		class Experimental
		{
			public Short variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("2"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(Short.valueOf((short) 2), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Float}.
	 */
	@Test
	public void injectionFloatType()
	{
		class Experimental
		{
			public Float variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("3.0"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(Float.valueOf(3.0F), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Double}.
	 */
	@Test
	public void injectionDoubleType()
	{
		class Experimental
		{
			public Double variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("4.59"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(Double.valueOf(4.59), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Long}.
	 */
	@Test
	public void injectionLongType()
	{
		class Experimental
		{
			public Long variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("1698756"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(Long.valueOf(1698756L), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code String}.
	 */
	@Test
	public void injectionStringType()
	{
		class Experimental
		{
			public String variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("text"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals("text", experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Character}.
	 */
	@Test
	public void injectionCharacterType()
	{
		class Experimental
		{
			public Character variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("A"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(Character.valueOf('A'), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Boolean}.
	 */
	@Test
	public void injectionBooleanType()
	{
		class Experimental
		{
			public Boolean variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("true"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(true, experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Byte}.
	 */
	@Test
	public void injectionByteType()
	{
		class Experimental
		{
			public Byte variable;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("variable", List.of("27"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertEquals(Byte.valueOf((byte) 27), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в одиночный тип данных.
	 */
	@Test
	public void injectionNull()
	{
		class Experimental
		{
			public Integer variable;
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
}