<h1 align="left">Microserviço - Envio de e-mail</h1>

<p align="left">Microserviço que permite enviar e-mail.</p>

<h2 align="left">Tecnologias Utilizadas</h2>

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="50" width="62" alt="java logo"  />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="50" width="62" alt="spring logo"  />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" height="50" width="62" alt="mysql logo"  />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" height="50" width="62" alt="docker logo"  />
   <img src="https://cdn.jsdelivr.net/npm/simple-icons@8.8.0/icons/rabbitmq.svg" height="50" width="62" alt="RabbitMQ logo"  />
</div>

<h2 align="left">Schemas JSON</h2>

E-mail
```json
{
  "ownerRef": "Paulo Dias",
  "emailFrom": "seuemailconfigurado@gmail.com",
  "emailTo": "paulo.dias@gmail.com",
  "subject": "Muito obrigado!",
  "text": "Obrigado por comprar conosco!"
}
```

<h2 align="left">Observações</h2>

<ul>
    <li>O JAVA 11 e o Docker precisam estar instalados em sua máquina</li>
    <li>Após clonar o projeto, abra o terminal na pasta raíz e execute o seguinte comando: docker-compose up -d</li>
    <li>Configure seu e-mail, para que seja gerado uma senha para aplicativos terceiros (não é a senha padrão)</li>
    <li>Configure o arquivo "application.properties" com o seu e-mail, senha gerada, endereço do RabbitMQ e o nome da fila</li>
    <li>Documentação disponível pelo Swagger em: http://localhost:8085/swagger-ui/index.html#/</li>
</ul>
