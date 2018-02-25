package classes;

import java.util.ArrayList;

public class LoadBalancingOnline extends LoadBalancing {



	public ArrayList<Macchina> jobsBalancingBF(ArrayList<Integer> allLoad,ArrayList<Macchina> allMachine) {
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

}
