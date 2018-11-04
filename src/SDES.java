//Framework based on http://cs.rowan.edu/~bergmann/crypto/projects/project2/doc/

public class SDES
{
	final int[] INITIAL_PERM = {1, 5, 2, 0, 3, 7, 4, 6};
	final int[] INITIAL_PERM_INV = {3, 0, 2, 4, 6, 1, 7, 5};	//Double check this one
	final int[] K1_PERM = {0, 6, 8, 3, 7, 2, 9, 5};
	final int[] K2_PERM = {7, 2, 5, 4, 9, 1, 8, 0};
	final int[] PERM_4 = {1, 3, 2, 0};
	final int[] EXPANSION_PERM = {3, 0, 1, 2, 1, 2, 3, 0};

	//TODO S-box data here?

	private boolean[] key10;

	public SDES()
	{

	}

	public void getKey10(java.util.Scanner scanner)
	{

	}
	
	/**
	 * Overloaded getKey method, for testclass
	 * @author Mantas Pileckis
	 * @param 10-bit key
	 */
	public void getKey10(boolean[] key) {
		this.key10 = key;
	}
	
	/**
	 * Encrypt the given string used SDES each character produces a byte of cipher.
	 * @return An array of bytes representing the cypher text.
	 */
	public byte[] encrypt(String msg)
	{
		return encrypt(stringToByteArray(msg));	//Overload for encrypt(byte[])
	}

	/**
	 * Encrypt the given byte array.
	 * @author Mantas Pileckis
	 * @param plainText An array of bytes representing the plain text.
	 * @return An array of bytes representing the cipher text.
	 */
	byte[] encrypt(byte[] plainText)
	{
		byte[] result = new byte[plainText.length];
		//Loop and encrypt each byte 1 by 1
		for(int i = 0; i < plainText.length; i++)
		{
			result[i] = encryptByte(plainText[i]);
		}
		return result;
	}


	/**
	 * Encrypt a single byte using SDES.
	 * @author Mantas Pileckis
	 * @param b Byte Single byte representing plain text byte.
	 * @return The encrypted single byte.
	 */
	public byte encryptByte(byte b)
	{
		//Transform byte b into an array of booleans
		boolean[] bitArray = byteToBitArray(b);
		//Generate subkey k1
		boolean[] k1 = expPerm(key10, K1_PERM);
		//Generate subkey k2
		boolean[] k2 = expPerm(key10, K2_PERM);

		// Initial permutation on the array of bytes
		boolean[] IP = expPerm(bitArray, INITIAL_PERM);
		// Round function of the SDES --> fk(x) = (L(x) xor F(K,R(x))) || R(x)
		boolean[] fk1 = concat(xor(lh(IP), feistel(k1,rh(IP))),rh(IP));
		// Perform swap R(x) || L(x)
		boolean[] swapFk1 = concat(rh(fk1), lh(fk1));
		// Round 2 of the Round function
		boolean[] fk2 = concat(xor(lh(swapFk1), feistel(k2,rh(swapFk1))),rh(swapFk1));
		// Inverse Permutation to get the cipher text
		boolean[] cipher = expPerm(fk2, INITIAL_PERM_INV);

		return bitArrayToByte(cipher);
	}


	/**
	 * Decrypt the given byte array.
	 * @author Mantas Pileckis
	 * @param cipher AN array of byutes representing the cipher text.
	 * @return An array of bytes representing the original plain text.
	 */
	public byte[] decrypt(byte[] cipher)
	{
		byte[] result = new byte[cipher.length];
		//Loop and decrypt each byte 1 by 1

		for(int i = 0; i < cipher.length; i++)
		{
			result[i] = decryptByte(cipher[i]);
		}
		return result;
	}


	/**
	 * Decrypt a single byte using SDES.
	 * @author Mantas Pileckis
	 * @param b Byte that we are decrypting.
	 * @return Single decrypted byte.
	 */
	public byte decryptByte(byte b)
	{
		//Transform byte b into an array of booleans
		boolean[] arrayByte = byteToBitArray(b);
		//Generate subkey k1
		boolean[] k1 = expPerm(key10, K1_PERM);
		//Generate subkey k2
		boolean[] k2 = expPerm(key10, K2_PERM);

		// Initial permutation on the array of bytes
		boolean[] IP = expPerm(arrayByte, INITIAL_PERM);
		// Round function of the SDES --> fk(x) = (L(x) xor F(K,R(x))) || R(x)
		boolean[] inverseFk2 = concat(xor(lh(IP), feistel(k2,rh(IP))),rh(IP));
		// Perform swap R(x) || L(x)
		boolean[] swapFk2 = concat(rh(inverseFk2), lh(inverseFk2));
		// Round 2 of the Round function
		boolean[] fk1 = concat(xor(lh(swapFk2), feistel(k1,rh(swapFk2))),rh(swapFk2));
		// Inverse Permutation to get the cipher text
		boolean[] plain = expPerm(fk1, INITIAL_PERM_INV);
		//System.out.println(bitArrayToString(plain));
		return bitArrayToByte(plain);

	}

	public boolean[] concat (boolean[] x, boolean[] y)
	{
		return null;
	}

	public boolean[] feistel(boolean[] k, boolean[] x)
	{
		return null;
	}

	public boolean[] f(boolean[] x, boolean[] k)
	{
		return null;
	}

	public boolean[] expPerm(boolean[] input, int[] epv)
	{
		return null;
	}

	public boolean[] lh(boolean[] inp)
	{
		return null;
	}

	public boolean[] rh(boolean[] inp)
	{
		return null;
	}

	public boolean[] xor(boolean[] x, boolean[] y)
	{
		return null;
	}
	/**
	 * @author Mantas Pileckis
	 */
	public void show(boolean[] inp)
	{
		System.out.println(bitArrayToByte(inp));

	}
	/**
	 * @author Mantas Pileckis
	 */
	public void show(byte[] byteArray)
	{
		System.out.println(byteArrayToString(byteArray));

	}


	public byte bitArrayToByte(boolean[] inp)
	{
		return 0;
	}

	public boolean[] byteToBitArray(byte inp)
	{
		return null;
	}

	public String byteArrayToString(byte[] inp)
	{
		return null;
	}

	public byte[] stringToByteArray(String inp)
	{
		return null;
	}


}