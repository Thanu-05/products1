package uk.ac.westminster.products_api;

// IS-A: PhysicalProduct is a Product (inheritance).
public class PhysicalProduct extends Product{

    // HAS-A: PhysicalProduct has a weight and dimensions.
    private double weightkg;
    private String dimension;
    //empty no-args constructor
    public PhysicalProduct(){}

    //constructors
    public PhysicalProduct(Long id, String name, double price, double weightkg, String dimension) {
        super(id, name, price);
        this.weightkg = weightkg;
        this.dimension = dimension;
    }

    public double getweightkg() {
        return weightkg;
    }
    public String getdimension() {
        return dimension;
    }



}

