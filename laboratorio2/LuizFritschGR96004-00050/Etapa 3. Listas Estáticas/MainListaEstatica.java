import java.util.Random;

public class MainListaEstatica {
    public static void printLista(ListaEstatica<Integer> lista){
        lista.printLista();
    }

    public static void testListaEstatica(String[] args){
        if (args.length < 1) {
            System.out.println("Uso: java Main <elemento>");
            return;
        }
        // Convertendo o primeiro argumento para Integer
        int elementoContado;
        try {
            elementoContado = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("O primeiro argumento deve ser um número inteiro.");
            return;
        }
        
        Random random = new Random();
        int tamanhoLista = random.nextInt(100) + 1; // 1 < tamanho < 100

        ListaEstatica<Integer> lista = new ListaEstatica<>();
        for (int i = 0; i < tamanhoLista; i++) {
            int numeroAleatorio = random.nextInt(tamanhoLista); // Gera números aleatórios de 0 a 99
            lista.adicionar(numeroAleatorio);
        }

        

        try {
            int quantidade = lista.contaElementos(elementoContado);
            System.out.println("Lista gerada automaticamente: ");
            printLista(lista);
            System.out.println("Elemento a ser contado: " + elementoContado);
            System.out.println("Quantidade de vezes que o elemento " + elementoContado + " aparece na lista: " + quantidade);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        testListaEstatica(args);
    }
}
