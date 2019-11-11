FROM centos

MAINTAINER aksarav@middlewareinventory.com

RUN sudo mkdir /opt/tomcat/

WORKDIR /opt/tomcat
RUN sudo curl -O https://www-eu.apache.org/dist/tomcat/tomcat-9/v9.0.27/bin/apache-tomcat-9.0.27.tar.gz
RUN sudo tar xvfz apache*.tar.gz
RUN sudo mv apache-tomcat-9.0.27/* /opt/tomcat/.
RUN sudo yum -y install java
RUN sudo java -version

WORKDIR /opt/tomcat/webapps
RUN sudo curl -O -L https://github.com/AKSarav/SampleWebApp/raw/master/dist/SampleWebApp.war

EXPOSE 8080

CMD ["/opt/tomcat/bin/catalina.sh", "run"]