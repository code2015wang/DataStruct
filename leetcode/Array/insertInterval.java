/*给定一个重叠的区间集合，现将一个新的区间插入这个集合中，请输出插入结果（结果是合并之后的区间集合）。你可以假定区间是排序好的。
  如区间集合([1,3],[6,9] ) ,插入并合并[2,5],结果为([1,5],[6,9])
  如区间集合（[1,2],[3,5],[6,7],[8,10],[12,16]）,插入并合并[4,9],输出结果为([1,2],[3,10],[12,16])
*/
/**
   public class Interval {
   int start;
   int end;
   Interval(){start = 0; end = 0;}
   Interval(int s, int e) {
   start =s;
   end = e;
}
}
*/
pulic class Solution {
    public List<Interval> insert (List<Interval> intervals ,Interval newInterval){
        int i=0;
        while(i < intervals.size() && interval.get(i).end < newInterval.start) i++;
        while(i< intervals.size() && intervals.get(i).start <= newInterval.end ){
            newInterval =new Interval(Math.min(intervals.get(i).start,newInterval.start),Math.max(intervals.get(i).end,newInterval.end))
                intervals.remove(i)
        }
        intervals.add(i,newInterval);
        return intervals;
    }
}
