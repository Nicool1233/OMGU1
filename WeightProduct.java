public class WeightProduct extends Product{
    private double weight;
    public WeightProduct()
    {

    }
    public WeightProduct(String name, String description, double weight)
    {
        super(name, description);
        if(weight > 0)
        {
            this.weight = weight;
        } else
            throw new IllegalArgumentException("Incorrect weight");
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public double getWeight() {
        return weight;
    }
}
