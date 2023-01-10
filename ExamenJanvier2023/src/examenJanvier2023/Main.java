package examenJanvier2023;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner keyboard = new Scanner(System.in);

    public static String choixDevice () {
        String input;
        do {
            System.out.println("Quel type d'appareil? Printer/Phone/Pc");
            input = keyboard.next();
        } while (!input.equals("Printer") && !input.equals("Phone") && !input.equals("Pc"));
        return input;
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int choix=0;
        
        Network network1 = new Network("192.168.1");
        
        Network network2 = new Network("192.168.2");
        
        Network network3 = new Network("192.168.3");
        
        Device device = new Device("","",0,0);
 /*       
        Printer printer1 = new Printer("Toshiba", "S2500", 7, 3000, 10, 5, false, false);
        device.ajoutListDevice(printer1);
        
        Printer printer2 = new Printer("Toshiba", "S2500", 1, 3000, 5, 10, true, false);
        device.ajoutListDevice(printer2);
        
        Phone phone1 = new Phone("Toshiba", "S2500", 18, 2000, "041217756", false, false);
        device.ajoutListDevice(phone1);
        
        Pc pc1 = new Pc("Toshiba", "S2500", 10, 2000, "Linux", 4096, false, false);
        device.ajoutListDevice(pc1);
 */       

        System.out.println("Projet de Java Q1 :");

        do {
            System.out.print("1) Lister les appareils \n2) Afficher les informations d'un appareil  \n3) Actionner un appareil \n4) Allumer ou �teindre un appareil \n5) Ajouter ou �diter ou supprimer un appareil \n6) Lister tous les r�seaux et le nombre d'appareil connect� \n7) Connecter ou d�connecter un appareil du r�seau \n8) Afficher les information d'un r�seau et des appareil connect� \n9) Quitter le programme :");

            try {
                choix = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un integer");
                choix = 1;
            } catch (Exception e) {
                System.out.println("Quelque chose s'est mal pass�");
            }

            if (choix == 1) { // -------- LIST APPAREIL -------
            	
                
                System.out.println("Voi�i la liste des appareils: ");
                device.afficheListDevice(device);
                

            } else if (choix == 2) { // ------- AFFICHER LES INFORMATIONS ---------
            	
            	Device targetDevice = device.infoAp(device);
            	String lna = "";
            	for(Network_Adapter na:targetDevice.getListNA()) {
            		lna += na.getIpv4() + " ";
            	}
                String input;
                String type = targetDevice.getType();
      
                if(type.equals("Printer")) {
                	Printer printer = (Printer) targetDevice;
                	int pageimp = printer.getPageImp();
                	int feuillepapier = printer.getFeuillePapier();
                	boolean etat = printer.getOn();
                    System.out.println("Device: "+targetDevice.getType()+" | NumSerie: "+targetDevice.getNumserie()+" | Marque: "+targetDevice.getMarque()+" | Modele: "+targetDevice.getModele()+" | Watts: "+targetDevice.getPuissanceW() + " | Etat: " +  (printer.getOn()?"On":"Off") +" | Page imprimer: " + printer.getPageImp() + " | Feuille restante: "+ printer.getFeuillePapier() + " | " + lna);
                    
                }else if(type.equals("Phone")) {
                	Phone phone = (Phone) targetDevice;
                	String pnumber = phone.getPnumber();
                	boolean etat = phone.getOn();
                    System.out.println("Device: "+targetDevice.getType()+" | NumSerie: "+targetDevice.getNumserie()+" | Marque: "+targetDevice.getMarque()+" | Modele: "+targetDevice.getModele()+" | Watts: "+targetDevice.getPuissanceW() + " | Etat: "+ (phone.getOn()?"On":"Off") + " | Numéro de tel : " + phone.getPnumber() + " | " + lna);
                    
                }else if(type.equals("Pc")) {
                	Pc pc = (Pc) targetDevice;
                	String Os = pc.getOs();
                	long ram = pc.getRamf();
                	boolean etat = pc.getOn();
                    System.out.println("Device: "+targetDevice.getType()+" | NumSerie: "+targetDevice.getNumserie()+" | Marque: "+targetDevice.getMarque()+" | Modele: "+targetDevice.getModele()+" | Watts: "+targetDevice.getPuissanceW() + " | Etat: " +  (pc.getOn()?"On":"Off") + " | OS: " + pc.getOs() + " | Ram: "+ pc.getRamf() + " | " + lna);
                    
                }

                    
                    

            } else if (choix == 3) { //  ------- ACTIONNER UN APPAREIL ---------
            	
                	System.out.println("Sélectionner l'appareil à actionner: ");
                	Device targetDevice = device.infoAp(device);
                    String input;
                    String type = targetDevice.getType();
                    
            		if(type.equals("Printer")) {
            			Printer printer = (Printer) targetDevice;
            			if(printer.getListNA().size() != 0) {
            			printer.actionImp();
            			}else {
            				System.out.println("Appareil non connecter au réseau!");
            			}
            		}else if(type.equals("Phone")) {
            			Phone phone = (Phone) targetDevice;
            			if(phone.getListNA().size() != 0) {
            			phone.actionCall();
            			}else {
            				System.out.println("Appareil non connecter au réseau!");
            			}
            		}else if(type.equals("Pc")) {
            			Pc pc = (Pc) targetDevice;
            			if(pc.getListNA().size() != 0) {
            			pc.actionPc();
            			}else {
            				System.out.println("Appareil non connecter au réseau!");
            			}
            		}
                    	


            } else if (choix == 4) { // --------- ALLUMER OU ETEINDRE ---------
            	
            	
                	System.out.println("Sélectionner l'appareil à allumer ou éteindre: ");
                	Device targetDevice = device.infoAp(device);
                    String input;
                    String type = targetDevice.getType();
            	
                    
                    		
	            		if(type.equals("Printer")) {
	            			Printer printer = (Printer) targetDevice;
	            			printer.printerOn();
	            			
	            		}else if(type.equals("Phone")) {
	            			Phone phone = (Phone) targetDevice;
	            			phone.phoneOn();
	            			
	            		}else if(type.equals("Pc")) {
	            			Pc pc = (Pc) targetDevice;
	            			pc.pcOn();
	            			
	            		}
                    	
            	
            	
            } else if (choix == 5) { // --------- AJOUTER OU EDITER OU SUPPRIMER UN APPAREIL ---------
            	
            	
            		System.out.println("Quel appareil voulez-vous ajouter(1) ou éditer(2) ou supprimer(3) ?:");
            		choix = keyboard.nextInt();
                    if(choix == 1) {
                    	
                    	int puissance = device.calPuissance(device);
                    	if(puissance < 10000) {
                    		
			            	String temp = Main.choixDevice();
			                if (temp.equals("Printer")) { 
			                    Printer printer = new Printer();
			                    device.ajoutListDevice(printer);
			                } else if (temp.equals("Phone")) {
			                    Phone phone = new Phone();
			                    device.ajoutListDevice(phone);
			                } else if (temp.equals("Pc")) {
			                    Pc pc = new Pc();
			                    device.ajoutListDevice(pc);
			                }
                    	}else {
                    		System.out.println("Surcharge alimentation, supprimer des appareils!");
                    	}
		            } else if (choix == 2) { //-------- EDIT ----------
		
		                System.out.println("Quel device voulez vous modifier?");
	                	Device targetDevice = device.infoAp(device);
	                    String input;
	                    String type = targetDevice.getType();
	            		
		            		if(type.equals("Printer")) {
		            			device.modifDevice();

		            		}else if(type.equals("Phone")) {
		            			device.modifDevice();
		            			
		            		}else if(type.equals("Pc")) {
		            			do {
			            			System.out.println("Voulez-vous modifier Marque/Modele/Puissance ou Os/Ram");
			            			input = keyboard.next();
		            			}while(!input.equals("Marque") && !input.equals("Modele") && !input.equals("Puissance") && !input.equals("Os") && !input.equals("Ram"));
		            				if(input.equals("Marque") || input.equals("Modele") || input.equals("Puissance")) {

		            				device.modifDevice();

		            				}else if(input.equals("Os") || input.equals("Ram")){
		            				
		            				Pc pc = (Pc) targetDevice;
		            				pc.infoPc();
		            			}
		            				
		            		}
		
		            } else if (choix == 3) { //-------- SUPPR ---------
		
		                System.out.println("Quel device voulez vous supprimer?");
		                device.removeDevice(device);

		            }
            	
            } else if (choix == 6) { // --------- LISTER TOUS LES RESEAUX ET LE NOMBRE D'APPAREIL CONNECTE ---------
            	
            	
            		System.out.println("Voici la liste des réseaux et le nombre d'appareil qui y sont connectés: ");
            		System.out.println("Réseau 1 (" + network1.getPrefix()+".x) : " + network1.getListDevice().size() + " appareils connectés");
            		System.out.println("Réseau 2 (" + network2.getPrefix()+".x) : " + network2.getListDevice().size() + " appareils connectés");
            		System.out.println("Réseau 3 (" + network3.getPrefix()+".x) : " + network3.getListDevice().size() + " appareils connectés");
            	
            } else if (choix == 7) { // --------- CONNECTER OU DECONNECTER UN APPAREIL DU RESEAU ---------
            	
            	
            	System.out.println("Quel appareil voulez-vous connecter ou d�connecter du r�seau ?:");
            	Device targetDevice = device.infoAp(device);
            	Network targetNetwork = null;
            	String input;
                do {
                	System.out.println("Voulez-vous connecter ou déconnecter l'appareil ?");
                	input = keyboard.next();
                }while (!input.equals("connecter") && !input.equals("déconnecter"));
                	if(input.equals("connecter")) {
                		System.out.println("A quel réseau voulez-vous connecter l'appareil ? 1/2/3 ");
                		input = keyboard.next();
                		if(input.equals("1")) {
                			targetNetwork = network1;
                		}else if(input.equals("2")) {
                			targetNetwork = network2;
                		}else if(input.equals("3")) {
                			targetNetwork = network3;
                		}
                	Device.connectNetwork(targetDevice, targetNetwork);
                			
                	}else if(input.equals("déconnecter")){
                		System.out.println("De quel réseau voulez-vous déconnecter l'appareil ? 1/2/3");
                		input = keyboard.next();
                		if(input.equals("1")) {
                			targetNetwork = network1;
                		}else if(input.equals("2")) {
                			targetNetwork = network2;
                		}else if(input.equals("3")) {
                			targetNetwork = network3;
                		}
                	Device.disconnectNetwork(targetDevice, targetNetwork);
                	}
            		
           
            	
            }else if (choix == 8) { // --------- AFFICHER LES INFORMATIONS D'UN RESEAU ET DES APPAREILS CONNECTE ---------
            	
            	String input;
            	
        		Network targetNetwork = null;

        		System.out.println("De quel réseau voulez-vous voir les informations ? 1/2/3 ");
				input = keyboard.next();
				if(input.equals("1")) {
        			targetNetwork = network1;
        		}else if(input.equals("2")) {
        			targetNetwork = network2;
        		}else if(input.equals("3")) {
        			targetNetwork = network3;
        		}
                System.out.println("Voici les informations des appareils connectés:");
                   device.afficheApre(targetNetwork);
            		
            	
            }
        } while (choix != 9);
    }
 }
