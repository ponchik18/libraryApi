# Инструкции по запуску проекта

Этот файл содержит инструкции для запуска проекта на Spring Boot локально на порту 9192 с логином "user" и паролем "password".

## Клонирование репозитория (если необходимо)

Если у вас ещё нет репозитория, клонируйте его с помощью Git:

```bash
git clone https://github.com/ponchik18/libraryApi.git
```
## Настройка конфигурации

Откройте файл application.properties (или application.yml) и, при необходимости, поменяйте следующие параметры в соответствии со своей БД :

```properties
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/library
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Сборка проекта

Выполните сборку проекта с помощью Maven (или Gradle):

```bash
mvn clean install
```

## Запуск приложения

Запустите приложение с помощью следующей команды:

```bash
java -jar target/libraryApi-0.0.1-SNAPSHOT.war
```

## Доступ к приложению

После успешного запуска, Web Api будет доступно по следующему URL:
```http request
http://localhost:9192/webapi
```
Вы можете использовать логин "user" и пароль "password" для аутентификации в приложении.

# Основной функционал web-Api

# Контроллер книг (Book Controller)

Этот контроллер предоставляет REST API для управления книгами.

## Получение списка всех книг

**URL**: `/books`

**Метод**: `GET`

Эндпоинт для получения списка всех книг.

Пример запроса:

GET /books

markdown
Copy code

## Получение книги по ID

**URL**: `/books/{id}`

**Метод**: `GET`

Эндпоинт для получения информации о книге по её ID.

Пример запроса:

GET /books/1

markdown
Copy code

## Получение книги по ISBN

**URL**: `/books/isbn/{isbn}`

**Метод**: `GET`

Эндпоинт для поиска книги по ISBN.

Пример запроса:

GET /books/isbn/978-3-16-148410-0

markdown
Copy code

## Добавление новой книги

**URL**: `/books/add`

**Метод**: `POST`

Эндпоинт для добавления новой книги.

Пример запроса:

POST /books/add
```json
{
    "title": "Название книги",
    "isbn": "ISBN-код",
    "genre": "Жанр",
    "description": "Описание книги",
    "author": "Автор"
}
```

markdown
Copy code

## Обновление информации о книге

**URL**: `/books/update`

**Метод**: `PUT`

Эндпоинт для обновления информации о книге.

Пример запроса:

PUT /books/update
```json
{
    "id": 1,
    "title": "Новое название книги",
    "isbn": "Новый ISBN-код",
    "genre": "Новый жанр",
    "description": "Новое описание книги",
    "author": "Новый автор"
}
```

markdown
Copy code

## Удаление книги по ID

**URL**: `/books/delete/{id}`

**Метод**: `DELETE`

Эндпоинт для удаления книги по её ID.

Пример запроса:

DELETE /books/delete/1

# Контроллер реестра книг (BookRegistry Controller)

Этот контроллер предоставляет REST API для управления записями книг и доступом к свободным книгам в библиотеке.

## Получение списка всех свободных книг

**URL**: `/library/free`

**Метод**: `GET`

Эндпоинт для получения списка всех свободных книг в библиотеке.

Пример запроса:

GET /library/free

markdown
Copy code

## Получение списка всех записей реестра книг

**URL**: `/library`

**Метод**: `GET`

Эндпоинт для получения списка всех записей в реестре книг.

Пример запроса:

GET /library

markdown
Copy code

## Добавление записи в реестр книг

**URL**: `/library/add`

**Метод**: `POST`

Эндпоинт для добавления новой записи в реестр книги. В теле запроса следует передать `bookId` - идентификатор книги.

Пример запроса:

POST /library/add
```json
1
```

markdown
Copy code

## Удаление записи реестра книг по ID

**URL**: `/library/delete/{id}`

**Метод**: `DELETE`

Эндпоинт для удаления записи в реестре книги по её ID.

Пример запроса:

DELETE /library/delete/1

markdown
Copy code

## Получение записи реестра книги по ID

**URL**: `/library/{id}`

**Метод**: `GET`

Эндпоинт для получения информации о записи в реестре книги по её ID.

Пример запроса:

GET /library/1