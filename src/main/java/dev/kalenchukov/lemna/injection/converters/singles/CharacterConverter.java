package dev.kalenchukov.lemna.injection.converters.singles;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Character}.
 */
public final class CharacterConverter implements Converting<Character>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public Character convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null || value[0] == null) {
			return null;
		}

		try
		{
			return value[0].charAt(0);
		}
		catch (IndexOutOfBoundsException exception)
		{
			throw new UnableConverterException();
		}
	}
}
