class Solution(object):
    def findMissingElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        m = min(nums)
        ma = max(nums)
        mis = []
        for i in range(m,ma): 
            if i not in nums: 
                mis.append(i)
        return mis        
