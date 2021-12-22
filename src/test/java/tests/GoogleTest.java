package tests;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;
import page.GooglePO;

import static org.junit.Assert.assertTrue;

/**
 * FixMethodOrder é uma Anotação para executar os testes de forma ordenada, crescente.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleTest extends BaseTest {


    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTeste() {
        driver.get("https://www.google.com.br/");
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_deveSerPossivelPesquisarNoGoogleOTextoBatatFrita() {
        // Pegando elemento sem PageFactory
        //WebElement inputPesquisa = driver.findElement(By.name("q"));

        //Pegando o elemento e inserindo na pesquisa com PageFactory
        googlePage.inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);

        String resultado = googlePage.divResultadoPesquisa.getText();

        assertTrue(resultado.contains("Aproximadamente"));
    }

    @Test
    public void TC002_deveSerPossivelPesquisarNoGoogleOTextoNutella() {
        googlePage.inputPesquisa.clear();
        googlePage.pesquisar("Nutella");

        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(resultado.contains("resultados"));
    }
}
