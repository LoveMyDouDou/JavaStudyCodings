package 小红书;

import java.util.*;

public class RED密码 {

    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        System.out.println(solve(s));
    }

    public static String solve(String s){
        ArrayList<String> arrayList=new ArrayList<String>();
        s=s.replace("RED","");
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                stringBuilder.append(s.charAt(i));
            }
            else {
                if(!stringBuilder.toString().equals("")){
                    arrayList.add(stringBuilder.toString());
                }
                stringBuilder=new StringBuilder();
            }
        }
        if(!stringBuilder.toString().equals("")){
            arrayList.add(stringBuilder.toString());
        }
        if(arrayList.size()==0){
            return "-1";
        }
        int index=0;
        for(String string:arrayList){
            boolean flag=false;
            while (string.length()>1&&string.charAt(0)=='0'){
                string=string.substring(1);
                flag=true;
            }
            if(flag){
                arrayList.remove(index);
                arrayList.add(string);
            }
            ++index;
        }

        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return -1;
                }
                else if(o1.length()<o2.length()){
                    return 1;
                }
                else {
                    return -o1.compareTo(o2);
                }
            }
        });
        return arrayList.get(0);

    }

}
