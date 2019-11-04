import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CatalanRecursive {

	public static long N; //Holds N value entered by user
	private static long end; //Gets end time after calculations are done
	private static long start; //Gets start time before calculations are done
	private static long time; //Time it took for calculations to be done (end minus start)
	private static long top; //Holds result from calculating the top number
	private static long btm; //Holds result from calculating bottom number
	private static long ans; //Holds answer (top divided by btm)
	private static long NTop; //Holds N value used during CalculateTop (value will change)
	private static long NBtm; //Holds N value used during CalculateBottom (value will change)
	
	public static void main(String[] args) { //Sets up file and calls CatRecursive
		
		String fileName = "CatalanRecursive.txt"; 
		PrintWriter toFile = null; 
		
		try{
			
			toFile = new PrintWriter(fileName); 
			
		}//Close try
		
		catch (FileNotFoundException e) {
			
		        System.out.println("PrintWriter error opening the file " + fileName);
		        System.out.println(e.getMessage());
		        
		}//Close catch
		
		CatRecursive();
		
	}//close main method
	
	public static void CatRecursive() { //Gets N value from user, gets start time, if N is 1 or 2 it prints out answer, gets end time, calculates time then asks if user wants to input another N value. Else it multiplies NTop by Ntop - 1, derements Ntop by 2, then calls CalculateTop
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter N value: ");
		N = scan.nextInt();
		NBtm = N;
		NTop = 2 * N;
		
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
				
				CatRecursive();
				
			} //close if
			
			else {
				
				System.out.print("\n<END RUN>");
				System.exit(0);
				
			}//close else
			
		} //close if
		
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
				CatRecursive();
			}//close if
			
			else {
				
				System.out.print("\n<END RUN>");
				System.exit(0);
				
			}//close else
			
		}//close else if
		
		else {
			
			top = (NTop) * (NTop - 1);
			NTop -= 2;
			
			CalculateTop();
			
		}//close else
		
	} //close CatRecursive
	
	public static void CalculateTop() { //Calculates top value of Catalan Number (dividend) then calls CalculateBottom
		
		if(NTop == (N + 1)) {
			
			btm = NBtm * (NBtm - 1);
			NBtm -=2;
			
			CalculateBottom();
			
		} //close if
		
		else {
			
			top *= NTop;
			NTop --;
			
			CalculateTop();
			
		}//close else
		
	} //close CalculateTop
	
	public static void CalculateBottom() { //Calculates  bottom of Catalan Number (divisor), divides top by bottom, prints answer, calculates time taken, then asks user if they want to enter another N and K
		
		if(NBtm == 1) {
			
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
				CatRecursive();
			}//close if
			
			else {
				
				System.out.print("\n<END RUN>");
				System.exit(0);
				
			}//close else
			
		}//close if
		
		else {
			
			btm *= NBtm;
			NBtm --;
			
			CalculateBottom();
			
		}//close else
		
	} //close CalculateBottom

} //close CatalanRecursive
