package me.surendra.design_patterns.Composite.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements File {
    private String name;

    private List<File> files = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(File file) {
        files.add(file);
    }

    public void remove(File file) {
        files.remove(file);
    }

    @Override
    public void print() {
        System.out.println("directory " + this.name + ":");
        for (File file : files) {
            file.print();
        }
    }
}
