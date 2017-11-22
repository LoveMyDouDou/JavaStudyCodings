package java核心技术卷I.Chapter3;

import java.util.stream.StreamSupport;

public class ArrayDemo {



    public static void main(String [] args){
        //数组初始化
        //    int [] smallPrimes={2,3,5,7,11,13};
        int [] smallPrimes=new int[]{2,3,5,7,11,13};

        //数组拷贝
        int [] luckyNumbers={1001,1002,1003,1004,1005,1006,1007};

        System.arraycopy(smallPrimes,2,luckyNumbers,3,4);
        for(Integer integer:luckyNumbers){
            System.out.println(integer);
        }
    }

}
