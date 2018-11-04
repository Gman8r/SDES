
public class TestClass {

	public static void main(String[] args)
	{   
		byte[] cipher = {-115, -17, -47, -113, -43, -47, 15, 84, -43, -113, -17, 84, -43, 79, 58, 15, 64, -113, -43, 65, -47, 127, 
				84, 64, -43, -61, 79, -43, 93, -61, -14, 15, -43, -113, 84, -47, 127, -43, 127, 84, 127, 10, 84, 15, 64, 43};
		byte [] plain;

		byte [] plainToCipher;

		 boolean[] key = {false,true,true,true,true,true,true,true,false,true};

		SDES sdes = new SDES();
		sdes.getKey10(key);

		System.out.println("Cipher");
		sdes.show (cipher);

		plain = sdes.decrypt(cipher);
		System.out.println("\n" + "Cipher to Plain");
		sdes.show(plain);

		plainToCipher = sdes.encrypt(plain);
		System.out.println("\n" + "Plain to Cipher");
		sdes.show (plainToCipher);

	}


}
