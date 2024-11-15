package lab.mohit.designPattern.iterator.impl;

import lab.mohit.designPattern.iterator.iface.Iterator;

import java.util.List;

public class PancakeHouseMenuIterator implements Iterator<MenuItem> {
    private final List<MenuItem> menuItems;
    int lastIndex;
    public PancakeHouseMenuIterator(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.lastIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return !menuItems.isEmpty() && menuItems.size() > lastIndex;
    }

    @Override
    public MenuItem next() {
        try {
            return menuItems.get(lastIndex);
        } finally {
            lastIndex++;
        }
    }
}
