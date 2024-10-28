package testesistema.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Classe Base para criação das páginas novas, que devem herdar dela
public abstract class BasePO {
  
  // driver base que será utilizado pelas pages
  protected WebDriver driver;

  
  protected BasePO(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public String obterTituloPagina() {
    return driver.getTitle();
  }


}
