package project1;

import java.util.Map;


//Framework based on http://cs.rowan.edu/~bergmann/crypto/projects/project2/doc/

public class SDES
{
	final int[] INITIAL_PERM = {1, 5, 2, 0, 3, 7, 4, 6};
	final int[] INITIAL_PERM_INV = {3, 0, 2, 4, 6, 1, 7, 5};	//Double check this one
	final int[] K1_PERM = {0, 6, 8, 3, 7, 2, 9, 5};
	final int[] K2_PERM = {7, 2, 5, 4, 9, 1, 8, 0};
	final int[] PERM_4 = {1, 3, 2, 0};
	final int[] EXPANSION_PERM = {3, 0, 1, 2, 1, 2, 3, 0};

	final boolean[] s00 = {false,false};
	final boolean[] s01 = {false,true};
	final boolean[] s10 = {true,false};
	final boolean[] s11 = {true,true};

	final Map<String, boolean[]> s0 = Map.ofEntries(
			Map.entry("0000",s01),Map.entry("0001",s11),Map.entry("0010",s00),Map.entry("0011",s10),
			Map.entry("0100",s11),Map.entry("0101",s01),Map.entry("0110",s10),Map.entry("0111",s00),
			Map.entry("1000",s00),Map.entry("1001",s11),Map.entry("1010",s10),Map.entry("1011",s01),
			Map.entry("1100",s01),Map.entry("1101",s11),Map.entry("1110",s11),Map.entry("1111",s10));

	final Map<String,boolean[]> s1 = Map.ofEntries(
			Map.entry("0000",s00),Map.entry("0001",s10),Map.entry("0010",s01),Map.entry("0011",s00),
			Map.entry("0100",s10),Map.entry("0101",s01),Map.entry("0110",s11),Map.entry("0111",s11),
			Map.entry("1000",s11),Map.entry("1001",s10),Map.entry("1010",s00),Map.entry("1011",s01),
			Map.entry("1100",s01),Map.entry("1101",s00),Map.entry("1110",s00),Map.entry("1111",s11));


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

	/**
		 * Read in an 8 digit key and 4 digit 'x', then apply the feistel function
		 *
		 * @param k			8 digit key to be used in conjuction with the xor function
		 * @param x			4 digit boolean array input
		 * @return			4 digit result of the feistel function
		 */
	public boolean[] feistel(boolean[] k, boolean[] x)
	{
		boolean[] xorSave = xor(k,expPerm(x,EXPANSION_PERM));

		return expPerm(
				concat(sBox(lh(xorSave),0),
					   sBox(rh(xorSave),1)),
				PERM_4);
	}

	/**
		 *
		 * Read in a 8 digit boolean array and key, then apply the 'round' function
		 *
		 * @param x			boolean array to which the function f will be applied
		 * @param k			boolean array holding the key to be used in the feistel function
		 * @return			returns boolean array after the 'round' function has been applied
		 * @author 			Matthew DeGenaro
		 */
	public boolean[] f(boolean[] x, boolean[] k)
	{
		return concat(xor(lh(x),feistel(k,rh(x))),rh(x));
	}

	/**
		 * Read in a 4 digit boolean array and return the corresponding sBox 2 digit code
		 *
		 * @param x     	boolean array to be passed to sBox
		 * @param boxNum	determines which sBox to use, 0 or 1
		 * @return			returns a boolean array  with the resulting 2 digit code
		 * @author			Matthew DeGenaro
		 */
	public boolean[] sBox(boolean[] x,int boxNum)
	{
		if(boxNum == 0)
		{
			return s0.get((bitArrayToString(x)));
		}
		else
		{
			return s1.get((bitArrayToString(x)));
		}
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

	public String bitArrayToString(boolean[] inp)
	{
		return null;
	}

}
