package Etapa4;
// Classe genérica para representar um nó numa lista duplamente encadeada
public class Node<E> {
    E element; // Dado armazenado no nó
    Node<E> prev; // Referência para o nó anterior
    Node<E> next; // Referência para o próximo nó

    // Construtor que inicializa o nó com um elemento e nulo para as referências anterior e próxima
    public Node(E element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }
}
