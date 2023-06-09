public class Alimentacao extends Loja {
    private Data dataAlvara;
    public Alimentacao(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
            Data dataFundacao, Data dataAlvara) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);
        this.dataAlvara = dataAlvara;
    }

    public Data getDataAlvara() {
        return this.dataAlvara;
    }

    public void setDataAlvara(Data dataAlvara) {
        this.dataAlvara = dataAlvara;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("\n| DataAlvara: %s", this.getDataAlvara().toString());
    }
    
}
