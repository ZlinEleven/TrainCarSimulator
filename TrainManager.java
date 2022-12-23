/* Zhenbin Lin, 114866923, Recitation section 04 */
import java.util.Scanner;

/**
 * This class contains the main method which is a menu driven application. 
 * The program prompts the user for an input which is then used to execute an event.
 */
public class TrainManager{
    public static void main(String[] args) throws Exception{
    	TrainLinkedList trainLink = new TrainLinkedList();
    
        Scanner scan = new Scanner(System.in);
        String menu = "(F) Cursor Forward\n(B) Cursor Backward\n(I) Insert Car After Cursor\n(R) Remove Car At Cursor\n(L) Set Product Load\n(S) Search For Product\n(T) Display Train\n(M) Display Manifest\n(D) Remove Dangerous Cars\n(Q) Quit\n";
        System.out.println(menu);
        
        System.out.print("Enter a selection: ");
        String selection = scan.nextLine().toUpperCase();
        System.out.println();
        
        while (!selection.equals("Q")) {
        	if(selection.equals("F")) {
        		try {
        			trainLink.cursorForward();
        		}
        		catch (NullPointerException e) {
        			System.out.println("Empty train.");
        		}
        		catch (Exception e) {
        			System.out.println("No next car, cannot move cursor forward.");
        		}
        	}
        	
        	else if(selection.equals("B")) {
        		try {
        			trainLink.cursorBackward();
        		}
        		catch (NullPointerException e) {
        			System.out.println("Empty train.");
        		}
        		catch (Exception e) {
        			System.out.println("No previous car, cannot move cursor backward.");
        		}
        	}
        	
        	else if(selection.equals("I")) {
        		try {
	        		System.out.print("Enter car length in meters: ");
	        		double length = scan.nextDouble();
	        		
	        		System.out.print("Enter car weight in tons: ");
	        		double weight = scan.nextDouble();
	        		scan.nextLine();
	        		
	        		System.out.println();
	        		TrainCar newCar = new TrainCar(length, weight, new ProductLoad());
	        		trainLink.insertAfterCursor(newCar);
        		}
        		catch (IllegalArgumentException e) {
        			System.out.println("Cannot add null object into train.");
        		}
        	}
        	
        	else if(selection.equals("R")) {
        		try {
	    	        TrainCar removedNode = trainLink.removeCursor();
	    	        String name = removedNode.getProductLoad().getName();
	    	        double weight = removedNode.getProductLoad().getWeight();
	    	        double value = removedNode.getProductLoad().getValue();
	    	        String isDangerous = "NO";
	    	        if(removedNode.getProductLoad().getIsDangerous()){
	    	        	isDangerous = "YES";
	    	        }
	    	        System.out.println("Car successfully unlinked. The following load has been removed from the train:\n");
	        		System.out.format("%8s%16s%14s%12s", "Name", "Weight (t)", "Value ($)", "Dangerous");
	        		System.out.println();
	    	        System.out.println("===================================================");
	    	        System.out.format("%10s%14s%14s%12s", name, weight, String.format("%,.2f", value), isDangerous);
	    	        System.out.println();
        		}
        		catch(NullPointerException e) {
        			System.out.println("Empty train.");
        		}
        	}
        	
        	else if(selection.equals("L")) {
        		System.out.print("Enter product name: ");
        		String name = scan.nextLine();
        		
        		System.out.print("Enter product weight in tons: ");
        		double weight = scan.nextDouble();
        		
        		System.out.print("Enter product value in dollars: ");
        		int value = scan.nextInt();
        		scan.nextLine();
        		
        		System.out.print("Enter is product dangerous? (y/n): ");
        		String dangerous = scan.nextLine();
        		System.out.println();
        		boolean isDangerous;
        		if(dangerous.equals("y")) {
        			isDangerous = true;
        		}
        		else {
        			isDangerous = false;
        		}
        		ProductLoad newLoad = new ProductLoad(name, weight, value, isDangerous);
        		trainLink.getCursorData().setProductLoad(newLoad);
        		trainLink.setWeight(trainLink.getWeight() + weight);
        		trainLink.setValue(trainLink.getValue() + value);
        		if(isDangerous) {
        			trainLink.setDangerousLoadCount(trainLink.getDangerousLoadCount() + 1);
        		}
        	}
        	
        	else if(selection.equals("S")) {
        		System.out.print("Enter product name: ");
        		String name = scan.nextLine();
        		System.out.println();
        		
        		trainLink.findProduct(name);
        	}
        	
        	else if(selection.equals("T")) {
        		System.out.println(trainLink);
        	}
        	
        	else if(selection.equals("M")) {
        		trainLink.printManifest();
        	}
        	
        	else if(selection.equals("D")) {
        		trainLink.removeDangerousCars();
        		System.out.println("Dangerous cars successfully removed from the train.");
        	}
        	
        	System.out.println();
        	System.out.println(menu);
        	System.out.print("Enter a selection: ");
        	selection = scan.nextLine().toUpperCase();
        	System.out.println();
        }
        System.out.println("Program terminating successfully...");
    }
}
