package dev.kalenchukov.lemna.injection.converters.arrays;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.converters.singles.CharacterConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Character[]}.
 */
public final class ArrayOfCharacterConverter implements Converting<Character[]>
{
	/**
	 * @see Converting#convert(String[])
	 */
	@Override
	@Nullable
	public Character @Nullable [] convert(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Character[] convertValue = new Character[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new CharacterConverter().convert(new String[]{value[elm]});
		}

		return convertValue;
	}
}
