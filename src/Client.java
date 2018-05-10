 
  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;  
import java.net.InetAddress;  
import java.net.Socket;  
  
public class Client {  
    static Socket socket;  
  
    public static void main(String[] args) throws Exception {  
    	socket = new Socket(InetAddress.getLocalHost(), 5678);  
        
        
        
      //向服务器端程序发送数据
      OutputStream outputStream = socket.getOutputStream();
      OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
      BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
      bufferedWriter.write("hello server, can you receiver my data?");
      bufferedWriter.flush();
      bufferedWriter.close();
      socket.close();
      System.out.println("finish send data!!");
        
        
    }  
}  