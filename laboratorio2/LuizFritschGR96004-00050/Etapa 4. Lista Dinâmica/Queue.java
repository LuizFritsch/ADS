public interface Queue<E> {
    void enqueue(E element); // Adiciona um elemento no final da fila
    E dequeue(); // Remove e retorna o elemento no início da fila
    E first(); // Retorna o elemento no início da fila sem removê-lo
    boolean isEmpty(); // Verifica se a fila está vazia
    int size(); // Retorna o tamanho da fila
}