import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.net.PortUnreachableException;

import static org.junit.Assert.*;
public class PackedPieceOrWeightProductTest {
    @Test
    public void TestBruttoPiece()
    {
        Pack pack = new Pack(2, "Картон");
        PackedPieceProduct n = new PackedPieceProduct("Яблоки", "Красные, вкусные, сысные", 3, pack);
        n.setPieceProduct(20, 0);
        n.setPieceProduct(15, 1);
        n.setPieceProduct(10, 2);
        assertEquals(0, Double.compare(47, n.getBrutto()));
    }
    @Test
    public void TestNettoPiece()
    {
        Pack pack = new Pack(2, "Картон");
        PackedPieceProduct n = new PackedPieceProduct("Яблоки", "Красные, вкусные, сысные", 3, pack);
        n.setPieceProduct(20, 0);
        n.setPieceProduct(15, 1);
        n.setPieceProduct(10, 2);
        assertEquals(0, Double.compare(45, n.getNetto()));
    }
    @Test
    public void TestNettoWeight()
    {
        Pack pack = new Pack(4, "Оленья шкура");
        PackedWeightProduct n = new PackedWeightProduct(4, pack, "Яблоко", "");
        n.setWeightProducts(12.3, 0);
        n.setWeightProducts(3, 1);
        n.setWeightProducts(14, 2);
        n.setWeightProducts(6, 3);
        assertEquals(0, Double.compare(35.3, n.getNetto()));
    }
    @Test
    public void TestBruttoWeight()
    {
        Pack pack = new Pack(4, "Оленья шкура");
        PackedWeightProduct n = new PackedWeightProduct(4, pack, "Яблоко", "");
        n.setWeightProducts(12.3, 0);
        n.setWeightProducts(3, 1);
        n.setWeightProducts(14, 2);
        n.setWeightProducts(6, 3);
        assertEquals(0, Double.compare(39.3, n.getBrutto()));
    }
    @Test
    public void TestPackedSetProductsNetto()
    {
        Pack pack = new Pack(4, "Человек");
        PackedSetProducts n = new PackedSetProducts(4, pack, "");
        PackedWeightProduct n1 = new PackedWeightProduct(4, pack, "Яблоко", "");
        n1.setWeightProducts(12, 0);
        n1.setWeightProducts(3, 1);
        n1.setWeightProducts(14, 2);
        n1.setWeightProducts(6, 3);
        PackedWeightProduct n2 = new PackedWeightProduct(3, pack, "Яблоко", "");
        n2.setWeightProducts(2, 0);
        n2.setWeightProducts(3, 1);
        n2.setWeightProducts(1, 2);
        PackedPieceProduct n3 = new PackedPieceProduct("Яблоки", "Красные, вкусные, сысные", 3, pack);
        n3.setPieceProduct(10, 0);
        n3.setPieceProduct(5, 1);
        n3.setPieceProduct(1, 2);
        PackedPieceProduct n4 = new PackedPieceProduct("Яблоки", "Красные, вкусные, сысные", 2, pack);
        n3.setPieceProduct(10, 0);
        n3.setPieceProduct(5, 1);
        n.setProductPackedWeightProduct(0, n1);
        n.setProductPackedWeightProduct(1, n2);
        n.setProductPackedPieceProduct(2, n3);
        n.setProductPackedPieceProduct(3, n4);
        assertEquals(0, Double.compare(57, n.getNetto()));
    }
    @Test
    public void TestPackedSetProductsBrutto()
    {
        Pack pack = new Pack(1, "Кошка");
        PackedSetProducts n = new PackedSetProducts(4, pack, "");
        PackedWeightProduct n1 = new PackedWeightProduct(4, pack, "Яблоко", "");
        n1.setWeightProducts(12, 0);
        n1.setWeightProducts(3, 1);
        n1.setWeightProducts(14, 2);
        n1.setWeightProducts(6, 3);
        PackedWeightProduct n2 = new PackedWeightProduct(3, pack, "Яблоко", "");
        n2.setWeightProducts(2, 0);
        n2.setWeightProducts(3, 1);
        n2.setWeightProducts(1, 2);
        PackedPieceProduct n3 = new PackedPieceProduct("Яблоки", "Красные, вкусные, сысные", 3, pack);
        n3.setPieceProduct(10, 0);
        n3.setPieceProduct(5, 1);
        n3.setPieceProduct(1, 2);
        PackedPieceProduct n4 = new PackedPieceProduct("Яблоки", "Красные, вкусные, сысные", 2, pack);
        n4.setPieceProduct(10, 0);
        n4.setPieceProduct(5, 1);
        n.setProductPackedWeightProduct(0, n1);
        n.setProductPackedWeightProduct(1, n2);
        n.setProductPackedPieceProduct(2, n3);
        n.setProductPackedPieceProduct(3, n4);
        assertEquals(0, Double.compare(77, n.getBrutto()));
    }
    @Test
    public void TestBatchedProductsBrutto()
    {
        BatchedProducts n = new BatchedProducts(4, "Белый порошок, сыпучий, высокое качество");
        Pack pack = new Pack(4, "Непрозрачный пакет");
        PackedWeightProduct n1 = new PackedWeightProduct(4, pack, "Яблоко", "");
        n1.setWeightProducts(12, 0);
        n1.setWeightProducts(3, 1);
        n1.setWeightProducts(14, 2);
        n1.setWeightProducts(6, 3);
        PackedWeightProduct n2 = new PackedWeightProduct(3, pack, "Яблоко", "");
        n2.setWeightProducts(2, 0);
        n2.setWeightProducts(3, 1);
        n2.setWeightProducts(1, 2);
        PackedPieceProduct n3 = new PackedPieceProduct("Фрукт", "Красные, вкусные, сысные", 3, pack);
        n3.setPieceProduct(10, 0);
        n3.setPieceProduct(5, 1);
        n3.setPieceProduct(1, 2);
        PackedPieceProduct n4 = new PackedPieceProduct("Фрукт", "Красные, вкусные, сысные", 2, pack);
        n4.setPieceProduct(10, 0);
        n4.setPieceProduct(5, 1);
        n.setPackedWeightProduct(0, n1);
        n.setPackedWeightProduct(1, n2);
        n.setPackedPieceProduct(2, n3);
        n.setPackedPieceProduct(3, n4);
        assertEquals(0, Double.compare(88, n.getBrutto()));

    }
    @Test
    public void TestPack()
    {
        try{
            Pack pack = new Pack(-1, "Непрозрачный пакет");
        }catch (IllegalArgumentException e)
        {
            System.err.println("Incorrect weight");
        }
    }
    @Test
    public void TestPack1()
    {
        try{
            String n = null;
            Pack pack = new Pack(2, n);
        }catch (IllegalArgumentException e)
        {
            System.err.println("empty description");
        }
    }
    @Test
    public void TestProduct()
    {
        try{
            String n = null;
            Product pack = new Product(n, "12");
        }catch (IllegalArgumentException e)
        {
            System.err.println("Incorrect name");
        }
    }
    @Test
    public void TestProduct1()
    {
        try{
            String n = null;
            Product pack = new Product("123", n);
        }catch (IllegalArgumentException e)
        {
            System.err.println("Incorrect description");
        }
    }
    @Test
    public void TestPieceProduct()
    {
        try{
            String n = null;
            PieceProduct pack = new PieceProduct("121", "23", -1);
        }catch (IllegalArgumentException e)
        {
            System.err.println("Incorrect weight");
        }
    }
    @Test
    public void TestWeightProduct()
    {
        try{
            String n = null;
            WeightProduct pack = new WeightProduct("121", "23", -1);
        }catch (IllegalArgumentException e)
        {
            System.err.println("Incorrect weight");
        }
    }
    @Test
    public void PackedSetProducts()
    {
        try{
            String n = null;
            Pack p = null;
            PackedPieceProduct pack = new PackedPieceProduct(n, "23", -1, p );
        }catch (IllegalArgumentException e)
        {
            System.err.println("Incorrect weight");
        }
    }
    @Test
    public void PackedSetProducts1()
    {
        try{
            String n = null;
            Pack p = null;
            PackedPieceProduct pack = new PackedPieceProduct(n, "23", 1, p );
        }catch (IllegalArgumentException e)
        {
            System.err.println("Pack null");
        }
    }
    @Test
    public void PackedSetProducts2() {
        try {
            String n = null;
            Pack p = new Pack(1, "23");
            PackedPieceProduct pack = new PackedPieceProduct(n, "23", 1, p);
        } catch (IllegalArgumentException e) {
            System.err.println("Name is null");
        }
    }
        @Test
        public void PackedSetProducts3()
        {
            try{
                String n = null;
                Pack p = new Pack(1, "23");
                PackedPieceProduct pack = new PackedPieceProduct("2", n, 1, p );
            }catch (IllegalArgumentException e)
            {
                System.err.println("Description is null");
            }
    }
    @Test
    public void PackedBatched()
    {
        String n = null;
        Pack p = new Pack(1, "23");
        BatchedProducts pack = new BatchedProducts(3, "as");
        PackedPieceProduct k = new PackedPieceProduct("as","as", 3, p);
        try{
            pack.setPackedPieceProduct(-1, k);
        }catch (IllegalArgumentException e)
        {
            System.err.println("Wrong index");
        }
    }

}