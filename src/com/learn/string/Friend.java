package com.learn.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        int[] a = {};
        int b = a.length;
        final Set<String> set = new HashSet<>();
        final Queue<Friend> queue = new ArrayDeque<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            final Friend friend1 = queue.poll();
            if (friend1.email.equals(friend.getEmail())) {
                return true;
            }
            for (final Friend next : friend1.friends) {
                if (set.add(next.email)) {
                    queue.offer(next);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(c));
    }
}