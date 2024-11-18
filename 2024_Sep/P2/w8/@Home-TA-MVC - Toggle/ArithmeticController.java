public class ArithmeticController
 {
    private final ArithmeticModel model;

    public ArithmeticController(ArithmeticModel model) 
    {
        this.model = model;
    }

    // call setter in the model and update accodingly
    public void updateX(String x) 
    {
        model.setX(convertStringToInt(x));
    }

    // call setter in the model and update accodingly
    public void updateY(String y) 
    {
        model.setY(convertStringToInt(y));
    }

    // convert input string meaninful integer if possible,
    // otherwise return 0
    private int convertStringToInt(String s) 
    {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if ("-".equals(s)) {                // input is only -
            return 0;
        }
        return Integer.parseInt(s); // Convert string into integer
    }

    public void updateSelctedOperation(Operation operation) 
    {
        model.setSelectedOperation(operation);
    }
}