public class Agency
{
    private Agents agents = new Agents();   
    private SalesProperties salesProperties = new SalesProperties();
    private RentalProperties rentalProperties = new RentalProperties();
    private String NAME = "Rainbow Real Estate ";
    private final char YES = 'Y';

    public Agency()
    {   
        addTestData();
        menu();
    }  
    
    private void addTestData()
    {
        Util.displayLine(true, "-- Adding Test Data --");
        agents.add("Agent1");
        Agent agent = agents.find(1);
        salesProperties.add(agent, "SalesOwner1", 10000.0);
        rentalProperties.add(agent, "RentalOwner1", 500.0);
        Util.displayLine(true, "-- Done Adding Test Data --\n");
    }

    private void menu()
    {
        char action = readAction();
        switch (action)
        {
            case 'A': addAgent(); break;
            case 'T': addRentalProperty(); break;
            case 'L': addSalesProperty(); break;
            case 'R': rent(); break;
            case 'S': sell(); break;
            case 'U': report(); break;
            case 'X': exit(); break;
            case '?': help(); break;
            default: error();
        }
    }

    private char readAction()
    {
        Util.displayLine(false,"\nPlease enter your choice (A, T, L, R, S, U, X, ?): \n");
        return In.nextUpperChar();
    }

    private void addAgent()
    {
        Util.displayLine(true, "Add Agent");
        agents.add();
        menu();
    }

    private void addRentalProperty()
    {
        Util.displayLine(true, "Add Rental Property");
        Agent agent = findAgentById();
        if (agent != null)
        {
            rentalProperties.add(agent, In.readName("owner"), In.readDouble("price"));
        }
        else
        {
            Util.displayLine(true, "Error - No agent with such ID");
        } 
        menu();
    }

    private void addSalesProperty()
    {
        Util.displayLine(true, "Add Sales Property");
        Agent agent = findAgentById();
        if (agent != null)
        {
            salesProperties.add(agent, In.readName("owner"), In.readDouble("price"));
        }
        else
        {
            Util.displayLine(true, "Error - No agent with such ID");
        } 
        menu();
    }

    private void rent()
    {
        Util.displayLine(true, "Rent a Property");
        Agent agent = findAgentById();
        if (agent != null)
        {
            RentalProperty property = findRentalPropertyById();
            if (property != null && property.isVacant())
            {                     
                property.rent(In.readName("tenant"), agent);
                Util.displayLine(true, "Rented !!");               
            }
            else
            {                
                Util.displayLine(true, "Error - Rental Property not vacant");
            }
        }
        else
        {
            Util.displayLine(true, "Error - No agent with such ID");
        }    
        menu();
    }

    private void sell()
    {
        Util.displayLine(true, "Rent a Property");
        Agent agent = findAgentById();
        if (agent != null)
        {
            SalesProperty property = findSalesPropertyById();
            if (property != null && property.isVacant())
            {
                property.sell(In.readName("buyer"), agent, In.readDouble("actual sell price"));
                Util.displayLine(true, "Sold !!");
            }
            else
            {                
                Util.displayLine(true, "Error - Sales Property not vacant");
            }
        }
        else
        {
            Util.displayLine(true, "Error - No agent with such ID");
        } 
        menu();
    } 

    private void report()
    {
        show();
        menu();
    }

    private void show()
    {
        Util.displayLine(true, toString());
    }

    private void exit()
    {
        if (!confirm())
            menu();
        else
            Util.displayLine(true, "Bye ...\n");
    }

    private boolean confirm()
    {
        Util.displayLine(false, "Are you sure (y/n)?: ");
        return In.nextUpperChar() == YES;
    }

    private void help()
    {
        Util.displayLine(true, "Welcome to Derelict Real Estate; enter");
        Util.displayLine(true, "A for add Agent");
        Util.displayLine(true, "T for add Rental Property");
        Util.displayLine(true, "L for add Sales Property");
        Util.displayLine(true, "R for Rent");
        Util.displayLine(true, "S for Sell");
        Util.displayLine(true, "U for Report");
        Util.displayLine(true, "X to exit");
        menu();
    }

    private void error()
    {
        Util.displayLine(true, "Error - No action found. Try again");
        menu();
    }

    private Agent findAgentById()
    {
        return agents.find(In.readInt("agent ID"));
    }

    private SalesProperty findSalesPropertyById()
    {
        return salesProperties.find(In.readInt("sales property ID"));
    }

    private RentalProperty findRentalPropertyById()
    {
        return rentalProperties.find(In.readInt("rental property ID"));
    }

    @Override
    public String toString()
    {
        double rentalIncome = rentalProperties.calcIncome();
        double salesIncome = salesProperties.calcIncome();

        return "\n" + NAME 
        + "\n" + agents.toString()
        + "\n" + salesProperties.toString()
        + "\n" + rentalProperties.toString()
        + "\nRental Property Income " + Util.format(rentalIncome)
        + "\nSales Property Income " + Util.format(salesIncome)
        + "\nAll Property Income " + Util.format(rentalIncome + salesIncome);
    }
}