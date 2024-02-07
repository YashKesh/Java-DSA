package Arrays;
import java.util.*;

public class Pascaltriangle {
    public static void main(String[] args) {
        Pascaltriangle sol = new Pascaltriangle();
        System.out.println(sol.generate(5));
    }
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> pascal = new ArrayList<>();
            for(int i = 1;i<=numRows;i++){
                if(i==1){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(1);
                    pascal.add(new ArrayList<>(temp));
                }
                else if(i==2){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(1);
                    temp.add(1);
                    pascal.add(temp);
                }
                else{
                    List<Integer> last = pascal.get(pascal.size()-1);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(1);
                    for(int j = 0;j<last.size()-1;j++){
                        temp.add(last.get(j)+last.get(j+1));
                    }
                    temp.add(1);
                    pascal.add(temp);
                }


            }
            return pascal;
        }
    }

