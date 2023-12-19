package me.surendra.leetcode.design;


/**
 * @see <a href="https://leetcode.com/problems/design-browser-history/">Design Browser History</a>
 */
public class BrowserHistory {

    class Page {
        String url;
        Page next;
        Page prev;
        boolean isHomePage = false;
        Page(final String url) {
            this.url = url;
        }
    }

    Page currentPage;
    public BrowserHistory(final String homepage) {
        currentPage = new Page(homepage);
        currentPage.isHomePage = true;
    }

    public void visit(final String url) {
        final Page newPage = new Page(url);

        currentPage.next = newPage;
        newPage.prev = currentPage;

        currentPage = newPage;
    }

    public String back(int steps) {
        while (!currentPage.isHomePage && steps > 0) {
            steps--;
            currentPage = currentPage.prev;
        }
        return currentPage.url;
    }

    public String forward(int steps) {
        while (currentPage.next != null && steps > 0) {
            steps--;
            currentPage = currentPage.next;
        }
        return currentPage.url;
    }

}
