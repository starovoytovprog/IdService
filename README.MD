Генератор числовых идентификаторов.

Разработать REST-сервис с единственным GET-методом по получению уникального числового идентификатора: 1, 2, 3 и т.д. Идентификатор должен быть целым натуральным числом. При каждом вызове данного метода должен возвращаться новый идентификатор. Идентификаторы не должны повторяться, однако могут идти не по порядку.
Пример ответа сервиса
{
  "id": 42
}

Сервис должен хорошо горизонтально масштабироваться для обработки большого количества запросов (до 1 млн в секунду). Сервис не должен зависеть от системного времени сервера.
Для разработки следует использовать фреймворк Spring. Другие технологии или библиотеки - по желанию.