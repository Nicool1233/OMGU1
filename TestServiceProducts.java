import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.net.PortUnreachableException;

import static org.junit.Assert.*;
public class TestServiceProducts
{
    @Test
    public void TestCountByFilter()
    {
        ServiceProducts n = new ServiceProducts();
        BatchedProducts nn = new BatchedProducts(4, "Белый порошок, сыпучий, высокое качество");
        Pack pack = new Pack(4, "Непрозрачный пакет");
        PackedWeightProduct n1 = new PackedWeightProduct(4, pack, "8", "");
        n1.setWeightProducts(12, 0);
        n1.setWeightProducts(3, 1);
        n1.setWeightProducts(14, 2);
        n1.setWeightProducts(6, 3);
        PackedWeightProduct n2 = new PackedWeightProduct(3, pack, "Фрукт", "");
        n2.setWeightProducts(2, 0);
        n2.setWeightProducts(3, 1);
        n2.setWeightProducts(1, 2);
        PackedPieceProduct n3 = new PackedPieceProduct("12", "Красные, вкусные, сысные", 3, pack);
        n3.setPieceProduct(10, 0);
        n3.setPieceProduct(5, 1);
        n3.setPieceProduct(1, 2);
        PackedPieceProduct n4 = new PackedPieceProduct("Фрукт", "Красные, вкусные, сысные", 2, pack);
        n4.setPieceProduct(10, 0);
        n4.setPieceProduct(5, 1);
        nn.setPackedWeightProduct(0, n1);
        nn.setPackedWeightProduct(1, n2);
        nn.setPackedPieceProduct(2, n3);
        nn.setPackedPieceProduct(3, n4);
        Filter filter = new BeginStringFilter("Фрукт");
        int actual = n.countByFilter(nn, filter);
        assertEquals(3, actual);

    }
    @Test
    public void TestCountByFilterDeep()
    {
        ServiceProducts n = new ServiceProducts();
        BatchedProducts nn = new BatchedProducts(4, "Белый порошок, сыпучий, высокое качество");
        Pack pack = new Pack(4, "Непрозрачный пакет");
        PackedWeightProduct n1 = new PackedWeightProduct(4, pack, "123", "");
        n1.setWeightProducts(12, 0);
        n1.setWeightProducts(3, 1);
        n1.setWeightProducts(14, 2);
        n1.setWeightProducts(6, 3);
        PackedWeightProduct n2 = new PackedWeightProduct(3, pack, "Фрукт", "");
        n2.setWeightProducts(2, 0);
        n2.setWeightProducts(3, 1);
        n2.setWeightProducts(1, 2);
        PackedPieceProduct n3 = new PackedPieceProduct("23", "Красные, вкусные, сысные", 3, pack);
        n3.setPieceProduct(10, 0);
        n3.setPieceProduct(5, 1);
        n3.setPieceProduct(1, 2);
        PackedPieceProduct n4 = new PackedPieceProduct("56" , "Красные, вкусные, сысные", 2, pack);
        n4.setPieceProduct(10, 0);
        n4.setPieceProduct(5, 1);
        nn.setPackedWeightProduct(0, n1);
        nn.setPackedWeightProduct(1, n2);
        nn.setPackedPieceProduct(2, n3);
        nn.setPackedPieceProduct(3, n4);
        Filter filter = new BeginStringFilter("Фрукт");
        boolean actual = n.countByFilterDeep(nn, filter);
        int k = 0;
        if(actual == true)
        {
            k = 1;
        }
        assertEquals(1, k);

    }
    @Test
    public void TestCheckAllWeighted1()
    {
        ServiceProducts n = new ServiceProducts();
        BatchedProducts nn = new BatchedProducts(4, "Белый порошок, сыпучий, высокое качество");
        Pack pack = new Pack(4, "Непрозрачный пакет");
        PackedWeightProduct n1 = new PackedWeightProduct(4, pack, "Фрукт", "Весовой");
        n1.setWeightProducts(12, 0);
        n1.setWeightProducts(3, 1);
        n1.setWeightProducts(14, 2);
        n1.setWeightProducts(6, 3);
        PackedWeightProduct n2 = new PackedWeightProduct(3, pack, "Фрукт", "Весовой");
        n2.setWeightProducts(2, 0);
        n2.setWeightProducts(3, 1);
        n2.setWeightProducts(1, 2);
        PackedPieceProduct n3 = new PackedPieceProduct("12", "Красные, вкусные, сысные", 3, pack);
        n3.setPieceProduct(10, 0);
        n3.setPieceProduct(5, 1);
        n3.setPieceProduct(1, 2);
        PackedPieceProduct n4 = new PackedPieceProduct("Фрукт", "Красные, вкусные, сысные", 2, pack);
        n4.setPieceProduct(10, 0);
        n4.setPieceProduct(5, 1);
        nn.setPackedWeightProduct(0, n1);
        nn.setPackedWeightProduct(1, n2);
        nn.setPackedPieceProduct(2, n3);
        nn.setPackedPieceProduct(3, n4);
        Filter filter = new BeginStringFilter("Фрукт");
        boolean actual = n.checkAllWeighted(nn);
        assertFalse("Not all weighted", actual);

    }
    @Test
    public void TestCheckAllWeighted2()
    {
        ServiceProducts n = new ServiceProducts();
        BatchedProducts nn = new BatchedProducts(4, "Белый порошок, сыпучий, высокое качество");
        Pack pack = new Pack(4, "Непрозрачный пакет");
        PackedWeightProduct n1 = new PackedWeightProduct(4, pack, "Фрукт", "Весовой");
        n1.setWeightProducts(12, 0);
        n1.setWeightProducts(3, 1);
        n1.setWeightProducts(14, 2);
        n1.setWeightProducts(6, 3);
        PackedWeightProduct n2 = new PackedWeightProduct(3, pack, "Фрукт", "Весовой");
        n2.setWeightProducts(2, 0);
        n2.setWeightProducts(3, 1);
        n2.setWeightProducts(1, 2);
        PackedWeightProduct n3 = new PackedWeightProduct(3, pack, "123", "Весовой");
        n3.setWeightProducts(10, 0);
        n3.setWeightProducts(5, 1);
        n3.setWeightProducts(1, 2);
        PackedWeightProduct n4 = new PackedWeightProduct(2, pack, "323241", "Весовой");
        n4.setWeightProducts(10, 0);
        n4.setWeightProducts(5, 1);
        nn.setPackedWeightProduct(0, n1);
        nn.setPackedWeightProduct(1, n2);
        nn.setPackedWeightProduct(2, n3);
        nn.setPackedWeightProduct(3, n4);
        Filter filter = new BeginStringFilter("Фрукт");
        final boolean actual = n.checkAllWeighted(nn);
        assertTrue("All weight", actual);
    }
}
