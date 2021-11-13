# MySQL

1. Run MySQL using docker

```shell
docker run --name mysql -e MYSQL_ROOT_PASSWORD=password -d -p 3306:3306 mysql:8.0.21
```

2. Create test database

```shell
docker exec -it mysql bash
mysql -u root -p
create database test
```

# 결과

```shell
mysql> show status like 'Threads_connected';
+-------------------+-------+
| Variable_name     | Value |
+-------------------+-------+
| Threads_connected | 11    |
+-------------------+-------+
1 row in set (0.00 sec)
```

`LazyConnectionDataSourceProxy`를 사용하더라도 Application 기동시에 connection자체는 생성된다.
