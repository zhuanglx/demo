package com.zhuanglx.demo.common.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDto extends BaseDto{
	  
    private Integer id;  
    private String roleName;  
    private List<PermissionDto> permissionDtoList;
    private List<UserDto> userDtoList;
      
    public Integer getId() {  
        return id;  
    }  
    public void setId(Integer id) {  
        this.id = id;  
    }  
    public String getRoleName() {  
        return roleName;  
    }  
    public void setRoleName(String roleName) {  
        this.roleName = roleName;  
    }  
    public List<PermissionDto> getPermissionDtoList() {  
        return permissionDtoList;  
    }  
    public void setPermissionDtoList(List<PermissionDto> permissionDtoList) {  
        this.permissionDtoList = permissionDtoList;  
    }  
    
    public List<UserDto> getUserDtoList() {  
        return userDtoList;  
    }  
    public void setUserDtoList(List<UserDto> userDtoList) {  
        this.userDtoList = userDtoList;  
    }  

    public List<String> getPermissionsName(){  
        List<String> permissionsNameList=new ArrayList<String>();  
        List<PermissionDto> permissionDtoList=getPermissionDtoList();  
        for (PermissionDto permissionDto : permissionDtoList) {  
        	permissionsNameList.add(permissionDto.getPermissionName());  
        }  
        return permissionsNameList;  
    }  
}
