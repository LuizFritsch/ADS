public class Bijuteria extends Loja{
    private double metaVendas;
    public Bijuteria(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
            Data dataFundacao, double metaVendas, int tamanhoEstoqueProdutos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoqueProdutos);
        this.metaVendas = metaVendas;
    }

    public double getMetaVendas() {
        return this.metaVendas;
    }

    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }
    

    @Override
    public String toString() {
        return super.toString() + String.format("\n| MetaVendas: R$%.2f", this.getMetaVendas());
    }

}
