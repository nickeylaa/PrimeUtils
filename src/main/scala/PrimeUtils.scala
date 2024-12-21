import scala.math.sqrt

object PrimeUtils {
  // Генератор простых чисел
  def primes(): LazyList[Int] = {
    def isPrime(n: Int): Boolean = {
      if (n < 2) false
      else !(2 to sqrt(n).toInt).exists(d => n % d == 0)
    }
    def loop(n: Int): LazyList[Int] = {
      if (isPrime(n)) n #:: loop(n + 1)
      else loop(n + 1)
    }
    loop(2) // Начинаем с 2, так как это первое простое число
  }
  // Функция для получения простых чисел в заданном диапазоне
  def pRange(lowerInclusive: Int, upperExclusive: Int): List[Int] = {
    primes().takeWhile(_ < upperExclusive).filter(_ >= lowerInclusive).toList
  }
  def main(args: Array[String]): Unit = {
    // Первые 20 простых чисел
    println("The first twenty primes:\n  " + primes().take(20).toList)
    // Простые числа между 100 и 150
    println("The primes between 100 and 150:\n  " + pRange(100, 150))
    // Количество простых чисел между 7,700 и 8,000
    println("The number of primes between 7,700 and 8,000:\n  " + pRange(7700, 8000).length)
    // 10,000-е простое число
    println("The 10,000th prime:\n  " + primes().drop(9999).head) // Индекс 9999 для 10,000-го числа
  }
}
