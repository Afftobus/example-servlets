## Servlet examples

Презентации:

https://docs.google.com/presentation/d/1DFx3h6QHVSq4d8jqzGqIg3f1IK9gXmbbego-Es99a7k/edit?usp=sharing

https://docs.google.com/presentation/d/1NeBOiqkEI0wt08S9Bcol7lHifRGPQLgeuvrOmic1bqg/edit?usp=sharing

### servers

Пример создания простого сервера на jetty и netty.
Каждый класс - отдельный пример.



Для сборки следующих приложений нужно выgолнить ```mvn clean package``` в соответствующей папке.

### servlet

Пример простого сервлета
Запускать ```java -jar target/servlet.jar```

```
http://localhost:8080/hello
```

### jsp

Пример использования jsp.
Запускать ```java -jar target/jsp.jar```

```
http://localhost:8080/
http://localhost:8080/jjj
http://localhost:8080/example.jsp
```

### spring-mvc

Пример использования spring-mvc
Запускать ```java -jar target/spring.jar```

```
http://localhost:8080/
http://localhost:8080/calc/{value}
```

### spring-freemarker

Запускать ```java -jar target/spring-freemarker.jar```

```
http://localhost:8080/
http://localhost:8080/test/1
http://localhost:8080/test/2
```

### jersey

Jersey.
Запускать ```java -jar target/jersey.jar```

```
http://localhost:8080/status
http://localhost:8080/data?service={service}
http://localhost:8080/data/param/{test}
http://localhost:8080/error
```

### jersey-mustache

Jersey с шаблонизатором mustache.
Запускать ```java -jar target/jersey-mustache.jar```

```
http://localhost:8080/
```
