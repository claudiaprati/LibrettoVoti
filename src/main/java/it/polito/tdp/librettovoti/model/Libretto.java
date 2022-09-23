package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
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
}
