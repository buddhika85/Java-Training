public class SnackStoreController 
{
    private final SnackStoreModel model;

    public SnackStoreController(SnackStoreModel model) 
    {
        this.model = model;
    }

    // call setter in the model and update accodingly
    public void updatePepsiQty(String value)
    {
        model.setPepsiQty(convertStringToInt(value));
    }

    public void updateJuiceQty(String value)
    {
        model.setJiceQty(convertStringToInt(value));
    }

    public void updatePepsiPrice(String value)
    {
        model.setPepsiPrice(convertStringToDouble(value));
    }

    public void updateJuicePrice(String value)
    {
        model.setJuicePrice(convertStringToDouble(value));
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

    private double convertStringToDouble(String s) 
    {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if ("-".equals(s)) {
            return 0;
        }
        return Double.parseDouble(s); // Convert string into double
    }
}
