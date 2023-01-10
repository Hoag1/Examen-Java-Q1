package examenJanvier2023;


public class Printer extends Device {
	
	private int PageImp;
	private int FeuillePapier;
	private boolean On;
	private boolean Impression;
	
	
	public Printer() {
		super();
		this.PageImp = 0;
		this.FeuillePapier = 10;
        setType("Printer");
	}
	
	
	public Printer(String Marque, String Modele, int Numserie, int PuissanceW, int PageImp, int FeuillePapier, boolean On, boolean Impression) {
		super(Marque, Modele, Numserie, PuissanceW);
		this.PageImp = PageImp;
		this.FeuillePapier = FeuillePapier;
		this.On = On;
		this.Impression = Impression;
		setType("Printer");
	}
	
	
	
	
	
	
	public int getPageImp() {
		return PageImp;
	}


	public void setPageImp(int pageImp) {
		PageImp = pageImp;
	}


	public int getFeuillePapier() {
		return FeuillePapier;
	}


	public void setFeuillePapier(int feuillePapier) {
		FeuillePapier = feuillePapier;
	}


	public boolean getOn() {
		return On;
	}
	
	public void setOn() {
		if (On == true) {
			System.out.println("On");
			System.out.println("Nombre de page imprimées: " + PageImp);
			System.out.println("Nombre de feuilles de papier restant: " + FeuillePapier);
		}else
			System.out.println("Off");
	}
	
	
	
	public boolean getImpression() {
		return Impression;
	}
	
	public void setImpression() {
		if (Impression == true && FeuillePapier > 0) {
			FeuillePapier = FeuillePapier - 1;
			System.out.println("Impression page test");
			PageImp = PageImp + 1;
			Impression = false;
		}else {
			String input;
			System.out.println("Papier vide");
			System.out.println("Voulez-vous remettre du papier ? oui/non: ");
			input = keyboard.next();
			if(input.equals("oui")) {
				FeuillePapier = 10;
			}
		}
	}
	

	public void printerOn() {
		
		if(On == false) {
			String input;
			do {
				System.out.println("Voulez-vous allumer l'imprimante ? oui/non ");
				input = keyboard.next();
			} while (!input.equals("oui") && !input.equals("non"));
			if (input.equals("oui")) {
				On = true;
				setOn();
			}else if(input.equals("non")) {
				On = false;
				setOn();
			}
		}else {
			System.out.println("Printer allumé");
			String input;
			do {
				System.out.println("Voulez-vous l'éteindre ? oui/non ");
				input = keyboard.next();
			} while (!input.equals("oui") && !input.equals("non"));
				if (input.equals("oui")) {
					On = false;
					setOn();
				}else if(input.equals("non")) {
					On = true;
					setOn();
				}
		}
		
	}
	public void actionImp() {
		
		if(this.getOn()) {
		
			String input;
			do {
				System.out.println("Voulez-vous actionner l'imprimante ? oui/non");
				input = keyboard.next();
				
			} while (!input.equals("oui") && !input.equals("non"));
			if (input.equals("oui")) {
				Impression = true;
				setImpression();
			}
		}else {
			System.out.println("Printer éteint");
			System.out.println("Allumé le avant de l'actionner");
		}
	}
	
	
}
