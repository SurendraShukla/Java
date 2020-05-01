package me.surendra;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


public class Surendra {

    @Test
    public void throwableTesting() {
//        boolean boovar = false;
//        String str = String.valueOf(boovar);
//        System.out.println(str);
    }

    @Test
    public void keywordBulkUploadAll() {
        generateBulkKeywordScript(1, 500);
        generateBulkKeywordScript(501, 1000);
        generateBulkKeywordScript(1001, 1500);
        generateBulkKeywordScript(1501, 2000);
        generateBulkKeywordScript(2001, 2500);
        generateBulkKeywordScript(2501, 3000);
    }

    @Test
    public void keywordBulkUploadInBatches() {
        for(int counter=1; counter<=500; counter+=50) {
            generateBulkKeywordScript(counter, counter + 49);
        }
    }

    @Test
    public void addKeywordOneByOne() {
        System.out.println(generateOldKeywordScript(1, 500));
    }

    private List<String> generateOldKeywordScript(final int counterStart, final int counterEnd) {
        final List<String> keywords = Lists.newArrayList();
        for(int counter=counterStart; counter<= counterEnd; counter++ ) {
            keywords.add("'Test keyword " + counter + "'");
        }
        return keywords;
    }

    private void generateBulkKeywordScript(final int counterStart, final int counterEnd) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdsApp.bulkUploads().newCsvUpload(['Ad Group Id', 'Ad group', 'Keyword', 'Action'])");
        List<String> keywords = Lists.newArrayList();
        for(int counter=counterStart; counter<= counterEnd; counter++ ) {
            stringBuilder.append(".append({" +
                "'Ad Group Id': adGroupId," +
                "'Ad group': adGroupName," +
                "'Keyword': 'test ky " + counter + "'," +
                "'Action': 'add'" +
                "})");
        }
        stringBuilder.append(".forCampaignManagement().apply();");
        System.out.println(stringBuilder);
    }

    @Test
    public void test1() {
//        System.out.println(LocalDateTime.now().);

        //3 apple, 2 banana, others 1
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result = items.stream()
            .collect(
                groupingBy(Function.identity(), Collectors.counting())
            );

        Map<String, Long> finalMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        result.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
        System.out.println(System.getProperty("user.home"));
    }


    @Test
    public void surendraTest() {
//        System.out.println(getTmpCount(Lists.newArrayList(5, 10, 25), 10));
        System.out.println(getCoinsNeeded(new int[]{5, 10, 25}, 30));
//        getCoinsNeeded(new int[] {1, 5, 6, 9}, 11);
//        getCoinsNeeded(new int[] {1, 4, 5, 6, 9}, 11);
    }

    private List<Integer> getCoinsNeeded(final int[] coins, final int v) {
        List<Integer> coinsNeeded = Lists.newArrayList();

        for(int outer=0; outer<3; outer++) {
            coinsNeeded.add(coins[outer]);
            for (int inner=outer+1; inner<3; inner++) {
                long tmpCount = getTmpCount(coinsNeeded, coins[inner]);
                if (tmpCount == v) {
                    coinsNeeded.add(coins[inner]);
                    System.out.println(coinsNeeded);
                    return coinsNeeded;
                }
                if (tmpCount > v) {
                    if( coinsNeeded.size() == 1 ) {
                        coinsNeeded = Lists.newArrayList();
                        break;
                    }
                    coinsNeeded.remove(coinsNeeded.size()-1);
                }
                if (tmpCount < v) {
                    coinsNeeded.add(inner);
                }
            }
        }
        return Lists.newArrayList();
    }

    private long getTmpCount(final List<Integer> coinsNeeded, final int coin) {
        return coinsNeeded.stream().reduce((a, b) -> a+b).get() + coin;
    }


}


