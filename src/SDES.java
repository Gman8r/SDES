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
	 * Encrypt the given string used SDES each character produces a byte of cipher.
	 * @return An array of bytes representing the cypher text.
	 */
	public byte[] encrypt(String msg)
	{
		return encrypt(stringToByteArray(msg));	//Overload for encrypt(byte[])
	}
	
	
	/**
	 * @author Mantas Pileckis
	 * Encrypt the given byte array.
	 * @param plainText An array of bytes representing the plain text.
	 * @return An array of bytes representing the cipher text.
	 */
	byte[] encrypt(byte[] plainText)
	{
		return null;
	}
	
	
	/**
	 * @author Mantas Pileckis
	 * Encrypt a single byte using SDES.
	 * @param b Byte Single byte representing plain text byte.
	 * @return The encrypted single byte.
	 */
	public byte encryptByte(byte b)
	{
		return 0;
	}
	
	
	/**
	 * @author Mantas Pileckis
	 * Decrypt the given byte array.
	 * @param cipher AN array of byutes representing the cipher text.
	 * @return An array of bytes representing the original plain text.
	 */
	public byte[] decrypt(byte[] cipher)
	{
		return null;
	}
	
	
	/**
	 * @author Mantas Pileckis
	 * Decrypt a single byte using SDES.
	 * @param b Byte that we are decrypting.
	 * @return Single decrypted byte.
	 */
	public byte decryptByte(byte b)
	{
		return 0;
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
		
	}
	/**
	 * @author Mantas Pileckis
	 */
	public void show(byte[] byteArray)
	{
		
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