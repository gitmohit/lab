package lab.mohit.designPattern.strategy.iface;

public interface IFileMigrator {
    void copy(boolean isZeroCopy, String fromPath, String toPath);
}
