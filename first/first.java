import java.util.Scanner;


public class first {
//משה
	public static boolean ricorcia(int num)
	{
		if(num<10)
			return true;
		if(num%2==(num/10)%2)
		return ricorcia(num/10);
		else 
			return false;
		
	}
	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int num;
	num = scanner.nextInt();
	System.out.println(	ricorcia(num));
	
	}

}
