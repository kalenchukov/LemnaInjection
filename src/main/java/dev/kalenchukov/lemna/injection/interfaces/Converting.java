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

package dev.kalenchukov.lemna.injection.interfaces;

import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Интерфейс для реализации собственного класса конвертера типа значений.
 *
 * @param <T> Объект типа возвращаемых данных.
 */
public interface Converting<T>
{
	/**
	 * Конвертирует значение в указанный тип данных.
	 *
	 * @param value значения, тип данных которых необходимо конвертировать.
	 * @return возвращает значение конвертированное в указанный тип данных.
	 * @throws UnableConverterException если конвертировать значение в нужный тип данных не удалось.
	 */
	@Nullable
	T convert(@Nullable List<@Nullable String> value)
		throws UnableConverterException;
}
