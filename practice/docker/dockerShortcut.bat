@echo off

Rem Docker clean up cmd

Rem the below cmd will give the list of running container name
docker ps -q

Rem  the below command will stop all running container without. This work on shell not on cmd prompt
docker stop $(docker ps -q)

Rem the below cmd will remove all the stop containers.
docker rm $(docker ps -aq)

Rem the below cmd will remove all stoped and running containers
docker rm -f $(docker ps -aq)

Rem this cmd is use remove the volume.
docker volume rm volumeId or name

Rem This cmd will list out all volume name and Id 
docker volume ls -q

Rem This cmd is use to remove all volume which are list out 
docker volume rm $(docker volume ls -q)
Rem or 
docker volume prune

Rem To remove the all images from  docker we use this cmd
docker images prune
rem or 
docker rmi $(docker images -q)