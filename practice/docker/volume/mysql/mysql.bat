@echo off
docker pull mysql

docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql

docker logs some-mysql

docker ps -a

docker volume ls

docker exec -it some-mysql mysql -user --user=root --password=my-secret-pw

docker run --name some-mysql1 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d -v db:/var/lib/mysql mysql

docker exec -it some-mysql1 mysql -user --user=root --password=my-secret-pw

Rem show Databases;

Rem create Database pets;

Rem Remove all created container "docker rm -f container ID"

Rem then We will create container using same volume and it will bring back the container with same DB

docker run --name some-mysql2 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d -v db:/var/lib/mysql mysql

Rem then Run login mysql and see databases we will find pet database is already present. 
docker exec -it some-mysql1 mysql -user --user=root --password=my-secret-pw

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
