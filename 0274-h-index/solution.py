class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        s = sorted(citations , reverse = True)
        h = 0
        for i in range(len(s)): 
            if s[i]>h and h >= i: 
                h += 1
        if len(s) == 0 : 
            h = 0 
        return h 
