# Spring boot & kafka projects

Tectnology: Java 17, Spring boot 3, apache kafka


Q.1 What is Apache Kafka & what are main terminology for the same?


	1. Producer & Producer Group
	2. Consumer & Producer Group
	3. Kafka Cluster 
	4. Zookeeper
	5. Kafka Brokers
	6. Topic
	7. Partition
	8. Offset

Applications:

Q.2 How to setup Kakfa to windows system?

STEP 1: GET KAFKA

Download & setup on windows: https://kafka.apache.org/quickstart


	$ tar -xzf kafka_2.13-3.7.0.tgz
$ cd kafka_2.13-3.7.0


*** Rename folder to kafka in windows 

STEP 2: START THE KAFKA ENVIRONMENT

Kafka with ZooKeeper

	a. Run the following commands in order to start all services in the correct order:

		# Start the ZooKeeper service -- WINDOWS

		$ .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
	
		D:\Study\env\config\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

	b. Open another terminal session and run:

		Start the Kafka broker service
	
		$ .\bin\windows\kafka-server-start.bat .\config\server.properties
	
		i.e D:\Study\env\config\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties


STEP 3: CREATE A TOPIC TO STORE YOUR EVENTS

	$ .\bin\windows\kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092

	D:\Study\env\config\kafka>.\bin\windows\kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092
	Created topic quickstart-events.


STEP 4: WRITE SOME EVENTS INTO THE TOPIC


	$ .\bin\windows\kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092
	
	D:\Study\env\config\kafka>.\bin\windows\kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092
	>Hello Jarvis
	>Catmanscode demo
	>hello cat


STEP 5: READ THE EVENTS

	$ .\bin\windows\kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
	
	D:\Study\env\config\kafka>.\bin\windows\kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
	
	Hello Jarvis
	Catmanscode demo


<br/>

1. Demo app to explore apache kafka & Key terminology.
2. Real world App
3. Event Drivern Microservers using kafka
