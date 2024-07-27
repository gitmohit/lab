package lab.mohit.designPattern;

import lab.mohit.designPattern.strategy.iface.IFileMigrator;
import lab.mohit.designPattern.strategy.impl.FileMigrator;
import lab.mohit.designPattern.strategy.impl.factory.FileCopierFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        IFileMigrator fileMigrator = new FileMigrator(new FileCopierFactory());
        String sourcePath = "/home/mohit/mylab/temp.txt";
        String targetPath = "/home/mohit/mylab/tempout_nonzero.txt";
        String targetPath1 = "/home/mohit/mylab/tempout_zero.txt";
        fileMigrator.copy(/*zeroCopy*/ true, sourcePath, targetPath);
        fileMigrator.copy(/*zeroCopy*/ false, sourcePath, targetPath1);
    }
}