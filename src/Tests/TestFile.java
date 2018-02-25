package tests;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import classes.LoadBalancingDEC;
import classes.LoadBalancingOnline;
import classes.LoadBalancingRAND;
import classes.LoadBalancingTotalRAND;
import classes.Macchina;

public class TestFile {

	public static void main(String[] args) throws IOException{
		
		BufferedReader buffer = new BufferedReader(new FileReader("input_test.txt"));
		
		String str;
		while(true){
			
			if((str = buffer.readLine()) == null)
				break;
			
			String [] array = str.split(",");
			System.out.println("\nNome test: " + array[0]);
			
			/*ArrayList contiene le istanze delle macchine */
			ArrayList<Macchina> allMachineDEC = new ArrayList<>();
			ArrayList<Macchina> allMachineRAND = new ArrayList<>();
			ArrayList<Macchina> allMachineOnline = new ArrayList<>();
			ArrayList<Macchina> allMachineTR = new ArrayList<>();
			
			/*ArrayList contiene tutti i carichi da assegnare*/
			ArrayList<Integer> allLoadDEC = new ArrayList<>();
			ArrayList<Integer> allLoadRAND = new ArrayList<>();
			ArrayList<Integer> allLoadOnline = new ArrayList<>();
			ArrayList<Integer> allLoadTR = new ArrayList<>();
			
			/* Istanzio le macchine */
			for(int i=0; i<Integer.parseInt(array[1]); i++){
				allMachineDEC.add(new Macchina("M"+i));
				allMachineRAND.add(new Macchina("M"+i));
				allMachineOnline.add(new Macchina("M"+i));
				allMachineTR.add(new Macchina("M"+i));
			}
			
			if(array[0].startsWith("genericorandom")){
				Random r = new Random();
				int random;
				for(int i = 0; i< Integer.parseInt(array[2]); i++){
					random = r.nextInt(Integer.parseInt(array[3]))+1;
					allLoadDEC.add(random);
					allLoadRAND.add(random);
					allLoadOnline.add(random);
					allLoadTR.add(random);
				}
			}
			if(!(array[0].startsWith("genericorandom"))){
				
				/* Istanzio i carichi */
				for(int i = 3; i<Integer.parseInt(array[2]); i++){
					
					allLoadDEC.add(Integer.parseInt(array[i]));
					allLoadRAND.add(Integer.parseInt(array[i]));
					allLoadOnline.add(Integer.parseInt(array[i]));
					allLoadTR.add(Integer.parseInt(array[i]));
				}
			}
			
			
			/*chiamo il balncing DEC, RAND, BF*/
			System.out.println("\nOnline: \n");
			LoadBalancingOnline LO = new LoadBalancingOnline();
			ArrayList<Macchina> allMachineOnline2 = LO.jobsBalancingBF(allLoadOnline, allMachineOnline);
			LO.stampa(allMachineOnline2);
			LO.saveIntoFile(allMachineOnline2);
			
			System.out.println("\nDEC: \n");
			LoadBalancingDEC LD = new LoadBalancingDEC();
			ArrayList<Macchina> allMachineDEC2 = LD.jobsBalancingDEC(allLoadDEC, allMachineDEC);
			LD.stampa( allMachineDEC2);
			LD.saveIntoFile(allMachineDEC2);
		
			System.out.println("\nRAND: \n");
			LoadBalancingRAND LR = new LoadBalancingRAND();
			ArrayList<Macchina> allMachineRAND2 = LR.jobsBalancingRAND(allLoadRAND, allMachineRAND);
			LR.stampa(allMachineRAND2);
			LR.saveIntoFile(allMachineRAND2);
			
			System.out.println("\nTotalRand: \n");
			LoadBalancingTotalRAND TR = new LoadBalancingTotalRAND();
			ArrayList<Macchina> allMachineTR2 = TR.jobsBalancingTR(allLoadTR, allMachineTR);
			TR.stampa(allMachineTR2);
			TR.saveIntoFile(allMachineTR2);
		}
		
	}
}
