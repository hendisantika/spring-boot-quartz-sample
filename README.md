# Spring Boot 3 Quartz Sample

### Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-quartz-sample.git`
2. Navigate to the folder: `cd spring-boot-quartz-sample`
3. Run the application: `mvn clean spring-boot:run`
4. Open your favorite browser
5. Open Swagger UI: http://localhost:8080/api/

### MySQL

    https://hub.docker.com/_/mysql

    docker run --name mysql -p 13306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:9.1.0
    docker exec -it mysql bash
    docker logs mysql

### Quartz

    https://github.com/quartznet/quartznet/blob/main/database/tables/tables_mysql_innodb.sql
    http://www.quartz-scheduler.org/documentation/quartz-1.8.6/configuration/ConfigJDBCJobStoreClustering.html

### other

1. Google Java Format
2. SonaLint
3. CheckStyle-IDEA
4. GitHub Copilot
5. Disable import * (Settings -> Editor -> Code Style -> Java -> Imports)
