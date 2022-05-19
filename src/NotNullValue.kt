interface NotNullValue {

    fun string() : kotlin.String

    abstract class Base<T : Any?>(
        private val src: T?,
        private val default: kotlin.String = DEFAULT_VALUE
    ) : NotNullValue {

        abstract fun uniqueCondition() : Boolean

        override fun string(): kotlin.String {
            return if (src == null || uniqueCondition()) {
                default
            } else {
                src.toString()
            }
        }

        private companion object {
            private const val DEFAULT_VALUE = "Unknown"
        }
    }
    class Int(
        src: kotlin.Int?
    ) : Base<kotlin.Int?>(src) {

        override fun uniqueCondition() = false
    }

    class Double(
        private val src: kotlin.Double?
    ) : Base<kotlin.Double?>(src) {

        override fun uniqueCondition() = src == NEGATIVE_VALUE

        private companion object {
            private const val NEGATIVE_VALUE = -1.0
        }
    }

    class String(
        private val src: kotlin.String?
    ) : Base<kotlin.String?>(src) {

        override fun uniqueCondition() = src.isNullOrEmpty()
    }

    object Empty : NotNullValue {
        override fun string() = ""
    }

}