package decorator

interface MathOperation {

    fun calculate(srcNumber: Int) : Int

    class Plus(
        private val number: Int
    ) : MathOperation {

        override fun calculate(srcNumber: Int): Int = number + srcNumber

    }

    class Diff(
        private val number: Int
    ) : MathOperation {

        override fun calculate(srcNumber: Int): Int = srcNumber - number
    }
}