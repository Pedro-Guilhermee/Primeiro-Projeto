public class Fila {
    private int[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;
    public Fila(int capacidade) {
        elementos = new int[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }
    public boolean isEmpty() { return tamanho == 0; }
    public boolean isFull() { return tamanho == elementos.length; }
    public void enqueue(int valor) {
        if (isFull()) {
        System.out.println("Fila cheia!");
        return;
        }
        fim++;
        elementos[fim] = valor;
        tamanho++;
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
        return -1;
        }
        int valor = elementos[inicio];
        inicio++;
        tamanho--;
        return valor;
    }
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return elementos[inicio];
    }
}
