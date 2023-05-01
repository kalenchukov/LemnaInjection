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

import dev.kalenchukov.lemna.injection.exceptions.InvalidConverterException;
import dev.kalenchukov.lemna.injection.exceptions.IllegalValueException;
import dev.kalenchukov.lemna.injection.exceptions.UnknownConverterException;
import dev.kalenchukov.notation.resources.NotationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Интерфейс для реализации внедряющего в поля класса данные.
 *
 * @author Aleksey Kalenchukov
 */
public interface Injectable
{
	/**
	 * Устанавливает локализацию.
	 *
	 * @param locale локализация.
	 */
	void setLocale(@NotNull Locale locale);

	/**
	 * Возвращает локализацию.
	 *
	 * @return локализация.
	 */
	@NotNull
	Locale getLocale();

	/**
	 * Устанавливает тип нотации названий полей класса в данных.
	 *
	 * @param notationType тип нотации.
	 */
	void setNotationType(@NotNull NotationType notationType);

	/**
	 * Возвращает тип нотации названий полей класса в данных.
	 *
	 * @return тип нотации.
	 */
	@NotNull
	NotationType getNotationType();

	/**
	 * Внедряет данные в поля класса.
	 *
	 * @param data данные которые необходимо внедрить в поля класса.
	 * <ul>
	 * 		<li><b>key</b> - поле класса в нотации Camel Case.</li>
	 * 		<li><b>value</b> - массив значений.</li>
	 * </ul>
	 * @throws IllegalValueException если передано некорректное значение для внедрения в данное поле класса.
	 * @throws UnknownConverterException если для типа поля не реализован персональный конвертер.
	 * @throws InvalidConverterException если конвертер некорректный.
	 */
	void inject(@NotNull Map<@NotNull String, @Nullable List<@Nullable String>> data)
        throws IllegalValueException, UnknownConverterException, InvalidConverterException;
}
