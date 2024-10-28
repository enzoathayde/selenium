package testesistema.build;



import testesistema.page.ControleProdutoPO;

public class ProdutoBuilder {
  
  public String codigo = "00001";
  public String nome = "Produto padrão";
  public String quantidade = "1";
  public String valor = "1.0";
  public String data = "03/11/2023";
  
  private ControleProdutoPO controleProdutoPO;

  public ProdutoBuilder(ControleProdutoPO controleProdutoPO){
    this.controleProdutoPO = controleProdutoPO;
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
  public String getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(String quantidade) {
    this.quantidade = quantidade;
  }
  public String getValor() {
    return valor;
  }
  public void setValor(String valor) {
    this.valor = valor;
  }
  public String getData() {
    return data;
  }
  public void setData(String data) {
    this.data = data;
  }

  
  public void buildProduct() {

    controleProdutoPO.escrever(controleProdutoPO.inputCodigo, codigo);
    controleProdutoPO.escrever(controleProdutoPO.inputNome, nome);
    controleProdutoPO.escrever(controleProdutoPO.inputQuantidade, quantidade.toString());
    controleProdutoPO.escrever(controleProdutoPO.inputValor, valor.toString());
    controleProdutoPO.escrever(controleProdutoPO.inputData, data);

    controleProdutoPO.buttonSalvar.click();


  }
  


}
