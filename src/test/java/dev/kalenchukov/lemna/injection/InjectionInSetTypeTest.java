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

public class InjectionInSetTypeTest
{
	/**
	 * Проверка внедрения в {@code Set} из {@code Integer}.
	 */
	@Test
	public void testInjectionSetTypeFromInteger()
	{
		class Experimental
		{
			public Set<Integer> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("1", "11"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Set.of(new Integer[]{1, 11}), experimental.variable);
	}
	
	/**
	 * Проверка внедрения в {@code Set} из {@code Short}.
	 */
	@Test
	public void testInjectionSetTypeFromShort()
	{
		class Experimental
		{
			public Set<Short> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("2", "22"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Set.of(new Short[]{2, 22}), experimental.variable);
	}

	/**
	 * Проверка внедрения в {@code Set} из {@code Float}.
	 */
	@Test
	public void testInjectionSetTypeFromFloat()
	{
		class Experimental
		{
			public Set<Float> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("3.0", "3.30"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Set.of(new Float[]{3.0F, 3.30F}), experimental.variable);
	}

	/**
	 * Проверка внедрения в {@code Set} из {@code Double}.
	 */
	@Test
	public void testInjectionSetTypeFromDouble()
	{
		class Experimental
		{
			public Set<Double> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("4.59", "59.40"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Set.of(new Double[]{4.59, 59.40}), experimental.variable);
	}

	/**
	 * Проверка внедрения в {@code Set} из {@code Long}.
	 */
	@Test
	public void testInjectionSetTypeFromLong()
	{
		class Experimental
		{
			public Set<Long> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("1698756", "345345346"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Set.of(new Long[]{1698756L, 345345346L}), experimental.variable);
	}

	/**
	 * Проверка внедрения в {@code Set} из {@code String}.
	 */
	@Test
	public void testInjectionSetTypeFromString()
	{
		class Experimental
		{
			public Set<String> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("text", "TEXT"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Set.of(new String[] {"text", "TEXT"}), experimental.variable);
	}

	/**
	 * Проверка внедрения в {@code Set} из {@code Character}.
	 */
	@Test
	public void testInjectionSetTypeFromCharacter()
	{
		class Experimental
		{
			public Set<Character> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("A", "B"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Set.of(new Character[]{'A', 'B'}), experimental.variable);
	}

	/**
	 * Проверка внедрения в {@code Set} из {@code Boolean}.
	 */
	@Test
	public void testInjectionSetTypeFromBoolean()
	{
		class Experimental
		{
			public Set<Boolean> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("true", "false"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Set.of(new Boolean[]{true, false}), experimental.variable);
	}

	/**
	 * Проверка внедрения в {@code Set} из {@code Byte}.
	 */
	@Test
	public void testInjectionSetTypeFromByte()
	{
		class Experimental
		{
			public Set<Byte> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("27", "45"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(Set.of(new Byte[]{27, 45}), experimental.variable);
	}

	/**
	 * Проверка внедрения {@code null} в {@code Set}.
	 */
	@Test
	public void testInjectionSetTypeNull()
	{
		class Experimental
		{
			public Set<Integer> variable;
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
	 * Проверка внедрения в дублирующих значений в {@code Set}.
	 */
	@Test
	public void testInjectionSetTypeDuplicate()
	{
		class Experimental
		{
			public Set<Integer> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("qwe", "qwe"));

		Experimental experimental = new Experimental();

		assertThrows(IllegalValueException.class, () -> {
			Injectable injector = new Injection(experimental);
			injector.inject(data);
		});
	}
}