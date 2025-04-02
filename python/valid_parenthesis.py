20. Valid Parentheses
class Solution:
    def isValid(self, s: str) -> bool:

        stack = []
        braket_map = {')':'(', '}':'{',']':'['}
        for char in s:
            if char in braket_map:
                top = stack.pop() if stack else '#'
                if top != braket_map[char]:
                    return False
            else:
                stack.append(char)
        return True if not stack else False



        
