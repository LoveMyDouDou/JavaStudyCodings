package 网易互娱;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for(int t=0;t<T;++t){
            char [][] c=new char[8][8];
            for(int i=0;i<8;++i){
                String line=scanner.next();
                c[i]=line.toCharArray();
            }
            int N=scanner.nextInt();
            for(int n=0;n<N;++n){
                int x=scanner.nextInt();
                int y=scanner.nextInt();
                int tt=scanner.nextInt();
                transform(c,x,y,tt);
            }
            print(c);
            int black=countBlack(c);
            int white=countWhite(c);
            System.out.println(black+" "+white);
        }
    }

    public static void print(char [][] c){
        System.out.println("-----------");
        for(int i=0;i<8;++i){
            for(int j=0;j<8;++j){
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    public static int countBlack(char [][]c){
        int count=0;
        for(int i=0;i<8;++i){
            for(int j=0;j<8;++j){
                if(c[i][j]=='*'){
                    ++count;
                }
            }
        }
        return count;
    }
    public static int countWhite(char [][]c){
        int count=0;
        for(int i=0;i<8;++i){
            for(int j=0;j<8;++j){
                if(c[i][j]=='o'){
                    ++count;
                }
            }
        }
        return count;
    }

    public static void transform(char [][]c,int x,int y,int t){
        char newchar;
        if(t==0){
            newchar='*';
            c[x][y]=newchar;
            for(int i=0;i<8;++i){
                for(int j=0;j<8;++j){
                    if(i!=x&&j!=y){
                        if(c[i][j]=='*'){
                            handle(c,x,y,i,j,newchar);
                        }
                    }
                }
            }
        }
        else {
            newchar='o';
            c[x][y]=newchar;
            for(int i=0;i<8;++i){
                for(int j=0;j<8;++j){
                    if(i!=x&&j!=y){
                        if(c[i][j]=='o'){
                            handle(c,x,y,i,j,newchar);
                        }
                    }
                }
            }
        }

    }

    public static void handle(char [][] c,int x,int y,int i,int j,char newchar){
        if(i==x){
            boolean flag=true;
            for(int k=i;k<x;++k){
                if(c[k][j]=='.'){
                    flag=false;
                }
            }
            if(flag){
                for(int k=i;k<x;++k){
                    c[k][j]=newchar;
                }
            }
            flag=true;
            for(int k=x;k<i;++k){
                if(c[k][j]=='.'){
                    flag=false;
                }
            }
            if(flag){
                for(int k=x;k<i;++k){
                    c[k][j]=newchar;
                }
            }
        }
        else if(j==y){
            boolean flag=true;
            for(int k=j;k<y;++k){
                if(c[i][k]=='.'){
                    flag=false;
                }
            }
            if(flag){
                for(int k=j;k<y;++k){
                    c[i][k]=newchar;
                }
            }

            flag=true;
            for(int k=y;k<j;++k){
                if(c[i][k]=='.'){
                    flag=false;
                }
            }
            if(flag){
                for(int k=y;k<j;++k){
                    c[i][k]=newchar;
                }
            }
        }
        else {
            if(Math.abs(i-x)==Math.abs(y-j)){
                if(i>x&&j>y){
                    boolean flag=true;
                    for(int row=x;row<i;++row){
                        for(int col=y;col<j;++col){
                            if(c[row][col]=='.'){
                                flag=false;
                            }
                        }
                    }
                    if(flag){
                        for(int row=x;row<i;++row){
                            for(int col=y;col<j;++col){
                                c[row][col]=newchar;
                            }
                        }
                    }
                }
                else if(i>x&&j<y){
                    for(int row=x;row<i;++row){
                        for(int col=y;col>j;--col){
                            if(c[row][col]!='.'){
                                c[row][col]=newchar;
                            }
                            else {break;}
                        }
                    }
                }
                else if(i<x&&j>y){
                    boolean flag=true;
                    for(int row=x;row>i;--row){
                        for(int col=y;col<j;++col){
                            if(c[row][col]=='.'){
                                flag=false;
                            }
                        }
                    }
                    if(flag){
                        for(int row=x;row>i;--row){
                            for(int col=y;col<j;++col){
                                c[row][col]=newchar;
                            }
                        }
                    }
                }
                else {
                    boolean flag=true;
                    for(int row=x;row>i;--row){
                        for(int col=y;col>j;--col){
                            if(c[row][col]=='.'){
                                flag=false;
                            }
                        }
                    }
                    if(flag){
                        for(int row=x;row>i;--row){
                            for(int col=y;col>j;--col){
                                c[row][col]=newchar;
                            }
                        }
                    }
                }
            }
        }
    }

}
