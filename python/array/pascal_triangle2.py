class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        if rowIndex == 0: return [1]
        if rowIndex == 1: return [1, 1]
        res = [1, 1] # temp result
        for i in xrange(2, rowIndex + 1):
            tmp = [1 for j in xrange(i + 1)] # create a tmp row 
            for j in xrange(1, i):
                tmp[j] = res[j - 1] + res[j] # ignore row number
            res = tmp # update res
        return res
        