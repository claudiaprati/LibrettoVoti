package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libretto {
    private List<Voto> vt;

    public Libretto() {
        this.vt= new ArrayList<>();
    }
    public boolean add(Voto v) {
        if (!this.isConflitto(v) && ! this.isDuplicato(v)) {
            this.vt.add(v);
            return true;
        }
        else
            return false;
    }
public Libretto votiMigliorati(){
        Libretto libnew=new Libretto();
        for(Voto v:this.vt){
            int punti=v.getVoto();
            if (punti>=24)
                punti+=2;
            else
                punti++;
            if (punti>30)
                punti=30;
            libnew.add(new Voto(v.getNcorso(),punti,v.getDesame()));
        }
        return libnew;
}

    /**
     * Cancella voti minori di punti
     * @param punti valore punteggio al di sotto del quale i voti si cancellano
     */
    public  void  deletePuntiMinori(int punti){
//cancellare elementi tramite iteratore
        Iterator<Voto> it=this.vt.iterator();
        while(it.hasNext()){
                Voto v=it.next();
                if (v.getVoto()<punti) {
               // System.out.println("eliminato voto di "+v.getNcorso()+ ":"+v.getVoto());
                //Voto vn=new Voto(v.getNcorso(),v.getVoto(),v.getDesame());
                    it.remove();
                }
        }
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
   public List<Voto> getVoti(){
         return this.vt;
   }
   public boolean isDuplicato(Voto voto){
         for(Voto v: this.vt){
             //if (v.getNcorso().equals(voto.getNcorso()) && v.getVoto()==voto.getVoto())
             if (v.equals(voto))
                 return true;
         }
         return false;
   }
   public boolean isConflitto(Voto v){
         Integer punti=this.searchPuntiEsame(v.getNcorso());
        if (punti!=null && punti!=v.getVoto())
            return true;
        else
            return false;
   }
   public Integer searchPuntiEsame(String ncorso){
         for(Voto v:this.vt){
             if (v.getNcorso().equals(ncorso))
                 return v.getVoto();
         }
         return null;
   }

}
