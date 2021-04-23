docker-compose exec kafka2 kafka-configs \
	--topic multi-region-async-0 \
	--bootstrap-server kafka2:9292 --alter \
	--replica-placement /etc/kafka/demo/flip-the-world-isr-only.json
