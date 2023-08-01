package neetCode150.stack;

import java.util.Arrays;
import java.util.Comparator;

public class Car_Fleet {

    public int carFleet(int target, int[] position, int[] speed) {
        double times[] = new double[target];
        for (int i=0; i < position.length; i++){
            times[position[i]] = (double)(target-position[i]) / speed[i];
        }
        int res = 0;
        double validation = 0;
        for (int i = target-1; i>=0; i--) {
             double check = times[i];
             while (check > validation) {
                 validation = check;
                 res++;
             }
        }
        return res;
    }


    public int carFleet2(int target, int[] position, int[] speed) {
        double[] times = new double[target];
        for (int i=0; i<position.length; i++) {
            times[position[i]] = (double) (target-position[i]) / speed[i];
        }
        int res = 0;
        double valid=0;
        for (int i=target-1; i>=0; i--) {
            double check = times[i];
            while (check > valid){
                valid = check;
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Car_Fleet().carFleet2(12, new int[]{10,8,5,3,0}, new int[]{2,4,1,1,3}));
    }
}
