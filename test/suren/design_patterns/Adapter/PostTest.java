package suren.design_patterns.Adapter;

import suren.design_patterns.Adapter.Post.Facebook;
import suren.design_patterns.Adapter.Post.Twitter;
import suren.design_patterns.Adapter.Post.TwitterAdapter;

public class PostTest {

    public static void main(String[] args) {

        Facebook facebook = new Facebook();
        facebook.getUserToken("123");
        facebook.postUpdate("Message for Facebook");

        Twitter twitter = new Twitter();
        TwitterAdapter adaptedTwitter = new TwitterAdapter(twitter);
        adaptedTwitter.getUserToken("420");
        adaptedTwitter.postUpdate("Message for Twitter");

    }

}
