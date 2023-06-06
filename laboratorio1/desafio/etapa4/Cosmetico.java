public class Cosmetico extends Loja{
    private double taxaComercializacao;
    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
            Data dataFundacao, double taxaComercializacao, int tamanhoEstoqueProdutos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoqueProdutos);
        this.taxaComercializacao = taxaComercializacao;
    }


    public double getTaxaComercializacao() {
        return this.taxaComercializacao;
    }

    public void setTaxaComercializacao(double taxaComercializacao) {
        this.taxaComercializacao = taxaComercializacao;
    }



    @Override
    public String toString() {
        return super.toString() + String.format("\n| TaxaComercializacao: R$%.2f", this.getTaxaComercializacao());
    }

    
}
