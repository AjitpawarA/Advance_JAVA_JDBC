package com.alpha.userController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.alpha.userDao.UserDao;
import com.alpha.userDto.User;

public class UserControllerTest {

    @Test
    public void testCreateUser() {
        User user = new User(1, "John Doe", "john@example.com", "password123", "1234567890");
        UserDao userDao = new UserDao();
        
        User savedUser = userDao.saveUser(user);
        
        assertNotNull(savedUser);
        assertEquals(user.getUserId(), savedUser.getUserId());
        assertEquals(user.getUserName(), savedUser.getUserName());
        assertEquals(user.getUserEmail(), savedUser.getUserEmail());
        assertEquals(user.getPassward(), savedUser.getPassward());
        assertEquals(user.getPhoneNo(), savedUser.getPhoneNo());
        System.out.println("createUser method");
    }
    
    @Test
    public void testUpdateUser() {
        User user = new User(1, "John Doe", "john@example.com", "newpassword123", "0987654321");
        UserDao userDao = new UserDao();
        
        User updatedUser = userDao.updateUser(user);
        
        assertNotNull(updatedUser);
        assertEquals(user.getUserId(), updatedUser.getUserId());
        assertEquals(user.getUserName(), updatedUser.getUserName());
        assertEquals(user.getUserEmail(), updatedUser.getUserEmail());
        assertEquals(user.getPassward(), updatedUser.getPassward());
        assertEquals(user.getPhoneNo(), updatedUser.getPhoneNo());
        System.out.println("updateUser method");
    }
    
    @Test
    public void testFindUserByID() {
        int userId = 1;
        UserDao userDao = new UserDao();
        
        User user = userDao.getUserById(userId);
        
        assertNotNull(user);
        assertEquals(userId, user.getUserId());
        System.out.println("findUserByID method");
    }
    
    @Test
    public void testDisplayAllUsers() {
        UserDao userDao = new UserDao();
        
        List<User> users = userDao.getAllUsers();
        
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println("displayAllUsers method");
    }
    
    @Test
    public void testDeleteUserByID() {
        int userId = 1;
        UserDao userDao = new UserDao();
        
        boolean isDeleted = userDao.deleteUser(userId);
        
        assertTrue(isDeleted);
        System.out.println("deleteUserByID method");
    }
}