package io.github.bruno.producer.services;

import io.github.bruno.producer.dtos.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static io.github.bruno.producer.configs.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static io.github.bruno.producer.configs.RabbitMQConfig.RK_PRODUCT_LOG;

@Service
@Log4j2
public class StringService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        log.info("Received message " + message);
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
    }

    public void sendToExchangeProduct(ProductDto dto) {
        log.info("Sending a message to exchange " + dto.toString());
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, dto.toString());
    }
}
