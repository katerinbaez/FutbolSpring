FROM openjdk:21 
COPY "./target/futbol-1.jar" "app.jar"
EXPOSE 8013
ENTRYPOINT [ "java", "-jar", "app.jar" ]


##https://github.com/katerinbaez/FutbolSpring.git