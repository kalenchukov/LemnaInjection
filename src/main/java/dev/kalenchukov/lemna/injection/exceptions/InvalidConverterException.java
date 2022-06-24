/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.lemna.injection.exceptions;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Исключение для некорректного конвертера значений внедрения.
 */
public class InvalidConverterException extends RuntimeException
{
	/**
     * Конструктор для {@code InvalidConverterException}.
     *
     * @param message Сообщение.
     */
    public InvalidConverterException(@NotNull final String message)
    {
		super(Objects.requireNonNull(message));
    }
}
