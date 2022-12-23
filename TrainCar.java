/* Zhenbin Lin, 114866923, Recitation section 04 */

/**
 * This class represents a train car object with attributes: length of car,
 * weight of car, and the product load that it contains
 * @author zhenb
 *
 */
public class TrainCar{
    private double carLength;
    private double carWeight;
    private ProductLoad load;

    /**
     * Constructor for the train car object
     * @param length The length of the car
     * @param weight The weight of the car
     * @param load The product load the car holds
     */
    public TrainCar(double length, double weight, ProductLoad load){
        carLength = length;
        carWeight = weight;
        this.load = load;
    }

    /**
     * Gives the length of the train car
     * @return The length of the train car
     */
    public double getCarLength(){
        return carLength;
    }

    /**
     * Gives the weight of the train car
     * @return The weight of the train car
     */
    public double getCarWeight(){
        return carWeight;
    }

    /**
     * Gives the product load the train car holds
     * @return The product the train car holds
     */
    public ProductLoad getProductLoad(){
        return load;
    }

    /**
     * Sets the product the train car will hold
     * @param load The product the train car will hold
     */
    public void setProductLoad(ProductLoad load){
        this.load = load;
        System.out.println(load.getWeight() + " tons of " + load.getName() + " added to the current car.");
    }

    /**
     * Tells whether the train car has a product in it or not
     * @return True if it has a product and false otherwise
     */
    public boolean isEmpty(){
        return this.getProductLoad().getName().equals("Empty");
    }
}