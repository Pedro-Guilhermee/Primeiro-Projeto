package Aula2503;

import java.util.*;
import java.io.*;
import java.nio.file.*;


class LeitorSeries{
    public static List<String> ler (String nomeArq) throws IOException{
        List<String> series;
        Path arquivo;
        arquivo = Paths.get(nomeArq);
        series = Files.readAllLines(arquivo);
        return series;
    }
}
public class App3{
    public static void main(String[] args) throws IOException{
        System.out.println(LeitorSeries.ler("series.txt"));
    }
}