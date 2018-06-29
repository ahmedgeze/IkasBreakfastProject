package com.example.ahmetserdargeze.ikasbreakfastproject.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ahmetserdargeze on 28.06.2018.
 */

public class Role {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;
    @SerializedName("permission_sets")
    @Expose
    private List<PermissionSet> permissionSets = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<PermissionSet> getPermissionSets() {
        return permissionSets;
    }

    public void setPermissionSets(List<PermissionSet> permissionSets) {
        this.permissionSets = permissionSets;
    }
}
