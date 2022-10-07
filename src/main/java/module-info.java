/**
 * Определяет API для внедрения значений в поля классов.
 */
module dev.kalenchukov.lemna.injection
{
	requires org.jetbrains.annotations;
	requires log4j;
	requires dev.kalenchukov.notation.converting;

	exports dev.kalenchukov.lemna.injection;
	exports dev.kalenchukov.lemna.injection.annotations;
	exports dev.kalenchukov.lemna.injection.exceptions;
	exports dev.kalenchukov.lemna.injection.interfaces;
}