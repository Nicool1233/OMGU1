import java.util.Arrays;
import java.util.Objects;

public class BatchedProducts implements Packed
{
    private Packed[] products;
    private String description;
    public BatchedProducts(int n, String description)
    {
        if(n>0)
        {
            products = new Packed[n];
        } else
            throw new IllegalArgumentException("Wrong size batched products");
        if(description != null)
        {
            this.description = description;
        } else
        {
            throw new IllegalArgumentException("Description is null");
        }
    }

    public void setPackedPieceProduct(int i, PackedPieceProduct n)
    {
        if(i>=0)
        products[i] = new PackedPieceProduct(n);
        else
            throw new IllegalArgumentException("Wrong index");
    }

    public void setPackedWeightProduct(int i, PackedWeightProduct n)
    {
        if(i>=0)
        products[i] = new PackedWeightProduct(n);
        else
            throw new IllegalArgumentException("Wrong index");
    }
    public void setPacledSetProducts(int i, PackedSetProducts n)
    {
        if(i>=0)
        products[i] = new PackedSetProducts(n);
        else
            throw new IllegalArgumentException("Wrong index");
    }
    public double getBrutto() {
        double weight = 0;
        for (int i = 0; i<products.length; i++)
        {
            weight = weight + products[i].getBrutto();
        }
        return weight;
    }

    @Override
    public double getNetto() {
        return 0;
    }

    @Override
    public String getName() {
        return description;
    }

    @Override
    public String getDetermination() {
        return null;
    }

    public Packed getProduct(int i)
    {
        return products[i];
    }
    public int getSizeProducts()
    {
        return products.length;
    }
}
