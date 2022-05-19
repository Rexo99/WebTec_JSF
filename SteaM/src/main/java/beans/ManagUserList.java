/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author marvinpieper
 */
@Named(value = "manageUserList")
@SessionScoped
public class ManagUserList implements Serializable{
    private static ArrayList<User> userList = new ArrayList<User>();
    
    
    /**
     * Check the log in data
     * @param username
     * @param password
     * @return 
     */
    public static boolean checkLogInData(String username, String password){
        for(User user: userList){
            if(user.getUsername().equals(username)){
                if(user.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * add a new User to the UserList
     * @param username
     * @param password 
     */
    public static void addUser(String username, String password){
        User newUser = new User(username, password);
        userList.add(newUser);
    }
    
    /**
     * remove User from List
     * @param u User object which will remove from the list
     */
    public static void removeUser(User u){
        userList.remove(u);
    }
    

}
