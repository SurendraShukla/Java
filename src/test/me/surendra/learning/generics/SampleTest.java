package me.surendra.learning.generics;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SampleTest {

    @Test
    public void fruit() {
        Sample.useFruit(new Banana());
        Sample.useFruit(new Orange());
    }

    @Test
    public void canNotPassBananasToFruitListDueToCollectionIssueWithInheritance() {
        final List<Banana> fruitBasket = Lists.newArrayList();
        fruitBasket.add(new Banana());

        // Below line won't compile
//        Sample.useFruitBasket(fruitBasket);
    }

    @Test
    public void noGenericMethod() {
        final List<T> tList1 = Lists.newArrayList();
        tList1.add(new T());

        Sample.nonGenericMethod(tList1);

        final List<Banana> bananaList = Lists.newArrayList();
        bananaList.add(new Banana());

        // Below line won't compile
//        Sample.nonGenericMethod(bananaList);
    }

    @Test
    public void passFruitsToFruitLists() {
        final List<Fruit> fruitBasket = Lists.newArrayList();
        fruitBasket.add(new Banana());
        fruitBasket.add(new Orange());

        Sample.useFruitBasket(fruitBasket);
        System.out.println(fruitBasket);
    }

    @Test
    public void copyFruitsFromOneFruitBasketToAnotherFruitBasket() {
        final List<Fruit> fruitsBasket1 = Lists.newArrayList();
        fruitsBasket1.add(new Banana());
        fruitsBasket1.add(new Orange());

        final List<Fruit> fruitBasket2 = Lists.newArrayList();
        Sample.copyFruits(fruitsBasket1, fruitBasket2);

        assertThat(fruitBasket2.size(), equalTo(2));
    }

    @Test
    public void canNotCopyBananasFromBananaBasketToFruitBasket() {
        final List<Banana> bananaBasket = Lists.newArrayList();
        bananaBasket.add(new Banana());

        final List<Fruit> fruitBasket = Lists.newArrayList();

//        Below line won't compile
//        Sample.copyFruits(bananaBasket, fruitBasket);
    }

    @Test
    public void copyBananasFromBananaBasketToFruitBasket() {
        final List<Banana> bananaBasket = Lists.newArrayList();
        bananaBasket.add(new Banana());

        final List<Fruit> fruitBasket = Lists.newArrayList();

        Sample.copyFruitsUsingLowerBound(bananaBasket, fruitBasket);
    }

    @Test
    public void copyBananasFromBananaBasketToFruitBasket2() {
        final List<Banana> bananaBasket = Lists.newArrayList();
        bananaBasket.add(new Banana());

        final List<Fruit> fruitBasket = Lists.newArrayList();

        Sample.copyFruitsUsingUpperBound(bananaBasket, fruitBasket);
    }

    @Test
    public void parameterizedTypeBondLevelDefinedBeforeMethodReturn() {
        List<Integer> list1 = Lists.newArrayList();
        list1.add(10);
        List<Integer> list2 = Lists.newArrayList();
        list2.add(10);

        assertThat(Sample.isFirstElementSame(list1, list2), equalTo(true));

        List<Fruit> fruitList1 = Lists.newArrayList();
        fruitList1.add(new Fruit());
        List<Fruit> fruitList2 = Lists.newArrayList();
        fruitList2.add(new Fruit());

//        Below line won't compile
//        assertThat(Sample.isFirstElementSame(fruitList1, fruitList2), equalTo(true));
    }

    @Test
    public void explicitTypeParameterToResolveTypeReferenceIssue() {
        final Set<Integer> ints = Sets.newHashSet();
        final Set<Double> doubles = Sets.newHashSet();

//        Below code won't compile sometime. Compiler is able to infers type properly.
        Set<Number> union = Sample.union(ints, doubles);

//        Explicit type parameter so that compiler can infer types proper
        Set<Number> nums = Sample.<Number>union(ints, doubles);
    }

}
