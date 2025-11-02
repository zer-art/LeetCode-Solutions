class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices: 
            profit = 0
        
        min = prices[0]
        profit = 0 

        for i in range(1,len(prices)): 
            curent_price = prices[i]
            if (curent_price - min )> profit: 
                profit = curent_price - min 
            if curent_price<min : 
                min = curent_price
        return profit