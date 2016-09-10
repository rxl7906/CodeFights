import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class Jet {
	static int packageBoxing(int[] pkg, int[][] boxes) {
		if(boxes.length < 1) return -1;
	    int result = -1;
	    int pkgVol = pkg[0] * pkg[1] * pkg[2];
	    Arrays.sort(pkg);
	    int minBoxIndex = 0, i = 0, minBoxVol = Integer.MAX_VALUE;
	    ArrayList<Integer> indices = new ArrayList<Integer>();
	    
	    for(int[] box : boxes){
	        int boxVol = 1;
	        for(int dim : box){
	            boxVol = boxVol * dim;
	        }
	        // check volumes
	        if(boxVol < minBoxVol){
	            // check if dim are valid to be min compared to pkg
	            Arrays.sort(box);
	            boolean isValid = true;
	            for(int j = 0; j < 3; j++){
	                if(pkg[j] > box[j]){ // this box is invalid
	                    isValid = false;
	                    break;
	                }
	            }
	            if(isValid){
	                minBoxIndex = i;
	                minBoxVol = boxVol;
	                indices.add(i);
	            }
	        }
	        i++;
	    }
	    if(minBoxVol >= pkgVol){
	        result = minBoxIndex;
	    }
	    int min = Integer.MAX_VALUE, pos = -1;
	    for(int k : indices){
	        int vol = boxes[k][0]*boxes[k][1]*boxes[k][2];
	        if(vol < min){
	            min = vol;
	            pos = k;
	        }
	    }
	    return pos;
	}
	
	static String[][] catalogUpdate(String[][] catalog, String[][] updates) {
		String[][] result = new String[1][];
	    Map<String,TreeSet<String>> catalogMap = new TreeMap<String,TreeSet<String>>();
	    for(String[] catagory : catalog){
	    	TreeSet<String> catagorySet = new TreeSet<String>();
	        for(int i = 1; i < catagory.length; i++){
	            catagorySet.add(catagory[i]);
	        }
	        catalogMap.put(catagory[0], catagorySet);
	    }
	    
	    for(String[] update : updates){
	    	// look up in catalog map
	    	// if update[0] exists in map; then add to the set
	    	if(catalogMap.containsKey(update[0])){
	    		catalogMap.get(update[0]).add(update[1]);
	    	} else {
	    		TreeSet<String> catagorySet = new TreeSet<String>();
	    		catagorySet.add(update[1]);
	    		catalogMap.put(update[0], catagorySet);
	    	}
	    }
	    catalog = new String[catalogMap.size()][];
	    int j = 0;
	    for(Map.Entry<String,TreeSet<String>> e : catalogMap.entrySet()){
	        catalog[j] = new String[e.getValue().size()+1];
	        catalog[j][0] = e.getKey();
	        int size = e.getValue().size();
	        for(int k = 1; k <= size; k++){
	        	catalog[j][k] = e.getValue().pollFirst();
	        }
	        j++;
	    }
	    return catalog;
	}

	public static void main(String args[]){
		String[][] catalog = new String[][]{ {"Books", "Classics", "Fiction"},
			{"Electronics", "Cell Phones", "Computers", "Ultimate item"},
			{"Grocery", "Beverages", "Snacks"},
			{"Snacks", "Chocolate", "Sweets"},
			{"root", "Books", "Electronics", "Grocery"}};
		String[][] updates = new String[][]{ {"Snacks", "Marmalade"},
			{"Fiction", "Harry Potter"},
			{"root", "T-shirts"},
			{"T-shirts", "CodeFights"}};
		catalogUpdate(catalog,updates);
	}
}
