/* 
 * Solution to Project Euler problem 10
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */


public final class p010 implements EulerSolution {
	
	public static void main(String[] args) {
		System.out.println(new p010().run());
	}
	
	
	private static final int LIMIT = 2000000;
	
	
	public String run() {
		boolean[] isPrime = Library.listPrimality(LIMIT - 1);
		long sum = 0;
		for (int i = 0; i < isPrime.length; i++) {
			if (isPrime[i])
				sum += i;
		}
		return Long.toString(sum);
	}
	
}
