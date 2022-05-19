import org.junit.After
import org.junit.Assert.*
import org.junit.Test

class NotNullValueTest {

    private var notNullValue: NotNullValue = NotNullValue.Empty

    @Test
    fun test_failure_string_is_null() {
        notNullValue = NotNullValue.String(null)
        val expected = "Unknown"
        val actual = notNullValue.string()
        assertEquals(expected,actual)
    }

    @Test
    fun test_success_string_is_not_null() {
        var string = "Hello,Bob"

        notNullValue = NotNullValue.String(string)

        var expected = "Hello,Bob"
        var actual = notNullValue.string()
        assertEquals(expected,actual)

        string = "Hello,Grunkle"
        notNullValue = NotNullValue.String(string)

        expected = "Hello,Grunkle"
        actual = notNullValue.string()
        assertEquals(expected,actual)
    }

    @Test
    fun test_failure_double_is_null() {
        notNullValue = NotNullValue.Double(null)
        val expected = "Unknown"
        val actual = notNullValue.string()
        assertEquals(expected,actual)
    }

    @Test
    fun test_failure_double_is_negative() {
        val double = -1.0
        notNullValue = NotNullValue.Double(double)

        val expected = "Unknown"
        val actual = notNullValue.string()

        assertEquals(expected, actual)
    }

    @Test
    fun test_success_fetch_string_from_double() {
        val double =  24.0
        notNullValue = NotNullValue.Double(double)

        val expected = "24.0"
        val actual = notNullValue.string()

        assertEquals(expected, actual)
    }

    @After
    fun clean() {
        notNullValue = NotNullValue.Empty
    }
}