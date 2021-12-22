package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(id = "result-stats")
    public WebElement divResultadoPesquisa;

    /**
     * Construtor base para a criação da pagina do Google.
     *
     * @param webDriver = Driver da pagina do google.
     */
    public GooglePO(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Método que irá efetuar uma pesquisa no google baseando-se no texto informado e concluindo com enter.
     *
     * @param texto = Texto a ser pesquisado.
     */
    public void pesquisar(String texto) {
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /**
     * Método que irá retornar o resultado aproximado da pesquisa
     *
     * @return = Retorna o resultado da pesquisa
     */
    public String obterResultadoDaPesquisa() {
        return divResultadoPesquisa.getText();
    }
}
