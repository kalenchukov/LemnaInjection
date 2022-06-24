package dev.kalenchukov.lemna.injection.converters.arrays;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.converters.singles.ByteConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Byte[]}.
 */
public final class ArrayOfByteConverter implements Converting<Byte[]>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public Byte @Nullable [] convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Byte[] convertValue = new Byte[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new ByteConverter().convert(new String[]{value[elm]});
		}

		return convertValue;
	}
}
