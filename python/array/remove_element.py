class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer
    def removeElement(self, A, elem):
        j = len(A) - 1
        for i in range(j, -1, -1):
            if (A[i] == elem):
                A[i], A[j] = A[j], A[i]
                j -= 1
        return j + 1
        