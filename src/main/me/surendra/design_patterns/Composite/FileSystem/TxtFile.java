package me.surendra.design_patterns.Composite.FileSystem;

public class TxtFile implements File {
    private String content;

    public TxtFile(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}
