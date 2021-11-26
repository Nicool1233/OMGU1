import java.util.Arrays;
import java.util.Objects;

public class PackedWeightProduct implements Packed
{
    private WeightProduct[] WeightProducts;
    private Pack pack;
    private String name;
    private String description;
    public PackedWeightProduct()
    {

    }
    public PackedWeightProduct(PackedWeightProduct n)
    {
        WeightProducts = n.getWeightProducts();
        pack = n.getPack();
        name = n.getName();
        description = n.getDetermination();
    }
    public PackedWeightProduct(int n, Pack pack, String line, String description)
    {
        if(line != null)
        {
            name = line;
        } else
            throw new IllegalArgumentException("Name is null");
        if(description!= null)
        {
            this.description = description;
        } else
            throw new IllegalArgumentException("Description is null is null");
        if(n>0)
        {
            WeightProducts = new WeightProduct[n];
        }
        else
            throw new IllegalArgumentException("Incorrect size for Weight Products");
        if(pack != null)
        {
            this.pack = pack;
        } else
            throw new IllegalArgumentException("No pack");
        for (int i = 0; i<n; i++)
        {
            WeightProducts[i] = new WeightProduct();
        }

    }

    @Override
    public double getBrutto() {
        double commonWeight = 0;
        for (int i = 0; i < WeightProducts.length; i++)
        {
            commonWeight = commonWeight + WeightProducts[i].getWeight();
        }
        commonWeight = commonWeight + pack.getWeight();
        return commonWeight;
    }

    @Override
    public double getNetto() {
        double commonWeight = 0;
        for (int i = 0; i < WeightProducts.length; i++)
        {
            commonWeight = commonWeight + WeightProducts[i].getWeight();
        }
        return commonWeight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetermination() {
        return description;
    }


    public void setWeightProducts(double Weight, int i)
    {
        if(i>=0)
        WeightProducts[i].setWeight(Weight);
        else
            throw new IllegalArgumentException("Wrong index");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackedWeightProduct that = (PackedWeightProduct) o;
        return Arrays.equals(WeightProducts, that.WeightProducts) && Objects.equals(pack, that.pack);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(pack);
        result = 31 * result + Arrays.hashCode(WeightProducts);
        return result;
    }

    @Override
    public String toString() {
        return "PackedWeightProduct{" +
                "WeightProducts=" + Arrays.toString(WeightProducts) +
                ", pack=" + pack +
                '}';
    }

    public WeightProduct[] getWeightProducts() {
        return WeightProducts;
    }

    public Pack getPack() {
        return pack;
    }
}
