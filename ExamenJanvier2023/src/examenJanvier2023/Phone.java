package examenJanvier2023;
import java.util.HashSet;
import java.util.Random;

public class Phone extends Device {
	
	private String Pnumber;
	private boolean On;
	private boolean Call;
	
	
	
	public Phone() {
		super();
        setType("Phone");
        Integer num;
        int a = 11111111;
        int b = 99999999;
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();
        while(set.size()<1) {
        num =  random.nextInt(b-a) + a;

        set.add(num);
        Pnumber = "04"+num;
        }
        
    }
        

	
	public Phone(String Marque, String Modele, int Numserie, int PuissanceW, String Pnumber, boolean On, boolean Call) {
		super(Marque, Modele, Numserie, PuissanceW);
		this.Pnumber = Pnumber;
		this.On = On;
		this.Call = Call;
		setType("Phone");
		
	}

	
	public String getPnumber() {
		return Pnumber;
	}

	public void setPnumber(String pnumber) {
		Pnumber = pnumber;
	}



	public boolean getOn() { 
		return On;
	}
	
	public void setOn() {
		if (On == true) {
			System.out.println("On");
			System.out.println("Sonne");
			System.out.println("Sonne");
		}else
			System.out.println("Off");
	}
	
	public boolean getCall() {
		return Call;
	}
	
	public void setCall() {
		if (Call == true) {
			System.out.println("Sonne");
			Call = false;
		}
	}
	
	
	
	public void phoneOn() {
		
		if(On == false) {
			String input;
			do {
				System.out.println("Voulez-vous allumer le téléphone ? oui/non ");
				input = keyboard.next();
			} while (!input.equals("oui") && !input.equals("non"));
			if (input.equals("oui")) {
				On = true;
				setOn();
			}else if(input.equals("non")) {
				On = false;
				
			}
		}else {
			System.out.println("Phone allumé");
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
					
				}
		}
	}
		
		public void actionCall(){
				
			if(this.getOn()) {
			
				String input;
				do {
					System.out.println("Voulez-vous actionner le téléphone ? oui/non ");
					input = keyboard.next();
				} while	(!input.equals("oui") && !input.equals("non"));
				if (input.equals("oui")) {
					Call = true;
					setCall();
				}
			}else {
				System.out.println("Phone éteint");
				System.out.println("Allumé le avant de l'actionner");
			}
	}
}
