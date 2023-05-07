public class Produto {
    private String nome;
    private double preco;
    private Data dataValidade;
    
    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    // Getter e Setter para o atributo dataValidade 
    public Data getDataValidade() {
        return this.dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    // Getter e Setter para o atributo nome
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    // Getter e Setter para o atributo preco
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean estaVencido(Data dataAtual) {
        // verifica se o ano atual é maior ou igual ao ano da data passada por parâmetro
        if (dataAtual.getAno() <= this.dataValidade.getAno()) {
          // se o ano for igual, verifica se o mês atual é maior ou igual ao mês da data passada por parâmetro
          if (dataAtual.getMes() <= this.dataValidade.getMes()) {
            // se o mês for igual, verifica se o dia atual é maior ao dia da data passada por parâmetro
            if (dataAtual.getDia() <= this.dataValidade.getDia()) {
              // se a data atual for anterior à data passada por parâmetro, retorna false
              return true;
            }
          }
        }
        // se a data atual for posterior à data passada por parâmetro, retorna true
        return false;
      }

    @Override
    public String toString() {
        return String.format("\nProduto\nNome: %s | Preço: R$%.2f | dataValidade: %s", nome, preco, dataValidade.toString());
    }
}
