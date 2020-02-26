#!/bin/bash
clear

echo "Clean ..."
rm -rf ~/.m2/repository/knossys/
cp -v ../../../../chaperone/wildfly/target/knossys-1.0.0.jar ./lib/knossys/knossys/1.0.0

echo "Build ..."
mvn package

echo "Run ..."
java -cp "./target/KPipelineTestApp-jar-with-dependencies.jar" com.knossys.rnd.test.KPipelineTestApp -f ./tests/pipeline-schedule.json
