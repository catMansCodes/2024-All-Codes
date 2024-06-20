package org.catmanscode.springbootkafkaconsumer.service;

import org.catmanscode.springbootkafkaconsumer.model.WikimediaData;
import org.catmanscode.springbootkafkaconsumer.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumerService.class);
    private WikimediaRepository wikimediaRepository;

    public KafkaDatabaseConsumerService(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(
            topics = "${spring.kafka.consumer.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage) {

        LOGGER.info(String.format("Event Received Messages : %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();

        wikimediaData.setWikiEventData(eventMessage);

        wikimediaRepository.save(wikimediaData);
    }

}
