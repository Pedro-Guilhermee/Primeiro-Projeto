package Aula2503;

import java.util.*;
import java.nio.file.*;

class LeitorSeries{
    public static List<String> ler (String nomeArq){
        List<String> series;
        Path arquivo;
        arquivo = Paths.get(nomeArq);
        series = Files.readAllLines(arquivo);
        return series;
    }

}
public class App0{
    public static void main(String[] args){
        System.out.println(LeitorSeries.ler("series.txt"));
    }
}
