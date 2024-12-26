import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PrimeUtilsSpec extends AnyFlatSpec with Matchers {

  "primes" should "generate the first 20 prime numbers" in {
    val expectedPrimes = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71)
    PrimeUtils.primes().take(20).toList shouldEqual expectedPrimes
  }

  "pRange" should "return primes within the specified range" in {
    val expectedPrimes = List(101, 103, 107, 109, 113, 127, 131, 137, 139, 149)
    PrimeUtils.pRange(100, 150) shouldEqual expectedPrimes
  }

  it should "count the number of primes in a given range" in {
    val count = PrimeUtils.pRange(7700, 8000).length
    count shouldEqual 30
  }

  "The 10,000th prime" should "be 104729" in {
    PrimeUtils.primes().drop(9999).head shouldEqual 104729
  }
}
