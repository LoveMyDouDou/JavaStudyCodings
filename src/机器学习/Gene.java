package 机器学习;

import java.util.Random;

public class Gene {
    private String gene;
    private int score;

    public Gene(){}
    public Gene(String gene){
        this.gene=gene;
    }
    public Gene(Gene gene){
        this.gene=gene.gene;
        this.score=gene.score;
    }

    /**
     * 覆写equals
     * @param obj
     * @return
     */
    public boolean equals (Object obj){
        // 地址相等，则肯定是同一个对象
        if(this==obj){
            return true;
        }
        // 类型不同，则肯定不是同一类对象
        if(!(obj instanceof Gene)){
            return false;
        }
        // 类型相同，向下转型
        Gene gene=(Gene) obj;

        if(this.gene.equals(gene.getGene()))
            return true;
        return false;
    }

    // 覆写hashCode方法
    public int hashCode(){
        return this.gene.hashCode();
    }

    public String toString(){
        return this.gene;
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    /**
     * 计算自己和目标基因的差值，来获得自己的分数
     * @param target
     */
    public void calculateScore(Gene target){
        String t=target.getGene();
        int sum=0;
        for(int i=0;i<t.length();++i){
            if(t.charAt(i)==this.gene.charAt(i)){
                ++sum;
            }
        }
        this.score=sum;
    }

    /**
     * 基因突变
     * @return
     */
    public String geneMutation(){
        int length=this.gene.length();
        Random random=new Random();
        int index=random.nextInt(length);
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<length;++i){
            if(i==index){
                if(this.gene.charAt(i)=='0'){
                    stringBuilder.append('1');
                }
                else {
                    stringBuilder.append('0');
                }
            }
            else {
                stringBuilder.append(this.gene.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 基因重组
     * @param gene
     */
    public void geneReorganization(Gene gene){
        Random random=new Random();
        int length=this.gene.length();
        //注意点，不然容易跑崩了
        int index=random.nextInt(length-1)+1;
        String s1=this.gene.substring(0,index)+gene.getGene().substring(index);
        String s2=gene.getGene().substring(0,index)+this.gene.substring(index);
        this.gene=s1;
        gene.setGene(s2);
    }

}
