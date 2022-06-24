package dev.kalenchukov.lemna.injection.converters.arrays;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.converters.singles.StringConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code String[]}.
 */
public final class ArrayOfStringConverter implements Converting<String[]>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public String @Nullable [] convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		String[] convertValue = new String[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new StringConverter().convert(new String[]{value[elm]});
		}

		return convertValue;
	}
}
