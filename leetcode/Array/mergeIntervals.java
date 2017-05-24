/* 给定一个区间的集合，合并所有重叠区域。如给定 [1,3],[2,6],[8,10],[15,18],返回 [1,6],[8,10],[15,18]*/
/**
   interval 定义如下：
   public class Interval {
   int start;
   int end;
   Interval(){start=0;end=0;}
   Interval(int s,int e) {start = s; end = e;}
}
*/
import java.util.Collections;
public class megeIntervals {
    public List<Interval> merge(List<Interval> intervals){
        if(intervals.size() <= 1){
            return intervals;
        }
        //排序
        Collections.sort(intervals ,new Comparator<Interval>(){
                @Override
                public int compare(Interval i1,Interval i2){
                    return Integer.compare(i1.start,i2.start);
                }
            });
        List<Interval> result = new ArrayList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval inter : intervals){
            if(inter.start <= end){
                end = Math.max(end,interval.end);
            }else{
                result.add(new Interval(start,end));
                start = interval.start;
                end =interval.end;
            }
        }
        result.add(new Interval(start,end));
        return result;
    }
}
