import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GoDaddy {
	public static String[] domainType(String[] domains) {
	    String[] types = new String[domains.length];
	    Map<String, String> domainMap = new HashMap<String, String>();
	    domainMap.put("com","commercial");
	    domainMap.put("org","organization");
	    domainMap.put("net","network");
	    domainMap.put("info","information");
	    for(int i = 0; i < domains.length; i++){
	        String[] strArr = domains[i].split("\\.");
	        // look up in map strArr[strArr.length-1]
	        types[i] = domainMap.get(strArr[strArr.length-1]);
	    }
	    return types;
	}
	
	static String[][] domainForwarding(String[][] redirects) {
		String[][] domainGroups = new String[2][];
		
		ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
		for(String[] redirect : redirects){
			if(groups.size() < 1){
				ArrayList<String> grp = new ArrayList<String>();
				grp.add(redirect[0]);
				grp.add(redirect[1]);
				groups.add(grp);
			} else {
				
				for(ArrayList<String> group : groups){
					// iterate thru list
					for(String s : group){
						if(s.equals(redirect[0]) || s.equals(redirect[1])){
							group.add(redirect[0]);
							group.add(redirect[1]);
						}
						if( !(s.equals(redirect[0])) || !(s.equals(redirect[1])) ){
							ArrayList<String> grp = new ArrayList<String>();
							grp.add(redirect[0]);
							grp.add(redirect[1]);
							groups.add(grp);
						}
					}
				}
			}
			
			//redirectsMap.put(redirect[0], redirect[1]);
			/*System.out.println("Key: "+redirect[0]+" |Value: "+redirect[1]+" |Size: "+groups.size());
			if(groups.size() < 1){
				HashSet<String> grp = new HashSet<String>();
				grp.add(redirect[0]);
				grp.add(redirect[1]);
				groups.add(grp);
			} else {
				// loop thru groups and find the set that has the key and value
				for(int i = 0; i < groups.size(); i++){
					System.out.println(groups.get(i));
				//for(HashSet<String> group : groups){
					if(groups.get(i).contains(redirect[0]) || groups.get(i).contains(redirect[1]) ){ // add both key and val to that group
						groups.get(i).add(redirect[0]);
						groups.get(i).add(redirect[1]);
					}

					if( !(groups.get(i).contains(redirect[0]) && !(groups.get(i).contains(redirect[1]))) ){
						HashSet<String> grp = new HashSet<String>();
						grp.add(redirect[0]);
						grp.add(redirect[1]);
						groups.add(grp);
					}
				}
			}*/
		}
		
		System.out.println("Domains: ");
		for(ArrayList<String> grp : groups){
			for(String s : grp){
				System.out.print(s + " ");
			}
		}
		
		return domainGroups;
	}
	
	public static void main(String args[]){
		String[] domains = new String[]{"en.wiki.org", "codefights.com", "happy.net", "code.info"};
		String[] res = domainType(domains);
		for(String s : res){
			//System.out.println(s);
		}
		
		String[][] redirects = new String[][]{ {"godaddy.net", "godaddy.com"}, 
			{"godaddy.org", "godaddycares.com"}, 
			{"godady.com", "godaddy.com"},
			{"godaddy.ne", "godaddy.net"}};
		domainForwarding(redirects);
	}
}
