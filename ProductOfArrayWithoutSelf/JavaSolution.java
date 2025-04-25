class JavaSolution {
    public int[] productExceptSelf(int[] nums) {

        
        int [] prefixArray = new int[nums.length];

        for(int i = 0 ;i < nums.length;i++){
            if(i==0){
                prefixArray[i] = 1;
            }
            else{
                prefixArray[i] = prefixArray[i-1] * nums[i-1];
            }
        }
        int right = 1;
        for(int i = nums.length-1;i>=0;i--){
            
            prefixArray[i] *= right;

            right = right * nums[i];

        }
        return prefixArray;

    }
}
