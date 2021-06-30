package utils

object Math{

    val byteMaxVal = 255

    def pow(base:Long, exp:Long):Long = {
        assert(exp >= 0)

        exp match {
            case 0 => 1
            case 1 => base
            case _ => fastPow(base, exp)
        }
    }

    inline private def fastPow(base:Long, exp:Long):Long = {
        val halfPow =  pow(base, exp /2)
        (exp % 2) match {
            case 0 => halfPow * halfPow
            case _ => halfPow * halfPow * base
        }
    }

    def abs(i:Int):Int = {
        if(i < 0){
            -i
        }
        else{
            i
        }
    }

    def zeroOrPositiveModulo(n:Int, m:Int):Int = {
        if (n < 0)  {
            m - (abs(n) % m)  %m }
        else {
            n % m
        }
    }

    def toPositiveLong(d:Double):Long = {
        if( d < 0) {
            0
        }
        else{
            d.round;
        }
    }
}