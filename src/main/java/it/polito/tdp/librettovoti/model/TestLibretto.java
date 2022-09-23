package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

public class TestLibretto {
    public static void main(String[] args) {
        Libretto lib=new Libretto();
        Voto v1= new Voto("Analisi 1",28, LocalDate.of(2019,10,13));
        lib.add(v1);
        lib.add(new Voto("Fisica 1",22,LocalDate.of(2022,11,10)));
        lib.add(new Voto("Informatica",30,LocalDate.of(2021,3,22)));
        System.out.println(lib);
    }
}
