package practice;

class SingleTon {


	private  static SingleTon singleTon;

	private  SingleTon (String name) 
	{
		System.out.println(name);
	}

	public void add(int a , int b)
	{
		System.out.println(a+b);
	}	

	public  static SingleTon accessClass() {

		 singleTon = new SingleTon("tyss");

		return singleTon;
	}
	



}
