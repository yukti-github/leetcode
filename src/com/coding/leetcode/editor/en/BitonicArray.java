
public class Main {
    static int ans =0;
    static int result =-1;
    static int res1=-1;
    static int res2=-1;
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        int target =12;
        binarymid(0, nums.length-1, nums);

        if(target> nums[ans]) result =-1;

        else if(target==nums[ans]) result= ans;
        else{
            if(target<nums[ans] && target>=nums[0])
            {
                binary(0, ans, nums, target);

                result=res1;
            }
            if(res1==-1 && target<nums[ans] && target>= nums[nums.length-1])
            {

                binary2(ans, nums.length-1, nums, target);
                result=res2;
            }
        }
        System.out.println(ans);
        System.out.println("ans= "+result);
    }

    public static void binary(int left, int right, int nums[], int target)
    {
        int mid = (left+right)/2;

        if(left>right) {
            res1= -1;
            return;
        }

        if(nums[mid]==target) {
            res1= mid;
            return;
        }

        if(left<right)
        {
            if(nums[mid]<target)
            {
                binary(mid+1,right,nums,target);
            }
            else if(nums[mid]>target)
            {
                binary(left,mid-1,nums,target);
            }
        }

    }
    public static void binary2(int left, int right, int nums[], int target)
    {

        int mid = (left+right)/2;
        System.out.println("left= "+left+" , right= "+right+" , and = "+nums[mid]+" , "+target );

        if(nums[mid]==target) {
            res2= mid;
            return;
        }
        if(left>right) {
            res2= -1;
            return;
        }


        if(left<right)
        {
            if(nums[mid]<target)
            {
                binary2(left,mid-1,nums,target);

            }
            else if(nums[mid]>target)
            {
                binary2(mid+1,right,nums,target);
            }
        }
        return;
    }





    public static void binarymid(int left, int right, int[] nums){
        int mid= (left+right)/2;

        if(nums.length==2){
            if(nums[1]>nums[0]) ans=1;
            else ans=0;
        }
        else if(left>=right || mid==0) {
            ans= mid;
            return;
        }
        else if(mid==nums.length-2 && nums[mid]<nums[mid+1] && nums[mid]>nums[mid-1])
        {
            ans= mid+1;
            return;
        }

        if(mid>0 && mid<nums.length-1 && left<right )
        {

            if( nums[mid-1] < nums[mid] &&  nums[mid+1]<nums[mid]){
                ans = mid;
                return;
            }

            else if(  nums[mid-1] < nums[mid] &&  nums[mid+1]>nums[mid])
            {

                binarymid(mid, right, nums);
            }

            else if( nums[mid-1]>nums[mid] &&  nums[mid+1]<nums[mid])
            {
                binarymid(left, mid, nums);
            }
        }
        return;
    }
}


