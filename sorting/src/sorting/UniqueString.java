package sorting;
import java.lang.reflect.Array;
import java.util.Arrays;

 public class UniqueString {
   
    private String inputString;
   
    public UniqueString(String input){
        inputString = input;
    }
    
    public boolean UsingSorting(){
       if(inputString.length() > 256) {
           return false;
       }
       
       char [] charArray = inputString.toCharArray();
       Arrays.sort(charArray);
       for(int i =0; i < charArray.length; i++)
       {
           if(charArray[i] == charArray[i+1]) {
               return false;
           }
       }
       return true;
    }
    
    
    public boolean UsingDataStructure()
    {
        if(inputString.length() > 256) {
            return false;
        }
        else {
            boolean [] checkArray = new boolean[256];
            Arrays.fill(checkArray, false);
          
            for(int i = 0; i < inputString.length(); i++) {
                int index = inputString.charAt(i);
                if(checkArray[index]) {
                    return false;
                }
                else {
                    checkArray[index] = true;
                }
            }
        }
        return true;
    }
    
    public static void main(String [] args)
    {
        UniqueString newString = new UniqueString("HA");
        if (newString.UsingDataStructure() == false) {
            System.out.println("There is duplicates");
        }
        else {
            System.out.println("There is no duplicates");
        }
    }
}
