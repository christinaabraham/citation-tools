import java.util.ArrayList;
import java.util.Scanner;

public class MLA extends Citation implements CitationAPI  {
	private static ArrayList<Citation> storedMLA;
	private static ArrayList<Citation> sortedMLA;
	
	public MLA() {
		storedMLA = new ArrayList<>();
		sortedMLA = new ArrayList<>();
	}
	
	public static void main(String[] args) throws NullPointerException {
		Scanner keyboard = new Scanner(System.in);
		int index = 0;
		while(true) {
			System.out.print("Create new MLA citation? (Y / N) : ");
			String input = keyboard.nextLine();
			input = input.toUpperCase();
			
			if(input.equals("Y")) {
				// Exception in thread "main" 
				// java.lang.NullPointerException
				storedMLA.add(new Citation());
			}
			
			System.out.println(storedMLA.get(index).toString());
			addCitation(storedMLA.get(index));

			System.out.println("\nCreate another MLA citation? (Y / N) :");
			String input2 = keyboard.nextLine();
			input2 = input2.toUpperCase();
			
			if(input2.equals("N")) {
				System.out.println("Processing Citations...\n\n");
				
				for(int i = 0; i < sortedMLA.size(); i++) {
					System.out.println(sortedMLA.get(i).toString());
					System.out.println("");
				}
				
				break;
			}
		}
	}
	
	public static void addCitation(Citation c) {
		if (sortedMLA.isEmpty()) {
			sortedMLA.add(c);
		} else {
			for (int i = 0; i < sortedMLA.size(); i++) {
				if (sortedMLA.get(i).compareTo(c) <= 0) {
					sortedMLA.add(i, c);
					return;
				}
			}
			sortedMLA.add(c);	
		}
	}
	
	public String toString() {
		// Would you like to continue? (Y/N)
		return this.getAuthor() + " " + this.getSourceTitle() 
			+ " " + this.getSiteName() + ", " + this.getPublishedDate() 
			+ ", " + this.getURL() + " " + this.getAccessedDate();
		
	}
}
