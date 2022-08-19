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

package dev.kalenchukov.lemna.injection.converters.arrays;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.converters.singles.FloatConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Float[]}.
 */
public final class ArrayOfFloatConverter implements Converting<Float[]>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public Float @Nullable [] convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Float[] convertValue = new Float[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new FloatConverter().convert(new String[]{value[elm]});
		}

		return convertValue;
	}
}
