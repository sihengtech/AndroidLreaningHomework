package com.meibaorui.manygirlfriends;

import com.meibaorui.manygirlfriends.bean.GirlFriend;
import com.meibaorui.manygirlfriends.factory.GirlFriendFactory;

/**
 * Created by meibaorui on 2015/8/5.
 */
public class ManyGirlFriendsDemo {
    public static void main(String[] args) throws GirlFriend.AgeOutOfRangeException, GirlFriend.NameLengthOutOfRangeException {
        GirlFriendFactory.printGirlFriends(GirlFriendFactory.createRandomGirlFriends(1000,10,20,1,5));
    }
}
