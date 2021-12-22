package page;

import builder.ProdutoBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleDeProdutoPO extends BasePO {

    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(className = "nav-link")
    public WebElement linkVoltar;

    @FindBy(className = "modal-title")
    public WebElement tituloModal;

    @FindBy(id = "codigo")
    public WebElement inputCodigoProduto;

    @FindBy(id = "nome")
    public WebElement inputNomeProduto;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidadeProduto;

    @FindBy(id = "valor")
    public WebElement inputValorProduto;

    @FindBy(id = "data")
    public WebElement inputDataProduto;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    /**
     * Construtor base para a criação da fabrica de elementos (PageFactory).
     *
     * @param webDriver = Driver da pagina atual.
     */
    public ControleDeProdutoPO(WebDriver webDriver) {
        super(webDriver);
    }


    public void cadastrarProduto(ProdutoBuilder produtoBuilder) {

        escrever(inputCodigoProduto, produtoBuilder.getCodigo());
        escrever(inputNomeProduto, produtoBuilder.getNome());
        escrever(inputQuantidadeProduto, produtoBuilder.getQuantidade().toString());
        escrever(inputValorProduto, produtoBuilder.getValor().toString());
        escrever(inputDataProduto, produtoBuilder.getData());

        buttonSalvar.click();

    }
}
