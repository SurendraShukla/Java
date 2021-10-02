package me.surendra.leetcode.backtracking;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class GenerateParenthesesTest {

    @Test
    public void name() {
//        final String[] str = {"()()()() ", "(((())))", "((()()))", "(()())()", "((()))()", "()(()())", "()((()))", "(()(()))", "()()(())", "(())(())", "(())()()", "()(())()", "()(())()"};
//        HashSet<String> strings = Sets.newHashSet("()()()() ", "(((())))", "((()()))", "(()())()", "((()))()", "()(()())", "()((()))", "(()(()))", "()()(())", "(())(())", "(())()()", "()(())()", "()(())()");
//        System.out.println(str.length);
//        System.out.println(strings.size());

        List<String> arrayList = Lists.newArrayList("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()");
        arrayList.stream().sorted();
        System.out.println(arrayList.size());
        System.out.println(arrayList.stream().collect(Collectors.toSet()).size());

        final List<String> list = new GenerateParentheses().generateParenthesis(3);
        System.out.println(list.size());
        System.out.println(list);

//        for(int i=1; i<=4; i++) {
//            final List<String> list = new GenerateParentheses().generateParenthesis(i);
//            System.out.println(list);
//            System.out.println(list.size());
//        }
    }
}
