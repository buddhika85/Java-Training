public class Q2 
{
    public static void main(String[] args) 
    {
        Bundle bundle = new Bundle(Phone.SAMSUNG, PhoneAccessory.HEADPHONES);
        System.out.println(bundle.discountedPrice(0.1));            // 1250 * .9 = 1125
    }    
}



class Bundle
{
	private Phone phone;
	private PhoneAccessory phoneAccessory;

	public Bundle(Phone phone, PhoneAccessory phoneAccessory)
	{
		this.phone = phone;
		this.phoneAccessory = phoneAccessory;
	}

	// computes the discounted total price of the phone and accessory
	public double discountedPrice(double discountPercentage)
	{
		return (phone.getPrice() + phoneAccessory.getPrice()) * (1 - discountPercentage);
	}
}