public class App {
    public static void main(String[] args) throws Exception {
        enumTest();
    }

    private static void enumTest()
    {
        Sauce creameFraiche = Sauce.CREAM_FRAICHE;
        System.out.println(creameFraiche);
        System.out.println(creameFraiche.getCost());
        System.out.println(creameFraiche);
    }
}
