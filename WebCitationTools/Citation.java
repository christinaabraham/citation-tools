
public class Citation implements CitationAPI {
	private String author;
	private String date;
	
	
	public Citation() {

	}
	
	public String getAuthor(String name) {
		//FORMAT: John Smith
		// Allow middle names and/or initials
		String lastName, firstName = "";
		for(int i = name.length(); i < 0; i++) {
			if(name.substring(i-1, i).equals(" ")) {
				lastName = name.substring(i-1, name.length());
				firstName = name.substring(0, i-1);
				return lastName + ", " + firstName + ".";
			} else {
				return name; 
			}
		}
		
	}
	
	public String getAccessedDate(String date) { 
		// FORMAT: MM/DD/YYYY || MM/YYY || YYYY
		int spaceCount = 0;
		String month, day, year = "";
		String nums = "012345s6789";
		String finalDate = "";
		String[] months = {"January", "February", "March", "April", "May", 
							"June", "July", "August", "September", 
							"October", "November", "December"};
		
		// String containing numbers only
		for(int i = 0; i < date.length(); i++) {
			if(nums.contains(date.substring(i, i+1))) {
				finalDate += date.substring(i, i+1);
			}
		}
		// Checks format; accounts for no. of slashes, spaces, etc.
		for(int i = 0; i < date.length(); i++) {
			if(!nums.contains(date.substring(i, i+1))) spaceCount++;
		}
			
		// MM/DD/YYYY
		if(spaceCount == 2) {
			month = months[Integer.valueOf(finalDate.substring(0, 2))];
			day = finalDate.substring(2, 4);
			year = finalDate.substring(4, 8);
			return "Accessed " + day + " " + month + year + ".";
			
		// MM/YYYY
		} else if(spaceCount == 1) {
			month = months[Integer.valueOf(finalDate.substring(0, 2))];
			year = finalDate.substring(2, 6);
			
		// YYYY
		} else {
			return "Accessed " + date;
		}
	}
	
	public String getPublishedDate() {
		// FORMAT: MM/DD/YYYY || MM/YYY || YYYY
		int spaceCount = 0;
		String month, day, year = "";
		String nums = "012345s6789";
		String finalDate = "";
		String[] months = {"Jan.", "Feb.", "Mar.", "Apr.", 
							"May", "June", "July", "Aug.", 
							"Sept.", "Oct.", "Nov.", "Dec."};
		
		// String containing numbers only
		for(int i = 0; i < date.length(); i++) {
			if(nums.contains(date.substring(i, i+1))) {
				finalDate += date.substring(i, i+1);
			}
		}
		
		// Checks format; accounts for no. of slashes, spaces, etc.
		for(int i = 0; i < date.length(); i++) {
			if(!nums.contains(date.substring(i, i+1))) spaceCount++;
		}
			
		// MM/DD/YYYY
		if(spaceCount == 2) {
			month = months[Integer.valueOf(finalDate.substring(0, 2))];
			day = finalDate.substring(2, 4);
			year = finalDate.substring(4, 8);
			return "Accessed " + day + " " + month + year + ".";
			
		// MM/YYYY
		} else if(spaceCount == 1) {
			month = months[Integer.valueOf(finalDate.substring(0, 2))];
			year = finalDate.substring(2, 6);
			
		// YYYY
		} else {
			return "Accessed " + date;
		}

	}
	
	public String getURL() {
		
	}
	
	public String getSourceName() {
		
	}
	
	public String getSiteName() {
		
	}
	public String sort() {
		
	}
}
