package practice;

import java.io.*;

public class ReadFile {


    public static void main(String [] args) throws IOException {
        String filepath="C:\\read_in";
        readfile(filepath);
    }

    public static void  readfile(String filepath) throws IOException {
        File file=new File(filepath);
        String [] files=file.list();
        double accuracy1NN=0.0;
        double accuracy3NN=0.0;
        double accuracy5NN=0.0;
        double accuracySVM=0.0;
        double accuracyJ48=0.0;
        double DR1NN=0.0;
        double DR3NN=0.0;
        double DR5NN=0.0;
        double DRSVM=0.0;
        double DRJ48=0.0;
        int count=0;

        for(int i=0;i<files.length;++i){
            File currentFile=new File(files[i]);
            BufferedReader bufferedReader=new BufferedReader(new FileReader(filepath+"\\"+currentFile.getName()));
            String line=null;
            while ((line=bufferedReader.readLine())!=null){
                if(count==0||count==1){
                    if(line.startsWith("accuracy")){
                        accuracy1NN+=Double.parseDouble(line.split("=")[1]);
                        ++count;
                    }
                    if(line.startsWith("DR")){
                        DR1NN+=Double.parseDouble(line.split("=")[1]);
                        ++count;
                    }
                }
                else if (count==2||count==3){
                    if(line.startsWith("accuracy")){
                        accuracy3NN+=Double.parseDouble(line.split("=")[1]);
                        ++count;
                    }
                    if(line.startsWith("DR")){
                        DR3NN+=Double.parseDouble(line.split("=")[1]);
                        ++count;
                    }
                }
                else if (count==4||count==5){
                    if(line.startsWith("accuracy")){
                        accuracy5NN+=Double.parseDouble(line.split("=")[1]);
                        ++count;
                    }
                    if(line.startsWith("DR")){
                        DR5NN+=Double.parseDouble(line.split("=")[1]);
                        ++count;
                    }
                }
                else if (count==6||count==7){
                    if(line.startsWith("accuracy")){
                        accuracySVM+=Double.parseDouble(line.split("=")[1]);
                        ++count;
                    }
                    if(line.startsWith("DR")){
                        DRSVM+=Double.parseDouble(line.split("=")[1]);
                        ++count;
                    }
                }
                else if (count==8||count==9){
                    if(line.startsWith("accuracy")){
                        accuracyJ48+=Double.parseDouble(line.split("=")[1]);
                        ++count;
                    }
                    if(line.startsWith("DR")){
                        DRJ48+=Double.parseDouble(line.split("=")[1]);
                        count=0;
                    }
                }
            }
        }

        final int N=2;
        System.out.println("accuracy1NN="+accuracy1NN/N);
        System.out.println("DR1NN="+DR1NN/N);
        System.out.println();
        System.out.println("accuracy3NN="+accuracy3NN/N);
        System.out.println("DR3NN="+DR3NN/N);
        System.out.println();
        System.out.println("accuracy5NN="+accuracy5NN/N);
        System.out.println("DR5NN="+DR5NN/N);
        System.out.println();
        System.out.println("accuracySVM="+accuracySVM/N);
        System.out.println("DRSVM="+DRSVM/N);
        System.out.println();
        System.out.println("accuracyJ48="+accuracyJ48/N);
        System.out.println("DRJ48="+DRJ48/N);
        System.out.println();

    }


}
