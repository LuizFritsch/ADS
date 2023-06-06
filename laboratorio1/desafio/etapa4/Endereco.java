public class Endereco {
    private String nomeDaRua;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private String numero;
    private String complemento;

    // Construtor
    public Endereco(String nomeDaRua, String cidade, String estado, String pais, String cep, String numero, String complemento) {
        this.nomeDaRua = nomeDaRua;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    // Getter e Setter para o atributo nomeDaRua
    public String getNomeDaRua() {
        return nomeDaRua;
    }

    public void setNomeDaRua(String nomeDaRua) {
        this.nomeDaRua = nomeDaRua;
    }

    // Getter e Setter para o atributo cidade
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // Getter e Setter para o atributo estado
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Getter e Setter para o atributo pais
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // Getter e Setter para o atributo cep
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    // Getter e Setter para o atributo numero
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Getter e Setter para o atributo complemento
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return String.format("\nEndereco\n" +
                "   | nomeDaRua: %s\n" +
                "   | cidade: %s\n" +
                "   | estado: %s\n" +
                "   | pais: %s\n" +
                "   | cep: %s\n" +
                "   | numero: %s\n" +
                "   | complemento: %s",
                nomeDaRua,
                cidade,
                estado,
                pais,
                cep,
                numero,
                complemento
            );
    }
}
