class RandomizedSet(object):

    def __init__(self):
        self.index = {}
        self.values = []

    def insert(self, val):
        """
        :type val: int
        :rtype: bool
        """
        if val in self.index: 
            return False 
        else : 
            self.index[val] = len(self.values) 
            self.values.append(val)
            return True 

    def remove(self, val):
        """
        :type val: int
        :rtype: bool
        """
        if val in self.index: 
            self.values[self.index[val]] = self.values[-1]
            self.index[self.values[-1]] = self.index[val]
            self.values.pop()
            del self.index[val]
            return True 
        else : 
            return False
        

    def getRandom(self):
        """
        :rtype: int
        """
        import random 
        return random.choice(self.values)
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
