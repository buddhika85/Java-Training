public class Q1 {
    public static void main(String[] args) {
        int total = 0;
        Phone[] phones = { Phone.MOTOROLA, Phone.IPHONE };
        PhoneAccessory[] accessories = { PhoneAccessory.HEADPHONES, PhoneAccessory.CHARGING_CABLE };
        for (Phone p : phones) {
            total += p.getPrice();
        }
        for (PhoneAccessory p : accessories) {
            total += p.getPrice();
        }
        System.out.println(total);
    }
}

enum Phone {
    IPHONE(1500),
    SAMSUNG(1200),
    MOTOROLA(500);

    private final int price;

    Phone(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

enum PhoneAccessory {
    CASE(20),
    SCREEN_PROTECTOR(15),
    CHARGING_CABLE(10),
    HEADPHONES(50);

    private final int price;

    PhoneAccessory(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}