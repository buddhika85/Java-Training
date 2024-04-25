import java.util.LinkedList;

public abstract class Records
{
    protected LinkedList<Record> records = new LinkedList<Record>();
    protected int id = 0;


    protected Record find(int id)
    {   
        for(Record record: records)
        {  
            if (record.matches(id))
                return record;  
        }
        return null;    
    }
    
    // overload
    protected Record find(String name)
    {   
        for(Record record: records)
        {  
            if (record.matches(name))
                return record;  
        }
        return null;    
    } 

    protected void add(Record record)
    {
        records.add(record);
    }

    public int size()
    {
        return records.size();
    }

    public void show()
    {
        System.out.println(toString());
    }

    @Override
    public String toString()
    {
        String str = "";
        for(Record record : records)
            str += record.toString() + "\n";
        return str;
    }
}