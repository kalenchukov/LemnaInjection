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
 * Класс проверки методов класса {@link Injection} с объектами типа {@code Set}.
 *
 * @author Алексей Каленчуков
 */
public class InjectionInSetTypeTest
{
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Set<Integer>}.
	 */
	@Test
	public void injectWithSetTypeFromInteger()
	{
		class Experimental
		{
			public Set<Integer> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("1", "11"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Set.of(new Integer[]{1, 11}));
	}
	
	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Set<Short>}.
	 */
	@Test
	public void injectWithSetTypeFromShort()
	{
		class Experimental
		{
			public Set<Short> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("2", "22"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Set.of(new Short[]{2, 22}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Set<Float>}.
	 */
	@Test
	public void injectWithSetTypeFromFloat()
	{
		class Experimental
		{
			public Set<Float> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("3.0", "3.30"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Set.of(new Float[]{3.0F, 3.30F}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Set<Double>}.
	 */
	@Test
	public void injectWithSetTypeFromDouble()
	{
		class Experimental
		{
			public Set<Double> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("4.59", "59.40"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Set.of(new Double[]{4.59, 59.40}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Set<Long>}.
	 */
	@Test
	public void injectWithSetTypeFromLong()
	{
		class Experimental
		{
			public Set<Long> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("1698756", "345345346"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Set.of(new Long[]{1698756L, 345345346L}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Set<String>}.
	 */
	@Test
	public void injectWithSetTypeFromString()
	{
		class Experimental
		{
			public Set<String> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("text", "TEXT"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Set.of(new String[] {"text", "TEXT"}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Set<Character>}.
	 */
	@Test
	public void injectWithSetTypeFromCharacter()
	{
		class Experimental
		{
			public Set<Character> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("A", "B"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Set.of(new Character[]{'A', 'B'}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Set<Boolean>}.
	 */
	@Test
	public void injectWithSetTypeFromBoolean()
	{
		class Experimental
		{
			public Set<Boolean> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("true", "false"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Set.of(new Boolean[]{true, false}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Set<Byte>}.
	 */
	@Test
	public void injectWithSetTypeFromByte()
	{
		class Experimental
		{
			public Set<Byte> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("27", "45"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Set.of(new Byte[]{27, 45}));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в {@code Set}.
	 */
	@Test
	public void injectWithSetTypeNull()
	{
		class Experimental
		{
			public Set<Integer> field;
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
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в дублирующих значений в {@code Set}.
	 */
	@Test
	public void injectWithSetTypeDuplicate()
	{
		class Experimental
		{
			public Set<Integer> field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("qwe", "qwe"));

		Experimental experimental = new Experimental();

		assertThatExceptionOfType(IllegalValueException.class).isThrownBy(() -> {
			Injectable injector = new Injection(experimental);
			injector.inject(value);
		});
	}
}