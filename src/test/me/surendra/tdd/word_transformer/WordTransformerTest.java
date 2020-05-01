package me.surendra.tdd.word_transformer;

import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordTransformerTest {
    
//    @ATMDispenseChainTest
//    public void shouldReturnChainListForPassedInputAndOutputString() {
//        final List<String> stringList = transform("cat", "dog");
//    }
//

    @Test
    public void shouldReturnFirstTransforationOfCatList() {
        ArrayList<String> strings = Lists.newArrayList("Paused", "Active");
        System.out.println(strings);

        final List<String> stringList = transform("cat", "dog");
        Assert.assertThat(stringList, Matchers.hasItem("cot"));
    }


    @Test
    public void shouldReturnListOfFirstTransforationOfCat() {
        final List<String> stringList = transform("cat", "dog");
        Assert.assertThat(stringList.size(), Matchers.equalTo(3));

        final List<String> allCatTransformation = getAllTransformation("cat");
        Assert.assertThat(stringList, Matchers.hasItem("cot"));
    }

    private List<String> getAllTransformation(String input) {
        return Lists.newArrayList();
    }

    private List<String> transform(final String cat, final String dog) {
        return Lists.newArrayList("cot");
    }
}
