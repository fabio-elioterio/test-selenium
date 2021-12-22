package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para a criação de novas PageObjects
 * Todas as pages devem ser herdadas desta classe
 */
public abstract class BasePO {

    /**
     * Driver base que será usado pelas pages
     */
    protected WebDriver webDriver;


    /**
     * Construtor base para a criação da fabrica de elementos (PageFactory).
     *
     * @param webDriver = Driver da pagina atual.
     */
    public BasePO(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Método que retorna o título da página atual
     */
    public String obterTituloDaPagina() {
        return webDriver.getTitle();
    }

    /**
     * Método que sabe escrever em qualuquer WebElement do tipo input e da um TAB ao final
     * @param input Input a qual será escrito
     * @param texto Texto que será escrito no input
     */
    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto);
    }
}
