package com.meibaorui.manygirlfriends.factory;

import com.meibaorui.manygirlfriends.bean.GirlFriend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meibaorui on 2015/8/5.
 */
public class GirlFriendFactory {

    /**
     * 随机生成女朋友
     * @param minAge 女朋友最小年龄
     * @param maxAge 女朋友最大年龄
     * @param minNameLength 姓名最大长度
     * @param maxNameLength 姓名最短长度
     * @return 女朋友
     */
    public static GirlFriend createRandomGirlFriend(int minAge, int maxAge, int minNameLength, int maxNameLength) throws GirlFriend.AgeOutOfRangeException, GirlFriend.NameLengthOutOfRangeException {
        int age = (int) (minAge + Math.random() * (maxAge - minAge + 1));

        int nameLength = (int) (minNameLength + Math.random() * (maxNameLength - minNameLength + 1));
        String name = "";
        for (int i = 0; i < nameLength; i++) {
            char charOfName = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            name += charOfName;
        }

        GirlFriend girlFriend = new GirlFriend(name, age);
        return girlFriend;
    }

    /**
     * 随机生成一组女朋友
     * @param girlFriendsAmount 女朋友数量
     * @param minAge 女朋友最小年龄
     * @param maxAge 女朋友最大年龄
     * @param minNameLength 姓名最大长度
     * @param maxNameLength 姓名最短长度
     * @return 女朋友列表
     */
    public static List<GirlFriend> createRandomGirlFriends(int girlFriendsAmount, int minAge, int maxAge, int minNameLength, int maxNameLength) throws GirlFriend.AgeOutOfRangeException, GirlFriend.NameLengthOutOfRangeException {
        List<GirlFriend> GirlFriends = new ArrayList<GirlFriend>();

        for (int i = 0; i < girlFriendsAmount; i++) {
            GirlFriends.add(createRandomGirlFriend(minAge, maxAge, minNameLength, maxNameLength));
        }
        return GirlFriends;
    }

    /**
     * 打印女朋友列表
     * @param girlFriends 女朋友列表
     */
    public static void printGirlFriends(List<GirlFriend> girlFriends){
        for(GirlFriend girlFriend : girlFriends){
            System.out.println(girlFriend.toString());
        }
    }
}
