package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private Label txtAnagrammiCorretti;

    @FXML
    private TextArea txtResultCorretti;

    @FXML
    private Label txtAnagrammiErrati;

    @FXML
    private TextArea txtResultErrati;

    @FXML
    private Button btnReset;

    
    /**
     * Il metodo si occupa di far apparire i risultati del calcolo degli anagrammi 
     * @param event
     */
    
    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	String parola;
    	txtResultCorretti.clear();
    	txtResultErrati.clear();
    	
    	parola=txtParola.getText();
    	
    	if(parola.length()<2) {
    		txtResultCorretti.appendText("Parola inserita troppo corta\n");
    		txtResultErrati.appendText("Parola inserita troppo corta\n");
    		return;
    	}
    	if(parola.length()>8) {
    		txtResultCorretti.appendText("Parola inserita troppo lunga\n");
    		txtResultErrati.appendText("Parola inserita troppo lunga\n");
    		return;
    	}
    	
    	Set<String>anagrammi=this.model.calcolaAnagrammi(parola);
    	
    	for(String anagramma : anagrammi) {
    		if(this.model.isCorrect(anagramma)) {
    			txtResultCorretti.appendText(anagramma+"\n");
    		}
    		else {
    			txtResultErrati.appendText(anagramma+"\n");
    		}
    	}
    	
    			

    }

    
    
    /**
     * Il metodo si occupa di resettare i campi di testo
     * @param event
     */
    
    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtResultCorretti.clear();
    	txtResultErrati.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultCorretti != null : "fx:id=\"txtResultCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultErrati != null : "fx:id=\"txtResultErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		
	}
}
