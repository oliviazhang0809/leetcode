class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
        index = m + n - 1 # last index
        while (m > 0 and n > 0):
            if (A[m - 1] < B[n - 1]):
                A[index] = B[n - 1]
                n -= 1
            else:
                A[index] = A[m - 1]
                m -= 1
            index -= 1
        while (n > 0):
            A[index] = B[n - 1]
            n -= 1
            index -= 1
