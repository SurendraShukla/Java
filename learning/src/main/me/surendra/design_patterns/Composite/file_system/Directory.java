package me.surendra.design_patterns.Composite.file_system;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    private String name;

    private List<FileSystem> fileSystems = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystem fileSystem) {
        fileSystems.add(fileSystem);
    }

    public void remove(FileSystem fileSystem) {
        fileSystems.remove(fileSystem);
    }

    @Override
    public void print() {
        System.out.println("directory " + this.name + ":");
        for (FileSystem fileSystem : fileSystems) {
            fileSystem.print();
        }
    }
}
