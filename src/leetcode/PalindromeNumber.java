package leetcode;

public class PalindromeNumber {


    public static void main(String [] args){
        System.out.println(new PalindromeNumber().isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        StringBuilder stringBuilder=new StringBuilder(Integer.valueOf(x).toString());
        for(int i=0;i<stringBuilder.length()/2;++i){
            if(stringBuilder.charAt(i)!=stringBuilder.charAt(stringBuilder.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
