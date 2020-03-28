package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
        var minSum: Int = 0
        var maxSum: Int = 0
        var output = IntArray(2)

        input.sort()
        for (i in 0..input.size - 2) {
            minSum += input[i]
        }
        for (i in input.size - 1 downTo 1) {
            maxSum += input[i]
        }

        output[0] = minSum
        output[1] = maxSum

        return output
    }
}
