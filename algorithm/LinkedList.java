

/* 链表操作*/
import java.util.Scanner;
public class LinkedList{


static class Data{
    String key;
    String name;
    int age;
}
static class CLType {
    Data nodeData = new Data();
    CLType nextNode;
    CLType CLAddEnd(CLType head, Data nodeData){
        CLType node, htemp;
        if((node = new CLType()) == null ){
            System.out.println("申请内存失败！\n");
            return null;
        }
        else{
            node.nodeData = nodeData;
            node.nextNode = null;
            if (head == null){
                head = node;
                return head;
            }
            htemp = head;
            while(htemp.nextNode != null){
                htemp = htemp.nextNode;
            }
            htemp.nextNode = node ;
            return head;
        }
    }
    CLType CLAddFirst(CLType head, Data nodeData){
        CLType node;
        if((node = new CLType()) == null){
            System.out.println("申请内存失败\n");
            return null;
        }
        else{
            node.nodeData = nodeData;
            node.nextNode = head;
            head = node;
            return head;
        }
    }
    CLType CLFindNode(CLType head,  String key){
        CLType htemp;
        htemp = head;
        while(htemp != null){
            if(htemp.nodeData.key.compareTo(key) == 0){
                return htemp;
            }
            htemp = htemp.nextNode;
        }
        return null;
    }
    CLType CLInsertNode(CLType head, String findkey, Data nodeData){
        CLType node,nodetemp;
        if((node = new CLType()) == null){
            System.out.println("申请内存失败\n");
            return null;
        }
        node.nodeData = nodeData;
        nodetemp = CLFindNode(head,findkey);
        if(nodetemp != null){
            node.nextNode = nodetemp.nextNode;
            nodetemp.nextNode = node;
        }else{
            System.out.println("未找到正确的位置");
            //free(node);
        }
        return head;
    }
    int CLDeleteNode(CLType head, String key){
        CLType node ,htemp;
        htemp = head;
        node = head;
        while(htemp != null){
            if(htemp.nodeData.key.compareTo(key) == 0){
                node.nextNode = htemp.nextNode;
                //free(htemp);
                return 1;
            }else{
                node = htemp;
                htemp = htemp.nextNode;
            }

        }
        return 0;
    }
	

    int CLLength(CLType head){
        CLType htemp;
        int len = 0;
        htemp = head;
        while(htemp != null){
            len++;
            htemp = htemp.nextNode;
        }
        return len;
    }
    void CLAllNode(CLType head){
        CLType htemp;
        Data nodeData;
        htemp = head;
        System.out.printf("当前链表有%d个节点。链表所有数据如下：\n",CLLength(head));
        while(htemp != null ){
            nodeData = htemp.nodeData;
            System.out.printf("节点(%s,%s,%d)\n",nodeData.key,nodeData.name,nodeData.age);
            htemp = htemp.nextNode;
        }
    }
}
    public static void main(String[] args){
        CLType node,head = null;
        CLType CL = new CLType();
        String key,findkey;
        Scanner input = new Scanner(System.in);
        System.out.println("链表测试。先输入链表中数据，格式为: 关键字 姓名 年龄\n");
        do{
            Data nodeData = new Data();
            nodeData.key = input.next();
            if(nodeData.key.equals("0")){
                break;
            }else{
                nodeData.name = input.next();
                nodeData.age = input.nextInt();
                head = CL.CLAddEnd(head,nodeData);
            }
        }while(true);
        CL.CLAllNode(head);
        System.out.println("\n演示插入节点，输入插入位置关键字:");
        findkey = input.next();
        Data nodeData = new Data();
        nodeData.key = input.next();
        nodeData.name = input.next();
        nodeData.age = input.nextInt();
        head = CL.CLInsertNode(head,findkey,nodeData);
        CL.CLAllNode(head);
        System.out.println("\n 演示删除节点，输入查找关键字:");
        key = input.next();
        CL.CLDeleteNode(head,key);
        CL.CLAllNode(head);
        System.out.println("\n演示在链表中查找，输入查找关键字:");
        key = input.next();
        node = CL.CLFindNode(head,key);
        if(node != null){
            nodeData = node.nodeData;
            System.out.printf("关键字 %s 对应的节点为（%s,%s,%d）\n",key,nodeData.key,nodeData.key,nodeData.name,nodeData.age);

        }else{
            System.out.printf("在链表中未找到关键字%s的节点\n",key);
        }
    }
}

