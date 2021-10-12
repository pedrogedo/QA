package bdd.automation.api.functionalities.api;

import bdd.automation.api.functionalities.domain.UserDomain;
import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;


public class UserAPI {

    private static final String CREATE_USER_ENDPOINT = "/v3/user";
    private static final String USER_ENDPOINT = "/v3/user/{name}";

    /**
     * @param userDomain iremos a massa de dados contida na classe UserDomain passando assim
     * os atributos da classe que foram pré-definidos, como massa no nosso BODY da aplicação.
     * Com isso iremos conseguir realizar o POST e validar o status de retorno.
     */
    public void createUser(UserDomain userDomain) {

        given().
            body(userDomain).
        when().
            post(CREATE_USER_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK);
    }

    /**
     * @param userDomain esse parâmetro irá receber os atributos da classe UserDomain e com
     * isso conseguimos fazer um get e set das propriedades desta classe.
     * @return após a busca através do método GET, iremos retornar o valor do BODY cujo o atributo
     * é o username
     */
    public String getUsername(UserDomain userDomain) {
        return given().
            pathParam("name", userDomain.getUsername()).
        when().
            get(USER_ENDPOINT).
        thenReturn().
            path("username");
    }
}
