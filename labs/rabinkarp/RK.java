package rabinkarp;

public class RK {
	
	//
	// Be sure to look at the write up for this assignment
	//  so that you get full credit by satisfying all
	//  of its requirements
	//
	
	private String chars;
	private int length;
	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * @param m size of the window
	 */
	public RK(int m) {
		chars = "";
		length = m;

	}
	

	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * @param d the next character in the target string
	 * @return
	 */
	
	private static int hash(char[] chars, int start, int m) {
		   int ans = 0;
		   int i=start;
		   while (i < start+m) {
		      int v = 0;
		      if (i < chars.length){ 
		         v = chars[i];       
		      }
		      ans = (((31 * ans % 511) + (v % 511)) % 511);
		   ++i;
		   }
		   return ans;
		}

	public int nextCh(char d) {
		chars += d;
		chars = chars.substring(Math.max(chars.length() - length, 0), chars.length());
		char[] charArray = chars.toCharArray();
		return hash(charArray, 0, charArray.length);	}
	
	

}
