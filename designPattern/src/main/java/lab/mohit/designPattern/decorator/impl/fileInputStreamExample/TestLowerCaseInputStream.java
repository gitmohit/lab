package lab.mohit.designPattern.decorator.impl.fileInputStreamExample;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestLowerCaseInputStream {
    public static void main(String[] args) {
        try {
            InputStream lowercaseInputStream = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("/home/mohit/mylab/lab/designPattern/src/main/java/lab/mohit/designPattern/decorator/impl/fileInputStreamExample/Test.txt")));
            while(true) {
                int ch = lowercaseInputStream.read();
                if(ch==-1) {
                    break;
                }
                System.out.print((char)ch);
            }
            lowercaseInputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
