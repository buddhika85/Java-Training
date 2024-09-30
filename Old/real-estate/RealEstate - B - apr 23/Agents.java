public class Agents extends Records
{
    @Override
    public Agent find(int id)
    {
        return (Agent) super.find(id);
    }
    
    public void add()
    {        
        Agent agent = new Agent(++id, In.readName("agent"));
        super.add(agent);
        System.out.println("\tAgent Added - " + agent.toString());
    }
    
    public void add(String name)
    {
        Agent agent = new Agent(++id, name);
        super.add(agent);
        System.out.println("\tAgent Added - " + agent.toString());
    }
    
    @Override
    public String toString()
    {
        return "Agents\n" + super.toString(); 
    }
}