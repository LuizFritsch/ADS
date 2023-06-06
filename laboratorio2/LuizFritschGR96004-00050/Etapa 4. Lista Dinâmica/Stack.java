public interface Stack<E> {
    void push(E element); // Adiciona um elemento no topo da pilha
    E pop(); // Remove e retorna o elemento do topo da pilha
    E top(); // Retorna o elemento do topo da pilha sem removê-lo
    boolean isEmpty(); // Verifica se a pilha está vazia
    int size(); // Retorna o tamanho da pilha
}
