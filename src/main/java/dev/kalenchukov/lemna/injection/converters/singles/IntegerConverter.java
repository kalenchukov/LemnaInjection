package dev.kalenchukov.lemna.injection.converters.singles;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Integer}.
 */
public final class IntegerConverter implements Converting<Integer>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public Integer convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null || value[0] == null) {
			return null;
		}

		try
		{
			return Integer.parseInt(value[0]);
		}
		catch (NumberFormatException exception)
		{
			throw new UnableConverterException();
		}
	}
}
