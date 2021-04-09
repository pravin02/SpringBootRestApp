This is an SpringBootRestAPIApp as a starter for rest API using spring boot framework and JPA(Java Persistant API)


Currently I have implemented only following APIs,
1) countries 	- http://localhost:8080/api/countries
2) states	- http://localhost:8080/api/states/1
3) cities	- http://localhost:8080/api/cities/1


To Test Api's using swagger we can opt this url,
http://localhost:8080/swagger-ui.html

http://localhost:8080/v2/api-docs

1) To run this project you can clone it or download backup and configure in eclipse editor or Intellij Editor.
2) Install mysql
3) Create database restapp
4) And run project using maven-build

In future I am planning to integrate this backend rest apis with Angular 8 frontend repository https://github.com/pravin02/Admin-lte-starter-template .

public static final String REGEX = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";