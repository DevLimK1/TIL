package 예외처리;

public class Program {
	public static void main(String[] args) {
		int result=0;
		int result2=0;
		
			result2=Calculator.div(8,0); //RuntimeException
			result=Calculator.add(103,8); //Exception
			System.out.println("bye~");
		
		
		
//		catch (백을넘는예외 e) {
//			// TODO Auto-generated catch block
//			System.out.println("죄송, 예기치 않은 오류 발생!");
//		} 
//		
//		catch (음수를만드는예외 e) {
//			System.out.println("앞자리가 더 커야됩니다~");
//		}

		System.out.println(result);
	}
	

}
