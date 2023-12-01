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
	public void injectWithIntegerType()
	{
		class Experimental
		{
			public Integer field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("1"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(1);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Short}.
	 */
	@Test
	public void injectWithShortType()
	{
		class Experimental
		{
			public Short field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("2"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Short.valueOf((short) 2));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Float}.
	 */
	@Test
	public void injectWithFloatType()
	{
		class Experimental
		{
			public Float field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("3.0"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Float.valueOf(3.0F));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Double}.
	 */
	@Test
	public void injectWithDoubleType()
	{
		class Experimental
		{
			public Double field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("4.59"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Double.valueOf(4.59));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Long}.
	 */
	@Test
	public void injectWithLongType()
	{
		class Experimental
		{
			public Long field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("1698756"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(1698756L);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code String}.
	 */
	@Test
	public void injectWithStringType()
	{
		class Experimental
		{
			public String field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("text"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo("text");
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Character}.
	 */
	@Test
	public void injectWithCharacterType()
	{
		class Experimental
		{
			public Character field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("A"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo('A');
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Boolean}.
	 */
	@Test
	public void injectWithBooleanType()
	{
		class Experimental
		{
			public Boolean field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("true"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(true);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением в {@code Byte}.
	 */
	@Test
	public void injectWithByteType()
	{
		class Experimental
		{
			public Byte field;
		}

		Map<String, List<String>> value = new HashMap<>();
		value.put("field", List.of("27"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(value);

		assertThat(experimental.field).isEqualTo(Byte.valueOf((byte) 27));
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null} в одиночный тип данных.
	 */
	@Test
	public void injectWithNull()
	{
		class Experimental
		{
			public Integer field;
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
}