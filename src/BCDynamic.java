import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class BCDynamic {
	
	public static long N; //Holds N value entered by user
	public static long K; //Holds K value entered by user
	private static long top; //Holds result from calculating the top number
	private static long btm; //Holds result from calculating bottom number
	private static long ans; //Holds answer (top divided by btm)
	private static long diff; //difference between N value and K value
	private static int subsets; //Holds original K value as an int
	private static int items;  //Holds original N value as an int
	private static long end; //Gets end time after calculations are done
	private static long start; //Gets start time before calculations are done
	private static long time; //Time it took for calculations to be done (end minus start)
	private static long d; //Holds original difference between N and K for for loop

	public static void main(String [] args) { //Sets up file and calls CalculateTop
		
		String fileName = "BCDynamic.txt"; 
		PrintWriter toFile = null; 
		
		try{
			
			toFile = new PrintWriter(fileName); 
			
		}//Close try
		
		catch (FileNotFoundException e) {
			
		        System.out.println("PrintWriter error opening the file " + fileName);
		        System.out.println(e.getMessage());
		        
		}//Close catch
		
		CalculateTop();
		
	}//close main method
	
	public static void CalculateTop(){ //Gets N and K from user, multiplies the first number by the second number then increments diff by 2. Then calculates top of binomial coefficient then calls CalculateBottom
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter N value: ");
		N = scan.nextInt();
		items = (int) N;
		
		System.out.print("Please enter K value: ");
		K = scan.nextInt();
		subsets = (int) K;
		
		start = System.nanoTime();
		
		diff = (N - K) + 1;
		top = diff * (diff + 1);
		diff += 2;
		d = diff;
		
		for(int i = (int)d; i <= N; i++) {
			
			top *= diff;
			diff ++;
			
		} //close for loop
		
		CalculateBottom();
		
	} //close CalculateTop
	
	public static void CalculateBottom(){ //Calculates  bottom of binomial coefficient (divisor), divides top by bottom, prints answer, calculates time taken, then asks user if they want to enter another N and K
		
		if(K == 1) {
			
			end = System.nanoTime();
			time = (end - start)/1000000000;
			
			if(time < 1)
				time = 1;
			
			System.out.println("There are " + N + " ways to choose " + subsets + " subsets from " + items + " items.");
			
			Scanner answer = new Scanner(System.in);
			System.out.print("\nWould you like to enter another N and K? (Y/N): ");
			String input = answer.nextLine();
			
			if(input.contentEquals("Y")) {
				CalculateTop();
			}//close if
			
			else {
				System.out.print("\n<END RUN>");
			}
			
		}//close if
		
		else {
			
			btm = 2;
			
			for(int j = 2; j < K; j++) {
			
				btm *= j + 1;
			
			} //close for loop
			
			ans = top / btm;
			
			end = System.nanoTime();
			time = (end - start)/1000000000;
			
			if(time < 1)
				time = 1;
			
			System.out.println("There are " + ans + " ways to choose " + subsets + " subsets from " + items + " items.");
			
			Scanner answer = new Scanner(System.in);
			System.out.print("\nWould you like to enter another N and K? (Y/N): ");
			String input = answer.nextLine();
		
			if(input.contentEquals("Y")) {
			
				CalculateTop();
			
			}//close if
		
			else {
			
				System.out.print("\n<END RUN>");
			
			}//close else
		
		}//close else
		
	} //close CalculateBottom

} //close BCDynamic
