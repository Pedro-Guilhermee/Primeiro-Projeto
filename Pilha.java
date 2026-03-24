public class Pilha<Integer> {
    private int elementos[];
    private int topo;

    public Pilha(int numero) {
        this.elementos = new int[numero];
        this.topo = -1;
    }

    public void push(int numero) {
        topo++;
        elementos[topo] = numero;
    }

    public int pop() {
        int valor = elementos[topo];
        topo--;
        return valor;
    }
    
    public int sizeElements() {
        return this.topo + 1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }
    
    public void lista(String nomePilha) {
        for (int i = topo; i >= 0; i--) {
            System.out.println("Posicao [" + i + "] = " + elementos[i] + " da pilha " + nomePilha);
        }
    }
    public int[] getElementos() {
        return elementos;
    }

    public void setElementos(int[] elementos) {
        this.elementos = elementos;
    }

    public int getTopo() {
        return topo;
    }

    public void setTopo(int topo) {
        this.topo = topo;
    }
}
