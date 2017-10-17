package 牛客网纠错题目;

public class Test20171013 {

    public static void main(String [] args){
        StringBuffer s1=new StringBuffer(10);
        s1.append("1234");
        System.out.println(s1.length());
        System.out.println(s1.capacity());

        StringBuffer s2=new StringBuffer(2);
        s2.append("012");
        System.out.println(s2.capacity());

        StringBuffer s3=new StringBuffer(2);
        s3.append("0123456");
        System.out.println(s3.capacity());


    }

}
