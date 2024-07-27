package lab.mohit.designPattern.strategy.impl;

import lab.mohit.designPattern.strategy.iface.ifactrory.IFileCopierFactory;
import lab.mohit.designPattern.strategy.iface.IFileCopier;
import lab.mohit.designPattern.strategy.iface.IFileMigrator;

public class FileMigrator implements IFileMigrator {

    IFileCopierFactory copierFactory;
    public FileMigrator(IFileCopierFactory copierFactory) {
        this.copierFactory = copierFactory;
    }
    @Override
    public void copy(boolean isZeroCopy, String fromPath, String toPath) {
        IFileCopier copier = copierFactory.createFileCopier(isZeroCopy);
        copier.copy(fromPath, toPath);
    }
}
