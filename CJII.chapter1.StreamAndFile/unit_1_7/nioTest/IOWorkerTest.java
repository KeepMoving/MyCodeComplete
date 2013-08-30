package unit_1_7.nioTest;
/*
 * 下面是一个简单的使用多路复用I/O的服务器实现。
 * 当有客户端连接上的时候，服务器会返回一个Hello World作为响应。
 * */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

public class IOWorkerTest 
{
	public static void main(String[] args) 
	{
		IOWorker ioworker = new IOWorker();
		Thread thread = new Thread(ioworker);
		thread.start();
	}
}

class IOWorker implements Runnable 
{
    public void run() 
    {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            ServerSocket socket = channel.socket();
            socket.bind(new InetSocketAddress("localhost", 10800));
            channel.register(selector, channel.validOps());
            while (true) {
                selector.select();
                Iterator iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = (SelectionKey)iterator.next();
                    iterator.remove();
                    if (!key.isValid()) {
                        continue;
                    }
                    if (key.isAcceptable()) {
                        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, sc.validOps()); 
                    }
                    if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        Charset charset = Charset.forName("UTF-8");
                        CharsetEncoder encoder = charset.newEncoder();
                        CharBuffer charBuffer = CharBuffer.allocate(32);
                        charBuffer.put("Hello World");
                        charBuffer.flip();
                        ByteBuffer content = encoder.encode(charBuffer);
                        client.write(content);
                        key.cancel();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}