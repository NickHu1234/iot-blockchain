import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
/**
 * MerkleTrees 
 * @author Jesse
 */
public class MerkleTrees {

    List<String> txList;
	
    String root;	

    public MerkleTrees(List<String> txList) {		
        this.txList = txList;
        root = "";
    }
                	/**
* execute merkle_tree and set root.
*/
    public void merkle_tree(){
        List<String> tempTxList = new ArrayList<String>();
                	
        for (int i = 0; i < this.txList.size(); i++) {
            tempTxList.add(this.txList.get(i));
        }
		
        List<String> newTxList = getNewTxList(tempTxList);
                	
        while(newTxList.size() != 1){
            newTxList = getNewTxList(newTxList);
        }		           	
        this.root = newTxList.get(0);
    }	
/**
 * return Node Hash List.
* @param tempTxList
* @return
 */private List<String> getNewTxList(List<String> tempTxList){
    List<String> newTxList = new ArrayList<String>();
    int index = 0;		
    while(index < tempTxList.size()){
	String left = tempTxList.get(index);
	index++;
			
	String right = "";			
                	
	if(index != tempTxList.size()){
		right = tempTxList.get(index);
	}			
	// sha2 hex value			
                	
	String sha2HexValue = getSHA2HexValue(left + right);
	newTxList.add(sha2HexValue);
	index++;
    }		
    return newTxList;
}	
/**
* Return hex string
* @param str
* @return*/

public String getSHA2HexValue(String str){		
    byte[] cipher_byte;               	
 try{
	MessageDigest md = MessageDigest.getInstance("SHA-256");
	md.update(str.getBytes());
	cipher_byte = md.digest();
	StringBuilder sb = new StringBuilder(2 * cipher_byte.length);			
                    	
        for(byte b: cipher_byte){
	    sb.append(String.format("%02x", b&0xff));
	}			
                    	
	return sb.toString();
}catch(Exception e){
	e.printStackTrace();
}		
                    	
 return "";
}	

public String getRoot(){
    return this.root;
}	
	
public static void main(String[] args) {
List<String> tempTxList = new ArrayList<String>();
tempTxList.add("a");
tempTxList.add("b");
tempTxList.add("c");
tempTxList.add("d");
tempTxList.add("e");
		
List<String> tempTxList2 = new ArrayList<String>();
tempTxList2.add("a");
tempTxList2.add("b");
tempTxList2.add("c");
tempTxList2.add("d");
tempTxList2.add("f");
		
MerkleTrees merkleTrees = new MerkleTrees(tempTxList);
MerkleTrees merkleTrees2 = new MerkleTrees(tempTxList2);
merkleTrees.merkle_tree();
merkleTrees2.merkle_tree();
System.out.println("root1:"+merkleTrees.getRoot());
System.out.println("root2:"+merkleTrees2.getRoot());
	
		
    }
}