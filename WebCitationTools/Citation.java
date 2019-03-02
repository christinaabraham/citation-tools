import java.util.Scanner;


public class Citation implements Comparable<Citation> { 
	private String author;
	private String title;
	private String site;
	private String datePublished;
	private String url;
	private String dateAccessed;
	private Scanner keyboard;
	
	public Citation() {
		keyboard = new Scanner(System.in);
		this.author = setAuthor();
		this.title = setSourceTitle();
		this.site = setSiteName();
		this.datePublished = setPublishedDate();
		this.url = setURL();
		this.dateAccessed = setAccessedDate();
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String setAuthor() throws NullPointerException {
		//FORMAT: John Smith
		// Allow middle names and/or initials
		System.out.print("\tAuthor(s): ");
		author = keyboard.nextLine();
		String lastName, firstName = "";
		
		for(int i = author.length(); i < 0; i++) {
			if(author.substring(i-1, i).equals(" ")) {
				lastName = author.substring(i-1, author.length());
				firstName = author.substring(0, i-1);
				return lastName + ", " + firstName + ".";
			}
		}
		return author + "."; 		
	}
	
	public String getAccessedDate() { 
		return dateAccessed;
	}
	
	public String setAccessedDate() {
		// DATE FORMAT: MM/DD/YYYY || MM/YYY || YYYY 
		System.out.print("\tDate Accessed: ");
		this.dateAccessed = keyboard.nextLine();
		
		int spaceCount = 0;
		String month, day, year, finalDate = "";
		String nums = "012345s6789";
		String[] months = {"January", "February", "March", "April", "May", 
							"June", "July", "August", "September", 
							"October", "November", "December"};
		
		// String containing numbers only
		for(int i = 0; i < dateAccessed.length(); i++) {
			if(nums.contains(dateAccessed.substring(i, i+1))) {
				finalDate += dateAccessed.substring(i, i+1);
			}
		}
		// Checks format; accounts for no. of slashes, spaces, etc.
		for(int i = 0; i < dateAccessed.length(); i++) {
			if(!nums.contains(dateAccessed.substring(i, i+1))) spaceCount++;
		}
			
		// MM/DD/YYYY
		if(spaceCount == 2) {
			month = months[Integer.valueOf(finalDate.substring(0, 2))];
			day = finalDate.substring(2, 4);
			year = finalDate.substring(4, 8);
			return "Accessed " + day + " " + month + " " + year + ".";
			
		// MM/YYYY
		} else if(spaceCount == 1) {
			month = months[Integer.valueOf(finalDate.substring(0, 2))];
			year = finalDate.substring(2, 6);
			return "Accessed " + month + " "  + year + ".";
			
		// YYYY
		} else {
			return "Accessed " + dateAccessed + ".";
		}
	}
	
	public String getPublishedDate() {	// Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 8
		return datePublished;
	}
	
	public String setPublishedDate() {
		// DATE FORMAT: MM/DD/YYYY || MM/YYY || YYYY 
		System.out.print("\tDate Published: ");
		this.datePublished = keyboard.nextLine();
		
		int spaceCount = 0;
		String month, day, year, finalDate = "";
		String nums = "0123456789";
		String[] months = {"Jan.", "Feb.", "Mar.", "Apr.", 
							"May", "June", "July", "Aug.", 
							"Sept.", "Oct.", "Nov.", "Dec."};
		
		// String containing numbers only
		for(int i = 0; i < datePublished.length(); i++) {
			if(nums.contains(datePublished.substring(i, i+1))) {
				finalDate += datePublished.substring(i, i+1);
			}
		}
		
		// Checks format; accounts for no. of slashes, spaces, etc.
		for(int i = 0; i < datePublished.length(); i++) {
			if(!nums.contains(datePublished.substring(i, i+1))) spaceCount++;
		}
			
		// MM/DD/YYYY
		if(spaceCount == 2) {
			month = months[Integer.valueOf(finalDate.substring(0, 2))];
			day = finalDate.substring(2, 4);
			year = finalDate.substring(4, 8);
			return day + " " + month + " " + year;
			
		// MM/YYYY
		} else if(spaceCount == 1) {
			month = months[Integer.valueOf(finalDate.substring(0, 2))];
			year = finalDate.substring(2, 6);
			return month + " " + year;
		}
		// YYYY
		return datePublished;
	}
	
	public String getURL() {
		return url;
	}
	
	public String setURL() {
		System.out.print("\tWebsite URL: ");
		url = keyboard.nextLine();
		return url + ".";
	}
	
	public String getSourceTitle() {
		return title;
	}
	
	public String setSourceTitle() {
		System.out.print("\tArticle Tite: ");
		title = keyboard.nextLine();
		return "\"" + title + ".\"";
	}
	
	public String getSiteName() {
		return site;
	}
	
	public String setSiteName() {
		System.out.print("\tWebsite Name: ");
		site = keyboard.nextLine();
		return site;
	}
	
	public int compareTo(Citation c) {
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return alpha.indexOf(author.substring(1).toUpperCase()) 
				- alpha.indexOf(c.getAuthor().substring(1).toUpperCase());		
	}	
}
