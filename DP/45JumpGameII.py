class Solution:
    def jump(self, nums: List[int]) -> int:
        
        # RECURSIVE SOLUTION
        def jump_recurse(curr_index):

            if curr_index == (len(nums)-1):
                return 0
            
            num_of_steps_required = len(nums) - 1 - curr_index
            if nums[curr_index] >= num_of_steps_required:
                return 1
            else:
                min_element = len(nums)
                for steps in range(1, nums[curr_index]+1):
                    min_element =  min(1+jump_recurse(curr_index + steps), min_element)
                return min_element

        # MEMORISED OPTION 
        def jump_recursive_memoised(nums: List[int]) -> int:

            steps_list = [0 for _ in range(len(nums))] 
            steps_list[len(nums)-1] = 0

            for i in range(len(nums)-2, -1, -1):
                if nums[i] == 0:
                    steps_list[i] = len(nums) + 1
                elif (nums[i] + i) >= (len(nums)-1):
                    steps_list[i] = 1
                else:
                    steps_list[i] = 1 + min(steps_list[i+1:i+nums[i]+1])
            
            return steps_list[0]

        
        return jump_recursive_memoised(nums)
        
