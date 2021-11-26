import java.util.Arrays;
import java.util.Objects;

public class PackedPieceProduct implements Packed
{
    private PieceProduct[] setPieceProduct;
    private Pack pack;
    private String name;
    private String description;
    public PackedPieceProduct(PackedPieceProduct n)
    {
        setPieceProduct = n.getSetPieceProduct();
        pack = n.getPack();
        name = n.getName();
        description = n.getDetermination();
    }
    public PackedPieceProduct(String name, String description, int n, Pack pack) {
        if(n>0) {
            setPieceProduct = new PieceProduct[n];
        } else
            throw new IllegalArgumentException("Wrong size");
        for (int i = 0; i<n; i++)
        {
            setPieceProduct[i] = new PieceProduct();
        }
        if(pack != null) {
            this.pack = pack;
        } else
            throw new IllegalArgumentException("Pack null");
        if(name != null)
        {
            this.name = name;
        } else
        {
            throw new IllegalArgumentException("Name is null");
        }
        if(description != null)
        {
            this.description = description;
        } else
            throw new IllegalArgumentException("Description is null");
    }
    public int getQuantityOfPieceProduct()
    {
        int n = setPieceProduct.length;
        return n;
    }
    public double getWeightOfAllProducts()
    {
        double prikol = 0;
        double Weight = 0;
        for (int i = 0; i<setPieceProduct.length; i++)
        {
            Weight = Weight + setPieceProduct[i].getWeight();
        }
        return Weight;
    }
    @Override
    public double getBrutto()
    {
        double prikol = 0;
        double Weight = 0;
        for (int i = 0; i<setPieceProduct.length; i++)
        {
            Weight = Weight + setPieceProduct[i].getWeight();
        }
        Weight = Weight + pack.getWeight();
        return Weight;
    }
    @Override
    public double getNetto()
    {
        double prikol = 0;
        double Weight = 0;
        for (int i = 0; i<setPieceProduct.length; i++)
        {
            Weight = Weight + setPieceProduct[i].getWeight();
        }
        return Weight;
    }

    public void setPieceProduct(double weight, int i) {
        if(i>=0)
        setPieceProduct[i].setWeight(weight);
        else
            throw new IllegalArgumentException("Wrong index");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetermination() {
        return description;
    }

    public Pack getPack() {
        return pack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackedPieceProduct that = (PackedPieceProduct) o;
        return Arrays.equals(setPieceProduct, that.setPieceProduct) && Objects.equals(pack, that.pack);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), pack);
        result = 31 * result + Arrays.hashCode(setPieceProduct);
        return result;
    }

    public PieceProduct[] getSetPieceProduct() {
        return setPieceProduct;
    }
}

