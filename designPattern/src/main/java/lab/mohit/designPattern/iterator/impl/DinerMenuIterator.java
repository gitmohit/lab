package lab.mohit.designPattern.iterator.impl;

import lab.mohit.designPattern.iterator.iface.Iterator;

public class DinerMenuIterator implements Iterator<MenuItem> {
    private final MenuItem[] menuItems;
    private int lastIndex;
    public DinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
        this.lastIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return lastIndex < menuItems.length && menuItems[lastIndex] != null;
    }

    @Override
    public MenuItem next() {
        return menuItems[lastIndex++];
    }
}
