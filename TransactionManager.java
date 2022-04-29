import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
public class TransactionManager{
	public static void roundRobin(String[] logs, int size)throws IOException{
		//Round-Robin fashion read of input
		System.out.println("Round-Robin");
		int[] linesread = new int[logs.length];
		int[] lognum = new int[logs.length];
		int totallen = 0;//total lines to process
		int result;
		Scheduler sd = new Scheduler(size,logs.length);
		//read total lines, find parameters
		BufferedReader reader;
		boolean[] blocked = new boolean[logs.length];
		for(int i = 0;i<logs.length;i++){
			linesread[i] = 0;
			blocked[i] = false;
			reader = new BufferedReader(new FileReader(logs[i]));
			while (reader.readLine() != null){
				lognum[i]++;
				totallen++;
			}
			reader.close();
		}
		//start reading
		String[] scripts = new String[totallen];//array of scripts
		int readlen = 0;//processed lines so far
		int pointer = 0;//String stack pointer
		int turn = 0;//current round robin head
		while(readlen<totallen){
			//one RR read
			if(linesread[turn]<lognum[turn]){//if not finish reading
				reader = new BufferedReader(new FileReader(logs[turn]));
				for(int k = 0; k<linesread[turn];k++){
					reader.readLine();
				}
				scripts[pointer] = reader.readLine();
				String[] operation = scripts[pointer].split("[ (),]+");
				pointer++;
				linesread[turn]++;
				readlen++;
				reader.close();
				if(blocked[turn] == false){
					result = sd.schedule(operation,turn);
				}//check for blocking
				System.out.println("");
			}
			turn++;
			if(turn == logs.length){
				turn = 0;
			}
			
		}
	}
	public static void randomReading(String[] logs, int seed, int size)throws IOException{
		//Random fashion read of input
		System.out.println("Round-Robin");
		int[] linesread = new int[logs.length];
		int[] lognum = new int[logs.length];
		int totallen = 0;//total lines to process
		int result;
		//read total lines, find parameters
		BufferedReader reader;
		boolean[] blocked = new boolean[logs.length];
		for(int i = 0;i<logs.length;i++){
			blocked[i] = false;
			linesread[i] = 0;
			reader = new BufferedReader(new FileReader(logs[i]));
			while (reader.readLine() != null){
				lognum[i]++;
				totallen++;
			}
			reader.close();
		}
		//start reading
		String[] scripts = new String[totallen];//array of scripts
		int readlen = 0;//processed lines so far
		int pointer = 0;//String stack pointer
		int turn = 0;
		Random rand = new Random(seed);
		Scheduler sd = new Scheduler(size,logs.length);
		while(readlen<totallen){
			//One random read
			turn = rand.nextInt(logs.length);
			if(linesread[turn]<lognum[turn]){//if not finish reading
				reader = new BufferedReader(new FileReader(logs[turn]));
				for(int k = 0; k<linesread[turn];k++){
					reader.readLine();
				}
				scripts[pointer] = reader.readLine();
				String[] operation = scripts[pointer].split("[ (),]+");
				pointer++;
				linesread[turn]++;
				readlen++;
				reader.close();
				if(blocked[turn] == false){
					result = sd.schedule(operation,turn);
				}//check for blocking
				
				System.out.println("");
			}
		}
		//Split the operations, we split space, comma, parentheses
	}
}