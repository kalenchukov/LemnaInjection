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
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class InjectionInCollectionTypeTest
{
	/**
	 * Проверка внедрения в {@code Collection} из {@code Integer}.
	 */
	@Test
	public void testInjectionCollectionTypeFromInteger()
	{
		class Experimental
		{
			public Collection<Integer> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("1", "11"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Integer[]{1, 11}), experimental.variable);
	}
	
	/**
	 * Проверка внедрения в {@code Collection} из {@code Short}.
	 */
	@Test
	public void testInjectionCollectionTypeFromShort()
	{
		class Experimental
		{
			public Collection<Short> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("2", "22"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Short[]{2, 22}), experimental.variable);
	}
	
	/**
	 * Проверка внедрения в {@code Collection} из {@code Float}.
	 */
	@Test
	public void testInjectionCollectionTypeFromFloat()
	{
		class Experimental
		{
			public Collection<Float> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("3.0", "3.30"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Float[]{3.0F, 3.30F}), experimental.variable);
	}
	
	/**
	 * Проверка внедрения в {@code Collection} из {@code Double}.
	 */
	@Test
	public void testInjectionCollectionTypeFromDouble()
	{
		class Experimental
		{
			public Collection<Double> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("4.59", "59.40"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Double[]{4.59, 59.40}), experimental.variable);
	}
	
	/**
	 * Проверка внедрения в {@code Collection} из {@code Long}.
	 */
	@Test
	public void testInjectionCollectionTypeFromLong()
	{
		class Experimental
		{
			public Collection<Long> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("1698756", "345345346"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Long[]{1698756L, 345345346L}), experimental.variable);
	}
	
	/**
	 * Проверка внедрения в {@code Collection} из {@code String}.
	 */
	@Test
	public void testInjectionCollectionTypeFromString()
	{
		class Experimental
		{
			public Collection<String> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("text", "TEXT"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new String[] {"text", "TEXT"}), experimental.variable);
	}
	
	/**
	 * Проверка внедрения в {@code Collection} из {@code Character}.
	 */
	@Test
	public void testInjectionCollectionTypeFromCharacter()
	{
		class Experimental
		{
			public Collection<Character> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("A", "B"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Character[]{'A', 'B'}), experimental.variable);
	}
	
	/**
	 * Проверка внедрения в {@code Collection} из {@code Boolean}.
	 */
	@Test
	public void testInjectionCollectionTypeFromBoolean()
	{
		class Experimental
		{
			public Collection<Boolean> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("true", "false"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Boolean[]{true, false}), experimental.variable);
	}
	
	/**
	 * Проверка внедрения в {@code Collection} из {@code Byte}.
	 */
	@Test
	public void testInjectionCollectionTypeFromByte()
	{
		class Experimental
		{
			public Collection<Byte> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("27", "45"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Byte[]{27, 45}), experimental.variable);
	}

	/**
	 * Проверка внедрения {@code null} в {@code Collection}.
	 */
	@Test(expected = IllegalValueException.class)
	public void testInjectionCollectionTypeNull()
	{
		class Experimental
		{
			public Collection<Integer> variable;
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
	 * Проверка внедрения дублирующих значений в {@code Collection}.
	 */
	@Test
	public void testInjectionCollectionTypeDuplicate()
	{
		class Experimental
		{
			public Collection<Integer> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("10", "10"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertEquals(List.of(new Integer[]{10, 10}), experimental.variable);
	}
}