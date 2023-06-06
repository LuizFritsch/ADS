public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;

    // Construtor que inicializa todos os atributos
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int tamanhoEstoqueProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[tamanhoEstoqueProdutos];
    }

    // Construtor que inicializa apenas nome e quantidade de funcionários,
    // colocando -1 no salário base dos funcionários
    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int tamanhoEstoqueProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.salarioBaseFuncionario = -1;
        this.estoqueProdutos = new Produto[tamanhoEstoqueProdutos];
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

    // Getter e Setter para o atributo estoqueProdutos
    public Produto[] getEstoqueProdutos() {
        return this.estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }
    
    // este método não recebe parâmetros e imprime a
    // informação de todos os produtos da loja
    public void imprimeProdutos(){
        // tive que adicionar a validacao para elementos nulos
        // estava dando erro no validador
        for (Produto produto : estoqueProdutos) {
            if (produto == null) {
                continue;
            }
            System.out.println(produto.toString());
        }
    }

    // este método recebe uma String que representa o
    // nome de um produto e remove o produto correspondente do estoque. O
    // método retorna verdadeiro caso o produto tenha sido removido e falso
    // caso contrário (caso não haja o produto solicitado no estoque)
    public boolean removeProduto(String nomeProduto){
        for (int i = 0; i < estoqueProdutos.length; i++) {
            // se o produto for nulo, pula para o próximo
            // validador estava dando erro 
            // quando o estoque estava vazio no meio da lista
            if (this.estoqueProdutos[i] == null) {
                continue;
            }
            if (this.estoqueProdutos[i].getNome().equals(nomeProduto)) {
                this.estoqueProdutos[i] = null;
                return true;
            }
        }
        return false;
    }

    // este método recebe um Produto por parâmetro e
    // insere-o na primeira posição livre do array de estoque desta loja (ou seja,
    // na primeira posição nula do array). O método deve retornar verdadeiro 
    // caso o produto seja inserido no estoque ou falso caso não seja (no caso de
    // não haver espaço).
    public boolean insereProduto(Produto produto){
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (this.estoqueProdutos[i] == null) {
                this.estoqueProdutos[i] = produto;
                return true;
            }
        }
        return false;
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