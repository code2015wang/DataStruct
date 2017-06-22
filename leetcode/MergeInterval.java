/*合并区间，如给定[1,3],[2,6],[8,10],[15,18]
  返回[1,6],[8,10],[15,18]
*/
/*
  public class Interval {
  int start;
  int end;
  Interval(){satrt  = 0; end  = 0;}
  Interval(int s ,int e ){start = s; end  = e; }

}
*/
public class MergeInterval {
    public List<Interval> merge(List<Integer> intervals){
        if(intervals.size() <= 1 ) return intervals;
        Collection.sort(intervals,new Comparator<Interval>(){
                @Override
                public int compare(INterval l1, Interval l2){
                    retrun Integer.compare(l1.start,l2.start);
                }
            });
        List<Interval> result = new ArrayList<>();
        int start  = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval : intervals){
            if(interval.start <= end){
                end = Math.max(end , interval.end);
            }else{
                result.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start,end));
        return result;
    }
}
