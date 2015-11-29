package test;

import java.util.Comparator;

public class TestComparator implements Comparator<Integer>
{
    public int compare(Integer x, Integer y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
       
        return x-y;
    }
}
