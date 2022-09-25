class Solution:
    def isPalindrome(self, x: int) -> bool:
        num = str(x)
        beg_second_half =  len(num)//2 
        first_half = num[0:beg_second_half] if len(num)%2==0 else num[0:beg_second_half+1]
        second_half = num[beg_second_half:][::-1]
        return first_half == second_half
