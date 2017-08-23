package com.zhuanglx.demo.common.dto;

public class PermissionDto extends BaseDto{
    private Integer id;  
    private String permissionName;  
    private RoleDto roleDto;//一个权限对应一个角色  
      
    public Integer getId() {  
        return id;  
    }  
    public void setId(Integer id) {  
        this.id = id;  
    }  
    public String getPermissionName() {  
        return permissionName;  
    }  
    public void setPermissionName(String permissionName) {  
        this.permissionName = permissionName;  
    }  
    
    public RoleDto getRoleDto() {  
        return roleDto;  
    }  
    public void setRoleDto(RoleDto roleDto) {  
        this.roleDto = roleDto;  
    } 
}
