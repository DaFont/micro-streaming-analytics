# Micro streaming analytics

## Introduction
Micro streaming analytics is a POC using a RabbitMQ broker, a mongoDB database and java spring boot application that sends messages
to this broker, read it from a specific queue, perform and statistic analysis and save in to the mongoDB.

It was developed using GIT as SCM using gitflow methodology.


## Run with docker
Just need to have docker-compose on your pc and execute "docker-compose up" **FROM DEVELOP BRANCH**.

There is known issue that affect the way the jar is generated from Dockerfile, **SO PLEASE KEEP IN MIND TO LUNCH THE APPLICATION
FROM DEVELOP BRANCH**.

You can see in the terminal how the application is working, anyway mongoDB port was exported in order to use a local mongoDB
client to see how the DB is getting processin data in two collections: one from messages, another for statistic analysis.

You can connect to this mongo on your localhost using the properties defined in the application.properties resources.

RabbitMQ is isolated and there's no way to connect outside docker.

If you have any doubt please contact me, I'll be glad to help ☺️
