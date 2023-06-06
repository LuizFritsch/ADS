public class Informatica extends Loja {
    private double seguroEletronicos;
    public Informatica(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
            Data dataFundacao, double seguroEletronicos, int tamanhoEstoqueProdutos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoqueProdutos);
        this.seguroEletronicos = seguroEletronicos;
    }

    public double getSeguroEletronicos() {
        return this.seguroEletronicos;
    }

    public void setSeguroEletronicos(double seguroEletronicos) {
        this.seguroEletronicos = seguroEletronicos;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("\n| SeguroEletronicos: R$ %.2f", this.getSeguroEletronicos());
    }

}