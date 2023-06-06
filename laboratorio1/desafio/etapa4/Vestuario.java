public class Vestuario extends Loja {
    private boolean produtosImportados;
    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
            Data dataFundacao, boolean produtosImportados, int tamanhoEstoqueProdutos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoqueProdutos);
        this.produtosImportados = produtosImportados;
    }

    public boolean getProdutosImportados() {
        return this.produtosImportados;
    }

    public void setProdutosImportados(boolean produtosImportados) {
        this.produtosImportados = produtosImportados;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("\n| ProdutosImportados: %s", this.getProdutosImportados() ? "Sim" : "Não");
    }
    
}
