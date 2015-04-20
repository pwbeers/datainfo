package nl.utwente.di;

public class Quoter {

	public double getBookPrice(String number)	{
		double result;
		if(Integer.parseInt(number) == 1)	{
			result = 10.0;
		}
		else if(Integer.parseInt(number) == 2)	{
			result = 45.0;
		}
		else if(Integer.parseInt(number) == 3)	{
			result = 20.0;
		}
		else if(Integer.parseInt(number) == 4)	{
			result = 35.0;
		}
		else {
			result = 50.0;
		}
		return result;
	}
}
