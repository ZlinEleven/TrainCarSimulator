/* Zhenbin Lin, 114866923, Recitation section 04 */

/**
 * This class represents a train load with attributes: product name, weight, value, 
 * and whether it is dangerous or not
 * @author zhenbin
 *
 */
public class ProductLoad{
    private String name;
    private double weight;
    private double value;
    private boolean isDangerous;

    /**
     * Constructor for a product load object
     * @param name The name/type of the product
     * @param weight The weight of the product
     * @param value The value of the product
     * @param isDangerous Whether the product load is dangerous or not
     */
    public ProductLoad(String name, double weight, double value, boolean isDangerous){
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.isDangerous = isDangerous;
    }
    
    /**
     * Initializes an empty product load object
     */
    public ProductLoad() {
    	this.name = "Empty";
    	this.weight = 0.0;
    	this.value = 0.0;
    	this.isDangerous = false;
    }

    /**
     * Gives the name of the product
     * @return The name of the product
     */
    public String getName(){
        return name;
    }

    /**
     * Gives the weight of the product
     * @return The weight of the product
     */
    public double getWeight(){
        return weight;
    }

    /**
     * Gives the value of the product
     * @return The value of the product
     */
    public double getValue(){
        return value;
    }

    /**
     * Gives whether the product is dangerous
     * @return The dangerousness of the product in either true or false
     */
    public boolean getIsDangerous(){
        return isDangerous;
    }

    /**
     * Sets the name of the product
     * @param name The name of the product to be set to
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the weight of the product
     * @param weight The weight of the product to be set to
     */
    public void setWeight(double weight){
        this.weight = weight;
    }

    /**
     * Sets the value of the product
     * @param value The value of the product to be set to
     */
    public void setValue(double value){
        this.value = value;
    }

    /**
     * Sets the dangerousness of the product
     * @param isDangerous The dangerousness of the product
     */
    public void setIsDangerous(boolean isDangerous){
        this.isDangerous = isDangerous;
    }
}