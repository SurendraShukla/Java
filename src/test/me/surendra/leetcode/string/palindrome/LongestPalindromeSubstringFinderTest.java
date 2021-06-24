package me.surendra.leetcode.string.palindrome;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LongestPalindromeSubstringFinderTest {

    private String callMethod(final String input) {
        return new LongestPalindromeSubstringFinder().longestPalindrome(input);
    }

    @Test
    public void test1() {
        assertThat(callMethod("babad"), equalTo("bab"));
//        assertThat(callMethod("cbbd"), equalTo("bb"));
//        assertThat(callMethod("a"), equalTo("a"));
//        assertThat(callMethod("ac"), equalTo("a"));
//        assertThat(callMethod("SQQSYYSQQS"), equalTo("SQQSYYSQQS"));
    }

    @Test
    public void test2() {
        callMethod("pihoigwlvzvtrugdolvtzrkyelaqdvbijzmkhebzawboaxkdjyfocpewwztffuaibcqurwwmijmvrnpfcoglyxpxkrbhupoxcafabxtoecodsjgngrionuvzaiigevuvruxxiwpjzjlqgenglhprcgzgpdzabrjhkbtfrbmwpcszepxhwiwdhvnpsmhhaiqsbeiwsaeomqtzcpjzfknejxlxwtpkufanhuoyjgihdzhtxnyctazzvnttjspfztjurdwmmzrvobcatkorfhpieoqfetcglembkgbexsznuduhrfoxkbswkanqwfkoktnnujqetijaqhrxuhkgsezfdrncbaltctwcourdbpdwhqlsxfwsoaduaqkbjeekwwykptjthhtokrvzsuelsywyznqscnwiszogzqvfsgggzltlvzkllinpfaigswquqfvabbzvestwxhbnfjhnvfhyxalchmtkcwnyyrbwjsoqooypwteozbivqiyldpqlykxinmzkgnmfbobgjivlzubfen");
    }

}
