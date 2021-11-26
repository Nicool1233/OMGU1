public class PackedSetProducts implements Packed
{
    private Packed[] product;
    private Pack pack;
    private String description;

    public PackedSetProducts(PackedSetProducts n)
    {
        product = n.getProduct();
        pack = n.getPack();
        description = n.getDetermination();
    }
    public PackedSetProducts(int n, Pack pack, String description)
    {
        if(n>0)
        {
            product = new Packed[n];
        } else
        {
            throw new IllegalArgumentException("Wrong size set");
        }
        if(pack != null)
        {
            this.pack = pack;
        } else
        {
            throw new IllegalArgumentException("pack is null");
        }
        if(description != null)
        {
            this.description = description;
        } else
        {
            throw new IllegalArgumentException("Description is null");
        }
    }

    @Override
    public double getBrutto() {
        double weight = 0;
        for (int i = 0; i<product.length; i++)
        {
            weight = weight + product[i].getBrutto();
        }
        weight = weight+pack.getWeight();
        return weight;
    }

    @Override
    public double getNetto() {
        double weight = 0;
        for (int i = 0; i<product.length; i++)
        {
            weight = weight + product[i].getNetto();
        }
        return weight;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDetermination() {
        return description;
    }

    public void setProductPackedPieceProduct(int i, PackedPieceProduct product)
    {
        if(i>=0)
        this.product[i] = new PackedPieceProduct(product);
        else
            throw new IllegalArgumentException("Wrong index");
    }
    public void setProductPackedWeightProduct(int i, PackedWeightProduct product)
    {
        if(i>=0)
        this.product[i] = new PackedWeightProduct(product);
        else
            throw new IllegalArgumentException("Wrong index");
    }

    public Pack getPack() {
        return pack;
    }

    public Packed[] getProduct() {
        return product;
    }
}
