package dev.kalenchukov.lemna.injection.converters.lists;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.converters.arrays.ArrayOfFloatConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code List} из {@code Float}.
 */
public final class ListFloatConverter implements Converting<List<Float>>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public List<@NotNull Float> convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		Float[] convertValue = new ArrayOfFloatConverter().convert(value);

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
