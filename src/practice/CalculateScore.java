package practice;

import java.io.*;

public class CalculateScore {
    public static void main(String [] args) throws IOException {
        String filepath="C:\\logs\\score1.txt";
        readfile(filepath);
    }

    public static void readfile(String filepath) throws IOException {
        File file=new File(filepath);
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        String line=null;
        double sumScore=0.0;
        int sumPower=0;
        while ((line=bufferedReader.readLine())!=null){
            String [] strings=line.split("\t");
            sumPower+=Integer.parseInt(strings[0]);
            sumScore+=Double.parseDouble(strings[1])*Integer.parseInt(strings[0]);
        }
        System.out.println("avg:"+sumScore/sumPower);
    }
}
