package dev.kalenchukov.lemna.injection.converters.singles;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Byte}.
 */
public final class ByteConverter implements Converting<Byte>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public Byte convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null || value[0] == null) {
			return null;
		}

		try
		{
			return Byte.parseByte(value[0]);
		}
		catch (NumberFormatException exception)
		{
			throw new UnableConverterException();
		}
	}
}
