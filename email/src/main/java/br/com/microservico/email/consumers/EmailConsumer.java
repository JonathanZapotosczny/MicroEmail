package br.com.microservico.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.microservico.email.dtos.EmailDto;
import br.com.microservico.email.services.EmailService;

@Component
public class EmailConsumer {
    
    private final EmailService emailService;


    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto) {
        
        emailService.create(emailDto);
    }
}