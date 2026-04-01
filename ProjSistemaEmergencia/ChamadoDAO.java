package ProjSistemaEmergencia;

import java.util.ArrayList;

public class ChamadoDAO {
    private PilhaEmergencia pilhaChamados = new PilhaEmergencia(60);
    private FilaComum filaChamados = new FilaComum(60);
    private ArrayList<Chamado> historico = new ArrayList<>();
    private ArrayList<Chamado> atendimentoAtivo = new ArrayList<>();
    private ArrayList<BairroContagem> qtdBairro = new ArrayList<>();

    public ChamadoDAO(){}

    public void novoChamado(Chamado chamado) {
        if (chamado.getNivelUrgencia() >= 4) {
            pilhaChamados.push(chamado);
        } else if(chamado.getNivelUrgencia() < 4){
            filaChamados.enqueue(chamado);
        }
        historico.add(chamado);
    }

    public void atenderProxChamado() {
        if(!pilhaChamados.isEmpty()){
            Chamado chamadoPilha = pilhaChamados.pop();
            chamadoPilha.setStatus("EM_ATENDIMENTO");
            atendimentoAtivo.add(chamadoPilha);
        }else if (!filaChamados.isEmpty()) {
            Chamado chamadoFila = filaChamados.dequeue();
            chamadoFila.setStatus("EM_ATENDIMENTO");
            atendimentoAtivo.add(chamadoFila);
        }   
    }

    public void finalizarAtendimento( int idRecebido) {
        for (int i = 0; i < atendimentoAtivo.size(); i++) {
            if (atendimentoAtivo.get(i).getId() == idRecebido) {
                atendimentoAtivo.get(i).setStatus("FINALIZADO");
                atendimentoAtivo.remove(i);
                break;
            }
        }
        for (int i = 0; i < historico.size(); i++) {
            if (historico.get(i).getId() == idRecebido) {
                historico.get(i).setStatus("FINALIZADO");
                break;
            }
        }

    }

    public void relatorio() {
    
    qtdBairro.clear();
    double somaUrgencia = 0;
    // 2. Contagem de Chamados por Bairro e Soma de Urgência
    for (int i = 0; i < historico.size(); i++) {
        Chamado c = historico.get(i);
        somaUrgencia += c.getNivelUrgencia(); // Acumula para a média
        boolean bairroEncontrado = false;
        // Procura se o bairro já existe na lista de contagem
        for (int j = 0; j < qtdBairro.size(); j++) {
            if (c.getBairro().equalsIgnoreCase(qtdBairro.get(j).getNome())) {
                // Se achou, incrementa o contador do objeto existente
                int atual = qtdBairro.get(j).getContagem();
                qtdBairro.get(j).setContagem(atual + 1);
                bairroEncontrado = true;
                break;
            }
        }
        // Se percorreu a lista toda e não achou o bairro, adiciona um novo
        if (!bairroEncontrado) {
            BairroContagem novoBairro = new BairroContagem();
            novoBairro.setNome(c.getBairro());
            novoBairro.setContagem(1);
            qtdBairro.add(novoBairro);
        }
    }
    // 3. Ranking: Ordenação Manual (Bubble Sort Decrescente)
    // Ordena a lista qtdBairro com base na contagem
    for (int i = 0; i < qtdBairro.size() - 1; i++) {
        for (int j = 0; j < qtdBairro.size() - 1 - i; j++) {
            if (qtdBairro.get(j).getContagem() < qtdBairro.get(j + 1).getContagem()) {
                // Troca de posição (Swap)
                BairroContagem temp = qtdBairro.get(j);
                qtdBairro.set(j, qtdBairro.get(j + 1));
                qtdBairro.set(j + 1, temp);
            }
        }
    }
    // 4. Exibição dos Resultados
    System.out.println("=== RELATÓRIO DE EMERGÊNCIAS URBANAS ===");
    System.out.println("\n--- Ranking de Bairros (Mais Problemáticos) ---");
    for (BairroContagem bc : qtdBairro) {
        System.out.println("Bairro: " + bc.getNome() + " | Chamados: " + bc.getContagem());
    }
    System.out.println("\n--- Estatísticas Gerais ---");
    if (!historico.isEmpty()) {
        System.out.printf("Média de Urgência: %.2f\n", (somaUrgencia / historico.size()));
    } else {
        System.out.println("Média de Urgência: 0.00");
    }
    // Pendentes = O que está na Pilha + O que está na Fila + O que está em Atendimento
    int pendentes = pilhaChamados.size() + filaChamados.size() + atendimentoAtivo.size();
    System.out.println("Chamados ainda pendentes/ativos: " + pendentes);
    }
}
