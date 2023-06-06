import java.text.Normalizer;
public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantidadeMaximaLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaLojas];
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return this.lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    // este método recebe um objeto do �po Loja por
    // parâmetro e insere esta loja no array lojas, na primeira posição livre do
    // array (ou seja, a primeira posição nula). O método retorna verdadeiro caso
    // a loja seja inserida corretamente e falso caso contrário (ou seja, caso não
    // haja lugar no array).
    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < this.lojas.length; i++) {
            if (this.lojas[i] == null) {
                this.lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    // este método recebe uma String que representa o nome
    // de uma loja e remove a loja com este nome do array lojas. O método
    // retorna verdadeiro caso a loja seja removida e falso caso contrário (caso
    // não haja a loja com o nome solicitado no array).
    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < this.lojas.length; i++) {
            if (this.lojas[i] == null) {
                continue;
            }
            if (this.lojas[i].getNome().equals(nomeLoja)) {
                this.lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    // este método recebe como parâmetro
    // uma String que indica o tipo de loja que deve ser buscado (Cosmé�co,
    // Vestuário, Bijuteria, Alimentação ou Informatica). Deve-se então retornar
    // a quantidade de lojas desse tipo que existem no shopping. Caso seja
    // recebida uma String que não corresponde a nenhuma das opções
    // anteriores, o método retorna –1.
    public int quantidadeLojasPorTipo(String tipoLoja) {
        int quantidade = -1;
        //Para cada loja eu vejo se ela é do tipo que eu recebi por parametro
        //pra isso eu tive que normalizar a string recebida
        for (Loja loja : this.lojas) {
            String tipoLojaSemAcentos = Normalizer.normalize(tipoLoja, Normalizer.Form.NFD);
            tipoLojaSemAcentos = tipoLojaSemAcentos.replaceAll("[^\\p{ASCII}]", "");
            if (loja != null && loja.getClass().getSimpleName().equals(tipoLojaSemAcentos)) {
                if (quantidade == -1) {
                    quantidade = 0;
                }
                quantidade++;
            }
        }
        return quantidade;
    }
    
    // este método não recebe parâmetros e retorna
    // a loja do tipo Informatica que paga o maior valor de seguro de 
    // eletrônicos do shopping. Caso não haja lojas deste tipo, o método retorna
    // null.
    public Informatica lojaSeguroMaisCaro(){
        double maiorSeguro = 0;
        Informatica lojaMaiorSeguro = null;

        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica lojaInformatica = (Informatica) loja;
                double seguroEletronicos = lojaInformatica.getSeguroEletronicos();
                if (seguroEletronicos > maiorSeguro) {
                    maiorSeguro = seguroEletronicos;
                    lojaMaiorSeguro = lojaInformatica;
                }
            }
        }

        return lojaMaiorSeguro;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("\n| Nome: %s\n| Endereco: %s | \nquantidade de lojas: %i", this.getNome(), this.getEndereco().toString(), this.lojas.length);
    }
}
