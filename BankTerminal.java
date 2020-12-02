package proxypattern;

public class BankTerminal {

	public static void main(String[] args) {
		Proxy flo = new Proxy("flo",1223123123,123123,"flostaudacher");
		
		try {
			flo.checkPasswort();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}