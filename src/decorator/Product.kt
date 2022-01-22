package decorator

interface Product {

    fun price() : Int

    fun newPrice(mathOperation: MathOperation) : Product

    class Milk(
        private val price: Int
    ) : Product {

        override fun price(): Int = price

        override fun newPrice(mathOperation: MathOperation): Product
            = Milk(
                mathOperation.calculate(price)
            )
    }

    class PercentageMilk(
        private val product: Product
    ) : Product {

        override fun price(): Int = product.newPrice(MathOperation.Diff(10)).price()
        override fun newPrice(mathOperation: MathOperation): Product = Product.Milk(0)
    }


}