package lab.mohit.designPattern.strategy.impl;


import lab.mohit.designPattern.strategy.iface.IFileCopier;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class NonZeroFileCopier implements IFileCopier {
    @Override
    public void copy(String fromPath, String toPath) {
        try {
            FileInputStream inputStream = new FileInputStream(fromPath);
            FileOutputStream outputStream = new FileOutputStream(toPath);
            long startMillis = System.currentTimeMillis();
            System.out.println("Starting non zero copy at : " + startMillis);
            inputStream.transferTo(outputStream);
            long endMillis = System.currentTimeMillis();
            System.out.println("Ending zero copy at : " + endMillis);
            System.out.println("Total seconds taken " + (endMillis - startMillis) / 1000.00);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
