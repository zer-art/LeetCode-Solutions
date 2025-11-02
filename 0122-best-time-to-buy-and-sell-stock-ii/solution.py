class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices : 
            profit = 0 
        profit = 0 
        min = prices[0]
        for i in range(1, len(prices)):
            if min<prices[i]: 
                profit += prices[i]-min 
            min = prices[i]
        return profit
