/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.lemna.injection.interfaces;

import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Интерфейс для реализации собственного класса конвертера типа значений.
 *
 * @param <T> Объект типа возвращаемых данных.
 */
public interface Converting<T>
{
	/**
	 * Конвертирует значение в указанный тип данных.
	 *
	 * @param value Значения, тип данных которых необходимо конвертировать.
	 * @return Возвращает значение конвертированное в указанный тип данных.
	 * @throws UnableConverterException Если конвертировать значение в нужный тип данных не удалось.
	 */
	@Nullable
	T convert(@Nullable String @Nullable [] value)
		throws UnableConverterException;
}
