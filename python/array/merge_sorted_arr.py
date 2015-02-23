def merge(A, m, B, n):
	index = m + n
	while (m > 0 and n > 0):
		index -= 1
		if A[m - 1] < B[n - 1]:
			n -= 1
			A[index] = B[n]
		else:
			m -= 1
			A[index] = A[m]
	while (n > 0):
		index -= 1
		n -= 1
		A[index] = B[n]

A = [1,3,5,7, 0, 0]
B = [2,4]
merge(A, 4, B, 2)
print(A)