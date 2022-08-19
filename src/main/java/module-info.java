module dev.kalenchukov.lemna.injection
{
	requires org.jetbrains.annotations;
	requires log4j;

	exports dev.kalenchukov.lemna.injection;
	exports dev.kalenchukov.lemna.injection.annotations;
	exports dev.kalenchukov.lemna.injection.exceptions;
	exports dev.kalenchukov.lemna.injection.interfaces;
}