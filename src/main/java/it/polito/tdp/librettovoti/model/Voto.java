package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
//esempio di classe POJO - Plain Old Java Obect
// java Bean
//semplice contenitore di dati , no logica, non fa cose

/**
 * Memorizza risultato di un esame
 * @author claudia
 */
public class Voto {
    private String ncorso;
    private int voto;
    private LocalDate desame; //meglio della classe Date

    /**
     * costruttore con pafanetri della classe voto
     * @param ncorso - nome del corso superato
     * @param voto - voto ottenuto
     * @param desame - data di superamento
     */
    public Voto(String ncorso, int voto, LocalDate desame) {
        this.ncorso = ncorso;
        this.voto = voto;
        this.desame = desame;
    }

    public void setNcorso(String ncorso) {
        this.ncorso = ncorso;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public void setDesame(LocalDate desame) {
        this.desame = desame;
    }

    public String getNcorso() {
        return ncorso;
    }

    public int getVoto() {
        return voto;
    }

     public LocalDate getDesame() {
        return desame;
    }

    @Override
    public String toString() {
        /*return "Voto{" +
                "ncorso='" + ncorso + '\'' +
                ", voto=" + voto +
                ", desame=" + desame +
                "}\n";
    */
        return ncorso+":"+voto+"\n";
    }
    public boolean equals(Voto v){
        if (v.getVoto()==this.voto && v.getNcorso().equals((this.ncorso))&&v.getDesame().equals(this.desame))
            return true;
        else
            return false;
    }

}
