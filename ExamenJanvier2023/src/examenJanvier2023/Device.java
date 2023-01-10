package examenJanvier2023;

import java.util.*;

public class Device{

    private String Marque, Modele, Type;
    private int Id, Numserie, PuissanceW;
	private static int nbDevices=0;
	private static int[] arraySerie = new int[1];
	private List<Device> ListDevice =  new ArrayList<>();
	private List<Network_Adapter> ListNA = new ArrayList<>();
	
	
    


    static Scanner keyboard = new Scanner(System.in);

    
    public Device() {
        	
    		this.Id = nbDevices;
	        System.out.print("Numéro de série: ");
	        this.Numserie = keyboard.nextInt();
	        for (int i=0; i != arraySerie.length; i++){ 
	            if (Numserie == arraySerie[i]){
	                System.out.println("Ce numéro de série existe déjà: ");
	                this.Numserie = keyboard.nextInt();
	                i = 0;
	            }
	        }
	        
	        
	        System.out.print("Marque: ");
	        this.Marque = keyboard.next();
	        
	        System.out.print("Modèle: ");
	        this.Modele = keyboard.next();
	        
	        System.out.print("Puissance(watt): ");
	        int input = keyboard.nextInt();
	        Integer alim = calPuissance(this) + input;
	        if(alim < 10000) {
	        	this.ListDevice.add(this);
			    this.PuissanceW = input;
		        arraySerie[nbDevices] = this.Numserie;
		        arraySerie = Arrays.copyOf(arraySerie, arraySerie.length+1);
		        nbDevices += 1;
	        	
	        }else {
	
	        	System.out.println("Impossible de créer l'appareil sinon surcharge");
	        }
       
    }

    public Device (String Marque, String Modele, int Numserie, int PuissanceW) {
        this.Marque = Marque;
        this.Numserie = Numserie;
        this.Modele = Modele;
        this.PuissanceW = PuissanceW;
        this.Id = nbDevices;
        
        
        arraySerie[nbDevices] = Numserie;
        arraySerie = Arrays.copyOf(arraySerie, arraySerie.length+1);
        nbDevices += 1;
    }

    
    public static int getarraySerieLength(){
        return arraySerie.length;
    }
    public static int getarraySerieValue(int i){
        return arraySerie[i];
    }
    
    public String getMarque() {
		return Marque;
	}

	public void setMarque(String marque) {
		Marque = marque;
	}

   
    public String getModele() {
		return Modele;
	}

	public void setModele(String modele) {
		Modele = modele;
	}
    
    
    public int getPuissanceW() {
		return PuissanceW;
	}

	public void setPuissanceW(int puissanceW) {
		PuissanceW = puissanceW;
	}

	public String getType () { 
    	return Type; 
    }
    public void setType (String type) { 
    	Type = type; 
    }

    public int getNumserie() {
    	return Numserie;
    }
    
    
    public int getid() {
        return Id;
    }


	public static int getNbDevices() {
        return nbDevices;
    }
    public void ajoutListDevice(Device device) {
        this.ListDevice.add(device);
    }
    
    
    public List<Device> getListDevice() {
		return ListDevice;
	}

	public void setListDevice(List<Device> listDevice) {
		ListDevice = listDevice;
	}

	public List<Network_Adapter> getListNA() {
		return ListNA;
	}

	public void setListNA(List<Network_Adapter> listNA) {
		ListNA = listNA;
	}
    
	
	public int calPuissance(Device device) {
		
		int input;
        ListIterator<Device> itr = this.ListDevice.listIterator();
        int sm = 0;
        while(itr.hasNext()) {
            Device temp = itr.next();
            int Puissance = temp.getPuissanceW();
            sm += Puissance;
            
            }
        return sm; 
	}
    
    public void afficheListDevice(Device targetDevice){
    	ListIterator<Device> itr = ListDevice.listIterator();
        while(itr.hasNext()){
            Device temp = itr.next();
            System.out.println("Device: "+temp.getType()+" | Num Série: "+temp.getNumserie());
            
        }
    }
    	
    public Device infoAp(Device targetDevice) {
    	
    	int input;
        ListIterator<Device> itr = targetDevice.ListDevice.listIterator();
        while(itr.hasNext()){
            Device temp = itr.next();
        
            System.out.println("Device id: "+itr.previousIndex()+" | Numéro de série : "+temp.getNumserie() + " | " + temp.getType());
        }
        System.out.print("Choisissez un id : ");
        input = keyboard.nextInt();
        return targetDevice.ListDevice.get(input);
    }
    
    

    public void modifDevice () { 

    	String input;
    	String type = getType();
    	
        do {
            System.out.println("Quelle caractéristiques voulez vous modifier? Marque/Modèle/Puissance");
            
            input = keyboard.next();
        } while (!input.equals("Marque") && !input.equals("Modèle") && !input.equals("Puissance")); 
        if (input.equals("Marque")) {
            System.out.print("Nouvelle Marque : ");
            setMarque(keyboard.next());
            
        } else if (input.equals("Modèle")) {
            System.out.print("Nouveaux Modèle : ");
            setModele(keyboard.next());
            
        } else if (input.equals("Puissance")) {
            System.out.print("Nouvelle Puissance(en watts) : ");
            setPuissanceW(keyboard.nextInt());
            
        }else if(type.equals("Pc")) {
        	infoPc();
            
        }
    	
    }
    
    public void removeDevice(Device targetDevice) {
    	
    	int input;
  	  
        ListIterator<Device> itr = targetDevice.ListDevice.listIterator();
        while(itr.hasNext()){
            Device temp = itr.next();
        
            System.out.println("Device id: "+itr.previousIndex()+" | Numéro de série : "+temp.getNumserie() + " | " + temp.getType());
        }
        
  	  System.out.print("Choisissez un id : ");
  	  input = keyboard.nextInt();
  	  for (int i=0; i < arraySerie.length-1; i++){
				arraySerie[i] = -1; 
			}
  	  targetDevice.ListDevice.remove(input);
    	
    }
    
    
    public static void connectNetwork(Device targetDevice, Network targetNetwork) {
    	
    	
    	int count = targetNetwork.getListDevice().size();
    	if(count <= 255) {
	    	String prefix = targetNetwork.getPrefix();
	    	boolean flag = true;
	    	for(Network_Adapter na:targetDevice.ListNA) {
	    		if(na.getIpv4().contains(prefix)) {
	    			flag = false;
	    		}
	    	}
	    	if(flag) {
	    		targetDevice.ListNA.add(new Network_Adapter(prefix+"."+(count+1)));
	    		targetNetwork.getListDevice().add(targetDevice);
	    		
	    	}
    	}	
    	
    }
    
    public static void disconnectNetwork(Device targetDevice, Network targetNetwork) {


        List listDevice= targetNetwork.getListDevice();
        if(listDevice.contains(targetDevice)) {
            listDevice.remove(targetDevice);
            String prefix = targetNetwork.getPrefix();
            Network_Adapter naToRemove = null;
            for(Network_Adapter na : targetDevice.ListNA) {
                if(na.getIpv4().contains(prefix)) {
                    naToRemove = na;
                }
            }
            if(naToRemove != null) {
                targetDevice.ListNA.remove(naToRemove);
                
            }
        }

    }
    
    
    public void afficheApre(Network targetNetwork) {
    	
    	List<Device> listdevice = targetNetwork.getListDevice();
    	
    	ListIterator<Device> itr = listdevice.listIterator();
    	
        while(itr.hasNext()){
        	String ipv4 = null;
        	Device temp = itr.next();
        	List<Network_Adapter> listadapter = temp.getListNA();
        	for(Network_Adapter na:listadapter) {
        		
        		if(na.getIpv4().contains(targetNetwork.getPrefix())) {
        			ipv4 = na.getIpv4();
        		}
        		
        	}
        	
        	System.out.println("Device: "+temp.getType()+" | Num Série: "+temp.getNumserie() + " | " + ipv4);
           }
        
    }
  
    public void infoPc () {}
 }
