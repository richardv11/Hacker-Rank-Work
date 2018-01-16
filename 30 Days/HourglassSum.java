/*
Calculates the greatest sum from all the hourglasses contained in a 6x6 matrix of integers.
 */
import java.util.*;

public class HourglassSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        // Check every hourglass' sum
        int centerIndex=1,topRowIndex=0,bottomRowIndex=2;
        int centerColIndex=1, topRowColIndex=0, bottomRowColIndex=0;
        int sum=-100, tempSum=0;

        // Outer for loop to go down in the matrix for next set of hourglasses
        for(int h=0; h<4; h++){
            // Inner for loop, checks them horizontally
            for(int i=0; i<4; i++){
                for(int j=0; j<3; j++)
                    tempSum += arr[topRowIndex][topRowColIndex+j];
                tempSum += arr[centerIndex][centerColIndex];
                for(int k=0; k<3; k++)
                    tempSum += arr[bottomRowIndex][bottomRowColIndex+k];
                if(tempSum > sum)
                    sum = tempSum;
                tempSum=0;
                topRowColIndex++; centerColIndex++; bottomRowColIndex++;
            }
            // Reset, and bring col indices down
            topRowIndex++; centerIndex++; bottomRowIndex++;
            centerColIndex=1; topRowColIndex=0; bottomRowColIndex=0;
        }
        // Print biggest sum
        System.out.print(sum);
    }
}