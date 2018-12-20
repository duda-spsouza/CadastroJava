package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.example.demo.model.UserForm;

@Repository
public class UserDAO {
  
    private static final Map<Long, User> userMap = new HashMap<Long, User>();
  
    static {
        initEmps();
    }
  
    private static void initEmps() {
        User user1 = new User(1L, "E01", "33", "A","0");
        User user2 = new User(2L, "E02", "22", "A","0");
        User user3 = new User(3L, "E03", "11", "A","0");
  
        userMap.put(user1.getUserId(), user1);
        userMap.put(user2.getUserId(), user2);
        userMap.put(user3.getUserId(), user3);
    }
  
    public Long getMaxEmpId() {
        Set<Long> keys = userMap.keySet();
        Long max = 0L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }
  
    public User getUser(Long userId) {
        return userMap.get(userId);
    }
  
    public User addUser(UserForm userForm) {
        Long empId= this.getMaxEmpId()+ 1;
        userForm.setUserId(empId);
        User newEmp = new User(userForm);  
         
        userMap.put(newEmp.getUserId(), newEmp);
        return newEmp;
    }
  
    public User updateUser(UserForm userForm) {
        User user = this.getUser(userForm.getUserId());
        if(user!= null)  {
        	user.setUserNome(userForm.getUserNome());
        	user.setUserCredito(userForm.getUserCredito());
        	user.setUserRisco(userForm.getUserRisco());
        	user.setUserTaxa(userForm.getUserTaxa());
        }  
        return user;
    }
  
    public void deleteUser(Long userId) {
    	userMap.remove(userId);
    }
  
    public List<User> getAllUsers() {
        Collection<User> c = userMap.values();
        List<User> list = new ArrayList<User>();
        list.addAll(c);
        return list;
    }
  
}

