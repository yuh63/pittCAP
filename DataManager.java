//LSM-tree storage, strict 2PL
public class DataManager{
	//Begin a transaction 
	//constructor
	int[] buffer;
	boolean[] isTrans;
	boolean[] committed;
	public DataManager(int buffersize, int nLog){
		buffer = new int[buffersize];// cache size
		isTrans = new boolean[nLog];// What mode is the thread?
		committed = new boolean[nLog];// Is the thread committed?
	}
	
	public void begin(String[] operation, int turn){
		//begin a transaction/process
		if(operation[1].equals("1")){
			isTrans[turn] = true;
			committed[turn] = false;
		} else{
			isTrans[turn] = false;
			committed[turn] = false;
		}
	}
	//Commit a transaction
	public void commit(String[] operation, int turn){
		//commit a transaction/process
		committed[turn] = true;
	}
	//Abort a transaction
	public void abort(String[] operation, int turn){
		//recovery process to be done
	}
	//Quit current script
	public void quit(String[] operation, int turn){
		
	}
	//Insert new record
	public void insert(String[] operation, int turn){
		
	}
	//Update table value
	public void update(String[] operation, int turn){
		
	}
	//Retrieve value if exist
	public void retrieve(String[] operation, int turn){
		
	}
	//Match age or score
	public void match(String[] operation, int turn){
		
	}
	//Find aggregation value: min max or avg
	public void aggregate(String[] operation, int turn){
		
	}
	public int manage(String[] operation, int turn){
		for(int i = 0;i<operation.length;i++){
			System.out.print(operation[i] + " ");
		}
		if(operation[0].equals("B")){
			begin(operation,turn);
		}
		if(operation[0].equals("C")){
			commit(operation,turn);
		}
		if(operation[0].equals("A")){
			abort(operation,turn);
		}
		if(operation[0].equals("Q")){
			quit(operation,turn);
		}
		if(operation[0].equals("I")){
			insert(operation,turn);
		}
		if(operation[0].equals("U")){
			update(operation,turn);
		}
		if(operation[0].equals("R")){
			retrieve(operation,turn);
		}
		if(operation[0].equals("M")){
			match(operation,turn);
		}
		if(operation[0].equals("G")){
			aggregate(operation,turn);
		}
		return 0;
		//received operation here, pass it to buffer
	}
}