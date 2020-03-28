package subtask4

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {

        var output = ArrayList<String>()
        findSequences(inputString, output)

        return output.toTypedArray()
    }

    fun findSequences(inputString: String, output: ArrayList<String>) {
        var i = 0
        var matchIndex = -1
        while (i < inputString.length - 1) {
            if (inputString.get(i) == '(' || inputString.get(i) == '[' || inputString.get(i) == '<') {
                matchIndex = findMatchBracketIndex(inputString, inputString.get(i), i)
                if (matchIndex != -1) {
                    output.add(inputString.substring(i + 1, matchIndex))
                    findSequences(inputString.substring(i + 2, matchIndex - 1), output)
                }
            }
            i++
        }
    }

    fun findInner(str: String, bracket: Char, bracketIndex: Int): Int{
        var result = -1
        when (bracket) {
            '(' -> result = str.indexOf('(', bracketIndex)
            '[' -> result = str.indexOf('[', bracketIndex)
            '<' -> result = str.indexOf('<', bracketIndex)
        }
        return result
    }

    fun findMatchBracketIndex(str: String, bracket: Char, bracketIndex: Int): Int {
        var result = -1
        when (bracket) {
            '(' -> result = str.indexOf(')', bracketIndex)
            '[' -> result = str.indexOf(']', bracketIndex)
            '<' -> result = str.indexOf('>', bracketIndex)
        }

        return result
    }
}
