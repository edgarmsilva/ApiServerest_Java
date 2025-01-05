package stepDefinitions;

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
    Map<String, String> map;
    String userId;

    @Quando("o usuário {string} fizer login com a senha {string}")
    public void o_usuário_fizer_login_com_a_senha(String usuario, String senha) {
        response = Serverest.login(usuario, senha);
    }

    @Então("a API retorna o status code {int}")
    public void a_api_retorna_o_status_code(int stausCode) {
        Assert.assertEquals(stausCode, response.getStatusCode());
    }

    @Então("devo receber a mensagem {string}")
    public void devo_receber_a_mensagem(String mensagem) {
        Assert.assertEquals(response.getBody().jsonPath().get("message"), mensagem);
    }

    @E("o token de autorização")
    public void o_token_de_autorização() {
        Assert.assertTrue(response.getBody().jsonPath().get("authorization").toString().contains("Bearer"));
    }

    @Então("devo receber a mensagem de erro {string} {string}")
    public void devo_receber_a_mensagem_de_erro(String chave, String mensagem) {
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

    @Então("devo receber a mensagem de erro correspondente")
    public void devo_receber_a_mensagem_de_erro_correspondente(DataTable dataTable) {
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
    public void fizer_uma_requisição_do_tipo_put_para_editar_o_usuário_com_as_informações_abaixo
            (DataTable data) {
        map = data.asMap(String.class, String.class);
        response = Serverest.editarUsuario(data, userId);
    }

    @Quando("fizer uma requisição do tipo PUT para editar o usuário com as informações abaixo sem informar o ID")
    public void fizer_uma_requisição_do_tipo_put_para_editar_o_usuário_com_as_informações_abaixo_sem_informar_o_id
            (DataTable data) {
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

    @Dado("excluo o usuário de teste com sucesso")
    public void excluo_o_usuário_de_teste_com_sucesso() {
        response = Serverest.excluirUsuario(userId);
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("Registro excluído com sucesso", response.jsonPath().get("message"));
    }

    @Quando("fizer uma requisição do tipo GET para listar o usuário com as informações abaixo")
    public void fizer_uma_requisição_do_tipo_get_para_listar_o_usuário_com_as_informações_abaixo
            (DataTable dataTable) {
        map = dataTable.asMap(String.class, String.class);

        map.forEach((campo, dado) -> {
            if (campo.equals("_id")) {
                response = Serverest.listarUsuario(campo, userId);
            } else {
                response = Serverest.listarUsuario(campo, dado);
            }
        });
    }

    @Então("devo receber a lista com o retorno dos usuários correspondentes")
    public void devo_receber_a_lista_com_o_retorno_dos_usuários_correspondentes() {
        map.forEach((campo, dado) -> {
            if (campo.equals("_id")) {
                Assert.assertEquals(userId, response.getBody().jsonPath().get("usuarios[0]." + campo));
            } else {
                Assert.assertEquals(dado, response.getBody().jsonPath().get("usuarios[0]." + campo));
            }
        });
    }

    @Quando("fizer uma requisição do tipo GET para buscar o usuário utilizando seu ID")
    public void fizer_uma_requisição_do_tipo_get_para_buscar_o_usuário_utilizando_seu_id() {
        response = Serverest.buscarUsuarioId(userId);
    }

    @Então("devo receber os dados do usuário")
    public void devo_receber_os_dados_do_usuário(DataTable dataTable) {
        map = dataTable.asMap(String.class, String.class);
        map.forEach((campo, dado) -> {
            if (campo.equals("_id")) {
                Assert.assertEquals(userId, response.getBody().jsonPath().get(campo));
            } else {
                Assert.assertEquals(dado, response.getBody().jsonPath().get(campo));
            }
        });
    }

    @Quando("fizer uma requisição do tipo GET para buscar o usuário sem informar um ID")
    public void fizer_uma_requisição_do_tipo_get_para_buscar_o_usuário_sem_informar_um_id() {
        response = Serverest.buscarUsuarioId("");
    }

    @Quando("fizer uma requisição do tipo DELETE para excluir esse usuário informando seu ID")
    public void fizer_uma_requisição_do_tipo_delete_para_excluir_esse_usuário_informando_seu_id() {
        response = Serverest.excluirUsuario(userId);
    }

    @Quando("fizer uma requisição do tipo DELETE para excluir um usuário inexistente")
    public void fizer_uma_requisição_do_tipo_delete_para_excluir_um_usuário_inexistente() {
        response = Serverest.excluirUsuario("useridinexistente");
    }

    @Quando("fizer uma requisição do tipo DELETE para excluir um usuário sem informar um ID")
    public void fizer_uma_requisição_do_tipo_delete_para_excluir_um_usuário_sem_informar_um_id() {
        response = Serverest.excluirUsuario("");
    }

}
