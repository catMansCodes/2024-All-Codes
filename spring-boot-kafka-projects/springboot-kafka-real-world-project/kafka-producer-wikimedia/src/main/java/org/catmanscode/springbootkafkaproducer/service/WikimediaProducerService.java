package org.catmanscode.springbootkafkaproducer.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.catmanscode.springbootkafkaproducer.handler.WikimediaEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class WikimediaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaProducerService.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.producer.topic.name}")
    private String topicName;

    public void sendMessageToProducer() throws InterruptedException {

        // To read realtime stream data from wikimedia to producer, we use the event source i.e OkHTTP EventSource third party Jar

        EventHandler eventHandler = new WikimediaEventHandler(kafkaTemplate, topicName);

        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();

        eventSource.start();

        TimeUnit.MINUTES.sleep(10);

    }

}
