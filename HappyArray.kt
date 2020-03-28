package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        var output = ArrayList(sadArray.toList())
        var isHappy = false

        while (!isHappy) {
            isHappy = true
            if (output.size > 2) {
                var i = 1
                while (i < output.size - 1) {
                    if (output[i - 1] + output[i + 1] < output[i]) {
                        output.removeAt(i)
                        isHappy = false
                    }
                    i++
                }
            }
        }
        return output.toIntArray()
    }
}
