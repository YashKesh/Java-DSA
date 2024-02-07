package Arrays;
import  java.util.*;
public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman sol = new IntegerToRoman();
        System.out.println(sol.intToRoman(5319));
    }

        public String intToRoman(int num) {
            Map<Integer, String> map = new HashMap<>();
            map.put(1, "I");
            map.put(4, "IV");
            map.put(5, "V");
            map.put(9, "IX");
            map.put(10, "X");
            map.put(40, "XL");
            map.put(50, "L");
            map.put(90, "XC");
            map.put(100, "C");
            map.put(400, "CD");
            map.put(500, "D");
            map.put(900, "CM");
            map.put(1000, "M");

            StringBuilder res = new StringBuilder();

            for (int value : new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}) {
                while (num >= value) {
                    num -= value;
                    res.append(map.get(value));
                }
            }

            return res.toString();
        }
    }


