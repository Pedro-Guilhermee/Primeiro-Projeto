package ProjSistemaEmergencia;

import java.util.ArrayList;

public class ChamadoDAO {
    private Pilha pilhaChamados = new Pilha(60);
    private Fila filaChamados = new Fila(60);
    private ArrayList<Chamado> historico = new ArrayList<>();
    private ArrayList<Chamado> atendimentoAtivo = new ArrayList<>();

    public ChamadoDAO(){
        
    }

    public void novoChamado(Chamado chamado) {
    // Se urgência ≥ 4 → vai para PILHA de emergência
    // Se urgência < 4 → vai para FILA comum
    // Sempre registrar no HISTÓRICO (Arraylist ou LinkedList)
        if (chamado.getNivelUrgencia() >= 4) {
            pilhaChamados.push(chamado);
        } else if(chamado.getNivelUrgencia() < 4){
            filaChamados.enqueue(chamado);
        }
        historico.add(chamado);
    }

    public void atenderProxChamado() {
    // Se houver emergência → desempilha
    // Senão → desenfileira
    // Move para Lista Linear de atendimentos ativos
        Chamado chamadoPilha = pilhaChamados.pop();
        Chamado chamadoFila = filaChamados.dequeue();
        if (chamadoPilha.getNivelUrgencia() >= 4) {
            atendimentoAtivo.add(chamadoPilha);
        } else if(chamadoFila.getNivelUrgencia() < 4){
            atendimentoAtivo.add(chamadoFila);
        }
    }

    public void finalizarAtendimento() {
    // Remove da lista linear
    // Marca como FINALIZADO no histórico
    // Para atualizar o status no histórico, o grupo deverá implementar busca linear
    // na estrutura utilizada pelo id do chamado.
    }

    public void relatorio(){
    // Total de chamados por bairro
    // Ranking de bairros mais problemáticos (ordenado decrescente)
    // Média de urgência
    // Chamados ainda pendentes
    }
}
