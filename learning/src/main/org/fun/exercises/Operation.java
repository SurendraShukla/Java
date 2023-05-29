package org.fun.exercises;

@FunctionalInterface
public interface Operation {
    int operate(int x, int y);

    default int anthorMethod(int x, int y) {
        return 0;
    }
}
