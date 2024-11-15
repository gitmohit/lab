package lab.mohit.designPattern.strategy.impl;


import lab.mohit.designPattern.strategy.iface.IFileCopier;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class ZeroFileCopier implements IFileCopier {
    @Override
    public void copy(String fromPath, String toPath) {
        try {
            FileChannel inputChannel = new FileInputStream(fromPath).getChannel();
            FileChannel outChannel = new FileOutputStream(toPath).getChannel();
            long startMillis = System.currentTimeMillis();
            System.out.println("Starting zero copy at : " + startMillis);
            inputChannel.transferTo(0L, inputChannel.size(), outChannel);
            long endMillis = System.currentTimeMillis();
            System.out.println("Ending zero copy at : " + endMillis);
            System.out.println("Total seconds taken " + (endMillis - startMillis) / 1000.00);
            inputChannel.close();
            outChannel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
