docker-compose rm -f && docker rmi $(docker images | awk '/^myapp/ { print $1 }') && docker rmi $(docker images | awk '/^<none>/ { print $3 }') 
