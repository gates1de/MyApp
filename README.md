# MyApp
Web Service on Docker

## Require
- Docker
- Docker Compose
- Docker Machine
- Virtualbox

## Get Started
```
$ cd <your develop directory>
$ git clone https://github.com/gates1de/MyApp.git
$ cd MyApp
$ docker-machine create --driver virtualbox MyAppVM
$ docker-compose up &

# building & starting...

$ docker-machine ls
# Find MyAppVM IP
# And access 'http://<MyAppVM IP>/myapp/index.html'

```

## MyApp-server
WebAPI by SpringBoot

### Language, Framework, etc
- Java 1.8.0_91
- SpringBoot 1.3.5

### API

Endpoint:	`http://<MyAppVM IP>/api/v1`

| Route | Method | Overview |
|:--|:--:|:--|
| /regions | GET | Get Japanese 8 Regions Data (with Relational Data) |
| /regions/:id | GET | Get Japanese Region Data by ID |
| /prefectures | GET | Get Japanese 47 Prefectures Data (with Relational Data) |
| /prefectures/:id | GET | Get Japanese Prefecture Data by ID |
| /areas | GET | Get Areas Data (with Relational Data) |
| /areas/:id | GET | Get Area Data by ID |
| /cities | GET | Get Cities Data |
| /cities/:id | GET | Get City Data by ID |
| /genres | GET | Get Food Genres Data |
| /genres/:id | GET | Get Food Genre Data by ID |

## MyApp-client
Google Map Application (only viewing)

### Language, Framework, etc
- Javascript(ES6)
- React
- Redux
- Webpack

## apache
HTTP Server

### configuration file
- httpd.conf : For reverse proxy

## db
Database Server

### configuration file
- charset.cnf: For UTF-8

## datastore
Datastore for MySQL data

## redis
Cache Server
