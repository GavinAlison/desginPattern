package Strategy.sample02;

interface TravelStrategy
{
	
	public void travelMethod();

}

class AirplaneStrategy implements  TravelStrategy
{	
	public void travelMethod()
	{
		System.out.println("�ɻ��Σ�");
	}
}

class TrainStrategy implements  TravelStrategy
{
	public void travelMethod()
	{
		System.out.println("���Σ�");
	}
}

class SelfTravelStrategy implements  TravelStrategy
{
	public void travelMethod()
	{
		System.out.println("�Լ��Σ�");
	}
}

class BicycleTravelStrategy implements  TravelStrategy
{
	public void travelMethod()
	{
		System.out.println("���г��Σ�");
	}
}

class MyContext
{
	private TravelStrategy ts;
	public MyContext(TravelStrategy ts)
	{
		this.ts=ts;
	}
	public void travelMethod()
	{
		ts.travelMethod();
	}
}

class Client
{
	public static void main(String args[])
	{
		MyContext mc=new MyContext((TravelStrategy)XMLUtil.getBean());
		mc.travelMethod();
	}
}
