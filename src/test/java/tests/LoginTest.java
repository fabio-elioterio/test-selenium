package tests;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.LoginPO;

import static org.junit.Assert.assertEquals;

/**
 * FixMethodOrder é uma Anotação para executar os testes de forma ordenada, crescente.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTeste() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {

        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagem();

        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {

        loginPage.executarAcaoDeLogar("teste", "");
        String mensagem = loginPage.obterMensagem();

        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {
        loginPage.executarAcaoDeLogar("", "teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailESenhaIncorretos() {
        loginPage.executarAcaoDeLogar("teste", "teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals("E-mail ou senha inválidos", mensagem);
    }

    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailCorretoESenhaIncorreta() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals("E-mail ou senha inválidos", mensagem);
    }

    @Test
    public void TC006_naoDeveLogarNoSistemaComEmailIncorretoESenhaCorreta() {
        loginPage.executarAcaoDeLogar("Aadmin@admin.com", "admin@123");
        String mensagem = loginPage.obterMensagem();

        assertEquals("E-mail ou senha inválidos", mensagem);
    }

    @Test
    public void TC007_deveLogarNoSistemaComEmailESenhaCorretos() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        assertEquals("Controle de Produtos", loginPage.obterTituloDaPagina());
    }
}
