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

package dev.kalenchukov.lemna.injection.annotations;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.*;

/**
 * Задаёт персональный конвертер типа данных для поля класса.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Converter
{
	/**
	 * Задаёт класс конвертера типа данных.
	 *
	 * @return класс конвертера типа данных.
	 */
	@NotNull
	Class<? extends Converting<?>> converter();
}
