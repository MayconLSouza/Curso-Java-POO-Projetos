# Workshop MongoDB - Project

This repository contains the sample application from the workshop about integrating Java with MongoDB.

**Project Structure**

```
├── 📁 src
│   ├── 📁 main
│   │   └── 📁 java
│   │       └── 📁 com
│   │           └── 📁 mayconlsouza
│   │               └── 📁 workshopmongo
│   │                   ├── 📁 config
│   │                   │   └── ☕ Instantiation.java
│   │                   ├── 📁 domain
│   │                   │   ├── ☕ Post.java
│   │                   │   └── ☕ User.java
│   │                   ├── 📁 dto
│   │                   │   ├── ☕ AuthorDTO.java
│   │                   │   ├── ☕ CommentDTO.java
│   │                   │   └── ☕ UserDTO.java
│   │                   ├── 📁 repository
│   │                   │   ├── ☕ PostRepository.java
│   │                   │   └── ☕ UserRepository.java
│   │                   ├── 📁 resources
│   │                   │   ├── 📁 exception
│   │                   │   │   ├── ☕ ResourceExceptionHandler.java
│   │                   │   │   └── ☕ StandardError.java
│   │                   │   ├── 📁 util
│   │                   │   │   └── ☕ URL.java
│   │                   │   ├── ☕ PostResource.java
│   │                   │   └── ☕ UserResource.java
│   │                   ├── 📁 services
│   │                   │   ├── 📁 exception
│   │                   │   │   └── ☕ ObjectNotFoundException.java
│   │                   │   ├── ☕ PostService.java
│   │                   │   └── ☕ UserService.java
│   │                   └── ☕ WorkshopmongoApplication.java
│   └── 📁 test
│       └── 📁 java
│           └── 📁 com
│               └── 📁 mayconlsouza
│                   └── 📁 workshopmongo
│                       └── ☕ WorkshopmongoApplicationTests.java
├── ⚙️ .gitattributes
├── ⚙️ .gitignore
├── 📝 README.md
├── 📄 mvnw
├── 📄 mvnw.cmd
└── ⚙️ pom.xml
```

**How to run**

- From the command line (Windows):

	`mvnw.cmd spring-boot:run`

- Or with local Maven:

	`mvn spring-boot:run`

Or run the main class `com.mayconlsouza.workshopmongo.WorkshopmongoApplication` from your IDE.

**Routes / Endpoints and tests**

The application exposes endpoints under `/users` and `/posts`.

- Users
	- `GET /users` — list all users. Example:

		`curl -v http://localhost:8080/users`

	- `GET /users/{id}` — get a user by id. Example:

		`curl -v http://localhost:8080/users/6340a1f2...`

	- `POST /users` — create a user. Send JSON with the fields from `UserDTO` (`name`, `email`). Example:

		`curl -v -H "Content-Type: application/json" -d "{\"name\":\"Alice\",\"email\":\"alice@example.com\"}" http://localhost:8080/users`

		Response: `201 Created` with a `Location` header pointing to the created resource.

	- `PUT /users/{id}` — update a user. Send `UserDTO` in the request body. Example:

		`curl -v -X PUT -H "Content-Type: application/json" -d "{\"name\":\"Alice Updated\",\"email\":\"alice@example.com\"}" http://localhost:8080/users/{id}`

		Response: `204 No Content` on success.

	- `DELETE /users/{id}` — delete a user. Example:

		`curl -v -X DELETE http://localhost:8080/users/{id}`

		Response: `204 No Content` on success.

	- `GET /users/{id}/posts` — list posts for a given user. Example:

		`curl -v http://localhost:8080/users/{id}/posts`

- Posts
	- `GET /posts/{id}` — get a post by id. Example:

		`curl -v http://localhost:8080/posts/{postId}`

	- `GET /posts/titlesearch?text=...` — search posts by title (query param `text`). Example:

		`curl -v "http://localhost:8080/posts/titlesearch?text=java"`

	- `GET /posts/fullsearch?text=...&minDate=YYYY-MM-DD&maxDate=YYYY-MM-DD` — search by text and a date range (optional query params). Example:

		`curl -v "http://localhost:8080/posts/fullsearch?text=spring&minDate=2020-01-01&maxDate=2025-12-31"`

		Notes:
		- `minDate` and `maxDate` must be in `YYYY-MM-DD` format. If omitted, defaults are used (1970-01-01 to today).
		- `text` is decoded by the application's `URL` utility.

**Test checklist**

- [ ] `GET /users` returns `200` and a list of users.
- [ ] `GET /users/{id}` returns `200` when the id exists and `404` otherwise.
- [ ] `POST /users` creates a user and returns `201` with `Location` header.
- [ ] `PUT /users/{id}` updates a user and returns `204`.
- [ ] `DELETE /users/{id}` returns `204`.
- [ ] `GET /users/{id}/posts` returns posts for the user.
- [ ] `GET /posts/{id}` returns `200` when the post exists.
- [ ] `GET /posts/titlesearch` filters posts by title.
- [ ] `GET /posts/fullsearch` applies text filter and date range.

