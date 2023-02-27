package com.stc.filemanagment.services;

import com.stc.filemanagment.models.PermissionGroup;

import java.util.UUID;

public interface PermissionGroupService {
    PermissionGroup createSpaceAdminGroupWithUsers(String userEmailView, String userEmailEdit);
}
