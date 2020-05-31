#!/bin/bash

curl -X POST -H "Content-Type: application/vnd.kafka.binary.v2+json" -H "Accept: application/vnd.kafka.v2+json" --data '{"records":[{"value":"S2Fma2E="}]}' "http://ec2-54-176-222-249.us-west-1.compute.amazonaws.com:8082/topics/albertsons"

echo
echo

