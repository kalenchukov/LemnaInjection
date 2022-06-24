package dev.kalenchukov.lemna.injection.annotations;

import dev.kalenchukov.lemna.injection.interfaces.Converting;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Задаёт персональный конвертер типа данных для поля класса.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Converter
{
	/**
	 * Задаёт класс конвертера типа данных.
	 *
	 * @return Класс конвертера типа данных.
	 */
	@NotNull
	Class<? extends Converting<?>> converter();
}
