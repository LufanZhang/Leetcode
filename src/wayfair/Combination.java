package wayfair;

import java.security.MessageDigest;
import java.util.ArrayList;

public class Combination {
static String input = "87d516575f6860a4169f671e1130b5969659ccf8fa67ce5a6ae2f607ccd5b845f1763c3b39b50556b08ed6f6406ce44f66cc2a7baf4b34bd14333614d3088a4fb20701bc7b9fb2f554258ea7a91b2bdcde0375fc854d25616b5c6bc8091c0704b2b89cfc6503d69a4ceb06bb0985ccc85a19b7d2fbc4e2084d232db94866736cfc2e6d5dfbb829e0151db18d0286f27df9baf84656c9ccacc3c49bd17f7ea9e0b22274386fe6774437a02877a86da5248ba2d3967232d0db76493cef3b8eda4afc0674baa1882466aa78d574f42c0ca9da21c93072b93749ce63c830f825e3184e7dd27648ced986a5f0b6729e88517bcde142298a54f116e4e89ff9e92b8829bff0dd2c2f4527b2a7e0e5d2b8faa8022f58c2296aa360b7c8c3be1bbe4a7fd9ab5d287eb391bf8116635c293b7825cddbdc0bb564fc58647f9877d92c3cffedcf221bb24ea46a3e60318567d69da3cfa16beaa1f23bf35080ca3d8ab954372fb99ffe0085030ca9457a748635c5711428534d61571e031a02a9b7248da490c9e7dcfacc78eaa366957ca13bbf2bca73835fe98281addb296a8a21656f157f66eecc019912fac1fe0bbfa6b281ba8f8352e30697ed9a5a3ac7ce73177341f781";
	
    public static void main(String[] args)throws Exception
    {	//number of md5 hashs
    	int size = input.length()/32;   	
    	String[] md5s = new String[size];
    	for(int i=0; i<size; i++){
    		md5s[i] = input.substring(i*32, (i+1)*32);
    	}
    	//list for characters in email address
    	ArrayList<Character> nums = new ArrayList<Character>();    	    	
    	for(char c='a'; c<='z'; c++){
    		nums.add(c);
    		nums.add((char) (c - 'a' + 'A'));
    	}    	
    	for(char c='0'; c<='9'; c++)
    		nums.add(c);
    	
    	nums.add('.');
    	nums.add('@');
    	nums.add('+');
    	nums.add('_');
    	
    	String ans = new String();
    	for(int i=0; i<size; i++){
    		String tmp = result(nums, md5s[i], ans, i == size-1 ? 1 : 2);
    		ans = tmp;
    		//System.out.println(ans);
    	}
    	System.out.println(ans);
    }
    
    public static String result(ArrayList<Character> nums, String str, String guess, int num) throws Exception{
    	for(int i=0; i<nums.size(); i++){
    		for(int j=0; j<nums.size(); j++){
    			
    			String sb = new String(guess + nums.get(i) + nums.get(j));
    			String currentMd5 = generateMd5(generateMd5("zhanglufan.rutgers@gmail.com") + sb + generateMd5(sb));
    			
    			if(currentMd5.equals(str)){
    				return sb;
    			}
    		}
    	}
    	
    	if(num == 1){
    		for(int j=0; j<nums.size(); j++){
    			
    			String sb = new String(guess + nums.get(j));
    			String currentMd5 = generateMd5(generateMd5("zhanglufan.rutgers@gmail.com") + sb + generateMd5(sb));
    			
    			if(currentMd5.equals(str)){
    				return sb;
    			}
    		}
    	}
    	
    	return null;
    }
    
    public static String generateMd5(String s) throws Exception{
    	MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(s.getBytes());
        
        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
     
        return sb.toString();  
    }
}
