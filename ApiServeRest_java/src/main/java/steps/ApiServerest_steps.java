package steps;

import api.Serverest;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

public class ApiServerest_steps {

    Response response;

    @Quando("o usuário {string} fizer login com a senha {string}")
    public void o_usuário_fizer_login_com_a_senha(String usuario, String senha) {
        response = Serverest.login(usuario, senha);
    }

    @Então("deve receber a mensagem {string}")
    public void deve_receber_a_mensagem(String mensagem) {
        Assert.assertEquals(response.getBody().jsonPath().get("message"), mensagem);
    }

    @E("o token de autorização")
    public void o_token_de_autorização() {
        Assert.assertTrue(response.getBody().jsonPath().get("authorization").toString().contains("Bearer"));
    }

    @Então("deve receber a mensagem de erro {string} {string}")
    public void deve_receber_a_mensagem_de_erro(String chave, String mensagem) {
        Assert.assertEquals(response.getBody().jsonPath().get(chave), mensagem);
    }

    @Então("deve receber as mensagens de erro:")
    public void deve_receber_as_mensagens_de_erro(io.cucumber.datatable.DataTable dataTable) {


        throw new io.cucumber.java.PendingException();
    }

}
