class Solution:
    # @param num, a list of integers
    # @return an integer
    # hash table, time: O(n), space: O(n)
    def majorityElement(self, num):
        d = {}
        size = len(num)
        for i in num:
            if d.has_key(i):
                d[i] += 1
            else:
                d[i] = 1
            if d[i] > size/2:
                return i
        
        # time: o(n)
        def majorityElement_on(self, num):
        	res = 0
        	c = 0
        	for i in num:
        		if c == 0:
        			res = i
        			c = 1
        		else:
        			if res == i:
        				c += 1
        			else:
        				c -= 1
        	return res
