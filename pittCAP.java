import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class pittCAP{
	public static void main(String[] args) throws IOException{
		//read scripts to execute
		System.out.println("pittCAP: enter the log scripts for execution, separate by space");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String log = reader.readLine();
		String[] logs = log.split(" ");//logs
		System.out.println("enter buffer size");
		int size = Integer.parseInt(reader.readLine());
		//Round-Robin or Random?
		System.out.println("enter rr for Round-Robin, ra for Random");
		String mode = reader.readLine();
		if(mode.equals("rr")){
			TransactionManager.roundRobin(logs,size);
		} else if(mode.equals("ra")){
			System.out.println("Please enter the random seed int.");
			int seed = Integer.parseInt(reader.readLine());
			TransactionManager.randomReading(logs,seed,size);
		} else{
			System.out.println("Invalid input");
			System.exit(0);
		}
		
	}
}