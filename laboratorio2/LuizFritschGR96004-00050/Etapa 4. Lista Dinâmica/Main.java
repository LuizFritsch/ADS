public class Main {
    public static void main(String[] args) {
        // Testando a LinkedStack
        Stack<Integer> stack = new LinkedStack<>();
        System.out.println("Pilha (LinkedStack) - Testes");
        
        System.out.println("Push 1, 2, 3 na pilha");
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top()); // Deve imprimir 3
        System.out.println("Tamanho: " + stack.size()); // Deve imprimir 3

        System.out.println("Pop: " + stack.pop()); // Deve imprimir 3
        System.out.println("Top: " + stack.top()); // Deve imprimir 2
        System.out.println("Tamanho: " + stack.size()); // Deve imprimir 2

        System.out.println("Pop: " + stack.pop()); // Deve imprimir 2
        System.out.println("Pop: " + stack.pop()); // Deve imprimir 1
        System.out.println("Pop (empty): " + stack.pop()); // Deve imprimir null
        System.out.println("Is Empty: " + stack.isEmpty()); // Deve imprimir true

        // Testando a LinkedQueue
        Queue<Integer> queue = new LinkedQueue<>();
        System.out.println("\nFila (LinkedQueue) - Testes");

        System.out.println("Enqueue 1, 2, 3 na fila");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("First: " + queue.first()); // Deve imprimir 1
        System.out.println("Tamanho: " + queue.size()); // Deve imprimir 3

        System.out.println("Dequeue: " + queue.dequeue()); // Deve imprimir 1
        System.out.println("First: " + queue.first()); // Deve imprimir 2
        System.out.println("Tamanho: " + queue.size()); // Deve imprimir 2

        System.out.println("Dequeue: " + queue.dequeue()); // Deve imprimir 2
        System.out.println("Dequeue: " + queue.dequeue()); // Deve imprimir 3
        System.out.println("Dequeue (empty): " + queue.dequeue()); // Deve imprimir null
        System.out.println("Is Empty: " + queue.isEmpty()); // Deve imprimir true
    }
}
