/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.lemna.injection.exceptions;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Исключение для неопределённого конвертера для значения внедрения.
 */
public class UnknownConverterException extends RuntimeException
{
	/**
     * Конструктор для {@code UnknownConverterException}.
     *
     * @param message Сообщение.
     */
    public UnknownConverterException(@NotNull final String message)
    {
        super(Objects.requireNonNull(message));
    }
}
