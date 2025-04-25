record Pair(int element , int index){};
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)-> y.element - x.element);
        int [] maxElementsArray = new int[nums.length-k+1];
        int lowest = 0;
        int maxElementsPtr = 0;
        for(int i =0 ;i < nums.length;i++){
            Pair currPair = new Pair(nums[i],i);
            if(i < k){
                pq.offer(currPair);

                if(k-i == 1){
                    maxElementsArray[maxElementsPtr] = pq.peek().element;
                    maxElementsPtr++;
                }

            }
            else{
                lowest = i - k;
                while( !pq.isEmpty() && ( pq.peek().index <= lowest)){
                    pq.poll();
                }
                pq.offer(currPair);
                maxElementsArray[maxElementsPtr] = pq.peek().element;
                maxElementsPtr++;
            }
        }
        return maxElementsArray;
    }
