package classes;

import java.util.ArrayList;

public class Macchina {
	
	private String name;
	private ArrayList<Integer> loads;
	
	public Macchina(String name){
		this.name = name;
		loads = new ArrayList<>();
	}
	
	public void addLoad(int load){
		loads.add(load);
	}
	
	public void removeLoad(int load){
		loads.remove(load);
	}
	
	public int getTotalLoad(){
		int total = 0;
		for(Integer l : loads)
			total += l;
		
		return total;
	}
	
	public String getName(){
		return name;
	}

	public ArrayList<Integer> getLoads() {
		return loads;
	}

	public void setLoads(ArrayList<Integer> loads) {
		this.loads = loads;
	}
	
	
}
