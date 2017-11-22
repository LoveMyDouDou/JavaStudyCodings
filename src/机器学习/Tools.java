package 机器学习;

import java.util.HashSet;
import java.util.Random;

public class Tools {


    /**
     * 将一个数转换成定长为length的二进制数
     * @param num
     * @param length
     * @return
     */
    public static String convertToBinary(int num,int length){
        String t=Integer.toString(num,2);
        while (t.length()<length){
            t="0"+t;
        }
        return t;
    }

    /**
     * 生成N个长度为length的基因
     * @param N
     * @param length
     * @return
     */
    public static HashSet<Gene> createRandomNGeens(int N,int length,Gene target){
        HashSet<Gene> hashSet=new HashSet<Gene>();
        while (hashSet.size()<N){
            String geneSequence=createAGeen(length);
            Gene gene=new Gene(geneSequence);
            if(!hashSet.contains(gene)&&!gene.equals(target)){
                hashSet.add(gene);
            }
        }
        return hashSet;
    }


    /**
     * 生成一个长度为length的基因
     * @param length
     * @return
     */
    public static String createAGeen(int length){
        Random random=new Random();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<length;++i){
            stringBuilder.append(random.nextInt(2));
        }
        return stringBuilder.toString();
    }

}
