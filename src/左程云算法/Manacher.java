package 左程云算法;

public class Manacher {

    public char [] manacherString(String string){
        char [] charArr=string.toCharArray();
        char [] res=new char[string.length()*2+1];
        int index=0;
        for(int i=0;i!=res.length;++i){
            res[i]=(i&1)==0?'#':charArr[index++];
        }
        return res;
    }

    public int maxLcpsLength(String str){
        return 0;
    }

}
