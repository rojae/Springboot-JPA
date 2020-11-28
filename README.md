# Springboot-JPA
Springboot JPA Practice


## DB Setting


### 1. docker download
> url('https://hub.docker.com/editions/community/docker-ce-desktop-windows/')

### 2. new postgres
> docker run -p 5432:5432 -e POSTGRES_PASSWORD=rojae8918 -e POSTGRES_USER=rojae -e POSTGRES_DB=springdata --name postgres_boot -d postgres<br/>

> docker exec -i -t postgres_boot bash

### 3. use database, table
> su - postgres</br>

> psql springdata<br/>
> -> or psql --username rojae --dbname springdata

### 4. query
> database view : 
> \list

>table view : 
>\dt

>example query : 
>SELECT * FROM account;










