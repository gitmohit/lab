package lab.mohit.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConstructorHierarchy {
    static class HolderSuperclass {
        protected int superValue;
        public HolderSuperclass() {
            System.out.println("Superclass constructor");
            superValue = 10;
        }
    }

    static class HolderSubclass extends HolderSuperclass {
        private int subValue;

        public HolderSubclass(int val) {
            System.out.println("Subclass constructor");
            subValue = val;
        }

        public void printValues() {
            System.out.println("superValue: " + superValue);
            System.out.println("subValue: " + subValue);
        }
    }

    static class HolderPublisher {
        private HolderSubclass holder;
        HolderPublisher() {
            holder = new HolderSubclass(33);
        }
        public HolderSubclass getHolder() {
            return holder;
        }
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> synchronizedList = Collections.synchronizedList(list);
        HolderSubclass holderSubclass = new HolderPublisher().getHolder();
        // If a concurrent thread calls geHolder() then there me be concurrency issue.
        holderSubclass.printValues();
    }

}
