public class ListaEstatica<E> {
    private static final int TAMANHO_MAXIMO = 100;
    private E[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public ListaEstatica() {
        elementos = (E[]) new Object[TAMANHO_MAXIMO];
        tamanho = 0;
    }

    public void adicionar(E elemento) {
        if (tamanho < TAMANHO_MAXIMO) {
            elementos[tamanho] = elemento;
            tamanho++;
        } else {
            throw new IllegalStateException("A lista está cheia.");
        }
    }

    public int contaElementos(E el) throws IllegalArgumentException {
        if (el == null) {
            throw new IllegalArgumentException("O elemento não pode ser nulo.");
        }
        int contador = 0;
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(el)) {
                contador++;
            }
        }
        return contador;
    }

    public void printLista() {
        System.out.print("[");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i]);
            if (i != tamanho - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
