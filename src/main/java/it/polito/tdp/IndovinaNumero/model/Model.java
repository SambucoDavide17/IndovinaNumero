package it.polito.tdp.IndovinaNumero.model;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class Model {
	
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;
	
	private Set<Integer> tentetivi;
	
	public void nuovaPartita() {
		
		//gestione inizio nuova partita
    	this.segreto = (int) (Math.random() * NMAX) +1;
    	this.tentativiFatti = 0;
    	this.inGioco = true;
    	tentetivi = new HashSet<Integer>();
	}
	
	public int tentativo(int tentativo) {
		
		if(inGioco == false) {
			throw new IllegalStateException("Hai perso, il segreto era " + segreto);
		}
		if(tentativoValido(tentativo) == false) {
			throw new InvalidParameterException("Devi interire un numero da 1 a NMAX, senza inserire due volte lo stesso numero");
		}
		
		tentativiFatti ++;
		tentetivi.add(tentativo); 
		
		if(tentativiFatti == (TMAX-1))
			inGioco = false;
		
		if(tentativo == segreto) {
			inGioco = false;
			return 0;
		}
		else if (tentativo < segreto)
			return -1;
		else
			return 1;			
	}
	
	public boolean tentativoValido(int tentativo) {
		if(tentativo < 1 || tentativo > NMAX) 
			return false;
		if(tentetivi.contains(tentativo))
			return false; 
		return true;
	}

	public int getSegreto() {
		return segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
	}
	

}
