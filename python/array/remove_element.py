class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer
    def removeElement(self, A, elem):
        end = len(A) - 1 # last index
        for i in xrange(end, -1, -1):
            if (A[i] == elem):
                A[i], A[end] = A[end], A[i]
                end -= 1
        return end + 1 # return the **new length**
        
        