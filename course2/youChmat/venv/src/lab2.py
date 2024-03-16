#!/bin/python3

import math
import os
import random
import re
import sys
import itertools

class Result:
    isMethodApplicable = True
    errorMessage = "The system has no diagonal dominance for this method. Method of the Gauss-Seidel is not applicable."
    n = 0
    matrix = []

    def solveByGaussSeidel(n, matrix, epsilon):
        try:
            Result.n = n
            Result.matrix = matrix
            if not Result.isPossible(matrix):
                Result.isMethodApplicable = False
                return []
            x = [0 for _ in range(n)]
            r = [0 for _ in range(n)]
            max_difference = epsilon + 1
            while max_difference > epsilon:
                max_difference = 0
                for i in range(n):
                    iteration_sum = 0
                    for j in range(0, n):
                        iteration_sum += Result.matrix[i][j] * x[j]
                    r[i] = (iteration_sum - Result.matrix[i][n]) / Result.matrix[i][i]
                    x[i] -= r[i]
                    max_difference = max(max_difference, abs(r[i]))
            return x + r
        except:
            Result.isMethodApplicable = False
            return []

    def isPossible(matrix):
        permutations = list(itertools.permutations(Result.matrix, Result.n))
        for new_matrix in permutations:
            Result.matrix = new_matrix
            if Result.isDDM(new_matrix):
                return True
        return False

    def isDDM(matrix):
        strictly_more = 0
        for i in range(Result.n):
            sum = 0
            for j in range(Result.n):
                sum = sum + abs(Result.matrix[i][j])
            if abs(2 * Result.matrix[i][i]) < sum:
                return False
            else:
                if abs(2 * Result.matrix[i][i]) > sum:
                    strictly_more = strictly_more + 1
        if strictly_more > 0:
            return True
        else:
            return False


if __name__ == '__main__':
    n = int(input().strip())

    matrix_rows = n
    matrix_columns = n+1

    matrix = []

    for _ in range(matrix_rows):
        matrix.append(list(map(float, input().rstrip().split())))

    epsilon = float(input().strip())

    result = Result.solveByGaussSeidel(n, matrix, epsilon)
    if Result.isMethodApplicable:
        print('\n'.join(map(str, result)))
    else:
        print(f"{Result.errorMessage}")
