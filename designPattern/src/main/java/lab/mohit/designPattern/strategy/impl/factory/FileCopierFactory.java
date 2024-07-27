package lab.mohit.designPattern.strategy.impl.factory;


import lab.mohit.designPattern.strategy.iface.ifactrory.IFileCopierFactory;
import lab.mohit.designPattern.strategy.iface.IFileCopier;
import lab.mohit.designPattern.strategy.impl.NonZeroFileCopier;
import lab.mohit.designPattern.strategy.impl.ZeroFileCopier;

public class FileCopierFactory implements IFileCopierFactory {
    @Override
    public IFileCopier createFileCopier(boolean isZero) {
        if (isZero) {
            return new ZeroFileCopier();
        } else {
            return new NonZeroFileCopier();
        }
    }
}
