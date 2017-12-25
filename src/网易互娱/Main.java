package 网易互娱;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for(int t=0;t<T;++t){
            String add1=scanner.next();
            String add2=scanner.next();
            String sum=scanner.next();
            int ans=0;
            ArrayList<Integer> a1=getNumbers(add1);
            ArrayList<Integer> a2=getNumbers(add2);
            ArrayList<Integer> s=getNumbers(sum);
            for(int i=0;i<a1.size();++i){
                for(int j=0;j<a2.size();++j){
                    for(int k=0;k<s.size();++k){
                        if((a1.get(i)+a2.get(j))==s.get(k)){
                            ++ans;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static ArrayList<Integer> getNumbers(String number){
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add(number);
        boolean [] b=new boolean[1];
        do{
            b[0]=true;
            arrayList=replaceX(arrayList,b);
        }
        while (!b[0]);
        ArrayList<Integer> alist=convert(arrayList);
        return alist;
    }

    public static ArrayList<String> replaceX(ArrayList<String> arrayList,boolean [] b){
        ArrayList<String> ans=new ArrayList<String>();
        for(int i=0;i<arrayList.size();++i){
            if(arrayList.get(i).contains("X")){
                b[0]=false;
                for(int j=1;j<=9;++j){
                    ans.add(arrayList.get(i).replaceFirst("X",""+j));
                }
            }
            else {
                ans.add(arrayList.get(i));
            }
        }
        return ans;
    }

    public static ArrayList<Integer> convert(ArrayList<String> alist){
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        for(int i=0;i<alist.size();++i){
            arrayList.add(Integer.parseInt(alist.get(i)));
        }
        return arrayList;
    }



}
