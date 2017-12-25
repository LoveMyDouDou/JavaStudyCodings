package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=left;i<=right;++i){
            if(isSelfDividingNumber(i)){
                list.add(i);
            }
        }
        return list;
    }

    public static boolean isSelfDividingNumber(int x){
        String s=""+x;
        for(int i=0;i<s.length();++i){
            int div=Integer.parseInt(""+s.charAt(i));
            if(div==0){
                return false;
            }
            if(x%div!=0){
                return false;
            }
        }
        return true;
    }

}
