package lab.mohit.designPattern.strategy.iface.ifactrory;


import lab.mohit.designPattern.strategy.iface.IFileCopier;

public interface IFileCopierFactory {
    IFileCopier createFileCopier(boolean isZero);
}
