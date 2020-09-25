package me.surendra.leetcode;

import java.util.Stack;

public class Directory {

    public String simplifyPath(String path) {
        final String[] directories = path.split("/");
        final Stack<String> directoryStack = new Stack<>();
        for (final String directory : directories) {
            if(directory.equals("") || directory.equals(".")) {
                continue;
            }else if(directory.equals("..")) {
                if (directoryStack.size() > 0) {
                    directoryStack.pop();
                }
            }else{
                directoryStack.push(directory);
            }
        }

        if (directoryStack.size() == 0) {
            return "/";
        }

        final StringBuilder stringBuilder = new StringBuilder();
        for (final String dir : directoryStack) {
            stringBuilder.append("/" + dir);
        }
        return stringBuilder.toString();
    }

}
