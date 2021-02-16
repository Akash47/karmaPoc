@echo off
Rem what is a dangling volume: when volume is not connected to any running or paused container is called dangling volume.
docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql

docker run --name some-mysql1 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql

docker ps -a

Rem the below cmd will remove all stoped and running containers
docker rm -f $(docker ps -aq)

Rem this will return all volume which is not assoiciate to any container. so this type of volume are called dangling volume
docker volume ls -qf dangling=true

Rem this cmd will remove all the dangling volume
docker volume rm $(docker volume ls -qf dangling=true)

