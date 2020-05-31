#!/bin/bash

curl -X POST -H "Content-Type: application/vnd.kafka.v2+json" --data '{"name": "albertsons_instance", "format": "binary", "auto.commit.enable": "true"}' http://ec2-54-176-222-249.us-west-1.compute.amazonaws.com:8082/consumers/java_consumer

sleep 1

curl -X POST -H "Content-Type: application/vnd.kafka.v2+json" --data '{"topics":["albertsons"]}' http://ec2-54-176-222-249.us-west-1.compute.amazonaws.com:8082/consumers/java_consumer/instances/albertsons_instance/subscription

sleep 1

echo
echo

curl -X GET -H "Accept: application/vnd.kafka.binary.v2+json" http://ec2-54-176-222-249.us-west-1.compute.amazonaws.com:8082/consumers/java_consumer/instances/albertsons_instance/records | jq

echo
echo

sleep 1

curl -X DELETE -H "Content-Type: application/vnd.kafka.v2+json" http://ec2-54-176-222-249.us-west-1.compute.amazonaws.com:8082/consumers/java_consumer/instances/albertsons_instance
