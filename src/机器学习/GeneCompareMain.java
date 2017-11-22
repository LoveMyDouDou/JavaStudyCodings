package 机器学习;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import static 机器学习.Tools.convertToBinary;
import static 机器学习.Tools.createRandomNGeens;

public class GeneCompareMain {

    public static void main(String [] args){

        //应为大整数
        int geneLength=4;
        int binaryNum=1<<geneLength;
        System.out.println(binaryNum);

        int totalGeneMutation=0;
        for(int i=0;i<binaryNum;++i){
            Gene target=new Gene(convertToBinary(i,geneLength));
//            System.out.println("target:"+target);
            totalGeneMutation+=initGene(5,geneLength,target);
        }
        int averageGeneMutation=totalGeneMutation/binaryNum;
        System.out.println("当N="+binaryNum+"时 "+"平均基因突变次数:"+averageGeneMutation);


    }

    /**
     * 初始生成N个长度为length的基因
     * @param N
     * @param length
     * @param target
     */
    public static int initGene(int N,int length,Gene target){
        HashSet<Gene> geneHashSet=createRandomNGeens(N,length,target);
        for(Gene gene: geneHashSet){
            gene.calculateScore(target);
//            System.out.println(gene.getGene()+"    socre:"+gene.getScore());
        }
        int geneMutationNum=1;
        while (!geneMutation(geneHashSet,N,target)){
            ++geneMutationNum;
        }
//        System.out.println("基因突变目标代数:"+geneMutationNum);
//        System.out.println("-------------");
        return geneMutationNum;
    }

//    public static boolean geneMutation(HashSet<Gene> geneHashSet,int size,Gene target){
//        ArrayList<Gene> arrayList=new ArrayList<Gene>(size*2);
//        for(Gene gene:geneHashSet){
//            arrayList.add(gene);
//            Gene mutateGene=new Gene(gene.geneMutation());
//            mutateGene.calculateScore(target);
//            if(target.equals(mutateGene)){
//                return true;
//            }
//            arrayList.add(mutateGene);
//        }
//        Gene bestGene=getBestGeneMutation(arrayList);
//        geneHashSet.clear();
//        geneHashSet.add(bestGene);
//
//        return false;
//    }

    /**
     * 选择最优秀的基因
     * @param arrayList
     * @return
     */
    public static Gene getBestGeneMutation(ArrayList<Gene> arrayList){
        Gene best=arrayList.get(0);
        for(int i=1;i<arrayList.size();++i){
            if(arrayList.get(i).getScore()>best.getScore()){
                best=arrayList.get(i);
            }
        }
        return best;
    }









    public static boolean geneMutation(HashSet<Gene> geneHashSet,int size,Gene target){
        ArrayList<Gene> arrayList=new ArrayList<Gene>(size*2);
        for(Gene gene:geneHashSet){
            arrayList.add(gene);
            Gene mutateGene=new Gene(gene.geneMutation());
            mutateGene.calculateScore(target);
            if(target.equals(mutateGene)){
                return true;
            }
            arrayList.add(mutateGene);
        }
        Collections.sort(arrayList, new Comparator<Gene>() {
            @Override
            public int compare(Gene o1, Gene o2) {
                if(o1.getScore()>o2.getScore()){
                    return -1;
                }
                else if(o1.getScore()<o2.getScore()){
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });
        geneHashSet.clear();
        for(int i=0;i<size;++i){
            geneHashSet.add(arrayList.get(i));
        }
        return false;
    }

}
