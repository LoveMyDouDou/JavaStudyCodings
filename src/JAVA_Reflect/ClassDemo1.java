package JAVA_Reflect;

public class ClassDemo1 {
    public static void  main(String [] args) throws IllegalAccessException, InstantiationException {
        //Foo的实例对象如何表示
        Foo foo1=new Foo();

        //Foo这个类，也是一个实例对象，Class类的实例对象，如何表示呢
        //任何一个类都是Class类的实例对象，这个实例对象有三种表示方式


        //第一种表示方式
        //实际在告诉我们任何一个类都有一个隐含的静态成员变量class
        Class c1=Foo.class;

        //第二种表达方式 已经知道该类的对象，通过getClass方法
        Class c2=foo1.getClass();

        /**
         * 官网c1 c2表示了Fool类的类类型(class Type)
         * 万事万物皆对象，
         * 类也是对象，是Class类的实例对象
         * 这个对象我们称为该类的类类型
         */

        //不管c1 c2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
        System.out.println( c1==c2 );


        //第三种表达方式
        Class c3=null;
        try {
            c3=Class.forName("JAVA_Reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println( c2==c3 );

        //我们完全可以通过类的类类型创建该类的对象实例
        //通过 c1 c2 c3 创建Foo的实例
        try {
            Foo foo=(Foo) c2.newInstance();
        }
        catch (InstantiationException e){
            e.printStackTrace();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        }


    }
}

class Foo{}
