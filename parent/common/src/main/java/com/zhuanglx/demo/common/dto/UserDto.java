package com.zhuanglx.demo.common.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDto extends BaseDto{
	  
    private Integer id;  
    private String username;  
    private String password;  
    private List<RoleDto> roleDtoList;//一个用户具有多个角色  
      
    public Integer getId() {  
        return id;  
    }  
    public void setId(Integer id) {  
        this.id = id;  
    }  
    public String getUsername() {  
        return username;  
    }  
    public void setUsername(String username) {  
        this.username = username;  
    }  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
    public List<RoleDto> getRoleDtoList() {  
        return roleDtoList;  
    }  
    public void setRoleDtoList(List<RoleDto> roleDtoList) {  
        this.roleDtoList = roleDtoList;  
    }  
      
    public Set<String> getRolesName(){  
        List<RoleDto> roleDtoList=getRoleDtoList();  
        Set<String> set=new HashSet<String>();  
        for (RoleDto roleDto : roleDtoList) {  
            set.add(roleDto.getRoleName());  
        }  
        return set;  
    } 
}
