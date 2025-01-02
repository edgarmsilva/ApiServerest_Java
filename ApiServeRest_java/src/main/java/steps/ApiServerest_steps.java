package steps;

import api.Serverest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

public class ApiServerest_steps {

    Response response;
    String userId;
    Map<String, String> map;

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

    @Quando("fizer uma requisição do tipo POST para cadastrar o usuário abaixo")
    public void fizer_uma_requisição_do_tipo_post_para_cadastrar_o_usuário_abaixo(DataTable dataTable) {
        response = Serverest.CadastrarUsuario(dataTable);
    }

    @Então("o id do usuário cadastrado realizado com sucesso")
    public void o_id_do_usuário_cadastrado_realizado_com_sucesso() {
        Assert.assertNotNull(response.getBody().jsonPath().get("_id"));
        userId = response.jsonPath().get("_id");

    }

    @Então("deve receber a mensagem de erro correspondente")
    public void deve_receber_a_mensagem_de_erro_correspondente(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        map.forEach((campo, mensagem) -> {
            Assert.assertEquals(response.getBody().jsonPath().get(campo), mensagem);
        });
    }

    @Dado("que eu possua um usuário Cadastrado")
    public void que_eu_possua_um_usuário_cadastrado() {
        userId = Serverest.CadastrarUsuarioTeste();

    }

    @Quando("fizer uma requisição do tipo PUT para editar o usuário com as informações abaixo")
    public void fizer_uma_requisição_do_tipo_put_para_editar_o_usuário_com_as_informações_abaixo(io.cucumber.datatable.DataTable data) {
        map = data.asMap(String.class, String.class);
        response = Serverest.editarUsuario(data, userId);
    }

    @Quando("fizer uma requisição do tipo PUT para editar o usuário com as informações abaixo sem informar o ID")
    public void fizer_uma_requisição_do_tipo_put_para_editar_o_usuário_com_as_informações_abaixo_sem_informar_o_id(io.cucumber.datatable.DataTable data) {
        map = data.asMap(String.class, String.class);
        response = Serverest.editarUsuario(data, "");
    }

    @Então("verifico que os dados do usuário foram atualizados na consulta")
    public void verifico_que_os_dados_do_usuário_foram_atualizados_na_consulta() {
        response = Serverest.listarUsuario("_id", userId);
        map.forEach((campo, dado) -> {
            Assert.assertEquals(response.getBody().jsonPath().get("usuarios[0]." + campo), dado.replace("\"", ""));
        });

    }

}
