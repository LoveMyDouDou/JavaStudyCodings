package leetcode;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }


    public int binarySearch(int [] nums,int low,int high,int target){
        if(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(target<nums[mid]){
                int found=binarySearch(nums,low,mid-1,target);
                if(found==-1){
                    return mid;
                }
                else {
                    return found;
                }
            }
            else {
                int found=binarySearch(nums,mid+1,high,target);
                if(found==-1){
                    return mid+1;
                }
                else {
                    return found;
                }
            }
        }
        else {
            return -1;
        }
    }

}
