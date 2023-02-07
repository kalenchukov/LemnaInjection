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

import dev.kalenchukov.lemna.injection.exceptions.UnknownConverterException;
import dev.kalenchukov.notation.converting.resources.NotationType;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link Injection}.
 */
public class InjectionTest
{
	/**
	 * Проверка метода {@link Injection#inject(Map)} с примитивным типом данных.
	 */
	@Test
	public void testInjectionPrimitiveType()
	{
		class Experimental
		{
			public int variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("1"));

		Experimental experimental = new Experimental();

		assertThrows(UnknownConverterException.class, () -> {
			Injectable injector = new Injection(experimental);
			injector.inject(data);
		});
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с неизвестным типом данных.<br>
	 * В качестве неизвестного типа данных коллекция {@code List} из {@code String[]},
	 * для которого нет стандартного конвертера.
	 */
	@Test
	public void testInjectionUnknownType()
	{
		class Experimental
		{
			public List<String[]> variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", List.of("QWE"));

		Experimental experimental = new Experimental();

		assertThrows(UnknownConverterException.class, () -> {
			Injectable injector = new Injection(experimental);
			injector.inject(data);
		});
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с внедрением {@code null}.
	 */
	@Test
	public void testInjectionNull()
	{
		class Experimental
		{
			public String variable;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("variable", null);

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertNull(experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} без данных.
	 */
	@Test
	public void testInjectionNotData()
	{
		class Experimental
		{
			public String variable;
		}

		Map<String, List<String>> data = new HashMap<>();

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertNull(experimental.variable);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с нотацией Camel Case.
	 */
	@Test
	public void testInjectionNotationCamelCase()
	{
		class Experimental
		{
			public String paramValue;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("paramValue", List.of("text"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.setNotationType(NotationType.CAMEL_CASE);
		injector.inject(data);

		assertEquals("text", experimental.paramValue);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с нотацией Kebab Case.
	 */
	@Test
	public void testInjectionNotationKebabCase()
	{
		class Experimental
		{
			public String paramValue;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("param-value", List.of("text"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.setNotationType(NotationType.KEBAB_CASE);
		injector.inject(data);

		assertEquals("text", experimental.paramValue);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с нотацией Upper Case.
	 */
	@Test
	public void testInjectionNotationUpperCase()
	{
		class Experimental
		{
			public String paramValue;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("PARAM_VALUE", List.of("text"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.setNotationType(NotationType.UPPER_CASE);
		injector.inject(data);

		assertEquals("text", experimental.paramValue);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с нотацией Snake Case.
	 */
	@Test
	public void testInjectionNotationSnakeCase()
	{
		class Experimental
		{
			public String paramValue;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("param_value", List.of("text"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.setNotationType(NotationType.SNAKE_CASE);
		injector.inject(data);

		assertEquals("text", experimental.paramValue);
	}

	/**
	 * Проверка метода {@link Injection#inject(Map)} с нотацией Pascal Case.
	 */
	@Test
	public void testInjectionNotationPascalCase()
	{
		class Experimental
		{
			public String paramValue;
		}

		Map<String, List<String>> data = new HashMap<>();
		data.put("ParamValue", List.of("text"));

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.setNotationType(NotationType.PASCAL_CASE);
		injector.inject(data);

		assertEquals("text", experimental.paramValue);
	}
}