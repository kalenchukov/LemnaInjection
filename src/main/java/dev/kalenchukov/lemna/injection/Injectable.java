/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.lemna.injection;

import dev.kalenchukov.lemna.injection.exceptions.InvalidConverterException;
import dev.kalenchukov.lemna.injection.exceptions.IllegalValueException;
import dev.kalenchukov.lemna.injection.exceptions.UnknownConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.Map;

/**
 * Интерфейс для реализации внедряющего в поля класса данные.
 */
public interface Injectable
{
	/**
	 * Устанавливает локализацию.
	 *
	 * @param locale Локализация.
	 */
	void setLocale(@NotNull Locale locale);

	/**
	 * Внедряет данные в поля класса.
	 *
	 * @param data Данные которые необходимо внедрить в поля класса.
	 * <ul>
	 * 		<li><b>key</b> - поле класса.</li>
	 * 		<li><b>value</b> - массив значений.</li>
	 * </ul>
	 * @throws IllegalValueException Если передано некорректное значение для внедрения в данное поле класса.
	 * @throws UnknownConverterException Если для типа поля не реализован персональный конвертер.
	 * @throws InvalidConverterException Если конвертер некорректный.
	 */
	void inject(@NotNull Map<@NotNull String, @Nullable String @Nullable []> data)
        throws IllegalValueException, UnknownConverterException, InvalidConverterException;
}
