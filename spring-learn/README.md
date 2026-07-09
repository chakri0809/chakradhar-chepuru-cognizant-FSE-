# spring-learn

A single, runnable Spring Boot project that implements **all five hands-on documents** end to end:

1. `1__spring-rest-handson.docx` — Spring Boot basics, Spring Core XML bean config, logging
2. `2__spring-rest-handson.docx` — RESTful GET services, MockMvc testing
3. `3__spring-rest-handson.docx` — Employee/Department REST services (Controller → Service → Dao)
4. `4__spring-rest-handson.docx` — POST/PUT/DELETE, bean validation, global exception handling
5. `5__JWT-handson.docx` — Spring Security (HTTP Basic) + JWT authentication/authorization

Everything lives in **one Maven project** so it can be opened and run in IntelliJ IDEA directly.

---

## 1. Folder structure

```
spring-learn/
├── pom.xml
├── .gitignore
├── README.md
└── src
    ├── main
    │   ├── java/com/cognizant/springlearn
    │   │   ├── SpringLearnApplication.java      # main() + Doc1 displayDate/displayCountry/displayCountries
    │   │   ├── Country.java                     # Doc1/Doc4 bean (validated)
    │   │   ├── Employee.java                    # Doc3/Doc4 bean (validated, nested Department/Skill)
    │   │   ├── Department.java                  # Doc3/Doc4 bean
    │   │   ├── Skill.java                        # Doc3/Doc4 bean
    │   │   ├── GlobalExceptionHandler.java       # Doc4 @ControllerAdvice
    │   │   ├── controller
    │   │   │   ├── HelloController.java          # Doc2 /hello
    │   │   │   ├── CountryController.java        # Doc2/Doc4 /countries
    │   │   │   ├── EmployeeController.java       # Doc3/Doc4 /employees
    │   │   │   ├── DepartmentController.java     # Doc3 /departments
    │   │   │   └── AuthenticationController.java # Doc5 /authenticate
    │   │   ├── service
    │   │   │   ├── CountryService.java
    │   │   │   ├── EmployeeService.java
    │   │   │   ├── DepartmentService.java
    │   │   │   └── exception
    │   │   │       ├── CountryNotFoundException.java
    │   │   │       └── EmployeeNotFoundException.java
    │   │   ├── dao
    │   │   │   ├── EmployeeDao.java
    │   │   │   └── DepartmentDao.java
    │   │   └── security
    │   │       ├── SecurityConfig.java           # Doc5 users/roles + filter chain
    │   │       └── JwtAuthorizationFilter.java   # Doc5 Bearer-token validation
    │   └── resources
    │       ├── application.properties            # port 8090 + logging pattern (Doc1 Hands on 3)
    │       ├── date-format.xml                    # Doc1 Hands on 2
    │       ├── country.xml                         # Doc1 Hands on 4/5/6
    │       ├── employee.xml                         # Doc3
    │       └── department.xml                       # Doc3
    └── test
        └── java/com/cognizant/springlearn
            └── SpringLearnApplicationTests.java    # Doc2 MockMvc tests
```

---

## 2. How each doc maps to the code

| Doc | Concept | Where it lives |
|---|---|---|
| 1 | Spring Boot bootstrapping, `@SpringBootApplication` | `SpringLearnApplication.java` |
| 1 | Load `SimpleDateFormat` bean from XML | `date-format.xml` + `displayDate()` |
| 1 | Logging config, log levels | `application.properties`, every class uses SLF4J `LOGGER` |
| 1 | `Country` bean, singleton vs prototype scope | `Country.java`, `country.xml`, `displayCountry()` |
| 1 | `<list>`/`<ref>` — list of countries | `country.xml` (`countryList` bean), `displayCountries()` |
| 2 | HTTP GET REST service | `HelloController` (`/hello`) |
| 2 | REST service returning a JSON bean | `CountryController` (`/countries/{code}`) |
| 2 | REST service returning a list | `CountryController` (`/countries`) |
| 2 | 404 on missing resource | `CountryNotFoundException` (`@ResponseStatus`) |
| 2 | MockMvc end-to-end test | `SpringLearnApplicationTests.java` |
| 3 | Controller → Service → Dao layering | `EmployeeController/Service/Dao`, `DepartmentController/Service/Dao` |
| 3 | `@Transactional` service method | `EmployeeService.getAllEmployees()` |
| 4 | HTTP method conventions (`GET/POST/PUT/DELETE`) | `CountryController`, `EmployeeController` |
| 4 | `@RequestBody` JSON → bean mapping | `CountryController.addCountry()` |
| 4 | Bean validation (`@NotNull`, `@Size`, `@Min`, `@JsonFormat`) | `Country.java`, `Employee.java`, `Department.java`, `Skill.java` |
| 4 | Global exception handling (`@ControllerAdvice`) | `GlobalExceptionHandler.java` |
| 5 | HTTP Basic auth, in-memory users/roles | `SecurityConfig.java` |
| 5 | JWT creation | `AuthenticationController.generateJwt()` |
| 5 | JWT verification filter | `JwtAuthorizationFilter.java` |

---

## 3. Running it in IntelliJ IDEA

1. **File → Open...** and select the `spring-learn` folder (the one containing `pom.xml`). IntelliJ detects it as a Maven project and imports dependencies automatically (needs internet access to Maven Central the first time).
2. Wait for the Maven import to finish (status bar bottom-right).
3. Make sure **Project SDK** is Java 11+ (`File → Project Structure → Project`).
4. Open `SpringLearnApplication.java` and click the green ▶ run icon next to `main()`, **or** run:
   ```bash
   mvn spring-boot:run
   ```
5. Console output confirms startup on port **8090**, plus the Doc-1 demo logs (`displayDate`, `displayCountry`, `displayCountries`) and, once security is enabled, a generated default password (ignore this — it's only used if you hit an endpoint without configured credentials, which shouldn't happen with the in-memory users below).

> If your machine sits behind a corporate proxy (as the original docs assume), add proxy settings to Maven's `settings.xml` or pass `-Dhttp.proxyHost=... -Dhttp.proxyPort=...` to the `mvn` command — IntelliJ's own Maven runner respects the same `settings.xml`.

---

## 4. Trying every endpoint

Since Spring Security (Doc 5) is active, **every** endpoint except `/authenticate` needs either:
- HTTP Basic credentials (`user`/`pwd` or `admin`/`pwd`), or
- a `Authorization: Bearer <token>` header obtained from `/authenticate`.

### Get a token
```bash
curl -s -u user:pwd http://localhost:8090/authenticate
# {"token":"eyJhbGciOiJIUzI1NiJ9...."}
```

### Use the token
```bash
TOKEN=$(curl -s -u user:pwd http://localhost:8090/authenticate | python3 -c "import sys,json;print(json.load(sys.stdin)['token'])")

curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/hello
curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/countries
curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/countries/in
curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/employees
curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/departments
```

### Create a country (POST + validation)
```bash
# Valid payload
curl -i -H "Authorization: Bearer $TOKEN" -H 'Content-Type: application/json' \
  -X POST -d '{"code":"FR","name":"France"}' http://localhost:8090/countries

# Invalid payload -> 400 with validation message
curl -i -H "Authorization: Bearer $TOKEN" -H 'Content-Type: application/json' \
  -X POST -d '{"code":"F","name":"France"}' http://localhost:8090/countries
```

### Update / delete an employee (PUT/DELETE + validation)
```bash
curl -i -H "Authorization: Bearer $TOKEN" -H 'Content-Type: application/json' -X PUT \
  -d '{"id":101,"name":"Arun Kumar","salary":60000,"permanent":true,"dateOfBirth":"15/03/1990","department":{"id":1,"name":"Engineering"},"skills":[{"id":1,"name":"Java"}]}' \
  http://localhost:8090/employees

curl -i -H "Authorization: Bearer $TOKEN" -X DELETE http://localhost:8090/employees/104
```

### Missing country -> 404
```bash
curl -i -H "Authorization: Bearer $TOKEN" http://localhost:8090/countries/az
```

---

## 5. Running the tests

In IntelliJ: right-click `SpringLearnApplicationTests.java` → **Run**.
From the command line:
```bash
mvn clean test
```

---

## 6. Notes / intentional simplifications

- All "database" data (countries, employees, departments) is loaded from XML files under `src/main/resources` into in-memory `ArrayList`s, exactly as the hands-on docs describe — there is no real database yet (that comes in a later Spring Data JPA module per Doc 5's note).
- The JWT secret key (`"secretkey"`) and Spring Security in-memory users/passwords are hard-coded for learning purposes only, matching the hands-on docs — never do this in production.
- `WebSecurityConfigurerAdapter` is deprecated (removed in Spring Security 6 / Spring Boot 3) but still present in Spring Boot 2.7.x, which is what this project targets so the code matches the hands-on docs exactly.
