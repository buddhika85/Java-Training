import java.util.ArrayList;
import java.util.List;

public class Members extends Records
{    
    @Override
    public Member find(int id)
    {
        return (Member)super.find(id);
    }

    public void add(String name, String email)
    {
        add(new Member(++id, name, email));
    }

    @Override
    public Member find(String name)
    {
        return (Member)super.find(name);
    }
    
    public List<Member> sortByNameAsc()
    {
        List<Member> sortedByNameAsc = new ArrayList<>();
        for (Record record :records) 
        {
            sortedByNameAsc.add((Member) record);
        }
        sortedByNameAsc.sort(NAME_ASC);
        return sortedByNameAsc;
    }
    
    public List<Member> sortByNameDesc()
    {
        List<Member> sortedByNameAsc = new ArrayList<>();
        for (Record record :records) 
        {
            sortedByNameAsc.add((Member) record);
        }
        sortedByNameAsc.sort(NAME_DESC);
        return sortedByNameAsc; 
    }

    @Override
    public String toString() 
    {
        return "Members\n" + super.toString();
    }
}
