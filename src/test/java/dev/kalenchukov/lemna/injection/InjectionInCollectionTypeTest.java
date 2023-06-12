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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Класс проверки методов класса {@link Injection} с объектами типа {@code Collection}.
 *
 * @author Алексей Каленчуков
 */
public class InjectionInCollectionTypeTest
{
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Collection<Integer>}.
	 */
	@Test
	public void injectionCollectionTypeFromInteger()
	{
		class Experimental
		{
			public Collection<Integer> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("1", "11"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new Integer[]{1, 11}));
	}
	
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Collection<Short>}.
	 */
	@Test
	public void injectionCollectionTypeFromShort()
	{
		class Experimental
		{
			public Collection<Short> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("2", "22"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new Short[]{2, 22}));
	}
	
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Collection<Float>}.
	 */
	@Test
	public void injectionCollectionTypeFromFloat()
	{
		class Experimental
		{
			public Collection<Float> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("3.0", "3.30"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new Float[]{3.0F, 3.30F}));
	}
	
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Collection<Double>}.
	 */
	@Test
	public void injectionCollectionTypeFromDouble()
	{
		class Experimental
		{
			public Collection<Double> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("4.59", "59.40"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new Double[]{4.59, 59.40}));
	}
	
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Collection<Long>}.
	 */
	@Test
	public void injectionCollectionTypeFromLong()
	{
		class Experimental
		{
			public Collection<Long> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("1698756", "345345346"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new Long[]{1698756L, 345345346L}));
	}
	
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Collection<String>}.
	 */
	@Test
	public void injectionCollectionTypeFromString()
	{
		class Experimental
		{
			public Collection<String> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("text", "TEXT"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new String[] {"text", "TEXT"}));
	}
	
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Collection<Character>}.
	 */
	@Test
	public void injectionCollectionTypeFromCharacter()
	{
		class Experimental
		{
			public Collection<Character> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("A", "B"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new Character[]{'A', 'B'}));
	}
	
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Collection<Boolean>}.
	 */
	@Test
	public void injectionCollectionTypeFromBoolean()
	{
		class Experimental
		{
			public Collection<Boolean> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("true", "false"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new Boolean[]{true, false}));
	}
	
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Collection<Byte>}.
	 */
	@Test
	public void injectionCollectionTypeFromByte()
	{
		class Experimental
		{
			public Collection<Byte> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("27", "45"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new Byte[]{27, 45}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в {@code Collection}.
	 */
	@Test
	public void injectionCollectionTypeNull()
	{
		class Experimental
		{
			public Collection<Integer> field;
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
	 * Проверка метода {@link Injection#inject(Map)} с внедрением дублирующих значений в {@code Collection}.
	 */
	@Test
	public void injectionCollectionTypeDuplicate()
	{
		class Experimental
		{
			public Collection<Integer> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("10", "10"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(List.of(new Integer[]{10, 10}));
	}
}