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

	/**
	 * Read 10 digit key value from scanner
	 * @param scanner input scanner
	 * @author Brian Intile
	 */
	public void getKey10(java.util.Scanner scanner)
	{
		key10 = new boolean[10];
		String keyStr = scanner.nextLine();
		for(int i = 0; i < 10; i++)
		{
			//Just check each digit to see if it's a "1"
			if (keyStr.charAt(i) == '1')
				key10[i] = true;
			else
				key10[i] = false;
		}
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

	/**
	 * Concatenate two bit arrays together into one array
	 * @param x left array
	 * @param y right array
	 * @return combined array
	 * @author Brian Intile
	 */
	public boolean[] concat (boolean[] x, boolean[] y)
	{
		//Our return list length will be the sum of the inputs' lengths  
		boolean[] result = new boolean[x.length + y.length];
		
		//Iterate through first list for first part
		for(int i = 0; i < x.length; i++)
		{
			result[i] = x[i];
		}
		
		//iterate through second list for second part, adding x.length as an index offset
		for(int i = 0; i < x.length; i++)
		{
			result[x.length + i] = y[i];
		}
		return result;
	}

	public boolean[] feistel(boolean[] k, boolean[] x)
	{
		return expPerm(concat(sBox(lh(xor(k,expPerm(x,EXPANSION_PERM))),0),sBox(rh(xor(k,expPerm(x,EXPANSION_PERM))),0)),PERM_4);
	}

	public boolean[] f(boolean[] x, boolean[] k)
	{
		return concat(xor(lh(x),feistel(k,rh(x))),rh(x));
	}
	public boolean[] sBox(boolean[] x,int boxNum) 
	{
		if(boxNum == 0)
		{
			return s0.get(((Byte)bitArrayToByte(x)).toString());
		}
		else
		{
			return s1.get(((Byte)bitArrayToByte(x)).toString());
		}
	}
	

	/**
	 * Performs a permutation on a bit array
	 * @param input array to permute
	 * @param epv permutation to execute
	 * @return permuted array
	 * @author Brian Intile
	 */
	public boolean[] expPerm(boolean[] input, int[] epv)
	{
		boolean[] returnArray = new boolean[epv.length];
		
		//For each value in epv, add the bit from the input array with that index to our return array  
		for(int i = 0; i < returnArray.length; i++)
		{
			returnArray[i] = input[epv[i]];
		}
		return returnArray;
	}
	
	/**
	 * Get the left half of a bit array
	 * @param inp input array
	 * @return left half
	 * @author Brian Intile
	 */
	public boolean[] lh(boolean[] inp)
	{
		int outputLength = inp.length / 2;
		boolean[] output = new boolean[outputLength];
		
		//iterate up to half the length and copy the values into a new half-sized array
		for(int i = 0; i < outputLength; i++)
		{
			output[i] = inp[i];
		}
		return output;
	}

	/**
	 * Get the right half of a bit array
	 * @param inp input array
	 * @return righ half
	 * @author Brian Intile
	 */
	public boolean[] rh(boolean[] inp)
	{
		int outputLength = inp.length / 2;
		boolean[] output = new boolean[outputLength];
		
		//iterate up to half the length and copy the values (with an offset of half the input size) into a new half-sized array
		for(int i = 0; i < outputLength; i++)
		{
			output[i] = inp[i + outputLength];
		}
		return output;
	}
	
	/**
	 * Applies xor to every bit in an array of bits
	 * @param x first array
	 * @param y second array
	 * @return the resulting bit array
	 * @author Brian Intile
	 */
	public boolean[] xor(boolean[] x, boolean[] y)
	{
		boolean[] result = new boolean[x.length];

		//xor is simply !=, so apply that to all the bits
		for(int i = 0; i < result.length; i++)
		{
			result[i] = x[i] != y[i];
		}
		return result;
	}
	
	public void show(boolean[] inp)
	{
		
	}
	
	public void show(byte[] byteArray)
	{
		
	}

	/**
	 * Creates a byte from an array of bits
	 * @param inp bit array to convert
	 * @return converted byte
	 * @author Brian Intile
	 */
	public byte bitArrayToByte(boolean[] inp)
	{
		byte result = 0;
		
		//As we iterate bytes and find 1's, add the correct power of 2 to our result
		//This also automatically deals with two's complement, as 2^7 will overflow to -128
		for(int i = 0; i < inp.length; i++)
		{
			if (inp[i])
				result += (byte)Math.pow(2, (inp.length - 1) - i);
		}
		return result;
	}

	/**
	 * Creates an array of bits from a byte
	 * @param inp byte to convert
	 * @return converted bit array
	 * @author Brian Intile
	 */
	public boolean[] byteToBitArray(byte inp)
	{
		boolean[] result = new boolean[8];
		
		//If our number is negative, we have to apply two's complement by making the first bit 1, and then add 128
		if (inp < 0)
		{
			inp += 128;
			result[0] = true;	
		}
		
		//For the remaining 7 bits, determine if the input is greater than or equal to the current power of 2
		//(starting at most significant digit)
		//If it is, fill in the bit with 1 and subtract that power of 2 from the input
		for(int i = 6; i >= 0; i--)
		{
			byte power = (byte)Math.pow(2, i);
			if (inp >= power)
			{
				inp -= power;
				result[7 - i] = true;
			}
		}
		return result;
	}

	/**
	 * Creates a string representation of a byte array
	 * @param inp byte array
	 * @return string representation
	 * @author Brian Intile
	 */
	public String byteArrayToString(byte[] inp)
	{
		String str = "";
		
		//Append the toString function for each byte, followed by a space, and trim the final result
		for(int i = 0; i < inp.length; i++)
		{
			str += Byte.toString(inp[i]) + " ";
		}
		return str.trim();
	}

	/**
	 * Creates a string representation of a bit array
	 * @param inp bit array
	 * @return string representation
	 * @author Brian Intile
	 */
	public String bitArrayToString(boolean[] inp)
	{
		String str = "";

		//Append a "1" or "0" to our return string for each boolean in the input
		for(int i = 0; i < inp.length; i++)
		{
			str += inp[i] ? "1" : "0";
		}
		return str;
	}

	/**
	 * Parses a string into an array of bytes
	 * @param inp string to parse
	 * @return resulting byte array
	 * @author Brian Intile
	 */
	public byte[] stringToByteArray(String inp)
	{
		//Start by splitting our input by spaces
		String[] inputs = inp.split(" ");
		byte[] result = new byte[inputs.length];
		
		//Parse each element from the split input into a byte and add it to our result
		for(int i = 0; i < inputs.length; i++)
		{
			result[i] = Byte.parseByte(inputs[i]);
		}
		return result;
	}
	

}