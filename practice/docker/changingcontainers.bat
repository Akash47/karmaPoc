@echo off

docker pull alpine

docker images

docker save alpine -o alpine.tar

ECHO now go set path to apline.tar in your docker resources.

docker run --rm -v C:/project/POC/karmaPoc/practice/docker:/data alpine ls /data

REM sending file inside a container

REM docker run --rm -it -v C:/project/POC/karmaPoc/practice/docker/alpine.tar:/data/alpine.tar alpine sh
REM mkdir /data/extract

REM tar -xf /data/alpine.tar -C /data/extract

REM cd /data/extract

REM ls

REM apk add --no-cache jq

REM jq manifest.json

Rem Sending file outside of container

Rem this command holds take docker map volume which is C:/project/POC/karmaPoc/practice/docker to /data shown in 
Rem alpine extract the same windows file to in   C:/project/POC/karmaPoc/practice/docker/alpine

docker run --rm -it -v C:/project/POC/karmaPoc/practice/docker:/data alpine mkdir /data/alpine

docker run --rm -it -v C:/project/POC/karmaPoc/practice/docker:/data alpine tar -xf /data/alpine.tar -C /data/alpine
