package br.com.microservico.email.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {

    @NotBlank(message = "O campo 'REFERÊNCIA' é obrigátorio!")
    private String ownerRef;

    @NotBlank(message = "O campo 'E-MAIL DE' é obrigátorio!")
    @Email
    private String emailFrom;

    @NotBlank(message = "O campo 'E-MAIL PARA' é obrigátorio!")
    @Email
    private String emailTo;

    @NotBlank(message = "O campo 'TÍTULO' é obrigátorio!")
    private String subject;

    @NotBlank(message = "O campo 'TEXTO' é obrigátorio!")
    private String text;
}