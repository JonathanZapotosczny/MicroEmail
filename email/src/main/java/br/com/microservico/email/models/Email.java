package br.com.microservico.email.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.microservico.email.enums.StatusEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private UUID id;

    @Column(nullable = false, length = 255)
    private String ownerRef;

    @Column(nullable = false, length = 255)
    private String emailFrom;

    @Column(nullable = false, length = 255)
    private String emailTo;

    @Column(nullable = false, length = 255)
    private String subject;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(nullable = false)
    private LocalDateTime sendDateEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 5)
    private StatusEmail statusEmail;
}