FROM docker.hotro.zing.vn/myplus/java:8u111-jre-alpine-k8s


ENV APP_NAME tsearch

ENV JAVA_OPTS "-Denv=dev -Xms512m -Xmx512m -server -XX:+PrintGCDateStamps -verbose:gc -XX:+PrintGCDetails -Xloggc:/tmp/gc.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M"

ADD "target/\$APP_NAME-jar-with-dependencies.jar" "/home/myplus/app.jar"
