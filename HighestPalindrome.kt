package subtask5

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var changeCount = 0
        var output = digitString

        for (i in 0..n / 2 - 1) {
            if (changeCount > k) break
            if (output[n / 2 - 1 - i] != output[n / 2 + i]) {
                if (n / 2 - 1 - i == 0 && changeCount + 2 <= k) {
                    output = output.replaceRange(
                        0,
                        1,
                        '9'.toString()
                    )
                    output = output.replaceRange(
                        output.length - 1,
                        output.length,
                        '9'.toString()
                    )
                    changeCount += 2
                }


                when (output[n / 2 - 1 - i] > output[n / 2 + i]) {
                    true -> output = output.replaceRange(
                        n / 2 + i,
                        n / 2 + i + 1,
                        output[n / 2 - i - 1].toString()
                    )
                    false -> output = output.replaceRange(
                        n / 2 - 1 - i,
                        n / 2 - i,
                        output[n / 2 + i].toString()
                    )
                }
                changeCount++
            }
        }


        if (isPalyndrome(output)) {
            return output
        } else {
            return "-1"
        }
    }

    fun isPalyndrome(string: String): Boolean {
        var status = true
        for (i in 0..string.length / 2) {
            if (string.get(i) != string.get(string.length - i - 1)) {
                status = false
            }
        }
        return status
    }
}
