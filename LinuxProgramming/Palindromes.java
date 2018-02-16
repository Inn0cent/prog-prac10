
/**
 * Write a description of class Palindromes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Palindromes
{
    
    String str;
    
    public static void main(String[] args){
        String st = "";
        for(String s : args){
            st += s + " ";
        }
        Palindromes check = new Palindromes(st);
        check.test();
    }
    
    public Palindromes(String newString)
    {
        str = newString;
    }
    
    public void test(){
        boolean flag = true;
        String st = str.replaceAll("\\s","");
        st = st.toLowerCase();
        for (int i = 0; i < st.length()*1.0/2; i++){
            if(st.charAt(i) != st.charAt(st.length()-1-i)){
                flag = false;
            }
        }
        if(flag){
            System.out.println(str + "is a palindrome");
        }else{
            System.out.println(str + "is not a palindrome");
        }
    }
}
