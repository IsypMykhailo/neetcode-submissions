class Twitter {
    class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    Map<Integer, Set<Integer>> followings;
    Map<Integer, List<Tweet>> tweets;
    int time;

    public Twitter() {
        followings = new HashMap();
        tweets = new HashMap();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        time++;
        tweets.putIfAbsent(userId, new ArrayList());
        tweets.get(userId).add(new Tweet(tweetId, time));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> queue = new PriorityQueue<>((Tweet a, Tweet b) -> b.time - a.time);

        if (tweets.containsKey(userId)) {
            queue.addAll(tweets.get(userId));
        }

        if (followings.containsKey(userId)) {
            for (int followeeId : followings.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    queue.addAll(tweets.get(followeeId));
                }
            }
        }

        List<Integer> feed = new ArrayList();
        for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
            feed.add(queue.poll().id);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        followings.putIfAbsent(followerId, new HashSet());
        followings.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followings.containsKey(followerId)) {
            followings.get(followerId).remove(followeeId);
        }
    }
}
