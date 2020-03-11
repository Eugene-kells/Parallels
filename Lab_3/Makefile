.PHONY: run-db
run-db:
    docker image build -t lab-3-db .
    docker run --name lab-3-dbha -d -p 2345:5432 -e POSTGRES_PASSWORD=admin123 lab-3-db


.PHONY: remove-db
remove-db:
    docker rm -f lab-3-dbha
    docker rmi -f lab-3-db