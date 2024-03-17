package SummerBootServerMain
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringReader
import java.net.ServerSocket
import java.net.Socket

fun main(args: Array<String>) {

    val serviceSocket = ServerSocket(8989)
    //循环等待客户端连接
    while (true){
        //等待客户端socket连接
        val socket = serviceSocket.accept()
        println("客户端上线"+socket.inetAddress.hostAddress)

        //开启携程处理链接内容
        val coroutineScope = CoroutineScope(Dispatchers.Default)
        coroutineScope.launch(start = CoroutineStart.ATOMIC) {
            //发起一个异步处理的连接处理
            launch {
                handleSocket(socket)
            }
        }
        //等待连接结束
    }

}
//连接处理
suspend fun handleSocket(socket: Socket){
    val bufferReader = BufferedReader(InputStreamReader(socket.getInputStream()))
    while (true){
        delay(1000 )
        while (bufferReader.ready()){
            println("---")
            println(bufferReader.readText())
        }
    }
}
