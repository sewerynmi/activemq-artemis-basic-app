# Basic Java Messaging app with use of Apache ActiveMQ Artemis
#### This example is for Native version of Artemis, not the Embeded one.

## Run Artemis as Docker container - docker compose
App has `docker-compose.yml` file so run command `docker-compose up -d` to start container.

Then run the spring boot app. 

## Run Artemis as Docker container - manually
`docker run -p8161:8161 -p61616:61616 --name artemis joylife/apache-artemis:arm64`

Of course, you can also download Artemis and run it on your local machine. The broker has to be created manually on your local machine. It is good solution if you don't like to use Docker or have some isees
with it. I've tested it without use of Docker, so feel free to try.

This one is for M1 Chip. Remove tag `arm64` for Intel CPU.

## Run Artemis as Docker container with custom username and password

`docker run -p 8161:8161 -p 61616:61616 -e ARTEMIS_USER=john -e ARTEMIS_PASSWORD=mama --name artemis joylife/apache-artemis:arm64`

#### Do not forget to change properties `spring.artemis.user` and `spring.artemis.password` if you use custom username and password!



## Login to ActiveMQ console
`http://localhost:8161/`

Username : `artemis` (or your custom username)
 
Password : `artemis` (or your custom password)

## Sending test message via Postman

REST endpoint : `http://localhost:8080/message/send`

Method: `POST`

Body (raw->Text) : `Your message here`

Then observe message in the app console logs. 

# Updates

#### 03 Sept 2022 :  Sending message to other queue specified in request body

>**Added:** sending messages to a queue specified in the POST request. The queue should exist (check `application.properties` file) as receivers at this stage are 
> designed to read messages from existing queues, so do not play hero by sending messages to unknown queues ok ? :)
> 
> Example:
`jms.otherQueue=myOtherQueue` is the other queue to which messages can be sent via POST to endpoint: 
> 
> `http://localhost:8080/message/sendtoqueue`
>
>This endpoint requires `JSON` body with keys `queue` and `message`
> 
> Example:
><pre>{
>"queue": "myOtherQueue", 
>"message": "Alicia has a funky cat"
>}</pre>