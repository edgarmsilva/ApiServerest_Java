package stepDefinitions;

import api.Serverest;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Objects;

public class Hooks {
    Response response;

    @Before
    public void setUp() {
        response = Serverest.listarUsuario("email", "testeAutomacao@email.com");
        if (!Objects.equals(response.jsonPath().get("quantidade").toString(), "0")) {
            response = Serverest.excluirUsuario(response.jsonPath().get("usuarios[0]._id"));
            Assert.assertEquals("Registro excluído com sucesso", response.jsonPath().get("message"));
        }
    }
}
