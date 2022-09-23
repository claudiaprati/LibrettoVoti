package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {
    public static void main(String[] args) {
        Libretto lib=new Libretto();
        Voto v1= new Voto("Analisi 1",28, LocalDate.of(2019,10,13));
        lib.add(v1);
        lib.add(new Voto("Fisica 1",22,LocalDate.of(2022,11,10)));
        lib.add(new Voto("Informatica",30,LocalDate.of(2021,3,22)));
        lib.add(new Voto("Chimica",25,LocalDate.of(2021,11,28)));
        System.out.println(lib);
        List<Voto> venti5=lib.listaUguali(25);
        System.out.println("elenco esami con 25:\n"+venti5);
        Libretto newlib=lib.votiUguali(25);
        System.out.println("elenco esami con 25:\n"+newlib);
    }
}
