
#Stage 1: Build War File with Gradle

FROM openjdk:8 AS TEMP_BUILD_IMAGE

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY build.gradle settings.gradle gradlew $APP_HOME

COPY gradle $APP_HOME/gradle

RUN ./gradlew build || return 0 

COPY . .

RUN ./gradlew clean build

##################################################################

#Stage 2: Copy War to Tomcat

FROM tomcat:8.5.38-jre8-alpine

ENV BUILD_APP_HOME=/usr/app/
ENV TOMCAT_HOME=/usr/local/tomcat/

WORKDIR $TOMCAT_HOME/bin

#Remove ROOT folder, to rebuild it later
RUN rm -rf $TOMCAT_HOME/webapps/ROOT

# copy the WAR bundle from build image to tomcat
COPY --from=TEMP_BUILD_IMAGE $BUILD_APP_HOME/build/libs/doan-thi-truong-cms-0.0.1-SNAPSHOT.war $TOMCAT_HOME/webapps/ROOT.war

# command to run
ENTRYPOINT ["catalina.sh", "run"]