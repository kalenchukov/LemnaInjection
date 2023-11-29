# Журнал изменений
## vX.X.X - XX.XX.XXXX
### Изменено
* Переименован пакет resources -> types.

## v1.4.0 - 08.07.2023
### Изменено
* Изменена версия Java на 17.

## v1.3.0 - 12.02.2023
### Добавлено
* Добавлена аннотация Documented к аннотациям.
* Добавлен AUTHOR.MD.
* Добавлен INSTALL.MD.
* Добавлен CHANGELOG.MD.

### Изменено
* Выставлена печать логов уровня INFO.
* Изменён тип параметра метода Injectable.inject(Map<String, List<String>>).
* Обновлён README.MD.

## v1.2.0 - 16.10.2022
### Добавлено
* Добавлен метод ConverterRepository.getConverter(String).
* Добавлен метод Injection.getLocale().
* Добавлен метод Injection.getNotationType().
* Добавлен метод Injection.inject(Map, NotationType).
* Добавлен плагин maven-assembly в pom.xml.
* Добавлен плагин maven-compiler в pom.xml.
* Добавлен плагин maven-dependency в pom.xml.
* Добавлен плагин maven-javadoc в pom.xml.
* Добавлен плагин maven-source в pom.xml.

### Изменено
* Переименован метод ConverterRepository.addConverters() -> ConverterRepository.addConvertersSimple().
* Класс ConverterRepository перемещён в пакет repositories.

## v1.1.0 - 15.09.2022
### Изменено
* Изменена директория ресурсных файлов.
* Изменена лицензия.
* Обновлён README.MD.
