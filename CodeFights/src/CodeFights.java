import java.util.ArrayList;

public class CodeFights {
	static double companyBotStrategy(int[][] trainingData) {
	    double avg = 0.00;
	    int correctSolutions = 0;
	    for(int[] trainer : trainingData){
	        if(trainer[1] == 1){
	            avg+=trainer[0];
	            correctSolutions+=1;
	        }
	    }
	    if(correctSolutions == 0)return 0;
	    return avg/correctSolutions;
	}
	static String[] taskMaker(String[] source, int challengeId) {
	    String newLine = null, origLine = null;
	    boolean found = false;
	    for(int i = 0; i < source.length; i++){
	        if(found) break;
	        if(source[i].contains("//DB")){
	            String[] debugLine = source[i].split("//");
	            String[] debugID = debugLine[1].split(" ");
	            int id = Integer.parseInt(debugID[1]);
	            if(id == challengeId){
	                for(int j = i; j >= 0; j--){
	                    if(!source[j].contains("//DB")){
	                        found = true;
	                        origLine = source[j];
	                        newLine = debugLine[0] + debugLine[2];
	                        source[j] = newLine;
	                        break;
	                    }
	                }
	            }
	        }
	    }
	    System.out.println("New Line: "+newLine);
	    System.out.println("Orig Line: "+origLine);
	    // remove debug statements
	    ArrayList<String> newSource = new ArrayList<String>();
	    for(int i = 0; i < source.length; i++){
	        if(!source[i].contains("//DB")){
	            newSource.add(source[i]);
	        }
	    }
	    // convert Arraylist to String[]
	    source = new String[newSource.size()];
	    for(int i = 0; i < newSource.size(); i++){
	        source[i] = newSource.get(i);
	    }
	    //System.out.println(buggyLine);
	    return source;
	}

	public static void main(String args[]){
		
	}
}
