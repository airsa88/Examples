//Java code for Vigenere cipher - Encryption and Decryption.
//Testing
package network2;
import java.util.Scanner;
import java.util.ArrayList;
public class Vigenere_Cipher {

	static String string = ("abcdefghijklmnopqrstuvwxyz").toUpperCase(); 
	  public static void main(String[] args) {
		  try {
		  int user_input = 0;
			System.out.println("Please select the value for Vigenere cipher technique 1.Encryption 2.Decryption");
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
		 //Encryption - Using Plain Text and Key Text
			private static void encryption() {
				//String s = "HELLOWORLD";
				//String key = "SECRETSECR";
				 char key1;
				 ArrayList<Integer> List = new ArrayList<Integer>();
				 ArrayList<Integer> List2 = new ArrayList<Integer>();
				 ArrayList<Integer> List3 = new ArrayList<Integer>();
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				System.out.println("Enter the Plain text: ");
		         String s = input.next().toUpperCase();
		 		 System.out.println("Enter the key(k): ");
		 		 String key = input.next().toUpperCase();
		 		 if(key.length() < s.length()) {
		 		int n = s.length() - key.length();
		 		for (int j = 0; j < n; j++){
						key1 = key.charAt(j);
						key = key + key1;
					}
		 		//System.out.println("Updated Key text for Encryption: " +key.toUpperCase());
		 		 }
		 		 
				 for (int i=0;i < s.length();i++) {
					for (int j=0; j < string.length(); j++){
					  if (s.charAt(i) == string.charAt(j)) {
						  List.add(j);
					  }
				}
				}
				//System.out.println(List);
				//System.out.println("--------------------");
					for(int k=0; k < key.length();k++) {
					for (int j=0; j < string.length(); j++){
					  if (key.charAt(k) == string.charAt(j)) {
						  //System.out.println(j);
						  List2.add(j);
					  }
			}
			}
					//System.out.println(List2);
					//System.out.println("--------------------");
					for (int i = 0; i < List.size(); i++) {
				        List3.add(List.get(i) + List2.get(i));
				}
				//System.out.println(List3);
				String string2 = ("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz").toUpperCase(); 
				System.out.println("--------------------------------");
				System.out.print("Cipher Text: ");
				for (int i = 0; i < List3.size(); i++) {
					System.out.print(string2.charAt(List3.get(i)));	
					}
				}
			
			//Decryption - Using Cipher Text and Key Text
			private static void decryption() {
				//String s = "HELLOWORLD";
				//String key = "SECRETSECR";
				char key1;
				 ArrayList<Integer> List = new ArrayList<Integer>();
				 ArrayList<Integer> List2 = new ArrayList<Integer>();
				 ArrayList<Integer> List3 = new ArrayList<Integer>();
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				//Enter the cipher text 
				System.out.println("Enter the Cipher text: ");
		         String s = input.next().toUpperCase();
		         //Getting key from the User
		 		 System.out.println("Enter the key(k): ");
		 		 String key = input.next().toUpperCase();
		 		 if(key.length() < s.length()) {
		 		int n = s.length() - key.length();
		 		for (int j = 0; j < n; j++){
						key1 = key.charAt(j);
						key = key + key1;
					}
		 		System.out.println("Updated Key text for Encryption: " +key.toUpperCase());
		 		 }
		    	 		 
				 for (int i=0;i < s.length();i++) {
					for (int j=0; j < string.length(); j++){
					  if (s.charAt(i) == string.charAt(j)) {
						  List.add(j);
					  }
				}
				}
				//System.out.println(List);
				//System.out.println("--------------------");
					for(int k=0; k < key.length();k++) {
					for (int j=0; j < string.length(); j++){
					  if (key.charAt(k) == string.charAt(j)) {
						  //System.out.println(j);
						  List2.add(j);
					  }
			}
			}
					//System.out.println(List2);
					//System.out.println("--------------------");
					for (int i = 0; i < List.size(); i++) {
						if(List.get(i) > List2.get(i)) {
							List3.add(List.get(i) - List2.get(i));
						}
						else {
							//List3.add(List2.get(i) - List.get(i));
			        		char alphabet1,alphabet2;
			        		String m1 = "",m2 = "";
			        		String m3 = "",m4 = "";
			        		for(alphabet1 = string.charAt(List2.get(i)); alphabet1 <= 'Z';alphabet1++) {
			        			m3 = Character.toString(alphabet1);
			        			//System.out.print(m1);
			        			m1 = m1 + m3;
			        		}
			        		//System.out.print(m1);
			        		for(alphabet2 = 'A'; alphabet2 <= string.charAt(List.get(i));alphabet2++) {
			        			//System.out.print(alphabet2);
			        			m4 = Character.toString(alphabet2);
			        			m2 = m2 + m4;
			        		}
			        		//System.out.print(m2);
			        		//System.out.println(m1.length());
			        		//System.out.println(m2.length());
			        		int n = m1.length() + m2.length();
			        		//System.out.println(string.charAt(n-1));
							List3.add(n-1);
						}
				}
				//System.out.println(List3);
				String string2 = ("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz").toUpperCase();
				System.out.println("--------------------------------");
				System.out.print("Plain Text: ");
				for (int i = 0; i < List3.size(); i++) {
					System.out.print(string2.charAt(List3.get(i)));	
					}
			}
	}
	
			
		
		
	        
		

