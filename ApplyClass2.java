public class ApplyClass2 implements Filter
{
    private String n1;
    private String n2;
    public ApplyClass2(String n1, String n2)
    {
        if(n1 != null)
        {
            this.n1 = n1;
        } else
        {
            throw new IllegalArgumentException("n1 is null");
        }
        if(n2 != null)
        {
            this.n2 = n2;
        } else
        {
            throw new IllegalArgumentException("n2 is null");
        }
    }
    @Override
    public boolean apply(String n) {
        if (n1.indexOf(n) == 0 && n2.indexOf(n) == 0)
        {
            return true;
        } else
        return false;
    }
}
