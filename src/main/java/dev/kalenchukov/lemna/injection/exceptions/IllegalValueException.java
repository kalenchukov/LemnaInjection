/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.lemna.injection.exceptions;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Исключение для некорректного значения для внедрения.
 */
public class IllegalValueException extends RuntimeException
{
    /**
     * Конструктор для {@code IllegalValueException}.
     *
     * @param message Сообщение.
     */
    public IllegalValueException(@NotNull final String message)
    {
		super(Objects.requireNonNull(message));
    }
}
