package me.surendra.design_patterns.Adapter.Post;

public class TwitterAdapter implements iStatusUpdate{

    private final Twitter twitter;

    public TwitterAdapter(Twitter twitter) {
        this.twitter = twitter;
    }

    @Override
    public void getUserToken(String userId) {
        twitter.checkUserToken(userId);
    }

    @Override
    public void postUpdate(String message) {
        twitter.setStatusUpdate(message);
    }
}
