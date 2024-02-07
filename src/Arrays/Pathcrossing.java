package Arrays;
import java.util.*;
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
public class Pathcrossing {
    public static void main(String[] args) {
        Pathcrossing sol = new Pathcrossing();
        String path = "NESWW";
        System.out.println(sol.isPathCrossing(path));
    }

        public boolean isPathCrossing(String path) {
            Map<Pair,Boolean> map = new HashMap<>();
            int x = 0;
            int y = 0;
            map.put(new Pair(x,y),true);
            for(int i = 0;i<path.length();i++){
                if(path.charAt(i)=='N'){
                    x+=1;
                    y+=1;
                    if(map.containsKey(new Pair(x,y))){
                        return true;
                    }
                    else{
                        map.put(new Pair(x,y),true);
                    }

                }
                if(path.charAt(i)=='E'){
                    x+=1;
                    if(map.containsKey(new Pair(x,y))){
                        return true;
                    }
                    else{
                        map.put(new Pair(x,y),true);
                    }

                }
                if(path.charAt(i)=='W'){
                    x-=1;
                    if(map.containsKey(new Pair(x,y))){
                        return true;
                    }
                    else{
                        map.put(new Pair(x,y),true);
                    }

                }
                if(path.charAt(i)=='S'){
                    x-=1;
                    y-=1;
                    if(map.containsKey(new Pair(x,y))){
                        return true;
                    }
                    else{
                        map.put(new Pair(x,y),true);
                    }

                }
            }
            return false;
        }
    }


