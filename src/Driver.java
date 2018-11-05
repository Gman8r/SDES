import java.util.*;
/**
 * Test the implementation of SDES
 * 
 * @author (sdb) 
 * @version (Oct 2018)
 */
public class Driver
{
	public static void main(String[] args)
	{
		SDES sdes = new SDES();

		Scanner scanner = new Scanner (System.in);

		System.out.println ("Enter your 10-bit key");
		sdes.getKey10(scanner);

		String plain = "x";
		System.out.println ("Enter plain text, or hit 'Enter' to terminate");
		plain = scanner.nextLine();
		byte [] cipher;
		while (plain.length() > 0)
		{   
			cipher = sdes.encrypt  (plain);
			System.out.print ("Cipher is ");
			sdes.show (cipher);
			System.out.println ("Decryption of cipher:\n" + sdes.byteArrayToString (sdes.decrypt (cipher)));
			System.out.println ("Enter plain text, or hit 'Enter' to terminate");
			plain = scanner.nextLine();
		}
	}
}
