import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.net.PortUnreachableException;

import static org.junit.Assert.*;
public class TestFilter
{
    @Test
    public void TestApply()
    {
        BeginStringFilter n = new BeginStringFilter("Мама дома");
        String n1 = "Мама";
        int k;
        if(n.apply(n1) == true)
            k = 1; else
                k = 0;
        assertEquals(1, k);
    }
    @Test
    public void TestApply1()
    {
        ApplyClass1 n = new ApplyClass1('R');
        String n1 = "homRan";
        int k;
        if(n.apply(n1) == true)
            k = 1; else
            k = 0;
        assertEquals(1, k);
    }
    @Test
public void TestApply2()
{
    ApplyClass2 n = new ApplyClass2("123", "123456");
    String n1 = "123";
    int k;
    if(n.apply(n1) == true)
        k = 1; else
        k = 0;
    assertEquals(1, k);
}


}
