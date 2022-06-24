package dev.kalenchukov.lemna.injection.converters.arrays;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.converters.singles.IntegerConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Integer[]}.
 */
public final class ArrayOfIntegerConverter implements Converting<Integer[]>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public Integer @Nullable [] convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Integer[] convertValue = new Integer[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new IntegerConverter().convert(new String[]{value[elm]});
		}

		return convertValue;
	}
}
