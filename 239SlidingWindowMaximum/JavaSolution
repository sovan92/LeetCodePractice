class JavaSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int i=0, j=0, index=0;
        while(j<nums.length){
            while(!dq.isEmpty() && dq.peekLast() < nums[j]){
                dq.pollLast();
            }
            dq.addLast(nums[j]);
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                res[index] = dq.peekFirst();
                index++;
                if(nums[i] == dq.peekFirst()){
                    dq.pollFirst();
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
