class Solution(object):
    def majorityElement(self, nums):
        HO = max(set(nums), key=nums.count)
        return HO
        
        




        
