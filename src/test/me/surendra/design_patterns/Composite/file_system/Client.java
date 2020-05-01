package me.surendra.design_patterns.Composite.file_system;

import org.junit.Test;

public class Client {

    @Test
    public void test() {
        // We can add File or Directory into a Directory and handle them in the same way

        FileSystem file1 = new File("File 1");
        FileSystem file2 = new File("File 2");
        FileSystem file3 = new File("File 3");
        FileSystem file4 = new File("File 4");
        Directory directory1 = new Directory("directory1");
        Directory directory2 = new Directory("directory2");
        directory1.add(file1);
        directory1.add(file2);
        directory2.add(file3);
        directory2.add(file4);
        directory1.add(directory2);
        directory1.print();
    }
}
