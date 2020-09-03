package utilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Utilities {
	
	public static Map<Integer, Float> orderValues(List<String> searchResultsList) {
				
		 Map<Integer, Float> unOrderedMap = new HashMap<Integer, Float>();
		 int index = 0;
		 for(String i : searchResultsList) {
			 unOrderedMap.put(index++ , Float.parseFloat(i.split("#SEPARATOR#")[1].replaceAll("\\$", "").replaceAll("\\n", ".")));
	     }
	     
		 LinkedHashMap<Integer, Float> orderedMap = new LinkedHashMap<>();
	        unOrderedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
	                .forEachOrdered(x -> orderedMap.put(x.getKey(), x.getValue()));
	        
	     return orderedMap;
	}
	
	public static void printProductAndPrice(Map<Integer, Float> orderedMap, List<String> searchResultsList) {
		
		for (Map.Entry<Integer, Float> i : orderedMap.entrySet())
        {
            String [] values = searchResultsList.get(i.getKey()).split("#SEPARATOR#");
			System.out.println("Product: " + values[0]);
            System.out.println("Price: " + values[1].replaceAll("\\n", "."));
        }
		
	}

}
