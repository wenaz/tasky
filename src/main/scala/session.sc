object session{
  1+3
  def abs(x:Double)=if (x>0) x else -x
  def sqrt(x:Double)= {
    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < 0.001
    def improve(guess: Double): Double =
      (guess + x / guess) / 2
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    sqrtIter(1.0)
  }
  def factorial(n:Int):Int={
    def loop(acc:Int,n:Int):Int=
    if (n==0) acc
    else loop(acc*n,n-1)
    loop(1,n)
  }

  def mapReduce(f:Int=>Int,combine:(Int,Int)=>Int,zero:Int)(a:Int,b:Int):Int=
    if (a>b) zero
    else combine(f(a),mapReduce(f,combine,zero)(a+1,b))

  def product(f:Int=>Int)(a:Int,b:Int):Int=
    if (a>b) 1
    else product(f)(a+1,b)*f(a)

  def product2(f:Int=>Int)(a:Int,b:Int)=
    mapReduce(f,(x,y)=>x*y,1)(a,b)

  sqrt(2)
  sqrt(4)
  sqrt(1e-6)
  sqrt(1e60)
  factorial(4)
  def fact(n:Int)=product2(x=>x)(1,n)
  fact(5)

}