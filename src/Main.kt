import decorator.Product

fun main() {
    val milk = Product.Milk(
        30
    )
    val percentageMilk = Product.PercentageMilk(milk)

    println("milk price: ${milk.price()}, percentage milk price: ${percentageMilk.price()} ")
}