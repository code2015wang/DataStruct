/* 顺序表就是按照顺序存储的方式存储的线性表，该线性表结点按照逻辑顺序存放在计算机的一组连续的存储单元*/
import java.util.Scanner;
public class seqList {
   public static  class Data {
	        String name;
	        String key;
	        int age;
	    }
	  public static  class SLType {
	        static final int MAXLEN = 100;
	        Data[] ListData = new Data[MAXLEN + 1];
	        int ListLen;
	        void SLInit(SLType sl){
	            sl.ListLen = 0;
	        }
	       int  SLlength(SLType sl){
	            return sl.ListLen;
	        }
	       int  SlInsert(SLType sl, int n, Data data){
	            int i;
	            if(sl.ListLen >= MAXLEN){
	                System.out.println("顺序表已满，不能插入节点");
	                return 0;
	            }
	            if( n < 1 || n > sl.ListLen -1 ){
	                System.out.println("插入序号错误，不能插入元素");
	                return 0;
	            }
	            for(i = sl.ListLen; i >= n; i--){
	                sl.ListData[i+1] = sl.ListData[i];
	            }
	            sl.ListData[n] = data;
	            sl.ListLen++;
	            return 1;
	        }
	       int  SLAdd(SLType sl, Data data){
	            if(sl.ListLen >= MAXLEN){
	                System.out.println("顺序表已满，不能添加节点了");
	                return 0;
	            }
	            sl.ListData[++sl.ListLen] = data;
	            return 1;
	        }
	       int  SLDelete(SLType sl, int n){
	            int i;
	            if( n < 1 || n > sl.ListLen+1){
	                System.out.println("删除节点序号错误，不能删除节点\n");
	                return 0;
	            }
	            for( i = n; i < sl.ListLen; i++){
	                sl.ListData[i] = sl.ListData[i+1];
	            }
	            sl.ListLen--;
	            return 1;
	        }
	       Data  SLFindByNum(SLType sl, int n ){
	            if( n < 1 || n > sl.ListLen + 1){
	                System.out.println("节点序号有误，不能删除");
	                return null;
	            }
	            return sl.ListData[n];
	        }
	       int  SLFindByCount(SLType sl, String key){
	            int i;
	            for(i = 1; i <= sl.ListLen; i++){
	                if(sl.ListData[i].key.compareTo(key) == 0){
	                    return i;
	                }
	            }
				return i;
	        }
	       int  SLAll(SLType sl ){
	            int i;
	            for(i = 1; i <= sl.ListLen; i++){
	                System.out.printf("(%s,%s,%d)\n",sl.ListData[i].key,sl.ListData[i].name,sl.ListData[i].age);
	            }
	            return 0;
	        }
	    }
	        public static void main(String[] args){
	            int i;
	            SLType sl = new SLType();
	            Scanner input = new Scanner(System.in);
	            Data pdata;
	            String key;
	            System.out.println("顺序表操作");
	            sl.SLInit(sl);
	            do{
	                System.out.println("输入添加的节点（学号 姓名 年龄）");
	                Data data = new Data();
	                data.key = input.next();
	                data.name = input.next();
	                data.age = input.nextInt();
	                if(data.age != 0){
	                    if(sl.SLAdd(sl,data) == 0){
	                        break;
	                    }
	                }
	                else{
	                    break;
	                }
	            }while(true);
	            System.out.println("顺序表中节点序号为：\n");
	            sl.SLAll(sl);
	            System.out.println("\n 要取出节点的序号：");
	            i = input.nextInt();
	            pdata = sl.SLFindByNum(sl,i);
	            if(pdata != null){
	                System.out.printf("第 %d 个节点为：(%s,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
	            }
	            System.out.println("\n要查找的关键字\n");
	            key = input.next();
	            i = sl.SLFindByCount(sl,key);
	            pdata = sl.SLFindByNum(sl,i);
	            if(pdata != null){
	                System.out.printf("第 %d 个节点为:(%s,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
	            }
	        }
}
