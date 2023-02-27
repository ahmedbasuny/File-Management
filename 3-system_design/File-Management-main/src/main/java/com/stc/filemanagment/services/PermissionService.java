package com.stc.filemanagment.services;

import com.stc.filemanagment.models.PermissionGroup;

import java.util.UUID;

public interface PermissionService {
    void createViewPermissionUser(PermissionGroup permissionGroup, String userEmailView);
    void createEditPermissionUser(PermissionGroup permissionGroup, String userEmailEdit);
}
