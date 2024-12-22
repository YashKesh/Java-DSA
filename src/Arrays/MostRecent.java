package Arrays;
import java.util.*;

class PairAvg{
    double avg;
    int index;
    public PairAvg(double avg ,int index){
        this.avg = avg;
        this.index = index;
    }
}
class MostRecent {
    public static void main(String[] args) {
        int[][] classes = new int[][]{{1,2},{3,5},{2,2}};
        int maxStudents = 2;
        MostRecent ms = new MostRecent();
        System.out.println(ms.maxAverageRatio(classes,maxStudents));
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<PairAvg> pq = new PriorityQueue<PairAvg>((x,y)->Double.compare(x.avg,y.avg));
        for(int i = 0;i<classes.length;i++){
            double avg = (double)classes[i][0] / classes[i][1];
            pq.add(new PairAvg(avg, i));
        }
        while(extraStudents>0) {
            PairAvg node = pq.poll();
            double avg = node.avg;
            int index = node.index;
            classes[index][0]++;
            classes[index][1]++;
            double newavg = (double) classes[index][0] / classes[index][1];
            if (avg < newavg) {
                pq.add(new PairAvg(newavg, index));
            }
            extraStudents--;
        }
        double ans = 0;
        while(!pq.isEmpty()){
            PairAvg node = pq.poll();
            ans+=node.avg;
        }
        return ans/classes.length;
    }
}