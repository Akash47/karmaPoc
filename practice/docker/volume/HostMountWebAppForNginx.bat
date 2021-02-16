@echo off

Rem this command will nginx server and files for web application is placed \app\Karma-POC\dist\Karma-POC but this files are placed under host drive 
Rem and this web app file is mapped via volume to a container.

docker run --rm -it -p 8080:80 -v %cd%\..\app\Karma-POC\dist\Karma-POC:/usr/share/nginx/html  nginx