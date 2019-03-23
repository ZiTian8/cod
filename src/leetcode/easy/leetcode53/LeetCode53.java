/**
 * @ClassName LeetCode38
 * @Description
 * @Author HAHA
 * @Version V1.0.0
 * @Date 2019/2/19 14:26
 */
package leetcode.easy.leetcode53;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    private int crossing(int[] nums,int mid){
        int low=0;
        int high=nums.length;


        int maxsumleft=Integer.MIN_VALUE;
        int sumleft=0;
        for(int i=mid-1;i>=low;i--){
            sumleft=sumleft+nums[i];
            if(sumleft>maxsumleft){
                maxsumleft=sumleft;
            }
        }

        int maxsumr=Integer.MIN_VALUE;
        int sumr=0;
        for(int i=mid;i<high;i++){
            sumr=sumr+nums[i];
            if(sumr>maxsumr){
                maxsumr=sumr;
            }
        }
        return maxsumleft+maxsumr;


    }
    public int maxSubArray(int[] nums) {
        int low=0;
        int high=nums.length;
        int mid=(low+high)/2;

        if(nums.length==1){
            return nums[0];
        }
        else{
            int suml=maxSubArray(Arrays.copyOfRange(nums,0,mid));
            int sumr=maxSubArray(Arrays.copyOfRange(nums,mid,high));
            int sumc=crossing(nums,mid);
            int max=suml>sumr?suml:sumr;
            max=max>sumc?max:sumc;
            return max;
        }



    }
}


public class LeetCode53 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new Solution().maxSubArray(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}