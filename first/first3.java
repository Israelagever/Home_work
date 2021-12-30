import java.util.Scanner;


public class first3 {
//משה
	public static int ricorcia (int[]arr,int num)
	{
		if(num==0){
			if(arr[num]>0) return 1;
			else return 0;
		}
		else {
		if(arr[num]>0) return ricorcia(arr, num-1)+1;
		else
			return ricorcia(arr, num-1);
		}
	}


	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int num;
		num = scanner.nextInt();
		int arr[]={7,8,-2,3,-3,-7};
		System.out.println(	ricorcia(arr,num));

	}

}
