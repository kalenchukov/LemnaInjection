package dev.kalenchukov.lemna.injection.converters.collections;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.converters.arrays.ArrayOfCharacterConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Collection} из {@code Character}.
 */
public final class CollectionCharacterConverter implements Converting<Collection<Character>>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public Collection<@NotNull Character> convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		Character[] convertValue = new ArrayOfCharacterConverter().convert(value);

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
