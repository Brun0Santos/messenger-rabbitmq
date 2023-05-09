package io.github.bruno.consumerservice.consumers;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class StringConsumer {
    @RabbitListener(queues = "product.log")
    public void consumer(String message) {
        log.info("Consumer received a message: " + message);
    }
}
