public class ApplyClass1 implements Filter
{
    private char a;
    public ApplyClass1(char a) {
        if (a >0)
        {
            this.a = a;
        } else
            throw new IllegalArgumentException("Wrong char symbol");
    }
    @Override
    public boolean apply(String n)
    {
        if(n.indexOf(a) == 0)
            return true;
        else
        return false;
    }
}
