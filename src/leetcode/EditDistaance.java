package leetcode;

public class EditDistaance {

    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int [][] c=new int [m+1][n+1];
        for(int i=0;i<=m;++i){c[i][0]=i;}
        for(int j=0;j<=n;++j){c[0][j]=j;}
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    c[i][j]=c[i-1][j-1];
                }
                else {
                    c[i][j]=Math.min(c[i-1][j-1],Math.min(c[i-1][j],c[i][j-1]))+1;
                }
            }
        }
        return c[m][n];
    }

}
