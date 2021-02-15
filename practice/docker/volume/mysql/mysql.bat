@
docker pull mysql

docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql

docker logs some-mysql

docker ps -a

docker volume ls

docker exec -it some-mysql mysql -user --user=root --password=my-secret-pw

