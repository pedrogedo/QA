package bdd.automation.api.api;

import bdd.automation.api.data.UserData;
import static io.restassured.RestAssured.given;

import bdd.automation.api.exceptions.ErrorMessage;
import io.restassured.path.json.exception.JsonPathException;
import org.apache.http.HttpStatus;
import java.net.ConnectException;


public class UserAPI {

    private static final String CREATE_USER_ENDPOINT = "/v3/user";
    private static final String USER_ENDPOINT = "/v3/user/{name}";

    /**
     * @param userData iremos a massa de dados contida na classe UserDomain passando assim
     * os atributos da classe que foram pré-definidos, como massa no nosso BODY da aplicação.
     * Com isso iremos conseguir realizar o POST e validar o status de retorno.
     */
    public void createUser(UserData userData) throws ConnectException {
        given().
            body(userData).
        when().
            post(CREATE_USER_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK);
    }

    /**
     * @param userData esse parâmetro irá receber os atributos da classe UserDomain e com
     * isso conseguimos fazer um get e set das propriedades desta classe.
     * @return após a busca através do método GET, iremos retornar o valor do BODY cujo o atributo
     * é o username
     */
    public String getUsername(UserData userData) throws ConnectException, JsonPathException {

            return given().
                pathParam("name", userData.getUsername()).
            when().
                get(USER_ENDPOINT).
            thenReturn().
                path("username");
    }
}
