/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.lemna.injection.supports;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class SetOfGenderConverter implements Converting<Set<Gender>>
{
    @Nullable
    @Override
    public Set<@NotNull Gender> convert(@Nullable String @Nullable [] value)
		throws UnableConverterException
    {
        Gender[] convertValue = new ArrayOfGenderConverter().convert(value);

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
