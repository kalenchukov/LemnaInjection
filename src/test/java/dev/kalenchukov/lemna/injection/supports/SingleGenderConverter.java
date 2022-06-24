/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.lemna.injection.supports;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

public class SingleGenderConverter implements Converting<Gender>
{
    @Nullable
    @Override
    public Gender convert(@Nullable String @Nullable [] value)
		throws UnableConverterException
    {
        if (value == null || value[0] == null) {
            return null;
        }

        try
        {
            return Gender.valueOf(value[0]);
        }
        catch (IllegalArgumentException exception)
        {
            throw new UnableConverterException();
        }

    }
}
