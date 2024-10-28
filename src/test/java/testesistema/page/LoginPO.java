package testesistema.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

  // criação de nova instância da pag de login
  public LoginPO(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "email")
  public WebElement inputEmail;

  @FindBy(id = "senha")
  public WebElement inputSenha;
  
  @FindBy(id = "btn-entrar")
  public WebElement buttonLogin;

  // exemplo de captura com queryselector
  @FindBy(css = "form>div.alert>span")
  public WebElement spanMensagem;

  public String obterMensagem() {
    return this.spanMensagem.getText();
  }

  public void escrever(WebElement input, String texto) {
    input.clear();
    input.sendKeys(texto + Keys.TAB);
  }

  public void logar(String email, String senha) {
    escrever(inputEmail, email);
    escrever(inputSenha, senha);
    buttonLogin.click();
  }

}
