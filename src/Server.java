  
  
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket;

import redis.clients.jedis.Jedis;  
  
public class Server {  
    public static void main(String[] args) throws IOException {  
        ServerSocket server = new ServerSocket(5678);  
         Jedis jedis=Myjedis.getJedis();
         jedis.lpush("ul0", "0");
         jedis.lpush("ul1", "0");
         jedis.lpush("ul2", "0");
         jedis.lpush("ul3", "0");
         jedis.lpush("ul4", "0");
         jedis.lpush("ul5", "0");
         jedis.lpush("ul6", "0");
 
          while (true) {  
        	Socket client = server.accept();
        	 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));  
             PrintWriter out = new PrintWriter(client.getOutputStream());  
             String str = in.readLine();  
             
             System.out.println(str);
             
             String[] userdata=str.split("u");
             System.out.println(userdata[0]);
             jedis.lpush("ul"+userdata[0], userdata[1]);
           
            
        }  
        
    }  
}  
