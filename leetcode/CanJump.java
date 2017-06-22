/* 给定一组非负整数，假设你最初位于数组的第一个索引处。数组中的每个位置代表你在该位置的最大跳跃长度，判断你是否能到达最后一个位置。如 [2,3,1,1,4] 返回true; [3,2,1,0,4] 返回false。*/
public class CanJump {
    public canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max ) return false;
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }
}
