package ProjSistemaEmergencia;

public class Fila {
    private Chamado[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;
    public Fila(int tamanhoFila) {
        elementos = new Chamado[tamanhoFila];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }
    public boolean isEmpty() { return tamanho == 0; }
    public boolean isFull() { return tamanho == elementos.length; }
    public void enqueue(Chamado chamadoFila) {
        if (isFull()) {
        System.out.println("Fila cheia!");
        return;
        }
        fim++;
        elementos[fim] = chamadoFila;
        tamanho++;
    }
    public Chamado dequeue() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
        return null;
        }
        Chamado valor = elementos[inicio];
        inicio++;
        tamanho--;
        return valor;
    }
    public Chamado peek() {
        if (isEmpty()) {
            return null;
        }
        return elementos[inicio];
    }
}
