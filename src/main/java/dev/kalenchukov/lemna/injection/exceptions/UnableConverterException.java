/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.lemna.injection.exceptions;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Исключение для невозможности конвертирования значения внедрения.
 */
public class UnableConverterException extends RuntimeException
{
	/**
	 * Конструктор для {@code UnableConverterException}.
	 */
	public UnableConverterException() {}

    /**
     * Конструктор для {@code UnableConverterException}.
     *
     * @param message Сообщение.
     */
    public UnableConverterException(@NotNull final String message)
    {
		super(Objects.requireNonNull(message));
    }
}
