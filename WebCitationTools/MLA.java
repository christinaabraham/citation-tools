import java.util.ArrayList;
import java.util.Scanner;

public class MLA extends Citation implements CitationAPI {
	private static ArrayList<Citation> mla;
	
	public MLA() {
		mla = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int index = 0;
		while(true) {
			System.out.print("Create new MLA citation? (Y/N)");
			String input = keyboard.nextLine();
			input = input.toUpperCase();
			
			if(input.equals("MLA")) {
				mla.add(new Citation());
			}	
		}
	}
	
	public void addCitation(Citation c) {
		if (mla.isEmpty()) {
			mla.add(c);
		} else {
			for (int i = 0; i < mla.size(); i++) {
				if (mla.get(i).compareTo(c) <= 0) {
					mla.add(i, c);
					return;
				}
			}
			mla.add(c);	
		}
	}
	
	public String toString() {
		// Would you like to continue? (Y/N)
		return this.getAuthor() + " " + this.getSourceTitle() 
			+ " " + this.getSiteName() + ", " + this.getPublishedDate() 
			+ ", " + this.getURL() + " " + this.getAccessedDate();
		
	}
}
