# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        curr = -200
        new_head = ListNode(-200)
        running_head = new_head
        prev_running_head = new_head
        while(head!=None):
            next = head.next
            head.next = None
            if(head.val != curr):
                running_head.next = head
                prev_running_head = running_head
                running_head = running_head.next
                curr = head.val
            else:
                prev_running_head.next = None
                running_head = prev_running_head
            head = next
        return new_head.next
