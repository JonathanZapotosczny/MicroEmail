package br.com.microservico.email.services;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.microservico.email.dtos.EmailDto;
import br.com.microservico.email.enums.StatusEmail;
import br.com.microservico.email.models.Email;
import br.com.microservico.email.repositories.EmailRepository;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final ModelMapper modelMapper;
    private final JavaMailSender javaMailSender;
    

    public EmailService(EmailRepository emailRepository, ModelMapper modelMapper, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.modelMapper = modelMapper;
        this.javaMailSender = javaMailSender;
    }

    @Transactional
    public Email create(EmailDto emailDto) {

        Email email = this.modelMapper.map(emailDto, Email.class);
        email.setSendDateEmail(LocalDateTime.now());

        try{

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            this.javaMailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException mailException) {

            email.setStatusEmail(StatusEmail.ERROR);
        }
        
        return this.emailRepository.save(email);
    }
}