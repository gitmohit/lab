package lab.mohit.designPattern.iterator.iface;

/* Aggregate i.e. collection*/
public interface IMenu<E> {
    Iterator<E> createIterator();
}
