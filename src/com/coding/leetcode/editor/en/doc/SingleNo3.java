class Solution {
    public int[] singleNumber(int[] nums) {


        int countbit=0;
        int xor = 0;
        int[] ans= new int[2];

        List<Integer> list1= new ArrayList<>();
        List<Integer> list2= new ArrayList<>();

        for(int i=0; i<nums.length;i++)
        {
            xor = xor^nums[i];
        }

        //System.out.println("xor ="+xor);

        int binary1 =0;

        while((xor&1)!=1)
        {
            xor = xor>>1;

            countbit++;

        }

        for(int i=0; i<nums.length; i++)
        {
            if(checkNthBit(nums[i],countbit)) list1.add(nums[i]);
            else list2.add(nums[i]);
        }
        ans[0]= doingXor(list1);
        ans[1]= doingXor(list2);
        // System.out.println(countbit+" hello "+list1+" , \n"+" list 2= "+list2);
        return ans;
    }

    public boolean checkNthBit(int n, int count)
    {

        int countbit=0;
        int bin=0;
        while(count!=countbit)
        {
            n=n>>1;
            countbit++;
        }
        if(countbit==count)
        {
            if((n&1) ==1) return true;
        }

        return false;
    }

    public int doingXor(List<Integer> list)
    {
        int xor=0;
        for(int i=0; i<list.size();i++)
        {
            xor = xor^list.get(i);
        }
        return xor;
    }
}