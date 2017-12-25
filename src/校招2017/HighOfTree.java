package 校招2017;

import java.util.HashMap;
import java.util.Scanner;

public class HighOfTree {

    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        HashMap<Integer,Integer> deep=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> childNum=new HashMap<Integer,Integer>();

        deep.put(0,1);
        childNum.put(0,0);

        int max=1;
        int myDeep=0;

        for(int i=0;i<n-1;++i){
            int parent=scanner.nextInt();
            int num=scanner.nextInt();

            if(!deep.containsKey(parent)||childNum.get(parent)>=2){
                continue;
            }
            myDeep=deep.get(parent)+1;
            deep.put(num,myDeep);
            childNum.put(parent,(childNum.get(parent)+1));
            childNum.put(num,0);
            if(myDeep>max){
                max=myDeep;
            }
        }
        System.out.println(max);
    }

}
