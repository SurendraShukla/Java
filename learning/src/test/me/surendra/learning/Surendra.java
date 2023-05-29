package me.surendra.learning;

import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Surendra {


    public static void main(String[] args)
    {

        Map<String, Integer> hashMap = new HashMap();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);

        hashMap.get("A");
        System.out.println(hashMap.get("A"));

        // 80018, 80050, 80187

        HashSet<String> audiences = Sets.newHashSet();
        audiences.add("Surendra");
        audiences.add("Suren");
        audiences.add("Suru");
        System.out.println(audiences);
//
//
//        HashMap<Character , Character> bracketList = new HashMap<>();
//        bracketList.put('}', '{');
//        bracketList.put(')', '(');
//        bracketList.put(']', '[');
//
//        Character closingBracket = '}';
//        System.out.println(bracketList.get(closingBracket));
//        System.out.println(bracketList);

//
//
//        List<Integer> list = Arrays.asList(12,5,45,18,33,24,40);
//        System.out.println(list);
//
//        List<? extends Number> foo1 = new ArrayList<Number>();
//        List<? extends Number> foo2 = new ArrayList<Integer>();
//        List<? extends Number> foo3 = new ArrayList<Double>();
//
////        List<List<Integer>> s = new ArrayList<List<Integer>>();
//        List<List<Integer>> s = new ArrayList<>();
//        s.add(list);
//        s.add(list);
//        System.out.println(s);
//
//
//        List<Pair<Integer, String>> result = new ArrayList<>();
//        result.add(new Pair<>(1, "1"));
//        result.add(new Pair<>(2, "2"));
//        System.out.println(result);

//
//        final Map<String, Object> params = Maps.newHashMap();
//        System.out.println(params);
//        params.put("runDate", "me.surendra");
//        System.out.println(params);
//

    }
}

/*

class Numbers {
    public static boolean isMoreThanFifty(int n1, int n2) {
        return (n1 + n2) > 50;
    }
    public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {

        List<Integer> newList = new ArrayList<>();

        for(Integer i : l) {
            if(p.test(i, i + 10)) {
                newList.add(i);
            }
        }
        return newList;

    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(12,5,45,18,33,24,40);
        System.out.println(list);

        List<Integer> newList = Numbers.findNumbers(list, new BiPredicate<Integer, Integer>() {
            public boolean test(Integer i1, Integer i2) {
                return Numbers.isMoreThanFifty(i1, i2);
            }
        });
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(newList);
        System.out.println(Numbers.findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2)));
        System.out.println(Numbers.findNumbers(list, Numbers::isMoreThanFifty));
        System.out.println(" ");
        System.out.println(" ");

        TreeMap<Integer, Object> treeMap = new TreeMap<>();
        treeMap.put(10, 10);
        treeMap.put(20, 20);
        System.out.println(treeMap);
    }

}*/
