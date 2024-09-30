public class Point {
    private int x, y;

	public void shift(double moveX, double moveY)
	{
		x += moveX;
		y += moveY;
	}

	public void quadrant()
	{	
		var quadrant = "Quadrant 1";
		if (x < 0 && y > 0)
		{
			quadrant = "Quadrant 2";
		}
		else if (x < 0 && y < 0)
		{
			quadrant = "Quadrant 3";
		}	
		else if (x >= 0 && y < 0)
		{
			quadrant = "Quadrant 4";
		}
		System.out.println(toString() + " => " + quadrant);	
	}

	@Override
	public String toString()
	{
		return "x : " + x + " y : " + y;
	}
}
