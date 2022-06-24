package dev.kalenchukov.lemna.injection.converters.collections;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.converters.arrays.ArrayOfByteConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Collection} из {@code Byte}.
 */
public final class CollectionByteConverter implements Converting<Collection<Byte>>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public Collection<@NotNull Byte> convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		Byte[] convertValue = new ArrayOfByteConverter().convert(value);

		if (convertValue == null) {
			return null;
		}

		boolean has = Arrays.stream(convertValue).anyMatch(Objects::isNull);

		if (has) {
			throw new UnableConverterException();
		}

		return List.of(convertValue);
	}
}
