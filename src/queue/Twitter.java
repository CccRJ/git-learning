package queue;

import java.util.*;

/**
 * @program: Java_Learning
 * @description: 自己实现简易twitter
 * @author: ChaiRJ
 * @create: 2020-04-13 23:48
 **/
public class Twitter {
    private Map<Integer,Tweet> twitter;//用户id和推文列表
    private Map<Integer, Set<Integer>> followings;//用户id和他关注的用户列表
    private static int timestamp=0;//时间戳
    private static PriorityQueue<Tweet> maxHeap;//合并k组推文数据结构，找出最新十条

    /**
     * 内部类推文，构建单链表
     */
    private class Tweet{
        private int id;
        private int timestamp;
        private Tweet next;
        public Tweet(int id,int timestamp){
            this.id=id;
            this.timestamp=timestamp;
        }
    }

    public Twitter(){
        followings=new HashMap<>();
        twitter=new HashMap<>();
        maxHeap=new PriorityQueue<Tweet>((o1,o2)->-o1.timestamp + o2.timestamp);
    }

    /**
     * 发表推文
     * @param userId 用户序号
     * @param tweetId 推特序号
     */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitter.containsKey(userId)){
            Tweet oldHead=twitter.get(userId);
            Tweet newHead=new Tweet(tweetId,timestamp);
            newHead.next=oldHead;
            twitter.put(userId,newHead);
        }
        else
            twitter.put(userId,new Tweet(tweetId,timestamp));
    }

    /**
     * 得到关注者的最新10条推文 包括自己
     * @param userId
     * @return 最新的10条推文序号
     */
    public List<Integer> getNewsFeed(int userId) {
        //全局使用 使用前清空
        maxHeap.clear();
        return new ArrayList<>();
    }

    /**
     * 关注别人
     * @param followerId 发起关注者id
     * @param followeeId 被关注者id
     */
    public void unfollow(int followerId, int followeeId) {
        //关注自己无效
        if (followeeId==followerId){
            return ;
        }
        Set<Integer> fList=followings.get(followerId);
        if (fList==null){
            fList=new HashSet<>();
            fList.add(followeeId);
            followings.put(followerId,fList);
        }
    }
}
