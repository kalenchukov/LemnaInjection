/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

module dev.kalenchukov.lemna.injection
{
	requires org.jetbrains.annotations;
	requires log4j;

	exports dev.kalenchukov.lemna.injection;
	exports dev.kalenchukov.lemna.injection.annotations;
	exports dev.kalenchukov.lemna.injection.exceptions;
	exports dev.kalenchukov.lemna.injection.interfaces;
}