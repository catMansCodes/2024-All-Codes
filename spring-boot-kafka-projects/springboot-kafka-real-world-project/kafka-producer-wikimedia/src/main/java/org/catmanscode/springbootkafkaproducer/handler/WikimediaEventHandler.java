package org.catmanscode.springbootkafkaproducer.handler;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@AllArgsConstructor
@NoArgsConstructor
public class WikimediaEventHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaEventHandler.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.producer.topic.name}")
    private String topicName;

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {

        LOGGER.info(String.format("Event Data ==> %s", messageEvent.getData()));

        kafkaTemplate.send(topicName, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
