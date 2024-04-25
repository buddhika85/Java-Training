public class Members extends Records
{
    @Override
    public Member find(int id)
    {
        return (Member)super.find(id);
    }

    @Override
    public Member find(String name)
    {
        return (Member)super.find(name);
    }

    @Override
    public String toString() 
    {
        return "Members\n" + super.toString();
    }
}
