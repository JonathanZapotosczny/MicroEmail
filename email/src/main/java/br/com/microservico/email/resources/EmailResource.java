package br.com.microservico.email.resources;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservico.email.dtos.EmailDto;
import br.com.microservico.email.models.Email;
import br.com.microservico.email.services.EmailService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/microservice/sending-email")
@Tag(name = "E-mails")
public class EmailResource {

    private final EmailService emailService;

    public EmailResource(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Email> create(@RequestBody @Valid EmailDto emailDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.emailService.create(emailDto));
    }
}