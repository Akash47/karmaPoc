#Base Image

> This is the Base image which will be responsible for running apps.
> Any application is going to run in docker container will extend this base image.
> There are 2 base image present. Both images are designed to java application.
>  * Ubuntu (base-ubuntu)
>  * Alpine (base-alpine)

> Both the images is having 
> * openjdk 8
> * JAVA 8
> * Maven 3.6.3
> * Gradle 4.0.0

### To build Images

*To build images with docker file execute the cmd below*

> docker build -t base-alpine . -f base-alpine.Dockerfile
> docker build -t base-ubuntu . -f base-ubuntu.Dockerfile

### RUN IMAGE
*To run this image we have to execute below cmd*
> docker run -it base-alpine bash
> docker run -it base-ubuntu bash

