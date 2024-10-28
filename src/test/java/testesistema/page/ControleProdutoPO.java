package testesistema.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ControleProdutoPO extends BasePO{

  public ControleProdutoPO(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "btn-adicionar")
  public WebElement botaoCriar;

  @FindBy(css = "ul>li>a.nav-link")
  public WebElement botaoVoltar;

  @FindBy(css = "div.modal-header>h4")
  public WebElement tituloModal;

  @FindBy(css = "div.modal-header>button")
  public WebElement botaoFecharModal;
  
  @FindBy(id = "codigo")
  public WebElement inputCodigo;

  @FindBy(id = "nome")
  public WebElement inputNome;

  @FindBy(id = "quantidade")
  public WebElement inputQuantidade;

  @FindBy(id = "valor")
  public WebElement inputValor;

  @FindBy(id = "data")
  public WebElement inputData;

  @FindBy(id = "btn-salvar")
  public WebElement buttonSalvar;

  @FindBy(id = "btn-sair")
  public WebElement buttonSair;

  @FindBy(id = "mensagem")
  public WebElement spanMensagem;

  public String obterMensagem() {
    return this.spanMensagem.getText();
  }


  public void cadastrarProduto(
  String codigo, 
  String nome, 
  String quantidade, 
  String valor, 
  String data ) {

      escrever(inputCodigo, codigo);
      escrever(inputNome, nome);
      escrever(inputQuantidade, quantidade);
      escrever(inputValor, valor);
      escrever(inputData, data);

      buttonSalvar.click();

  }


}
