public class ArithmeticController {
    private final ArithmeticModel model;

    public ArithmeticController(ArithmeticModel model) {
        this.model = model;
    }

    public void updateX(String x) {
        model.setX(convertStringToInt(x));
    }

    public void updateY(String y) {
        model.setY(convertStringToInt(y));
    }

    private int convertStringToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if ("-".equals(s)) {
            return 0;
        }
        return Integer.parseInt(s); // Convert string into integer
    }
}