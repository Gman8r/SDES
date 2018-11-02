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
	
	public byte[] encrypt(String msg)
	{
		return encrypt(stringToByteArray(msg));	//Overload for encrypt(byte[])
	}
	
	byte[] encrypt(byte[] msg)
	{
		return null;
	}

	public byte encryptByte(byte b)
	{
		return 0;
	}

	public byte[] decrypt(byte[] cipher)
	{
		return null;
	}

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
	
	public void show(boolean[] inp)
	{
		
	}
	
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