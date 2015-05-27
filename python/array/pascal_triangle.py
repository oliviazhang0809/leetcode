class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        # if numRows is 0, 1, 2 -- special cases
        if numRows == 0: return []
        elif numRows == 1: return [[1]]
        elif numRows == 2: return [[1], [1,1]]
        else:
            list = [[] for i in xrange(numRows)]
            for i in xrange(numRows):
                list[i] = [1 for j in xrange(i + 1)]
            for i in xrange(2, numRows): # starting from row 3
                for j in xrange(1, i):
                    list[i][j] = list[i - 1][j - 1] + list[i - 1][j]
        return list
                
                
            