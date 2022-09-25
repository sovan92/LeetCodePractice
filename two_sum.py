class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        partial_sum = dict({})
        for idx in range(len(nums)):
            prevIdx = None
            if target - nums[idx] in partial_sum:
                return [partial_sum[target - nums[idx]],idx]
            else:
                partial_sum[nums[idx]]=idx;
        return [-1,-1]  
