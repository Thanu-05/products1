package uk.ac.westminster.products_api;

// IS-A: PhysicalProduct is a Product (inheritance).
public class PhysicalProduct extends Product implements Discountable{

    // HAS-A: PhysicalProduct has a weight and dimensions.
    private double weightKg;
    private String dimension;
    private double discountedPrice;
    //empty no-args constructor
    public PhysicalProduct(){}

    //constructors
    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimension) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimension = dimension;
    }

    public double getWeightKg() {
        return weightKg;
    }
    public String getdimension() {
        return dimension;
    }


    @Override
    public String getSummary() {
        return "Physical: " + getName()
                + " | Weight: " + weightKg + " kg";
    }

    @Override
    public void applyDiscount(double rate) {
        double appliedRate = Math.min(rate, 0.20);
        discountedPrice = getPrice() * (1 - appliedRate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }


}

