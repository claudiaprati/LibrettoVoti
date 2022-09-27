/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.lang.model.type.NullType;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML // fx:id="lblStatus"
    private Label lblStatus; // Value injected by FXMLLoader

    @FXML // fx:id="btnAdd"
    private Button btnAdd; // Value injected by FXMLLoader

    @FXML // fx:id="cmbPunti"
    private ComboBox<Integer> cmbPunti; // Value injected by FXMLLoader

    @FXML // fx:id="txtData"
    private DatePicker txtData; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader
    @FXML // fx:id="txtElencoVoti"
    private TextArea txtElencoVoti; // Value injected by FXMLLoader

    private Libretto modello;

    @FXML
    void handleBtnAdd(ActionEvent event) {
        Alert errAlert=new Alert(Alert.AlertType.WARNING);

        //fase1: recupero dei dati
        String nome=txtNome.getText();
        Integer punteggio= cmbPunti.getValue();
        LocalDate dataVoto=txtData.getValue();

        //fase2: esecuzione dell'operazione (chiedere al modello di farlo)
        //qui controlli sui dati inseriti
        if (nome.equals("") || punteggio==null || dataVoto== null){
            //errore sui dati inseriti
            errAlert.setTitle("Errore");
            errAlert.setContentText("DEVI inserire il nome della disciplina, il punteggio del voto e la data!!!!");
            errAlert.show();
            lblStatus.setText("DEVI inserire il nome della disciplina, il punteggio del voto e la data!!!!");
                    //uscita dal gestore dell'evento
        }
        else {
            modello.add(new Voto(nome, punteggio, dataVoto));

            //fase3: visualizzazione/aggiornamento risultato

            //notifica di avvenuto inserimento
            //variazione della text area con nuovo voto
            //txtElencoVoti.setText(modello.toString());
//meglio che interfaccia del modello sia sempre ad oggetti
            //compito del controller è decidere come visualizzare le cose
            List<Voto> elenco= modello.getVoti();
            txtElencoVoti.clear();
            txtElencoVoti.appendText("Hai superato "+elenco.size()+" esami\n");
            for(Voto v: elenco){
                txtElencoVoti.appendText(v.toString()+"\n");
            }
            //txtNome.setText("");
            txtNome.clear();
            txtData.getEditor().clear();
            cmbPunti.setValue(null);
            lblStatus.setText("");
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";

        for(int i=18;i<=30;i++)
            cmbPunti.getItems().add(i);
    }
    public void setModel(Libretto l){
        this.modello=l;
    }

}
