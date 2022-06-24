package dev.kalenchukov.lemna.injection.converters.sets;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.converters.arrays.ArrayOfShortConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Set;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Set} из {@code Short}.
 */
public final class SetShortConverter implements Converting<Set<Short>>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public Set<@NotNull Short> convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		Short[] convertValue = new ArrayOfShortConverter().convert(value);

		if (convertValue == null) {
			return null;
		}

		boolean has = Arrays.stream(convertValue).anyMatch(Objects::isNull);

		if (has) {
			throw new UnableConverterException();
		}

		return Set.of(convertValue);
	}
}
