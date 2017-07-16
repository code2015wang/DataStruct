/*二叉树的实现*/
public class BinaryTreeNode{
    private int data;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;
    public int getData(){
        return data;
    }
    pyublic void setData(int data){
        this.data = data;
    }
    public BinaryTreeNode getLeftChild(){
        return leftChild;
    }
    public BinaryTreeNode setLeftChild(BinaryTreeNode leftChild){
        this.leftChild = leftChild;
    }
    public BinaryTreeNode getRightChild(){
        return rightChild;
    }
    public BinaryTreeNode setRightChild(BinaryTreeNode rightChild){
        this.rightChild = rightChild;
    }
    public int height(BinaryTreeNode node){
        if(node == null){
            return 0;
        }else{
            int l = height(node.getLeftChild());
            int r = height(node.getRightChild());
            return l > r ? l+1 : r+1;
        }
    }
    /*获节点的个数*/
    public int size(BinaryTreeNode node){
        if(node == null){
            return 0;
        }else{
            return 1+size(node.getLeftChild())+size(node.getRightChild());
        }
    }
    /*先根遍历*/
    public void preOrder(BinaryTreeNode node){
        if(node!=null){
            System.out.println(node.getData());
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }
    /*中根遍历*/
    public void inOrder(BinaryTreeNode node){
        if(node != null){
            inOrder(node.getLeftChild());
            System.out.println(node.getData());
            inOrder(node.getRightChild());
        }
    }
    /* 后根遍历*/
    public void postOrder(BinaryTreeNode node){
        if(node != null){
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.println(node.getData());
        }
    }
    /*递归查找二叉树*/
    public BinaryTreeNode search(BinaryTreeNode node ,data){
        if(node == null){
            return null;
        }else if (node.getData()== data){
            return node
                }else if(data > node.getData()){
            return search(node.getRightChild(),data);
        }else{
            return search(node.getLeftChild(),data);
        }
    }

}
