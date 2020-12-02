package proxypattern;


import java.util.Scanner;

public class LockBankKonto implements Konto {
	public String name;
	public int kontoNr;
	private double kontostand;

	
	
	LockBankKonto(String name, int kontoNr, double kontostand){
		this.name = name;
		this.kontoNr = kontoNr;
		this.kontostand = kontostand;
	}

	public void ShowAccount() throws Exception {
		System.out.println("Ihr Kontostand betr�gt: "+kontostand+"�");
		
	}

	public void download() throws Exception {
		Scanner sc = new Scanner(System.in);	
		double e = 0.00;
		System.out.println("Auszahlung");
		boolean ok;
		do {
			ok = true;
			try {
				e = sc.nextDouble();
				}
			catch (Exception ex) {
				ok = false;
				}
			if(e<0) {
				ok = false;
			}
			if(e>kontostand) {
				ok = false;
				System.out.println("Dieser Betrag ist h�her als ihr Guthaben("+kontostand+"�)! \nVersuchen Sie es erneut: ");
			}
		}
		while(!ok);
		kontostand -= e;
		ShowAccount();
	}

	public void upload() throws Exception {
		Scanner sc = new Scanner(System.in);
		double e = 0.00;
		System.out.println("Anzahlung:");
		boolean ok;
		do {
			ok = true;
			try {
				e = sc.nextDouble();
				}
			catch (Exception ex) {
				ok = false;
				}
			if(e<0) {
				ok = false;
			}
		}
		while(!ok);
		kontostand += e;
		ShowAccount();
	}

	@Override
	public void chooseOption() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Geld einzahlen(Dr�cke 0)");
		System.out.println("Geld abheben(Dr�cke 1)");
		System.out.println("Kontostand anzeigen(Dr�cke 2)");
		System.out.println("W�hle eine Aktion: ");
		int e = -1;
		boolean ok;
		do {
			ok = true;
			try {
				e = sc.nextInt();
				}
			catch (Exception ex) {
				System.out.println("Falsche Eingabe! \nVersuchen Sie es erneut: ");
				ok = false;
				}
			if(e>2 || e<0) {
				ok = false;
				System.out.println("Falsche Eingabe! \nVersuchen Sie es erneut: ");
			}
		}
		while(!ok);
		switch (e) {
			
			case 0:
				upload();
				break;
			case 1:
				download();
				break;
			case 2:
				ShowAccount();
				break;
		}
	}
	
}