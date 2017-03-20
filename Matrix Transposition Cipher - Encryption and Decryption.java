// Java code for Matrix transposition cipher - Encryption and Decryption 
package network2;
import java.util.Scanner;

public class Matrix {

	static int k1,key,k2 = 0;
	static int k3,k4;
	public static void main(String[] args) {
		try {
			  int user_input = 0;
				System.out.println("Please select the value for Matrix cipher technique 1.Encryption 2.Decryption");
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				user_input = input.nextInt();
				if(user_input == 1){
					encryption();
				}
				else if (user_input == 2) {
					decryption();
				}
				else {
					System.out.println("Please enter the correct value ( 1 or 2) : 1(Encryption)  2(Decryption)");
					user_input = input.nextInt();
					if(user_input == 1){
						encryption();
					}
					else if (user_input == 2) {
						decryption();
					}
				}
			  }
			  catch(Exception e) {
				  System.out.println("Invalid Input - it must be an integer; Run Again");
			  }
		
}
	// Encryption - Using Plain Text and Key
	private static void encryption() {
		@SuppressWarnings("resource")
		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter the key value(k): ");
		k1 = input1.nextInt();
		int m = Integer.valueOf(k1).toString().length();
		System.out.println("Enter the Plain text: ");
		String s1 = input1.next().toUpperCase();
		while (s1.length() < m*m) {
			s1 = s1 + '%';
		}
	    //System.out.println("Updated Plain text for Matrix : " +s1);  
		String[][] s2 = new String[m][m];
	    for (int row = 0; row < m; row++) {
	        for (int column = 0; column < m; column++) {
	            s2[row][column] = String.valueOf(s1.charAt(m * row + column));
	        }
	    }
	    System.out.println("Matrix format:");
	    for (int row = 0; row < m; row++) {
	        for (int column = 0; column < m; column++) {
	            System.out.print(s2[row][column] + " ");
	        }
	        System.out.println();
	    }
	    String number = String.valueOf(k1);
	    System.out.println("-------------------------------------------");
	    System.out.print("Cipher Text: ");
	    for (int q=0;q < number.length(); q++) {
	    	k4 = Character.getNumericValue(number.charAt(q));
			  for (int row = 0; row <= m-1; row++) {
		            System.out.print(s2[row][k4-1]);
		        }
	    }
		
	}
	// Decryption - Using Cipher Text and Key
	private static void decryption() {
		int k4=0;
		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter the key value(k): ");
		key = input1.nextInt();
		System.out.println("Enter the Cipher text: ");
		String s2 = input1.next().toUpperCase();
		int f = s2.length();
		int m = Integer.valueOf(key).toString().length();
		int n = s2.length() / m;
        String[][] s3 = new String[n][n];
	    String key_string = String.valueOf(key);
	    int b=0;
	    input1.close();
	    for (int q=0;q < key_string.length(); q++) {
	    	k4 = Character.getNumericValue(key_string.charAt(q));
		    for (int row = 0; row < n; row++) {
		    	 if(b<f) {
		            s3[row][k4-1] = String.valueOf(s2.charAt(b));
		            b = b+1;
		         }
		    }

	    }
	     System.out.println("Matrix format: ");
	        for (int row = 0; row < n; row++) {
	        	for (int column = 0; column < n; column++) {
	            System.out.print(s3[row][column] + " ");
	        }
	        System.out.println();
	    }
	        System.out.println("---------------------------------------");
           System.out.print("Plain Text: ");
			  for (int row = 0; row <= n-1; row++) {
				  for (int column = 0; column <=n-1; column++) {
					 if(s3[row][column].contains("%")){
						 s3[row][column] = "";
						 System.out.print(s3[row][column]);
						 //System.out.print("\t");
					 }
					 //System.out.print('\t');
		            System.out.print(s3[row][column]);
			  }
			  }
		
	}
}
