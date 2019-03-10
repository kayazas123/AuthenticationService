# AuthenticationService


docker run --name postgres -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine

docker run  --detach --name ec-mysql -p 5432:5432 -e POSTGRES_PASSWORD=password -d postgres:alpine

# For angular application

FROM nginx:alpine

COPY nginx.conf /etc/nginx/nginx.conf

WORKDIR /usr/share/nginx/html
COPY dist/


docker image build -t usershub-angular-app .


mvn spring-boot:run -Dspring.profiles.active=postgres


