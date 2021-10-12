package bdd.automation.api.functionalities.domain;

import lombok.Builder;
import lombok.Data;


/**
 * Usamos a tag @Data do Lombok para criar métodos GET e SETTERS para todos os atributos para
 * que fiquem acessíveis em outras classes.
 *
 * Usamos o Builder para poder utilizar o @Builder.Default para que inicialize com as informações padrões
 * definidas nesta classe, caso nenhum valor seja informado.
 */

@Data
@Builder
public class UserDomain {

    @Builder.Default
    private int id = 10;
    @Builder.Default
    private String username = "pedro";
    @Builder.Default
    private String firstName = "Pedro";
    @Builder.Default
    private String lastName = "Rosendo";
    @Builder.Default
    private String email = "pedrorosendo@gmail.com";
    @Builder.Default
    private String password = "12345";
    @Builder.Default
    private String phone = "(11) 92222-5555";
    @Builder.Default
    private int userStatus = 1;

}
