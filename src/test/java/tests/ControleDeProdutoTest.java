package tests;

import builder.ProdutoBuilder;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.ControleDeProdutoPO;
import page.LoginPO;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {

    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;

    @BeforeClass
    public static void prepararTeste() {
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals("Controle de Produtos", controleProdutoPage.obterTituloDaPagina());
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar() {
        controleProdutoPage.buttonAdicionar.click();
        //TODO: Remover esse clique assim que o sistema for corrigido
        controleProdutoPage.buttonAdicionar.click();

        String titulo = controleProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);

        controleProdutoPage.buttonSair.click();
        controleProdutoPage.buttonSair.click();
    }

    @Test
    public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
        controleProdutoPage.buttonAdicionar.click();
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";

        //Aqui cria o objeto para adicionar na tela
        ProdutoBuilder produto = new ProdutoBuilder(controleProdutoPage);

        //Aqui estamos testando se o produto é adicionado sem o código
        produto
                .adicionarCodigo("")
                .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        //Aqui estamos testando se o produto é adicionado sem a quantidade
        produto
                .adicionarCodigo("0005")
                .adicionarQuantidade(null)
                .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        //Aqui estamos testando se o produto é adicionado sem nome
        produto
                .adicionarQuantidade(15)
                .adicionarNome("")
                .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        //Aqui estamos testando se o produto é adicionado sem valor
        produto
                .adicionarNome("Cimento")
                .adicionarValor(null)
                .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        //Aqui estamos testando se o produto é adicionado sem data
        produto
                .adicionarNome("Cimento")
                .adicionarValor(50.0)
                .adicionarData("")
                .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

    }
}
