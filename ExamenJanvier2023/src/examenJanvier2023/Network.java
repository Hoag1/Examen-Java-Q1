package examenJanvier2023;

import java.util.ArrayList;
import java.util.List;

public class Network {
    
	private String prefix;
	private List<Device> ListDevice = new ArrayList<>();
	
	
	public Network(String prefix) {
	
	this.prefix = prefix;	
		
	}
	
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public List<Device> getListDevice() {
		return ListDevice;
	}

	public void setListDevice(List<Device> listDevice) {
		ListDevice = listDevice;
	}


}
