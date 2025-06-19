import java.util.Scanner;
public class Finance {
    public static double calculateFutureValue(double initialValue, double rate, int years) {
        if (years == 0) return initialValue;
        return calculateFutureValue(initialValue, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        Scanner o= new Scanner(System.in);
        System.out.println("Welcome to the Future Value Calculator!");
        System.out.print("Enter the initial investment amount:"); 
        double initial = o.nextDouble(); 
        System.out.print("Enter the growth/decrease rate:"); 
        double rate = o.nextDouble(); 
        System.out.print("Enter the time period in years:"); 
        int years = o.nextInt();

        double future = calculateFutureValue(initial, rate, years);
        System.out.printf("Future Value (Recursive): ₹%.2f\n", future);

        System.out.println("\nUsing Iteration:\n");
        double res = initial;
        for(int i = 0; i < years; i++) {
            res *= (1+rate);
        }
        System.out.printf("The value of the investment after %d years is: %.4f\n\n", years, res);
    }
}
