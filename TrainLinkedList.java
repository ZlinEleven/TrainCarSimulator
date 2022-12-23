import java.lang.Exception;

/**
 * This class represents a doubly linked list with pointers: head, tail, and cursor
 * It also keeps track of the total size, length, weight, value, and dangerousness of the train
 * @author zhenb
 *
 */
public class TrainLinkedList{
    private TrainCarNode head;
    private TrainCarNode tail;
    private TrainCarNode cursor;
    private int size;
    private double totalLength;
    private double totalWeight;
    private double totalValue;
    private int dangerousLoadCount;

    /**
     * Constructor for the linked list. Initializes an empty doubly linked list
     */
    public TrainLinkedList(){
        head = null;
        tail = null;
        cursor = null;
        size = 0;
        totalLength = 0;
        totalWeight = 0;
        totalValue = 0;
        dangerousLoadCount = 0;
    }

    /**
     * Gets the train car that the cursor node is on
     * @exception NullPointerException If the cursor node is currently a null object
     * @return The train car that the cursor node is on
     */
    public TrainCar getCursorData() {
    	if(cursor == null) {
    		throw new NullPointerException();
    	}
        return cursor.getData();
    }

    /**
     * Sets the train car wrapped by the cursor node to car
     * @exception NullPointerException If the car parameter is a null object
     * @param car The TrainCar object to be wrapped by the cursor node
     */
    public void setCursorData(TrainCar car){
    	if(cursor == null) {
    		throw new NullPointerException();
    	}
        cursor.setData(car);
    }

    /**
     * Moves the cursor node forward
     * @throws Exception If the cursor node is null or at the tail of the list
     * @exception NullPointerException If the cursor node is a null object, terminate the method
     * @exception Exception If the cursor node is at the tail of the list, terminate the method
     */
    public void cursorForward() throws Exception {
    	if(cursor == null) {
    		throw new NullPointerException();
    	}
    	if(cursor == tail) {
    		throw new Exception();
    	}
    	
    	cursor = cursor.getNext();
   		System.out.println("Cursor moved forward");
    }

    /**
     * Moves the cursor node backward
     * @throws Exception If the cursor node is null or at the head of the list
     * @exception NullPointerException If the cursor node is a null object, terminate the method
     * @exception Exception If the cursor node is at the head of the list, terminate the method
     */
    public void cursorBackward() throws Exception{
    	if(cursor == null) {
    		throw new NullPointerException();
    	}
    	if(cursor == head) {
    		throw new Exception();
    	}
    	else {
    		cursor = cursor.getPrev();
    		System.out.println("Cursor moved backward.");
    	}
    }

    /**
     * Inserts a new node after the cursor with newCar wrapped within it. The cursor will then be moved forward to the new node
     * @exception IllegalArgumentException If newCar is null, the method will terminate
     * @param newCar The TrainCar object to be wrapped in the new to-be-inserted node
     */
    public void insertAfterCursor(TrainCar newCar){
        if(newCar == null){
            throw new IllegalArgumentException();
        }
        TrainCarNode newCarNode = new TrainCarNode(newCar);
        if(cursor == null) {
        	head = newCarNode;
        	tail = newCarNode;
        	cursor = newCarNode;
        }
        else {
            newCarNode.setPrev(cursor);
            newCarNode.setNext(cursor.getNext());
            if(cursor.getNext() != null)
            	cursor.getNext().setPrev(newCarNode);
            cursor.setNext(newCarNode);
            cursor = cursor.getNext();
        }
        if(cursor.getNext() == null) {
        	tail = cursor;
        }
        totalLength += newCar.getCarLength();
        totalWeight += newCar.getCarWeight();
        totalValue += newCar.getProductLoad().getValue();
        if(newCar.getProductLoad().getIsDangerous()){
            dangerousLoadCount++;
        }
        size++;
        System.out.println("New train car " + newCar.getCarLength() + " meters " + newCar.getCarWeight() + " tons inserted into train.");;
    }

    /**
     * Removes the node pointed by the cursor. If the cursor wasn't the tail,
     * it will point to the next node, Previous node otherwise
     * @return The TrainCar object that was wrapped by the removed node
     */
    public TrainCar removeCursor(){
    	if(cursor == null) {
    		throw new NullPointerException();
    	}
    	TrainCar temp = this.getCursorData();
    	if(cursor != tail || cursor != head) {
    		if(cursor != head){
	    		cursor.getPrev().setNext(cursor.getNext());
	    	}
	    	if(cursor != tail){
	            cursor.getNext().setPrev(cursor.getPrev());
	            cursor = cursor.getNext();
	        }
	    	else {
	    		cursor = cursor.getPrev();
	    	}
    	}
        else{
            cursor = null;
            head = null;
            tail = null;
        }
        totalLength -= temp.getCarLength();
        totalWeight -= temp.getCarWeight();
        totalValue -= temp.getProductLoad().getValue();
        if(temp.getProductLoad().getIsDangerous()){
            dangerousLoadCount--;
        }
        size--;
        return temp;
    }

    /**
     * Gives the amount of nodes in the linked list
     * @return The amount of nodes in the linked list
     */
    public int size(){
        return size;
    }

    /**
     * Gives the total length of all the train cars on the train
     * @return The total length of all the train cars on the train
     */
    public double getLength(){
        return totalLength;
    }

    /**
     * Gives the total weight of all the train cars and product loads
     * @return The total weight of all the train cars and product loads
     */
    public double getWeight(){
        return totalWeight;
    }

    /**
     * Gives the total value of all the product loads on the train
     * @return The total value of all the product loads on the train
     */
    public double getValue(){
        return totalValue;
    }
    
    /**
     * Sets the total length of the train
     * @param length The total length of the train to be set to
     */
    public void setLength(double length) {
    	totalLength = length;
    }
    
    /**
     * Sets the total weight of the train and product loads
     * @param weight The total weight of the train to be set to
     */
    public void setWeight(double weight) {
    	totalWeight = weight;
    }
    
    /**
     * Sets the total value of the product loads
     * @param value The total value of the product loads to be set to
     */
    public void setValue(double value) {
    	totalValue = value;
    }

    /**
     * Gives whether the train has a dangerous load on it
     * @return True if the train has at least one dangerous load on it, false otherwise
     */
    public boolean isDangerous(){
        return dangerousLoadCount != 0;
    }
    
    /**
     * Gives the amount of dangerous product loads on the train
     * @return The amount of dangerous product loads on the train
     */
    public int getDangerousLoadCount() {
    	return dangerousLoadCount;
    }
    
    /**
     * Sets the count of dangerous product loads on the train
     * @param count The amount of dangerous product loads to be set to
     */
    public void setDangerousLoadCount(int count) {
    	dangerousLoadCount = count;
    }

    /**
     * Goes through the linked list and look for the amount of train cars containing
     * product loads with the same name as the parameter. Prints the total amount of
     * weight and value of the product loads combined as well as whether the product
     * is dangerous
     * @param name The name of the products to look for
     */
    public void findProduct(String name){
        TrainCarNode nodePTR = head;
        double totalLoadWeight = 0;
        double totalLoadValue = 0;
        String isLoadDangerous = "NO";
        int productFound = 0;
        while (nodePTR != null){
            if (nodePTR.getData().getProductLoad().getName().equals(name)){
                totalLoadWeight += nodePTR.getData().getProductLoad().getWeight();
                totalLoadValue += nodePTR.getData().getProductLoad().getValue();
                if(nodePTR.getData().getProductLoad().getIsDangerous()){
                    isLoadDangerous = "YES";
                }
                productFound++;
            }
            nodePTR = nodePTR.getNext();
        }
        if(productFound == 0) {
        	System.out.println("No record of " + name + " on board train.");
        }
        else {
	        System.out.println("The following products were found on " + productFound + " cars:");
	        System.out.println();
	        System.out.format("%8s%16s%14s%12s", "Name", "Weight (t)", "Value ($)", "Dangerous");
	        System.out.println();
	        System.out.println("===================================================");
	        System.out.format("%10s%14s%14s%12s", name, totalLoadWeight, String.format("%,.2f", totalLoadValue), isLoadDangerous);
	        System.out.println();
        }
    }
    
    /**
     * Prints all the train cars and product loads in a neatly formatted table.
     * Each train car and its product loads are printed on its own line
     */
    public void printManifest() {
    	System.out.println(String.format("%7s%37s", "CAR:", "LOAD:"));
    	System.out.println(String.format("%9s%13s%14s%11s%16s%14s%12s", "Num", "Length (m)", "Weight (t)", "|    Name", "Weight (t)", "Value($)", "Dangerous"));
    	System.out.println("   ===================================+====================================================");
    	
    	TrainCarNode nodePTR = head;
    	
    	int count = 1;
    	while(nodePTR != null) {
    		if(nodePTR == cursor) {
    			System.out.print("->");
    		}
    		else {
    			System.out.print("  ");
    		}
    		TrainCar nodeCar = nodePTR.getData();
    		ProductLoad nodeLoad = nodeCar.getProductLoad();
    		String isDangerous = "NO";
    		if(nodeLoad.getIsDangerous())
    			isDangerous = "YES";
    		System.out.format("%6s%14s%14s%3s%10s%14s%14s%12s", count, nodeCar.getCarLength(), nodeCar.getCarWeight(), "|", nodeLoad.getName(), nodeLoad.getWeight(), String.format("%,.2f", nodeLoad.getValue()), isDangerous);
    		System.out.println();
    		nodePTR = nodePTR.getNext();
    		count++;
    	}
    }

    /**
     * Goes through the linked list and removes all train cars containing a dangerous load
     */
    public void removeDangerousCars(){
        cursor = head;
        while(cursor != null){
            if(cursor.getData().getProductLoad().getIsDangerous()){
                removeCursor();
            }
            cursor = cursor.getNext();
        }
        cursor = tail;
    }

    /**
     * Returns a neatly formatted String representation of the train
     */
    public String toString(){
        String ansStr = "Train: " + this.size() + " cars, " + this.getLength() + " meters, " + String.format("%.1f", this.getWeight()) + " tons, $" + String.format("%,.2f", this.getValue()) + " value, ";
        
        if(this.isDangerous()) {
        	ansStr += "DANGEROUS.";
        }
        else {
        	ansStr += "not dangerous.";
        }
        return ansStr;
    }
}