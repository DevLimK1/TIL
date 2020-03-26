package 예외처리;

public class Calculator {
	public static int add(int x,int y) throws 백을넘는예외 { //내가 예외를 처리하지 않고 나를 사용하고 있는 애한테 던지겠다는 의미
		int result;
		
		if(x>100)
			throw new 백을넘는예외();
		
		result=x+y;
		return result;
	}
	
	public static int sub(int x,int y) throws 음수를만드는예외 {
		int result;
		
		if(x<y)
			throw new 음수를만드는예외();
		
		result=x-y;
		return result;
	}
	
	public static int div(int x,int y)  {
		int result;
		
		result=x/y;
		
		return result;
	}
}
