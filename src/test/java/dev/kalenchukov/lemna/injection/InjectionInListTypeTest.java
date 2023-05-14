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

import dev.kalenchukov.lemna.injection.exceptions.IllegalValueException;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link Injection} с объектами типа {@code List}.
 *
 * @author Алексей Каленчуков
 */
public class InjectionInListTypeTest
{
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code List<Integer>}.
	 */
	@Test
	public void testInjectionListTypeFromInteger()
	{
		class Experimental
		{
			public List<Integer> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("1", "11"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Integer[]{1, 11}), experimental.variable);
	}
	
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code List<Short>}.
	 */
	@Test
	public void testInjectionListTypeFromShort()
	{
		class Experimental
		{
			public List<Short> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("2", "22"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Short[]{2, 22}), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code List<Float>}.
	 */
	@Test
	public void testInjectionListTypeFromFloat()
	{
		class Experimental
		{
			public List<Float> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("3.0", "3.30"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Float[]{3.0F, 3.30F}), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code List<Double>}.
	 */
	@Test
	public void testInjectionListTypeFromDouble()
	{
		class Experimental
		{
			public List<Double> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("4.59", "59.40"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Double[]{4.59, 59.40}), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code List<Long>}.
	 */
	@Test
	public void testInjectionListTypeFromLong()
	{
		class Experimental
		{
			public List<Long> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("1698756", "345345346"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Long[]{1698756L, 345345346L}), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code List<String>}.
	 */
	@Test
	public void testInjectionListTypeFromString()
	{
		class Experimental
		{
			public List<String> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("text", "TEXT"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new String[] {"text", "TEXT"}), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code List<Character>}.
	 */
	@Test
	public void testInjectionListTypeFromCharacter()
	{
		class Experimental
		{
			public List<Character> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("A", "B"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Character[]{'A', 'B'}), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code List<Boolean>}.
	 */
	@Test
	public void testInjectionListTypeFromBoolean()
	{
		class Experimental
		{
			public List<Boolean> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("true", "false"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Boolean[]{true, false}), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code List<Byte>}.
	 */
	@Test
	public void testInjectionListTypeFromByte()
	{
		class Experimental
		{
			public List<Byte> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("27", "45"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Byte[]{27, 45}), experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в {@code List}.
	 */
	@Test
	public void testInjectionListTypeNull()
	{
		class Experimental
		{
			public List<Integer> variable;
		}

		List<String> values = new ArrayList<>();
		values.add(null);

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", values);

		Experimental experimental = new Experimental();

		assertThrows(IllegalValueException.class, () -> {
			Injectable injector = new Injection(experimental);
			injector.inject(data);
		});
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением дублирующих значений в {@code List}.
	 */
	@Test
	public void testInjectionListTypeDuplicate()
	{
		class Experimental
		{
			public List<Integer> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("10", "10"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Integer[]{10, 10}), experimental.variable);
	}
}