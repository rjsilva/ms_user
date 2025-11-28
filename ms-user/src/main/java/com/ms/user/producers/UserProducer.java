package com.ms.user.producers;

import com.ms.user.dtos.EmailRecordDTO;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}")
    private String rountingKey;

    public void publishMessageEmail(UserModel userModel){
        var emailDTO = new EmailRecordDTO(
                userModel.getUserId(),
                userModel.getEmail(),
                "Cadastro realizado com sucesso",
                userModel.getName() + "Obrigado por usar nossa plataforma"
        );
        rabbitTemplate.convertAndSend("", rountingKey, emailDTO);
    }
}
