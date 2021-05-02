package test;
import java.util.*;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;
public class count {
    public static void main( String[ ] args ) throws Exception {
        Scanner sc=new Scanner(System.in);

String st=sc.nextLine();
        String[] arr=st.split(" ");
        String str=arr[0];     //控制参数
        String filename=arr[1];//文本文件名称

        File dir=new File("src/test");//dir为执行程序所在目录
        File[]files=dir.listFiles();
        File file = null;     //文本所在地址

        for(File filed :files)  //根据文本名称检索文件并返回地址
        {
            if(filed.isFile() && filename.equals(filed.getName())){
                file=filed.getAbsoluteFile();
                break;
            }
        }

        FileReader reader =new FileReader(file);
        int len =(int)file.length();
        char[] ch=new char[len];
        reader.read(ch);
        reader.close();
        String string=String.valueOf(ch);//将数组转化为字符串
        int count = 0;
        int n = ch.length;
        if(str.equals("-c")){
            for(int i = 0; i < n ; i++)
            {
                if((ch[i] >= 'a' && ch[i] <= 'z')||ch[i]==' '||ch[i]=='\t'||ch[i]=='\n'|| (ch[i] >= '0' && ch[i] <= '9'))
                {
                    count++;
                }
            }
            System.out.println("字符数"+count);
        }else if(str.equals("-w")){
            string=string.trim();
            String regex = "\\s+";
            string = string.replaceAll(regex, ",");//通过正则表达式把中间的空格转化为逗号
            String[] arr1 = string.split(",");//用逗号把字符串分割为数组
            StringBuilder sb1 = new StringBuilder();
            int count1=1;
            for (int i = 0 ; i < arr1.length ; i++) {
                String s = arr1[i].trim();
                if (s!= null && !s.equals("")) {
                    sb1.append(s);//如果该数组不为空，则生成到新字符串里
                    if (i != arr1.length-1) {
                        sb1.append(",");//如果不是最后一个数组，就在数组后加逗号
                    }
                }
            }
            String sb2=sb1.toString();
            String[] arr2 = sb2.split(",");//最后将新生成的字符串用逗号相隔，数组的个数就是单词的个数
            count1=arr2.length;


            System.out.println("单词数"+count1);
        }

}
}
