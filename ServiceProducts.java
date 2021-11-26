public class ServiceProducts
{
    public int countByFilter(BatchedProducts n, Filter filter)
    {
        int k = 0;
        String line;
        for (int i = 0; i < n.getSizeProducts(); i++) {
            line = n.getProduct(i).getName();
            if (filter.apply(line) == true)
            {
                k++;
            }
        }
        return k;
    }
    public boolean countByFilterDeep(BatchedProducts n, Filter filter)
    {
        int k = 0;
        String line;
        for (int i = 0; i < n.getSizeProducts(); i++) {
            line = n.getProduct(i).getName();
            if (filter.apply(line) == true)
            {
                return true;
            }
        }
        return false;
    }
    public boolean checkAllWeighted(BatchedProducts n)
    {
        Filter filter = new BeginStringFilter("Весовой");
        int k = 0;
        String line;
        for (int i = 0; i < n.getSizeProducts(); i++) {
            line = n.getProduct(i).getDetermination();
            if (filter.apply(line) == true)
            {
                k++;
            }
        }
        if(k == n.getSizeProducts())
        return true;
        else
        return false;
    }
}
