import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CatalanDynamic {

	public static long N; //Holds N value entered by user
	private static long end; //Gets end time after calculations are done
	private static long start; //Gets start time before calculations are done
	private static long time; //Time it took for calculations to be done (end minus start)
	private static long top; //Holds result from calculating the top number
	private static long btm; //Holds result from calculating bottom number
	private static long ans; //Holds answer (top divided by btm)
	private static long NTop; //Holds N value used during CalculateTop (value will change)
	private static long topStart; // Value of N multiplied by 2, used to stop for loop after last value on top is multiplied
	private static long d; //Value of topStart plus 2, used for for loop in CalculateTop
	
	public static void main(String[] args) { //Sets up file and calls CalculateTop
		
		String fileName = "CatalanDynamic.txt"; 
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
	
	
	
	public static void CalculateTop() { //Gets N from user, topStart the first topStart + 1 then increments diff by 2. Then calculates top of catalan number then calls CalculateBottom
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter N value: ");
		N = scan.nextInt();
		//NBtm = N;
		NTop = 2 * N;
		topStart = N + 2;
		
		start = System.nanoTime();
		
		if(N == 1) {
			
			end = System.nanoTime();
			time = (end - start)/1000000000;
			
			if(time < 1)
				time = 1;
			
			System.out.println("C(1) = 1");
			
			Scanner answer = new Scanner(System.in);
			System.out.print("\nWould you like to enter another N? (Y/N): ");
			String input = answer.nextLine();
			
			if(input.contentEquals("Y")) {
				
				CalculateTop();
				
			}//close if
			
			else {
				
				System.out.print("\n<END RUN>");
				System.exit(0);
				
				} //close else
			
		}//close if
		
		else if(N == 2) {
			
			end = System.nanoTime();
			time = (end - start)/1000000000;
			
			if(time < 1)
				time = 1;
			
			System.out.println("C(2) = 2");
			
			Scanner answer = new Scanner(System.in);
			System.out.print("\nWould you like to enter another N? (Y/N): ");
			String input = answer.nextLine();
			
			if(input.contentEquals("Y")) {
				
				CalculateTop();
				
			}//close if
			
			else {
				
				System.out.print("\n<END RUN>");
				System.exit(0);
				
			}//close else
			
		} //close else if
		
		else {
			
			top = topStart * (topStart + 1);
			topStart += 2;
			d = topStart;
				
		}//close else
		
		for(int j = (int) d; j <= NTop; j++) {
			
			top *= topStart;
			topStart ++;
			
		}
		
		CalculateBottom();
		
	} //close CalculateTop
	
	public static void CalculateBottom() { //Calculates  bottom of catalan number (divisor), divides top by bottom, prints answer, calculates time taken, then asks user if they want to enter another N
		
		btm = 2;
		
		for(int j = 2; j < N; j++) {
		
			btm *= j + 1;
		
		}
	
		ans = top / btm;
		
		end = System.nanoTime();
		time = (end - start)/1000000000;
		
		if(time < 1)
			time = 1;
		
		System.out.println("C(" + N + ") = " + ans);
		
		Scanner answer = new Scanner(System.in);
		System.out.print("\nWould you like to enter another N? (Y/N): ");
		String input = answer.nextLine();
		
		if(input.contentEquals("Y")) {
			
			CalculateTop();
			
		}//close if
		
		else {
			
			System.out.print("\n<END RUN>");
			System.exit(0);
			
		}//close else
		
	} //close CalculateBottom

} //close CatalanDynamic
