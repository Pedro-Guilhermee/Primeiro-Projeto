import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Implementação de uma Pilha (Stack) Genérica.
 * @param <T> Tipo de dado que a pilha irá armazenar.
 */
public class Pilha<T> {
    private ArrayList<T> itens;

    // Construtor
    public Pilha(int tamanho) {
        this.itens = new ArrayList<>();
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return itens.isEmpty();
    }

    // Adiciona um elemento ao topo
    public void push(T elemento) {
        itens.add(elemento);
    }

    // Remove e retorna o elemento do topo
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return itens.remove(itens.size() - 1);
    }

    // Retorna o topo sem remover
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return itens.get(itens.size() - 1);
    }

    // Retorna o tamanho da pilha
    public int size() {
        return itens.size();
    }

    // Limpa a pilha
    public void clear() {
        itens.clear();
    }

    // Exibição amigável da estrutura
    @Override
    public String toString() {
        return "Pilha: " + itens.toString();
    }
}