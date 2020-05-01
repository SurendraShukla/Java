package me.surendra.design_patterns.Composite.file_system;

public class File implements FileSystem {
    private String content;

    public File(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}
