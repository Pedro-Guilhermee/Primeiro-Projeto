package ProjSistemaEmergencia; 

class PilhaEmergencia {
    private Chamado[] elementos;
    private int topo;

    public PilhaEmergencia(int capacidade) {
        this.elementos = new Chamado[capacidade]; // Mínimo 30 conforme o PDF [cite: 58]
        this.topo = -1;
    }

    public void push(Chamado c) {
        if (topo < elementos.length - 1) {
            elementos[++topo] = c;
        }
    }

    public Chamado pop() {
        if (topo == -1) return null;
        return elementos[topo--];
    }
    
    public boolean isEmpty() {
        return topo == -1;
    }
}

class FilaComum {
    private Chamado[] elementos;
    private int tamanho, inicio, fim;

    public FilaComum(int capacidade) {
        this.elementos = new Chamado[capacidade]; // Mínimo 30 conforme o PDF [cite: 58]
        this.tamanho = 0;
        this.inicio = 0;
        this.fim = 0;
    }

    public void enqueue(Chamado c) {
        if (tamanho < elementos.length) {
            elementos[fim] = c;
            fim = (fim + 1) % elementos.length;
            tamanho++;
        }
    }

    public Chamado dequeue() {
        if (tamanho == 0) return null;
        Chamado c = elementos[inicio];
        inicio = (inicio + 1) % elementos.length;
        tamanho--;
        return c;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}