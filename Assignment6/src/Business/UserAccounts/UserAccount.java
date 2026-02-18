/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import java.util.Date;



/**
 *
 * @author kal bugrara
 */
public class UserAccount {
    
    Profile profile;
    String username;
    String password;
    Date lastAccessTime;
    Date lastUpdatedTime;
    
    public UserAccount (Profile profile, String un, String pw){
        username = un;
         password = pw;
         this.profile = profile;
         this.lastAccessTime = new Date();
         this.lastUpdatedTime = new Date();

    }

    public String getPersonId(){
        return profile.getPerson().getPersonId();
    }
    public String getUserLoginName(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        this.lastUpdatedTime = new Date();
    }

    public void setPassword(String password) {
        this.password = password;
        this.lastUpdatedTime = new Date();
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void updateAccessTime() {
        this.lastAccessTime = new Date();
    }

    public void updateTimestamp() {
        this.lastUpdatedTime = new Date();
    }

        public boolean isMatch(String id){
        if(getPersonId().equals(id)) return true;
        return false;
    }
        public boolean IsValidUser(String un, String pw){
        
            if (username.equalsIgnoreCase(un) && password.equals(pw)) {
                updateAccessTime();
                return true;
            }
            else return false;
        
        }
        public String getRole(){
            return profile.getRole();
        }
        
        public Profile getAssociatedPersonProfile(){
            return profile;
        }
        
    @Override
        public String toString(){
            
            return getUserLoginName();
        }
        
}

