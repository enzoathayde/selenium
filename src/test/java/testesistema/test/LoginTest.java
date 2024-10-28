package testesistema.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import testesistema.page.LoginPO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends BaseTest {

  private static LoginPO loginPage;

  // private void logar(String email, String senha) {
  //   loginPage.escrever(loginPage.inputEmail, email);
  //   loginPage.escrever(loginPage.inputSenha, senha);
  //   loginPage.buttonLogin.click();
  // }

  @BeforeAll
  public static void prepararTestes() {
    loginPage = new LoginPO(driver);
  }

  // CASO DE TESTE 1: ESPERA-SE UMA MENSAGEM AO INSERIR O LOGIN COM CAMPOS VAZIOS
  @Test
  @Order(1)
  public void naoLogarSistemaEmailSenhaVazios() {

    loginPage.logar("", "");

    String mensagem = loginPage.obterMensagem();

    assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);

  }

  // CASO DE TESTE 2: NÃO DEVE LOGAR NA TELA COM EMAIL INCORRETO E SENHA VAZIA
  @Test
  @Order(2)
  public void naoLogarSistemaEmailIncorretoSenhaVazia() {

    loginPage.logar("teste", "");

    String mensagem = loginPage.obterMensagem();

    assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);

  }

  // CASO DE TESTE 3: NÃO DEVE LOGAR NA TELA COM EMAIL VAZIO E SENHA INCORRETA
  @Test
  @Order(3)
  public void naoLogarSistemaEmailVazioSenhaIncorreta() {

    loginPage.logar("", "teste");
    String mensagem = loginPage.obterMensagem();
    assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);

  }

  // CASO DE TESTE 4: NÃO DEVE LOGAR NA TELA COM EMAIL VAZIO E SENHA INCORRETA
  @Test
  @Order(4)
  public void naoLogarSistemaEmailSenhaIncorreta() {

    loginPage.logar("teste", "teste");
    String mensagem = loginPage.obterMensagem();
    assertEquals("E-mail ou senha inválidos", mensagem);

  }

  @Test
  @Order(5)
  public void naoLogarSistemaEmailCorretoSenhaIncorreta() {
    
    loginPage.logar("admin@admin.com", "teste");
    String mensagem = loginPage.obterMensagem();
    assertEquals("E-mail ou senha inválidos", mensagem);

  }

  @Test
  @Order(6)
  public void naoLogarSistemaEmailIncorretoSenhaCorreta() {
    
    loginPage.logar("Aadmin@admin.com", "admin@123");
    String mensagem = loginPage.obterMensagem();
    assertEquals("E-mail ou senha inválidos", mensagem);

  }

  @Test
  @Order(7)
  public void logarSistemaEmailSenhaCorreta() {
    
    loginPage.logar("admin@admin.com", "admin@123");
    String titulo = loginPage.obterTituloPagina();

    assertEquals("Controle de Produtos", titulo);

  }


}
