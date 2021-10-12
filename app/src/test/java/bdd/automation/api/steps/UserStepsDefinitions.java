package bdd.automation.api.steps;

import bdd.automation.api.functionalities.api.UserAPI;
import bdd.automation.api.functionalities.domain.UserDomain;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class UserStepsDefinitions {

    private UserDomain expectedUser;
    private UserAPI userAPI;

    public UserStepsDefinitions() {

        userAPI = new UserAPI();
    }


    @Quando("Crio um usuario")
    public void crioUmUsuario() {

        expectedUser = UserDomain.builder().build();
        userAPI.createUser(expectedUser);
    }

    @Entao("O usuario e criado com sucesso")
    public void oUsuarioECriadoComSucesso() {

        String actualUsername = userAPI.getUsername(expectedUser);
        assertThat(actualUsername, is(expectedUser.getUsername()));
    }

}
