package examenJanvier2023;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Pc extends Device {
	private String Os;
	private boolean On;
	private boolean ActPc; //Actionne pc
	private long ram_ins = 1024; //ram install�
	private long ram;
	private long ramf;
	
	static Scanner keyboard = new Scanner(System.in);
	
	public Pc() {
		super();
        setType("Pc");
        
        
        do {
        System.out.println("Quantité de ram :");
        ram = keyboard.nextLong();
        boolean ramR = pu2(ram); 
	        if(ramR){
	        	ramf = ram;
	        }else {
	        	ramf = 0;
	        }
        } while (ramf <= ram_ins);
  
        do {
            System.out.println("Os Linux/Windows :");
            Os = keyboard.next();
        } while (!setOs(Os));
	}
	
	
	
	public Pc(String Marque, String Modele, int Numserie, int PuissanceW, String Os, long ramf, boolean On, boolean ActPc)  {
        
		super(Marque, Modele, Numserie, PuissanceW);
        this.Os = Os;
        this.On = On;
        this.ActPc = ActPc;
        setType("Pc");

    }
	
	
	
	public long getRamf() {
		return ramf;
	}



	public void setRamf(long ramf) {
		this.ramf = ramf;
	}



	public static boolean pu2(long numb) {
        return numb !=0 && ((numb & (numb-1))==0);
    }
	
	
	public boolean setOs (String newOs) {
        if (newOs.equals("Linux") || newOs.equals("Windows")) {
            this.Os = newOs;
            return true;
        } else {
            return false;
        }
    }
	
	public String getOs () {
        return Os;
    }
	
	public boolean getOn() {
        return On;
    }
    public void setOn() {
        if(On == true) {
            System.out.println("Pc allumé");
            Bienvenue();
        }else{
            System.out.println("Pc éteint");
            Bye();
        }
    }
    
    
    
	 public void infoPc () { 
	        
	        String input;       
	        
	        do {
	            System.out.println("Modifier une info? Os/Ram");
	            input = keyboard.next();
	        } while (!input.equals("Os") && !input.equals("Ram"));
	        
	        	if (input.equals("Os")) {
		            do {
		                System.out.print("Os? Linux/Windows : ");
		                input = keyboard.next();
		            } while (!this.setOs(input));
	        
	        	}else if(input.equals("Ram")) {
	        		
	        			System.out.println("Quantité Ram: ");
	        			setRamf(keyboard.nextInt());
	        		
	        	}
	 }
	 
	 private void Bye() {
	        System.out.println("Au revoir de la part de " +getOs());
	    }
	 
	 private void Bienvenue() {
	        System.out.println("Bienvenue de la part de " +getOs());
	    }
	 
	 public void pcOn() {
		 
		 if(On == false) {
			String input;
			do {
				System.out.println("Voulez-vous allumer le Pc ? oui/non ");
				input = keyboard.next();
			} while (!input.equals("oui") && !input.equals("non"));
				if (input.equals("oui")) {
					On = true;
					setOn();
				}else if(input.equals("non")) {
					On = false;
					
			}
		 }else {
			System.out.println("Pc allumé");
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
	 
	 public void actionPc() {
			
		 if(this.getOn()) {
			 
			 String input;
			 do {
				 System.out.println("Voulez-vous actionner le Pc ? oui/non");
				 input = keyboard.next();
				
			 } while (!input.equals("oui") && !input.equals("non"));
			 	if (input.equals("oui")) {
			 		ActPc = true;
			 		System.out.println("Hello world");
			 	}
		 }else{
			System.out.println("Pc éteint");
			System.out.println("Allumé et connecté le à un réseau avant de l'actionner");
		 }
	 }


	}