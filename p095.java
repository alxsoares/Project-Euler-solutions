/* 
 * Solution to Project Euler problem 95
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */

import java.util.HashSet;
import java.util.Set;


public final class p095 implements EulerSolution {
	
	public static void main(String[] args) {
		System.out.println(new p095().run());
	}
	
	
	private static final int LIMIT = 1000000;
	
	
	public String run() {
		int[] divisorSum = new int[LIMIT + 1];
		for (int i = 1; i <= LIMIT; i++) {
			for (int j = i * 2; j <= LIMIT; j += i)
				divisorSum[j] += i;
		}
		
		int[] amicableChainLen = new int[LIMIT + 1];
		for (int i = 0; i <= LIMIT; i++) {
			int count = 1;
			Set<Integer> visited = new HashSet<Integer>();
			visited.add(i);
			int temp = i;
			while (true) {
				int next = divisorSum[temp];
				if (next == i) {
					amicableChainLen[i] = count;
					break;
				} else if (next > LIMIT || visited.contains(next)) {
					amicableChainLen[i] = 0;  // Illegal
					break;
				} else {
					visited.add(next);
					temp = next;
				}
				count++;
			}
		}
		
		int maxChainLen = 0;
		for (int x : amicableChainLen)
			maxChainLen = Math.max(x, maxChainLen);
		
		for (int i = 0; i <= LIMIT; i++) {
			if (amicableChainLen[i] == maxChainLen)
				return Integer.toString(i);
		}
		throw new AssertionError();
	}
	
}
