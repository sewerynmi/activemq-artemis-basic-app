# Basic Java Messaging app with use of Apache ActiveMQ Artemis
#### This example is for Native version of Artemis, not the Embeded one.

## Run Artemis as Docker container
`docker run -p8161:8161 -p61616:61616 --name artemis joylife/apache-artemis:arm64`

Of course, you can also download Artemis and run it on your local machine. The broker has to be created manually on your local machine. It is good solution if you don't like to use Docker or have some isees
with it. I've tested it without use of Docker, so feel free to try.

This one is for M1 Chip. Remove tag `arm64` for Intel CPU.

## Run Artemis as Docker container with custom username and password

`docker run -p 8161:8161 -p 61616:61616 -e ARTEMIS_USER=john -e ARTEMIS_PASSWORD=mama --name artemis joylife/apache-artemis:arm64`

#### Do not forget to change properties `spring.artemis.user` and `spring.artemis.password` if you use custom username and password!



## Login to ActiveMQ console
`http://localhost:8161/`

Username : `artemis`

Password : `artemis`

## Sending test message via Postman

REST endpoint : `http://localhost:8080/message/send`

Method: `POST`

Body (raw->Text) : `Your message here`

Then observe message in the app console logs. 