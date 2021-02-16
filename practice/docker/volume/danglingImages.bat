@echo off
Rem what are Dangling images? Those images which dont have a tag assoicated with it or a name associated with it are called dangling images.

Rem The below cmd will find the dangling images in local repo.
docker images -f dangling=true

Rem build new image of an existing image.
cd ../app/Karma-POC

ng build --prod 

docker build -t karma-poc:df .

docker images

docker images -f dangling=true

Rem docker remove dangling images

docker rmi $(docker images -qf dangling=true)
