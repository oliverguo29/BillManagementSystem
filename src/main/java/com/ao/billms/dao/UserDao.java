package com.ao.billms.dao;


import com.ao.billms.entities.Provider;
import com.ao.billms.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.*;

@Repository
public class UserDao {

    private static Map<Integer, User> userMap = null;
    private static Integer initId = 1006;

    static{
        userMap = new HashMap<Integer, User>();

        userMap.put(1001, new User(1001, "MXG-AA", "xiaomeng1", "123456", 2, 3));
        userMap.put(1002, new User(1002, "MXG-BB", "xiaomeng2", "123456", 1, 1));
        userMap.put(1003, new User(1003, "MXG-CC", "xiaomeng3", "123456", 1, 2));
        userMap.put(1004, new User(1004, "MXG-DD", "xiaomeng4", "123456", 2, 3));
        userMap.put(1005, new User(1005, "MXG-EE", "xiaomeng5", "123456", 1, 2));
    }



    public void save(User User){
        if(User.getId() == null){
            User.setId(initId++);
        }
        userMap.put(User.getId(), User);
    }

    public Collection<User> getAll(){
        return userMap.values();
    }

    public Collection<User> getAll(String username){
        Collection<User> users = getAll();

        //不为空
        if( !StringUtils.isEmpty( username )) {
            int count = 0;
            for (User user: users) {
                //包含则存在
                if ( user.getUsername().toUpperCase().contains(  username.toUpperCase() ) ) {
                    count++;
                    //count>1 表示集合至少有一个存在的用户, 否则创建新的集合
                    users = count > 1 ? users : new ArrayList<User>();
                    users.add(user);
                }
            }
        }

        return users;
    }
    public User get(Integer id){
        return userMap.get(id);
    }

    public void delete(Integer id){
        userMap.remove(id);
    }


}
