package bdd.automation.api.steps;

import bdd.automation.api.api.UserAPI;
import bdd.automation.api.data.UserData;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.net.ConnectException;

public class UserStepsDefinitions {

    private UserData expectedUser;
    private UserAPI userAPI;

    public UserStepsDefinitions() {

        userAPI = new UserAPI();
    }

    @Quando("Crio um usuario")
    public void crioUmUsuario() {

        boolean statusTest = false;
        expectedUser = UserData.builder().build();

        try {
            userAPI.createUser(expectedUser);
            statusTest = true;
        }catch (ConnectException e) {
            System.out.println("Erro ao tentar se conectar com a API da PetStore.");
        }
        assertEquals(true,statusTest);
        System.out.println("O usuario foi cadastrado com sucesso !");
    }


    @Entao("O usuario e criado com sucesso")
    public void oUsuarioECriadoComSucesso() {

        String actualUsername = null;

        try {
            actualUsername = userAPI.getUsername(expectedUser);
        }catch (ConnectException e) {
            System.out.println("Erro ao tentar se conectar com a API da PetStore.");
        }
        catch (Exception e) {
            System.out.println("O usuario pesquisado, nao foi encontrado.");
        }
        assertThat(actualUsername, is(expectedUser.getUsername()));
        System.out.println("A API de consulta retornou o seguinte usuario: " + actualUsername);
    }
}
