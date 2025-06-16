package UI;

import java.util.HashMap;

public class LanguageHandler {
	private HashMap<String, String> danish;
	
	public LanguageHandler() {
		danish = new HashMap<String, String>();
		danish.put("Front page", "Forside");
		danish.put("Create order", "Start ordre");
		danish.put("Add product(s)", "Tilføj produkter");
		danish.put("Add customer", "Tilføj kunde");
		danish.put("Search products", "Søg efter produkter");
		danish.put("Search customers", "Søg efter kunder");
		danish.put("Send list to customer", "Send ordreliste til kunde");
		danish.put("Confirm order", "Bekræft ordre");
	}
	
	public String getSentence(String language, String key) {
		String result = key;
		
		if (language == "DANISH") {
			result = danish.get(key);
		}
		
		return result;
	}
}
