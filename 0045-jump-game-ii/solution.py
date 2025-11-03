class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        jump =0 
        n = len(nums)
        if n <= 1:
            return 0
        curent_end = 0 
        max_reach = 0 
        for i in range (n): 
            max_reach = max (max_reach , i +nums[i])
            if i == curent_end : 
                    jump +=1 
                    curent_end = max_reach 
            if curent_end >= n - 1:
                    break
        return jump
        


            
        
