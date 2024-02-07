package Yashque;

import java.util.ArrayList;
import java.util.List;

public class AverageofNumber {
    public static void main(String[] args) {
        AverageofNumber s = new AverageofNumber();
        double ans  = s.calculateaverage(new int[]{1,2,3,4,5,6});
        System.out.print(ans);

    }
    public double calculateaverage(int[] number){
        double average = 0;
        if(number.length<=3){
            int sum1= 0;
            for(int num :number){
                sum1 = sum1+num;
            }
            average = (double) sum1/ number.length;
//            return average;
        }
        else{
            int sum1 = 0;
            for(int i = number.length-3;i< number.length;i++){
                sum1 = sum1 + number[i];
            }
            average = (double) sum1/ 3;
//            return average;


        }
        return average;


    }
}
