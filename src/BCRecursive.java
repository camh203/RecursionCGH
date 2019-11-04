import java.util.Scanner;
import java.io.*;

public class BCRecursive {
	
	public static long N; //Holds N value entered by user
	public static long K; //Holds K value entered by user
	private static long top; //Holds result from calculating the top number
	private static long btm; //Holds result from calculating bottom number
	private static long ans; //Holds answer (top divided by btm)
	private static long diff; //difference between N value and K value
	private static int subsets; //Holds original K value as an int
	private static int items; //Holds original N value as an int
	private static long end; //Gets end time after calculations are done
	private static long start; //Gets start time before calculations are done
	private static long time; //Time it took for calculations to be done (end minus start)
	
	public static void main(String [] args) { //Sets up file and calls BinomialRecursive
		

		String fileName = "BCRecursive.txt"; 
		PrintWriter toFile = null; 
		
		try{
			
			toFile = new PrintWriter(fileName); 
			
		} //Close try
		
		catch (FileNotFoundException e) {
			
		        System.out.println("PrintWriter error opening the file " + fileName);
		        System.out.println(e.getMessage());
		        
		} //Close catch
		
		BinomialRecursive();
		
	} //close main method
	
	public static void BinomialRecursive() { //Gets N and K from user, If k is 1 it prints out N as the answer and asks user if they want to enter another N and K. If not it multiplies the last number by the second to last number then decrements N by 2. 
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter N value: ");
		N = scan.nextInt();
		items = (int) N;
	
		System.out.print("Please enter K value: ");
		K = scan.nextInt();
		subsets = (int) K;
		
		start = System.nanoTime();

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
				BinomialRecursive();
			} //close if
			
			else {
				System.out.print("\n<END RUN>");
			} //close else
			
		} //close if
		
		else {
			
			diff = N - K;
			top = N * (N - 1);
			N -= 2;
		
			CalculateTop();
			
		} //close else
		
	} //close binomial recursive
	
	public static void CalculateTop() { //Calculates top value of binomial coefficient (dividend) then calls CalculateBottom
		
		if(N == diff) {
		
			btm = K * (K - 1);
			K -= 2;
			CalculateBottom();
			
		} //close if	
		
		else {
			
			top *= N;
			N --;
			
			CalculateTop();
			
		} //close else
		
	} //close CalculateTop
	
	public static void CalculateBottom() { //Calculates  bottom of binomial coefficient (divisor), divides top by bottom, prints answer, calculates time taken, then asks user if they want to enter another N and K
		
		if(K <= 1) {
			
			ans = top / btm;
			
			end = System.nanoTime();
			time = (end - start)/1000000000;
			
			if(time < 1)
				time = 1;
			
			System.out.println("There are " + ans + " ways to choose " + subsets + " subsets from " + items + " items.");
			
			//toFile.println();
			
			Scanner answer = new Scanner(System.in);
			System.out.print("\nWould you like to enter another N and K? (Y/N): ");
			String input = answer.nextLine();
			
			if(input.contentEquals("Y")) {
				
				BinomialRecursive();
				
			} //close if
			
			else {
				
				System.out.print("\n<END RUN>");
				
			} //close else
			
		} //close if
		
		else {
			
			btm *= K;
			K --;
			CalculateBottom();
			
		} //close else
		
	} //close CalculateBottom

} //close BCRecursive
