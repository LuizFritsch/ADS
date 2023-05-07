public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;

    // Construtor que inicializa todos os atributos
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
    }

    // Construtor que inicializa apenas nome e quantidade de funcionários,
    // colocando -1 no salário base dos funcionários
    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.salarioBaseFuncionario = -1;
    }

    // Getter e Setter para o atributo endereco
    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // Getter e Setter para o atributo dataFundacao
    public Data getDataFundacao() {
        return this.dataFundacao;
    }

    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }


    // Getter e Setter para o atributo nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para o atributo quantidadeFuncionarios
    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    // Getter e Setter para o atributo salarioBaseFuncionario
    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    // Método que retorna quanto a loja gasta com o salário de todos os seus funcionários
    // retorna -1 caso o salário base dos funcionários não tenha sido definido
    public double gastosComSalario() {
        if (salarioBaseFuncionario == -1) {
            return -1;
        }
        return quantidadeFuncionarios * salarioBaseFuncionario;
    }

    // Método que retorna o tamanho da loja
    // P: pequena (menos de 10 funcionários)
    // M: média (10 a 30 funcionários - inclusive)
    // G: grande (mais de 30 funcionários)
    public char tamanhoDaLoja() {
        if (quantidadeFuncionarios < 10) {
            return 'P';
        } else if (quantidadeFuncionarios <= 30) {
            return 'M';
        } else {
            return 'G';
        }
    }

    @Override
    public String toString() {
        return String.format("\nLoja\nNome: %s | salarioBaseFuncionario: R$%.2f | quantidadeFuncionarios: %s | \nenderecoLoja: %s | \ndataFundacao: %s", nome, salarioBaseFuncionario, quantidadeFuncionarios, endereco, dataFundacao.toString());
    }
}