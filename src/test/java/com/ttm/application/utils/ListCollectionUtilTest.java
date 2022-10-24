package com.ttm.application.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangtaiming
 * @date 2022.10.24 17:28
 */
public class ListCollectionUtilTest {

    @Test
    public void listTest() {
        ListCollectionUtil lct = new ListCollectionUtil();
        List<User> users5000 = new ArrayList<>();
        for (int x = 1; x <= 5000; x++) {
            User user1 = new User();
            user1.setId(x);
            user1.setName("Name" + x);
            user1.setAge(x);
            users5000.add(user1);
        }
        int a = users5000.size() / 700;
        List<List<User>> l = lct.averageAssign(users5000, a);
        System.out.println(l.size());
    }

}


class User {
    private int id;

    private String name;

    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
