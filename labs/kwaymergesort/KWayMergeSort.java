package kwaymergesort;

import java.util.ArrayList;

import timing.Ticker;

public class KWayMergeSort {
	
	/**
	 * 
	 * @param K some positive power of 2.
	 * @param input an array of unsorted integers.  Its size is either 1, or some other power of 2 that is at least K
	 * @param ticker call .tick() on this to account for the work you do
	 * @return
	 */
	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		int n = input.length;
		
		//
		// FIXME
		// Following just copies the input as the answer
		//
		// You must replace the loop below with code that performs
		// a K-way merge sort, placing the result in ans
		//
		// The web page for this assignment provides more detail.
		//
		// Use the ticker as you normally would, to account for
		// the operations taken to perform the K-way merge sort.
		//
		Integer[] ans = new Integer[n];
		if (n <= 1) {
			ticker.tick();
			return input;
		} else {
			Integer[][] mk = new Integer[K][n/K];
			ticker.tick();
			for(int i = 0; i < n; ++i){
				mk[i/(n/K)][i%(n/K)] = input[i];
				ticker.tick();			
			}
			for(int i = 0; i < K; ++i) {
				mk[i] = kwaymergesort(K, mk[i], ticker);
				ticker.tick();
			}
			ans = merge(mk, ticker);
			ticker.tick();
		}
		return ans;
	}

	public static Integer[] merge(Integer[][] ps, Ticker ticker){
        int K = ps.length;
        int N = ps[0].length;
        int[] arr = new int[K];
        Integer[] merged = new Integer[K * N];
        int i = 0;
        ticker.tick();
        while (i < K * N){
            int minP = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < K; ++j){
            	ticker.tick();
                if (arr[j] < N){
                    if (ps[j][arr[j]] < min){
                        minP = j;
                        min = ps[j][arr[j]];
                        ticker.tick();
                    }
                }                
            }
            merged[i] = min;
            
            ++arr[minP];           
      
            ++i;
            ticker.tick();
        }
        return merged;
    }
}