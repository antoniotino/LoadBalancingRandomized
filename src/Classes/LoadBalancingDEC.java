package classes;


import java.util.ArrayList;


public class LoadBalancingDEC extends LoadBalancing {

	public ArrayList<Macchina>  jobsBalancingDEC(ArrayList<Integer> allLoad,ArrayList<Macchina> allMachine) {

	
		/*ORDINAMENTO DECRESCENTE DEI CARICHI*/

		sortDec(allLoad);
	

		int passo = 0;
		
		for(int i = 0 ; i< allLoad.size(); i++){

			int value = allLoad.get(i);
			int toLoad = controlLoad(allMachine);
			allMachine.get(toLoad).addLoad(value);
			

			System.out.println("Passo: "+ passo+" -> Macchina: "+ allMachine.get(toLoad).getName() + 
					", Carico inserito: [" + value + "], Carico totale: " + allMachine.get(toLoad).getTotalLoad());
			passo++;
			
			System.out.println("------------------------------------------------------------------");
		}


		return allMachine;
	}


	private static ArrayList<Integer> sortDec(ArrayList<Integer> allLoad){

		int temp;
	
		
		for( int i=0; i<allLoad.size(); i++) {
			for( int j=i; j<allLoad.size(); j++) {

				if( (allLoad.get(i)).compareTo(allLoad.get(j)) < 0 ) {

					temp = allLoad.get(i);
					allLoad.set(i, allLoad.get(j));
					allLoad.set(j,temp);
					
				}
			}
		}

		return allLoad;
	}
	
	
	
}