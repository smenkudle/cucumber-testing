/* 
 * Save this in a file called Main.java and compile it. To test it 
 * create the file `input.txt` in the workspace / Working Directory
 * (For Eclipse/VisualStudio, by default this is the top level project folder)
 */

/* Do not add a package declaration */
import java.util.*;

/* You may add any imports here, if you wish, but only from the 
   standard library */

public class CharInt {
    public static int process(String str) {
        char arr[] = str.toCharArray();
        int count = 0;
        List<Integer> arrList = new ArrayList<Integer>();
        for(char c: arr) {
        	int asc = (int) c;
        	if( asc >= 48 && asc <= 57)
        		count++;
        	else {
        		if(count > 0)
        			arrList.add(new Integer(count));
        		count = 0;
        	}
        }
        Optional<Integer> result = arrList.stream().reduce((i, j) -> i > j ? i : j);
        return result.isPresent() ? result.get() : 0;
    }

    public static void main (String[] args) {
        	System.out.println(process("I will eat 2 burgers 23 fries & 11.275 cokes l8888r"));
    }
}
