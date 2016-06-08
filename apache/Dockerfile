FROM httpd

RUN mkdir -p /usr/local/apache2/htdocs/myapp/build

COPY ./httpd.conf /usr/local/apache2/conf/httpd.conf
COPY ./index.html /usr/local/apache2/htdocs/myapp/index.html
COPY ./bundle.js /usr/local/apache2/htdocs/myapp/build/bundle.js

EXPOSE 80
