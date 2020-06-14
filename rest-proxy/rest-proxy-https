Rest Proxy HTTPS


listeners=http://0.0.0.0:8081,https://0.0.0.0:8082
ssl.truststore.location=/Users/mark.cox/Kafka/intel/kafka.server.truststore.jks
ssl.truststore.password=password
ssl.keystore.location=/Users/mark.cox/Kafka/intel/kafka.server.keystore.jks
ssl.keystore.password=password
ssl.key.password=password

#ssl.client.auth=false
#ssl.endpoint.identification.algorithm=


All options (if you set “ssl.client.auth=true”)
curl -X POST -H "Content-Type: application/vnd.kafka.json.v2+json" -H "Accept: application/vnd.kafka.v2+json" --data '{"records":[{"value":{"foo":"bar"}}]}' "https://Mark-Coxs-MBP13.local:8082/topics/rest-topic" -vvvv --cert /Users/mark.cox/Kafka/intel/ca-cert.p12 --key /Users/mark.cox/Kafka/intel/ca-key --cacert /Users/mark.cox/Kafka/intel/ca-cert


Works in “insecure” mode (i.e. ignore SSL)
Note: setting “insecure” mode doesn’t work if you set “ssl.client.auth=true”
curl -X POST -H "Content-Type: application/vnd.kafka.json.v2+json" -H "Accept: application/vnd.kafka.v2+json" --data '{"records":[{"value":{"foo":"bar"}}]}' "https://Mark-Coxs-MBP13.local:8082/topics/rest-topic" -vvvv --insecure


This also works (if you set “ssl.client.auth=false”)
curl -X POST -H "Content-Type: application/vnd.kafka.json.v2+json" -H "Accept: application/vnd.kafka.v2+json" --data '{"records":[{"value":{"foo":"bar"}}]}' "https://Mark-Coxs-MBP13.local:8082/topics/rest-topic" -vvvv --cacert /Users/mark.cox/Kafka/intel/ca-cert
