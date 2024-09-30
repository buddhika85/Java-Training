public class Q2 
{
    public static void main(String[] args) 
    {
        System.out.println(new Bundle(Phone.IPHONE, PhoneAccessory.HEADPHONES).discountedPrice(0.1));
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

	public double discountedPrice(double discountPercentage)
	{
		return (phone.getPrice() + phoneAccessory.getPrice()) * (1 - discountPercentage);
	}
}