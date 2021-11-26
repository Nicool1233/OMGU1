public class FilterNeed implements Filter
{
    private String pattern;
    public FilterNeed(String pattern)
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
        if(k != -1)
        {
            return true;
        } else
            return false;
    }
}
