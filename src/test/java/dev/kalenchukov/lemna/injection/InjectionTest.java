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

import dev.kalenchukov.lemna.injection.exceptions.UnknownConverterException;
import dev.kalenchukov.notation.converting.resources.NotationType;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class InjectionTest
{
	/**
	 * Проверка внедрения в примитивные типы данных.
	 */
	@Test(expected = UnknownConverterException.class)
	public void testInjectionPrimitiveType()
	{
		class Experimental
		{
			public int variable;
		}

		Map<String, String[]> data = new HashMap<>();
		data.put("variable", new String[]{"1"});

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);
	}

	/**
	 * Проверка внедрения в поле с неизвестным типом данных.<br>
	 * В качестве неизвестного типа данных коллекция {@code List} из {@code String[]},
	 * для которого нет стандартного конвертера.
	 */
	@Test(expected = UnknownConverterException.class)
	public void testInjectionUnknownType()
	{
		class Experimental
		{
			public List<String[]> variable;
		}

		Map<String, String[]> data = new HashMap<>();
		data.put("variable", new String[]{"QWE"});

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);
	}

	/**
	 * Проверка внедрения {@code null}.
	 */
	@Test
	public void testInjectionNull()
	{
		class Experimental
		{
			public String variable;
		}

		Map<String, String[]> data = new HashMap<>();
		data.put("variable", null);

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertNull(experimental.variable);
	}

	/**
	 * Проверка внедрения без данных.
	 */
	@Test
	public void testInjectionNotData()
	{
		class Experimental
		{
			public String variable;
		}

		Map<String, String[]> data = new HashMap<>();

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data);

		assertNull(experimental.variable);
	}

	/**
	 * Проверка внедрения данных в нотации Camel Case.
	 */
	@Test
	public void testInjectionNotationCamelCase()
	{
		class Experimental
		{
			public String paramValue;
		}

		Map<String, String[]> data = new HashMap<>();
		data.put("paramValue", new String[] {"text"});

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data, NotationType.CAMEL_CASE);

		assertEquals("text", experimental.paramValue);
	}

	/**
	 * Проверка внедрения данных в нотации Kebab Case.
	 */
	@Test
	public void testInjectionNotationKebabCase()
	{
		class Experimental
		{
			public String paramValue;
		}

		Map<String, String[]> data = new HashMap<>();
		data.put("param-value", new String[] {"text"});

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data, NotationType.KEBAB_CASE);

		assertEquals("text", experimental.paramValue);
	}

	/**
	 * Проверка внедрения данных в нотации Upper Case.
	 */
	@Test
	public void testInjectionNotationUpperCase()
	{
		class Experimental
		{
			public String paramValue;
		}

		Map<String, String[]> data = new HashMap<>();
		data.put("PARAM_VALUE", new String[] {"text"});

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data, NotationType.UPPER_CASE);

		assertEquals("text", experimental.paramValue);
	}

	/**
	 * Проверка внедрения данных в нотации Snake Case.
	 */
	@Test
	public void testInjectionNotationSnakeCase()
	{
		class Experimental
		{
			public String paramValue;
		}

		Map<String, String[]> data = new HashMap<>();
		data.put("param_value", new String[] {"text"});

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data, NotationType.SNAKE_CASE);

		assertEquals("text", experimental.paramValue);
	}

	/**
	 * Проверка внедрения данных в нотации Pascal Case.
	 */
	@Test
	public void testInjectionNotationPascalCase()
	{
		class Experimental
		{
			public String paramValue;
		}

		Map<String, String[]> data = new HashMap<>();
		data.put("ParamValue", new String[] {"text"});

		Experimental experimental = new Experimental();

		Injectable injector = new Injection(experimental);
		injector.inject(data, NotationType.PASCAL_CASE);

		assertEquals("text", experimental.paramValue);
	}
}