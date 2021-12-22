package builder;

import page.ControleDeProdutoPO;

/**
 * Classe que sabe construir ou adicionar um produto na tela.
 */
public class ProdutoBuilder {

    private String codigo = "0001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "21/12/2021";

    private ControleDeProdutoPO controleDeProdutoPO;

    /**
     * Construtor do ProdutoBuilder que recebe a pagina de controle de produtos.
     *
     * @param controleDeProdutoPO
     */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO) {
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    /**
     * Método que sabe adicionar um código ao builder.
     *
     * @param codigo Código que será adicionado.
     * @return Retorno da propria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    /**
     * Método que sabe adicionar um nome ao builder.
     *
     * @param nome Nome que será adicionado.
     * @return Retorno da propria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * Método que sabe adicionar uma quantidade ao builder.
     *
     * @param quantidade Quantidade que será adicionada.
     * @return Retorno da propria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    /**
     * Método que sabe adicionar um valor ao builder.
     *
     * @param valor Valor que será adicionado.
     * @return Retorno da propria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarValor(Double valor) {
        this.valor = valor;
        return this;
    }

    /**
     * Método que sabe adicionar uma data ao builder.
     *
     * @param data Data que será adicionada.
     * @return Retorno da propria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarData(String data) {
        this.data = data;
        return this;
    }

    /**
     * Método que constroi o produto, ou seja, adiciona o produto pela tela de cadastro de produto.
     */
    public void builder() {
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigoProduto, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNomeProduto, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidadeProduto, (quantidade != null) ? quantidade.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValorProduto, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputDataProduto, data);

        controleDeProdutoPO.buttonSalvar.click();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
