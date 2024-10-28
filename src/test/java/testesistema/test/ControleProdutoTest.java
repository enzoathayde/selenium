package testesistema.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import testesistema.build.ProdutoBuilder;
import testesistema.page.ControleProdutoPO;
import testesistema.page.LoginPO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ControleProdutoTest extends BaseTest {

  private static LoginPO loginPage;
  private static ControleProdutoPO productPage;

  @BeforeAll
  public static void prepararTestes() {
    loginPage = new LoginPO(driver);
    loginPage.logar("admin@admin.com", "admin@123");

    productPage = new ControleProdutoPO(driver);

    assertEquals(productPage.obterTituloPagina(), "Controle de Produtos");
  }

  // CASO 1: TESTA A ABERTURA DE UM MODAL
  @Test
  @Order(1)
  public void abrirModal() {
    productPage.botaoCriar.click();
    // Caso o cliente não veja problema em clicar duas vezes para abrir o modal de
    // cadastro, descomente instrução abaixo
    productPage.botaoCriar.click();
    String titulo = productPage.tituloModal.getText();

    assertEquals("Produto", titulo);

    productPage.botaoFecharModal.click();

  }

  // CASO 2: NÃO CADASTRAR PRODUTO SEM CAMPO FALTANTE
  @Test
  @Order(2)
  public void cadastroIncompleto() {

    productPage.botaoCriar.click();
    // productPage.botaoCriar.click();

    

    // DATA VAZIA 

    // cria objeto com todos os atributos pré-confugrados
    ProdutoBuilder produtoBuilder = new ProdutoBuilder(productPage);
    // invoca o método do objeto que coloca os métodos pŕe-configurados dentro de cada campo, NESSE CASO ESTOU RETIRANDO A DATA
    produtoBuilder.setData("");;
    produtoBuilder.buildProduct();
    String aviso = productPage.obterMensagem();
    assertEquals("Todos os campos são obrigatórios para o cadastro!", aviso);


    //VALOR VAZIO
    produtoBuilder.setValor("");;
    produtoBuilder.buildProduct();
    aviso = productPage.obterMensagem();
    assertEquals("Todos os campos são obrigatórios para o cadastro!", aviso);

    // QUANTIDADE VAZIA
    produtoBuilder.setQuantidade("");
    produtoBuilder.buildProduct();
    aviso = productPage.obterMensagem();
    assertEquals("Todos os campos são obrigatórios para o cadastro!", aviso);

    // NOME VAZIO 
    produtoBuilder.setNome("");
    produtoBuilder.buildProduct();
    aviso = productPage.obterMensagem();
    assertEquals("Todos os campos são obrigatórios para o cadastro!", aviso);

    // CÓDIGO VAZIO
    produtoBuilder.setNome("");
    produtoBuilder.buildProduct();
    aviso = productPage.obterMensagem();
    assertEquals("Todos os campos são obrigatórios para o cadastro!", aviso);

    productPage.botaoFecharModal.click();

  }

}


