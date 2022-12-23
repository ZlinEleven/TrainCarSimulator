/* Zhenbin Lin, 114866923, Recitation section 04 */


/**
 * A node wrapper class that will hold a TrainCar object. This node object will
 * be used in a doubly linked list
 * @author zhenb
 *
 */
public class TrainCarNode{
    private TrainCarNode prev;
    private TrainCarNode next;
    private TrainCar car;

    /**
     * Constructor that sets the previous link, next link, and current data to null
     */
    public TrainCarNode(){
        prev = null;
        next = null;
        car = null;
    }

    /**
     * Overloaded constructor that sets the previous and next link to null and the
     * current node data to car
     * @param car The train car object to be wrapped in the current node
     */
    public TrainCarNode(TrainCar car){
        prev = null;
        next = null;
        this.car = car;
    }

    /**
     * Gives the previous link's node
     * @return The previous link
     */
    public TrainCarNode getPrev(){
        return prev;
    }

    /**
     * Gives the next link's node
     * @return The next link
     */
    public TrainCarNode getNext(){
        return next;
    }

    /**
     * Gives the train car that is wrapped in the current node
     * @return The train car that is wrapped in the current node
     */
    public TrainCar getData(){
        return car;
    }

    /**
     * Sets the current node's previous link to node
     * @param node Another node that will be set to the current node's previous link
     */
    public void setPrev(TrainCarNode node){
        prev = node;
    }

    /**
     * Sets the current node's next link to node
     * @param node Another node that will be set to the current node's next link
     */
    public void setNext(TrainCarNode node){
        next = node;
    }

    /**
     * Wraps car in the current node
     * @param car The train car object that will be wrapped by the current node
     */
    public void setData(TrainCar car){
        this.car = car;
    }

    /**
     * Returns a neatly formatted String representation of the train car and the load within
     */
    public String toString(){
    	String ansStr = "Car: " + this.getData().getCarLength() + " meters, " + this.getData().getCarWeight() + " tons\n"
    			+ "Load: " + this.getData().getProductLoad().getName() + ", " + this.getData().getProductLoad().getWeight() + "tons, $" + 
    			String.format("%,.2f", this.getData().getProductLoad().getValue()) + "value, ";
    	String isDangerous = "not dangerous.";
    	if(this.getData().getProductLoad().getIsDangerous()) {
    		isDangerous = "DANGEROUS";
    	}
    	ansStr += isDangerous;
    	return ansStr;
    }
}