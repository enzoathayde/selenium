package testesistema.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import testesistema.page.ControleProdutoPO;
import testesistema.page.LoginPO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ControleProdutoTest extends BaseTest {
  
  private static LoginPO loginPage;
  private static ControleProdutoPO productPage;

  @BeforeAll
  public static void prepararTestes() {
    loginPage = new LoginPO(driver);
    loginPage.logar("admin@admin.com","admin@123");

    productPage = new ControleProdutoPO(driver);

    assertEquals(productPage.obterTituloPagina(), "Controle de Produtos");
  }

  // CASO 1: TESTA A ABERTURA DE UM MODAL
  @Test
  public void abrirModal() {
    productPage.botaoCriar.click();
    // Caso o cliente não veja problema em clicar duas vezes para abrir o modal de cadastro, descomente instrução abaixo
     // productPage.botaoCriar.click();
    String titulo = productPage.tituloModal.getText();

    assertEquals("Produto", titulo);
  }


}
