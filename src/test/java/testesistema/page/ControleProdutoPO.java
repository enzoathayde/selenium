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
  
}
