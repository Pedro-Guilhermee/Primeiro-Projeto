package ProjSistemaEmergencia;

import java.util.Scanner;

public class Programa
 {
    public static void main(String[] args) {
        ChamadoDAO chamadoDao = new ChamadoDAO();
        Chamado chamado;
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja abrir um chamado: (S/N)?");
        char opcChamado = sc.next().toUpperCase().charAt(0);
        sc.nextLine();
        int id = 1;
        while (opcChamado == 'S') {
            System.out.println("Digite o bairro do paciente:");
            String bairroDigitado = sc.nextLine();
            System.out.println("Digite a descrição do paciente:");
            String descricaoDigitada = sc.nextLine();
            System.out.println("Digite o nível de urgência do paciente:");
            int urgenciaDigitada = sc.nextInt();
            chamado = new Chamado(id, bairroDigitado, descricaoDigitada, urgenciaDigitada);
            chamadoDao.novoChamado(chamado);
            id++;
            System.out.println("Deseja abrir um chamado: (S/N)?");
            opcChamado = sc.next().toUpperCase().charAt(0);
        }
        
    }
}
