public class BeginStringFilter implements Filter
{
    private String pattern;
    public BeginStringFilter(String pattern)
    {
        if(pattern != null)
        {
            this.pattern = pattern;
        } else
        {
            throw new IllegalArgumentException("Pattern is null");
        }
    }
    @Override
    public boolean apply(String n)
    {
        int k = pattern.indexOf(n);
        if(k == 0)
        {
            return true;
        } else
            return false;
    }
}
