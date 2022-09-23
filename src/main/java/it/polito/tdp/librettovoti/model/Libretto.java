package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Libretto {
    private List<Voto> vt;

    public Libretto() {
        this.vt= new ArrayList<>();
    }
    public void add(Voto v) {
        this.vt.add(v);
    }

    @Override
    public String toString() {
        /*return "Libretto{\n" +
                "vt=" + vt +
                "}\n";

         */
        String s="";
        for(Voto v: this.vt){
            s+=v.toString()+"\n";
        }
        return s;
    }
    /*
    public  String votiUguali(int punteggio){
        // calcola la stringa dei voti da stampare e poi il chiamante procede nella stampa
        String s="";

    }
    */
    public  List<Voto> listaUguali(int punteggio){
        // restituisce una lista di voti da stampare e poi il chiamante procede nella stampa
        //qui nondecido quali sono i dati da stampare ma sarà ilchiamante che li seleziona a suo piacere
        //difetto: si espone all'esterno il tipo di dati che ho usato all'interno
        List<Voto> nl=new LinkedList<>();
        for(Voto v:this.vt){
            if (v.getVoto() ==punteggio)
                nl.add(v);// lo stesso oggetto è contenuto in due liste diverse (quella del libretto e quella della linkedList in cui l'ho inserito
        }
        return nl;
    }

    /**
     * Ricerca un voto associato al corso indicato come parametro
     * se corso non esiste ritorna NULL
     * @param materia nome del corso di cui si vuole avere il voto
     * @return riferimento ad oggetto voto o NULL se materia non esiste nel libretto
     */
     public Voto searchVoto(String materia){
        Voto ris=null;
        for(Voto v: this.vt){
            if (v.getNcorso().equals(materia))
                ris=v;
        }
        return ris;
    }


    public Libretto votiUguali(int punteggio){
        // restituisce un altro libretto con soli i voti che soddisfano la condizione che ha il metodo toString con cui potersi stampare
        Libretto nl=new Libretto();
        for(Voto v:this.vt) {
            if (v.getVoto() == punteggio) {
                nl.add(v);// lo stesso oggetto è contenuto in due liste diverse (quella del libretto e quella della linkedList in cui l'ho inserito
                //qui si potrebbe dire  nl.vt.add(v)

            }
        }
        return nl;
    }


}
