package chapter14

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

fun main(args: Array<String>) {
    FtocTemplateMethod().run()
}

class FtocTemplateMethod : Application() {

    private lateinit var isr: InputStreamReader
    private lateinit var br: BufferedReader

    override fun init() {
        isr = InputStreamReader(System.`in`)
        br = BufferedReader(isr)
    }

    override fun idle() {
        val fahrString = readLineAndReturnNullIfError()
        if (fahrString.isNullOrBlank()) {
            setDone()
        } else {
            val fahr = fahrString!!.toDouble()
            val celsius = 5.0 / 9.0 * (fahr - 32)
            println("F=$fahr, C=$celsius")
        }
    }

    override fun cleanup() {
        br.close()
        isr.close()
        println("ftoc exit")
    }

    private fun readLineAndReturnNullIfError(): String? =
        try {
            br.readLine()
        } catch (e: IOException) {
            null
        }
}
