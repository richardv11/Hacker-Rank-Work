import java.util.Scanner;

// Class uses an interface to calculate the divisor sum
public class DivisorSum implements AdvancedArithmetic {

    public int divisorSum(int n){
        int sum=0;
        for(int h=n; h>0; h--){
            if(n%h == 0)
                sum += h;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myDivisorSum = new DivisorSum();
        int sum = myDivisorSum.divisorSum(n);
        System.out.println("I implemented: " + myDivisorSum.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}
