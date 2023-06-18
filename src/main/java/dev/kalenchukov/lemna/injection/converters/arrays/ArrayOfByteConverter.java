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

package dev.kalenchukov.lemna.injection.converters.arrays;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.converters.singles.ByteConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * Класс конвертирует тип данных {@code List<String>} в {@code Byte[]}.
 *
 * @author Алексей Каленчуков
 */
public final class ArrayOfByteConverter implements Converting<Byte[]>
{
	/**
	 * {@inheritDoc}
	 *
	 * @param value {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws UnableConverterException {@inheritDoc}
	 */
	@Nullable
	@Override
	public Byte @Nullable [] convert(@Nullable final List<@Nullable String> value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Byte[] convertValue = new Byte[value.size()];

		for (int elm = 0; elm < value.size(); elm++)
		{
			convertValue[elm] = new ByteConverter().convert(Collections.singletonList(value.get(elm)));
		}

		return convertValue;
	}
}
