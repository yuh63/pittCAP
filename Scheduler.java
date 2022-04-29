public class Scheduler{
	int buffersize;
	DataManager DM;
	public Scheduler(int size, int nLog){
		
		buffersize = size;
		DM = new DataManager(buffersize, nLog);
	}
	
	public int schedule(String[] operation, int turn){
		return DM.manage(operation,turn);
	}
}