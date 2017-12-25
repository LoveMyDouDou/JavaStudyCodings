package Java语言快速入门;


import org.junit.Test;

public class FreshJuice {

    enum FreshJuiceSize{SMALL,MEDIUM,LARGE}
    FreshJuiceSize size;

    @Test
    public void test(){
        FreshJuice juice=new FreshJuice();
        juice.size= FreshJuiceSize.MEDIUM;
        System.out.println("Size:"+juice.size);
    }

}
