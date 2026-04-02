import java.util.Scanner;
public class Exerc5 {
    public static void main(String[] args) {
        Pilha p = new Pilha (100);
        int n, cont = 0;
        char resp;
        Scanner s = new Scanner(System.in);
        do {// leitura dos números
            System.out.print("Deseja fornecer um nro (S/N): ");
            resp = s.next().toUpperCase().charAt(0);
            if (resp == 'S') {
                System.out.print("Forneça o "+ ++cont + "o nro: ");
                n = s.nextInt();
                p.push(n);
            }
        } while( resp == 'S');
         
    } 
}
        