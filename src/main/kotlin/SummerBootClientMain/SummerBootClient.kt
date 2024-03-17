package SummerBootClientMain

import java.io.OutputStreamWriter
import java.net.Socket

var ip=""
val port = 8989

fun main(args: Array<String>) {
    //创建socket
    val socket = Socket(ip,port)

    val outputStream = socket.getOutputStream()
    val outputWriter = OutputStreamWriter(outputStream)


}