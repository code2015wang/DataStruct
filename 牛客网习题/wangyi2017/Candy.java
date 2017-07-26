/* 计算糖果
   A,B,C三人是好朋友，每个人手里都有一些糖果，我们不知道他们每个人手上具体有多少糖果，但是我们知道以下信息：
   A-B,B-C,A+B,B+C这四个数值，每个字母代表每个人所拥有的糖果数。
   现在需要通过这四个数值计算出每个人手里有多少个糖果，即A，B，C，这里保证最多只有一组整数A，B，C满足所有题设条件。
   输入描述：
   输入一行，一共4个整数，分别为A-B,B-C,A+B,B+c,用空格隔开
   输出描述：
   输出一行，如果存在满足整数A，B,C则顺序输出A，B，C，用空格隔开，行末无空格
   如果不存在这样的整数A,B,C,则输出NO。
*/
public class Candy{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a,b,c,d;
        int A,B,C;
        while(in.hasNext()){
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            d = in.nextInt();
            A = (a+c) / 2;
            B = (c-a) / 2;
            C = (d-b) / 2;
            if((A-B == a) && (B-C==b) && (A+B==c) && (B+C==d))
                System.out.println(A+" "+B+" "+C);
            else
                System.out.println("NO");
        }
    }
}
