package api;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;


public class Serverest {

    public static Response login(String email, String password) {
        String body = "{\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .log().all()
                .post("https://serverest.dev/login")
                .then()
                .log().all()
                .extract().response();

        return response;
    }

    public static Response CadastrarUsuario(DataTable dataTable) {

        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String body = "{\n" +
                "  \"nome\": " + map.get("nome") + ",\n" +
                "  \"email\": " + map.get("email") + ",\n" +
                "  \"password\": " + map.get("password") + ",\n" +
                "  \"administrador\": " + map.get("administrador") + "\n" +
                "}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .log().all()
                .post("https://serverest.dev/usuarios")
                .then()
                .log().all()
                .extract().response();


        return response;
    }

    public static String CadastrarUsuarioTeste() {
        String body = "{\n" +
                "  \"nome\": \"teste Automação\",\n" +
                "  \"email\": \"testeautomacao@email.com\",\n" +
                "  \"password\": \"teste123\",\n" +
                "  \"administrador\": \"false\"\n" +
                "}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .log().all()
                .post("https://serverest.dev/usuarios")
                .then()
                .log().all()
                .extract().response();

        Assert.assertEquals(201, response.getStatusCode());

        return response.jsonPath().get("_id");
    }

    public static Response editarUsuario(DataTable dataTable, String id) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String body = "{\n" +
                "  \"nome\": " + map.get("nome") + ",\n" +
                "  \"email\": " + map.get("email") + ",\n" +
                "  \"password\": " + map.get("password") + ",\n" +
                "  \"administrador\": " + map.get("administrador") + "\n" +
                "}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .log().all()
                .put("https://serverest.dev/usuarios/"+id)
                .then()
                .log().all()
                .extract().response();

        return response;
    }

    public static Response listarUsuario(String tipo, String valor) {

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .param(tipo, valor)
                .log().all()
                .get("https://serverest.dev/usuarios")
                .then()
                .log().all()
                .extract().response();

        return response;
    }
}
