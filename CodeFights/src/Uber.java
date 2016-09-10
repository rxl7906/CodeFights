
public class Uber {
	double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {
	    double[] fares = new double[cost_per_minute.length];
	    for(int i = 0; i < cost_per_minute.length; i++){
	        // (cost per minute) * (ride time)
	        double rideCost = ride_time * cost_per_minute[i];
	        // (cost per mile) * (ride distance)
	        double distanceCost = cost_per_mile[i] * ride_distance;
	        double fareCost = rideCost+distanceCost;
	        fares[i] = fareCost;
	    }
	    return fares;
	}
	public static void main(String args[]){
		double a = 0.4;
		float c = (float) 1.232;
		int b = 4;
		System.out.println((int)Math.ceil(a));
	}
}
