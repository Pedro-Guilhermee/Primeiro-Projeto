package ProjSistemaEmergencia;

import java.util.Scanner;

public class Programa
 {
    public static void main(String[] args) {
        ChamadoDAO chamadoDao = new ChamadoDAO();
        Chamado chamado;
        Scanner sc = new Scanner(System.in);

        int id = 1;
        int opcMenu;
        do {
            System.out.println("=============== MENU ===============");
            System.out.println("1. Abrir novo chamado\n"+
                               "2. Atender próximo chamado\n" + 
                               "3. Finalizar chamado\n" +
                               "4. Exibir relatório\n" +
                               "5. Encerrar programa\n"
            );
            System.out.print("Digite uma opção: ");
            opcMenu = sc.nextInt();
            sc.nextLine();
            if (opcMenu == 1) {
                System.out.print("Digite o bairro do paciente: ");
                String bairroDigitado = sc.nextLine();
                System.out.print("Digite a descrição do paciente: ");
                String descricaoDigitada = sc.nextLine();
                System.out.print("Digite o nível de urgência do paciente: ");
                int urgenciaDigitada = sc.nextInt();
                sc.nextLine();
                chamado = new Chamado(id, bairroDigitado, descricaoDigitada, urgenciaDigitada);
                chamadoDao.novoChamado(chamado);
                id++;
            } else if (opcMenu == 2) {
                chamadoDao.atenderProxChamado();
            } else if (opcMenu == 3) {
                System.out.print("Informe o ID do chamado que deseja finalizar: ");
                int idDigitado = sc.nextInt();
                chamadoDao.finalizarAtendimento(idDigitado);
            } else if (opcMenu == 4) {
                chamadoDao.relatorio();
            }
        } while (opcMenu < 5 || opcMenu > 0);
        
    }
}
