#!/bin/bash

SERVER="120.27.47.134"
JAR="target/learnmooc-0.0.1-SNAPSHOT.jar"

echo "Building $JAR..."
mvn clean package

echo "Upload $JAR to server $SERVER..."
scp $JAR root@$SERVER:/root/java/learnmooc

python deploy.py