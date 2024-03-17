package SummerBootServerMain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.ServerSocket
import java.net.Socket

fun main(args: Array<String>) {

    val serviceSocket = ServerSocket(8989)
    //循环等待客户端连接
    while (true){
        //等待客户端socket连接
        val socket = serviceSocket.accept()
        println("客户端上线"+socket.localAddress.hostAddress)
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
    while (true){
        var inputStream = socket.getInputStream();
        println(inputStream.read())
        println(">>>")
    }
}
