package it.polito.tdp.anagrammi.model;

import it.polito.tdp.anagrammi.DAO.AnagrammiDAO;

public class TestModel {
	
	private void start() {
		
		//---------------Test sul DAO----------------
		AnagrammiDAO anagrammaDAO = new AnagrammiDAO(); 
		
		if(anagrammaDAO.isCorrect("ciao")) {
			System.out.println("ciao è nel dizionario\n");
		}
		else {
			System.out.println("ERRORE\n");
		}
		
		if(anagrammaDAO.isCorrect("coia")) {
			System.out.println("ERRORE\n");
		}
		else {
			System.out.println("coia non è nel dizionario\n");
		}
		
		
		//--------------------Test sul modello------------------------
		Model mod=new Model();
		System.out.println(mod.calcolaAnagrammi("eta"));
		System.out.println(mod.calcolaAnagrammi("ere"));
		
	}

	public static void main(String[] args) {
		TestModel test=new TestModel();
		test.start();

	}

}
