public class Candidato {
    private String nome;
    private String partido;
    private int intencoesVotos;

    public Candidato(String nome, String partido, int intencoesVotos) {
        this.nome = nome;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }

    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public int getIntencoesVotos() {
        return intencoesVotos;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Partido: " + partido + ", Intenções de Votos: " + intencoesVotos;
    }
}
