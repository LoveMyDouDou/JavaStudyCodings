package leetcode;

public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        StringBuilder stringBuilder=new StringBuilder();
        int minLength=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;++i){
            if(strs[i].length()<minLength){
                minLength=strs[i].length();
            }
        }

        boolean flag=true;
        for(int i=0;i<minLength;++i){
            char temp=strs[0].charAt(i);
            for(int j=1;j<strs.length;++j){
                if(strs[j].charAt(i)!=temp){
                    flag=false;
                    break;
                }
            }
            if(!flag){
                break;
            }
            else {
                stringBuilder.append(temp);
            }
        }
        return stringBuilder.toString();
    }


}
