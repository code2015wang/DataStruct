/*假定你在一个party，party上有n个人(从0到n-1)，并且n个人中可能存在一个名人。名人是这样的人，所有n-1个知道他，而它不知道其他任何人。现在你需要找到在party上是否存在这个celebrity。你现在存在一个帮助函数像：”hi,a .do you know b" 来获得a是否知道b的消息。你需要在这个帮助函数的帮助下找到party中是否存在celebrity。要求尽可能的调用帮助函数*/
/*帮助API在父类Relation中定义 boolean int knoes(int a,int b)*/
public class findTheCelebrity extends Relation {
    public int findCelebrity(int n){
        int candidata = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidata,i)){
                candidata = i;
                /*这个遍历就找到了最有希望是名人的候选人*/
            }

        }
        /*这个遍历是判断候选人不知道其他人，其他人知道候选人。存在则存在名人，否则不存在返回-1*/
        for(int i = 0; i < n; i++){
            if(i!= candidata && knows(candidata, i) || !knows(i, candidata)) {
                return -1
            }
        }
        return candidata;
    }
}
