docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=tabimeshi -e MYSQL_PASSWORD=password -e MYSQL_DATABASE=tabimeshi_db --volumes-from datastore --name mysql --net tabimeshi-net mysql &
