package ProjSistemaEmergencia;

public class Pilha {
    private Chamado elementos[];
    private int topo;

    public Pilha(Chamado chamadoPilha) {
        this.elementos = new Chamado[chamadoPilha];
        this.topo = -1;
    }

    public void push(Chamado chamadoPilha) {
        topo++;
        elementos[topo] = chamadoPilha;
    }

    public Chamado pop() {
        Chamado valor = elementos[topo];
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
    public Chamado[] getElementos() {
        return elementos;
    }

    public void setElementos(Chamado[] elementos) {
        this.elementos = elementos;
    }

    public int getTopo() {
        return topo;
    }

    public void setTopo(int topo) {
        this.topo = topo;
    }
}
