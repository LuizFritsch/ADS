import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {

    public static void main(String[] args) {
        Random random = new Random();
        int tamanhoArray = random.nextInt(100) + 1; // 1 <= tamanhoArray <= 100
        Candidato[] candidatos = new Candidato[tamanhoArray];

        // Populan o array com dados aleatórios
        populaCandidatos(candidatos, tamanhoArray);

        // Imprime os candidatos não ordenados
        System.out.println("Candidatos não ordenados:");
        imprimeCandidatos(candidatos);

        // Ordena os candidatos
        ordenaCandidatos(candidatos);

        // Imprime os candidatos ordenados
        System.out.println("\nCandidatos ordenados:");
        imprimeCandidatos(candidatos);

        // Realiza pesquisa binária
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o nome do candidato a ser procurado: ");
        String nomeProcurado = scanner.nextLine();
        int posicao = pesquisaBinariaCandidatos(candidatos, nomeProcurado);

        if (posicao != -1) {
            System.out.println("Candidato encontrado: " + candidatos[posicao]);
        } else {
            System.out.println("Candidato não encontrado.");
        }

        scanner.close();
    }

    // Método para popular candidatos
    private static void populaCandidatos(Candidato[] candidatos, int tamanho) {
        String[] nomes = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gabriel", "Helena", "Igor", "Julia"};
        String[] partidos = {"Partido A", "Partido B", "Partido C", "Partido D"};

        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            String nome = nomes[random.nextInt(nomes.length)];
            String partido = partidos[random.nextInt(partidos.length)];
            int intencoesVotos = random.nextInt(1000);
            candidatos[i] = new Candidato(nome, partido, intencoesVotos);
        }
    }

    // Método para imprimir candidatos
    private static void imprimeCandidatos(Candidato[] candidatos) {
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }
    }

    // Método de ordenação considerando múltiplos critérios
    public static void ordenaCandidatos(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato key = candidatos[i];
            int j = i - 1;
            while (j >= 0 && comparaCandidatos(candidatos[j], key) > 0) {
                candidatos[j + 1] = candidatos[j];
                j = j - 1;
            }
            candidatos[j + 1] = key;
        }
    }

    // Método de comparação para os candidatos
    private static int comparaCandidatos(Candidato c1, Candidato c2) {
        int nameComparison = c1.getNome().compareTo(c2.getNome());
        if (nameComparison != 0) {
            return nameComparison;
        }
        int voteComparison = Integer.compare(c2.getIntencoesVotos(), c1.getIntencoesVotos());
        if (voteComparison != 0) {
            return voteComparison;
        }
        return c1.getPartido().compareTo(c2.getPartido());
    }

    // Método de pesquisa binária
    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        int low = 0;
        int high = candidatos.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int compareResult = candidatos[mid].getNome().compareTo(nome);
            if (compareResult < 0) {
                low = mid + 1;
            } else if (compareResult > 0) {
                high = mid - 1;
            } else {
                return mid; // Candidato encontrado
            }
        }
        return -1; // Candidato não encontrado
    }
}
