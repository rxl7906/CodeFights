import java.util.ArrayList;

class Stock{
	int futureReturn;
	int expectedRisk;
	public Stock(int futureReturn, int expectedRisk){
		this.futureReturn=futureReturn;
		this.expectedRisk=expectedRisk;
	}
}
public class TwoSigma {
	static int optimalStockBasket(int[][] stocks, int riskBudget) {
		int n = stocks.length;
		ArrayList<ArrayList<Integer>> combs = new ArrayList<ArrayList<Integer>>();
		for(int k = 1; k <= n; k++){
			// produce k pairs
			// n! / k! (n-k)!
			int comb = factorial(n) / (factorial(k)*factorial(n-k));
			System.out.println("k: " + k + " |combinations: " + comb);
			System.out.println("-----");
			for(int i = 0; i < comb; i++){ // goes up to how many combinations exist at given k
				// produce all combinations at this given k
				for(int j = 0; j < n; j++){
					for(int l = 0; l < n; l++){
						if(stocks[j] == stocks[l]){
							continue;
						} else {
							// take stocks[j] and stocks[l] add 
						}
					}
				}
			}
		}
		return 0;
	}
	// recursion
	/*static int factorial(int n){
		if(n == 0){
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}*/
	// iteration
	/*static int factorial(int n){
		int res = 1, num = n;
		while(num > 0){
			res *= num;
			num -= 1;
		}
		return res;
	}*/

	// factorial without multiplication sign
	static int factorial(int n){
		if(n <= 1) return 1;
		int result = n, ops = n - 2, count = n - 1;
		while(ops > 0){
			// val = value at this loop
			// times = how many times you add the val
			int val = result, times = count, sum = 0;
			while(times > 0){
				sum += val;
				times--;
			}
			result = sum;
			ops--;
			count--;
		}
		return result;
	}
	
	public static void main(String args[]){
		int[][] stocks = new int[][]{{-1,2},{10,15},{11,13},{9,10}};
		int riskBudget = 30;
		//System.out.println(factorial(0)); // 1
		//System.out.println(factorial(1)); // 1
		//System.out.println(factorial(2)); // 2
		//System.out.println(factorial(3)); // 6
		//System.out.println(factorial(4)); // 24
		//System.out.println(factorial(5)); // 120
		//System.out.println(factorial(6)); // 720
		optimalStockBasket(stocks, riskBudget);
	}
}
