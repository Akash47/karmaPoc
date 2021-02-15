@echo off

Rem --rm will not work with -d (which is detached mode) 
Rem Below command is a docker in which runs docker in detached mode on port 8080 with name NginxName
docker run -d -p 8080:80 --name nginxName nginx

docker exec -it nginxName bash

cd /usr/share/nginx/html

mv index.html index2.html

docker cp %cd%\..\app\Karma-POC\dist\Karma-POC\. nginxName:/usr/share/nginx/html

docker commit nginxName karma-poc:nginx

docker run -p 8090:80 karma-poc:nginx