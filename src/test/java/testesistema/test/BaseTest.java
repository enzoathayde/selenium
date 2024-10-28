package testesistema.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

  protected static WebDriver driver;
  private static final String URL_BASE = "http://127.0.0.1:5500/login.html";
  private static final String CAMINHO_DRIVER = "src/test/java/testesistema/resource/chromedriver";

  @BeforeAll
  protected static void iniciar() {
    System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(URL_BASE);
  }

  @AfterAll
  protected static void finalizar() {
    driver.quit();
  }


}
