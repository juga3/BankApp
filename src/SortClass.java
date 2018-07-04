import java.util.Comparator;

class SortbyInterest implements Comparator<Investor>
{
    public int compare(Investor a, Investor b) {
        return a.getInterest() - b.getInterest();
    }
}