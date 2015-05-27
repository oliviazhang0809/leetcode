class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        if (len(A) == 0): return 0 # empty array
        j = 0 # index of unique element
        for i in xrange(len(A)):
            if (A[i] != A[j]): # find a new unique element!
                # swap
                A[i], A[j + 1] = A[j + 1], A[i]
                j += 1 # increase the number
        return j + 1
            
                
                
        