public class PieceProduct extends Product {
    private double weight;
    public  PieceProduct()
    {
        super("", "");
        weight = 0;
    }
    public PieceProduct(String name, String description, double weight) {
        super(name, description);
        if(weight >0)
        {
            this.weight = weight;
        }
        else
            throw new IllegalArgumentException("Incorrect weight");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
