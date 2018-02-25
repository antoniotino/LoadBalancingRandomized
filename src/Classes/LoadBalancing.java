package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LoadBalancing{

	/*Il metodo stampa dà in output il risultato dei passi e del carico delle macchine*/
	
	public void stampa(ArrayList<Macchina> allMachine){
		System.out.println("Carico delle macchine finale: ");
		for(Macchina m : allMachine)
			System.out.println(m.getName() + ", Carico Totale: " + m.getTotalLoad());
	}
	
	public void saveIntoFile(ArrayList<Macchina> allMachine) throws IOException{
		
		File file = new File("output_test.txt");
		FileWriter writer = new FileWriter(file, true);
		
		GregorianCalendar calendar = new GregorianCalendar();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		
		writer.append(day + "-" + month + "-" + year + "---" + hour + ":" + min + ":"+sec+"\n" );
		
		writer.append("Carico delle macchine finale: \n");
		for(Macchina m : allMachine)
			writer.append(m.getName() + ", Carico Totale: " + m.getTotalLoad() + "\n");
		
		writer.flush();
	}
	
	public int controlLoad(ArrayList<Macchina> allMachine){

		int[] array = new int[allMachine.size()];
		int toReturn = 0;

		for(int j = 0; j<array.length;j++)
			array[j] = allMachine.get(j).getTotalLoad();

		int min = array[0]; 
		for(int i=1; i < array.length; i++){
			if(array[i] < min){
				min = array[i];
				toReturn = i;
			}
		}
		return toReturn;
	}


}
