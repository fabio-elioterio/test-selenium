package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    /**
     * Construtor para a criação da pagina de Login.
     *
     * @param webDriver = Driver da pagina de Login.
     */
    public LoginPO(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Método que obtem a mensagem disparada na tela.
     * @return Texto da mensagem
     */
    public String obterMensagem() {
        return spanMensagem.getText();
    }

    /**
     * Método que tenta executar a ação de executar a ação de logar no sistema
     *
     * @param email Email para a tentativa de login
     * @param senha Senha para a tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha) {
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntrar.click();
    }
}
