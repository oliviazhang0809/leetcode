class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        if rowIndex == 0: return [1]
        if rowIndex == 1: return [1, 1]
        list = [ [] for i in range(rowIndex + 1)]
        list[0] = [1]
        list[1] = [1, 1]
        for i in xrange(2, rowIndex + 1):
            list[i] = [1 for j in xrange(i + 1)]
            for j in xrange(1, i):
                list[i][j] = list[i - 1][j] + list[i - 1][j - 1]
        return list[rowIndex]
        