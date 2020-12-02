package proxypattern;

import java.util.ArrayList; 
import java.util.List;
import java.util.Scanner; 
  
  
public class Proxy implements Konto {
	
	private String passwort;
	private Konto flo;
	
	Proxy(String name, int kontoNr, double kontostand, String passwort){
		flo = new LockBankKonto(name,kontoNr,kontostand);
		this.passwort = passwort;
	}
	
	@Override
	public void chooseOption() throws Exception {
		flo.chooseOption();
	}

	public void checkPasswort() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben Sie Ihr Passwort ein:");
		String e = sc.next();
		while(!e.equals(passwort)) {
			System.out.println("Falsches Passwort! \n Geben Sie Ihr Passwort erneut ein:");
			e = sc.next();
		}
		chooseOption();
	}
	
}