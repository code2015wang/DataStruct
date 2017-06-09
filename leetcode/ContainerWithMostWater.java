/* 给定n个非负整数a1,a2,a3,a4,a5.....ai,每个数代表一个点（i，ai）。绘制n条垂直的直线，使直线i的两个端点分别在(i,ai)和(i,0).找到两条线，使他们与x轴一起形成一个容器，使得容器含有最多的水*/
public class ContainerWithMostWater {
    public static int  mostArea(int[] height){
        int left = 0, right = height.length - 1;
        int maxarea = 0;
        while(left < right){
            maxarea = Math.max(maxarea,Math.min(height[left],height[right]) * (right - left));
            if(height[left] < height[right])
                left ++;
            else
                right --;
        }
        return maxarea;
    }
    public static void main(String[] args){
        int[] height = new int[]{1,2,3,4,5,6};
        System.out.println(mostArea(height));
    }
}
