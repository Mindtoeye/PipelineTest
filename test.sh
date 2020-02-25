#!/bin/bash
clear
rm -rf ~/.m2/repository/knossys/
cp -v ../../../../chaperone/wildfly/target/knossys-1.0.0.jar ./lib/knossys/knossys/1.0.0
mvn package
#java -cp "./target/KPipelineTestApp-jar-with-dependencies.jar:./lib/knossys-classes.jar" com.knossys.rnd.test.KPipelineTestApp -f ./tests/pipeline-timer-generate.json
echo "Run ..."
java -cp "./target/KPipelineTestApp-jar-with-dependencies.jar" com.knossys.rnd.test.KPipelineTestApp -f ./tests/pipeline-schedule.json