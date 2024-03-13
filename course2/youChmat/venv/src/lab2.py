#!/bin/python3

import math
import os
import random
import re
import sys


class Result:
    isMethodApplicable = True
    errorMessage = "The system has no diagonal dominance for this method. Method of the Gauss-Seidel is not applicable."
    n = 0
    matrix = []

    def solveByGaussSeidel(n, matrix, epsilon):
        try:
            Result.n = n
            Result.matrix = matrix
            Result.isPossible(matrix)
            if not Result.isMethodApplicable:
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
        diagonalCandidates = [[0 for i in range(Result.n)] for i in range(Result.n)]
        for i in range(Result.n):
            sumOfRowValues = 0
            for j in range(Result.n):
                sumOfRowValues += matrix[i][j]
            for j in range(Result.n):
                if sumOfRowValues < 2 * matrix[i][j]:
                    diagonalCandidates[i][j] = 2
                else:
                    if sumOfRowValues == 2 * matrix[i][j]:
                        diagonalCandidates[i][j] = 1
                    else:
                        diagonalCandidates[i][j] = 0
        rank = Result.rankOfMatrix(diagonalCandidates)
        if rank == Result.n:
            Result.isMethodApplicable = True
        else:
            Result.isMethodApplicable = False

    def rankOfMatrix(diagonalCandidates):
        rank = Result.n
        for i in range(rank):
            if diagonalCandidates[i][i] != 0:
                for j in range(Result.n):
                    if j != i:
                        mult = diagonalCandidates[j][i] / diagonalCandidates[i][i]
                        for k in range(rank):
                            diagonalCandidates[j][k] -= mult * diagonalCandidates[i][k]
            else:
                reduce = True
                for k in range(i + 1, Result.n):
                    if diagonalCandidates[k][i] != 0:
                        diagonalCandidates[i], diagonalCandidates[k] = diagonalCandidates[k], diagonalCandidates[i]
                        Result.matrix[i], Result.matrix[k] = Result.matrix[k], Result.matrix[i]
                        reduce = False
                        break
                if reduce:
                    rank -= 1
                    return rank
                i -= 1
        return rank


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
