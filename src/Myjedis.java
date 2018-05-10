 

import redis.clients.jedis.Jedis;

public class Myjedis {

	  
	    private static Jedis jedis = new Jedis();  
	    private Myjedis(){}  
	    public static Jedis getJedis(){ 
	     
	        jedis = new Jedis("localhost", 6379); 
	        
	        jedis.select(0);
	        return jedis;  
	    }  
}
