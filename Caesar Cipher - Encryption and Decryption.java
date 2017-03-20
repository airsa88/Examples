//Java code -Encryption and Decryption for Caesar cipher.
package network2;
import java.util.Scanner;
public class Caesar_q1 {
        
	public static int k;
	static int p = 0;
	static int i;
	static int j;
	static String m = "";
	static String m2 = "";
	static String string = ("abcdefghijklmnopqrstuvwxyz").toUpperCase();
	public static void main(String[] args) {
		try {
		int user_input = 0;
		System.out.println("Please select the value for Caesar cipher technique 1.Encryption 2.Decryption");
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
	
	// Decryption
		private static void decryption() {
			@SuppressWarnings("resource")
			Scanner input2 = new Scanner(System.in);
			System.out.println("Enter the key value(k): ");
			k = input2.nextInt();
			System.out.println("Enter the Cipher text: ");
			//String string1 = "hello";
			String c_text = input2.next().toUpperCase();
			if(c_text != null && !c_text.isEmpty()) {
	        for (j=0;j<  c_text.length(); j++) {
	        for (i = 0 ; i<string.length() ; i++) {
	        if (string.charAt(i) ==  c_text.charAt(j)) {
	        //System.out.println(i);
	        p = i-k;
	        //System.out.print(string.charAt(p));
	        m2 = m2 + string.charAt(p);
	        }
	        }
	        }
	        System.out.println("--------------------------");
	        System.out.println("Plain Text: " +m2);
	        //input2.close();
		}
			else {
				System.out.println("Please enter the input Cipher text");
			}
	}
		
		//Encryption
		private static void encryption() {
			@SuppressWarnings("resource")
			Scanner input2 = new Scanner(System.in);
			System.out.println("Enter the key value(k): ");
			k = input2.nextInt();
			System.out.println("Enter the Plain text: ");
			//String string1 = "hello";
			String p_text = input2.next().toUpperCase();
			if(p_text != null && !p_text.isEmpty()) {
	        for (j=0;j<  p_text.length(); j++) {
	        for (i = 0 ; i<string.length() ; i++) {
	        if (string.charAt(i) ==  p_text.charAt(j)) {
	        //System.out.println(i);
	        p = i+k;
	        //System.out.print(string.charAt(p));
	        m = m + string.charAt(p);
	        }
	        }
	        }
	        System.out.println("--------------------------");
	        System.out.println("Cipher Text: " +m);
			}
			else {
				System.out.println("Please enter the input plain text");
			}
		}
}
	