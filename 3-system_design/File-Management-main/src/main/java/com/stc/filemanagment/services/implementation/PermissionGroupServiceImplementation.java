package com.stc.filemanagment.services.implementation;

import com.stc.filemanagment.models.PermissionGroup;
import com.stc.filemanagment.repositories.PermissionGroupRepository;
import com.stc.filemanagment.services.PermissionGroupService;
import com.stc.filemanagment.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PermissionGroupServiceImplementation implements PermissionGroupService {

    private final PermissionGroupRepository permissionGroupRepository;
    private final PermissionService permissionService;

    @Override
    public PermissionGroup createSpaceAdminGroupWithUsers(String userEmailView, String userEmailEdit) {
        PermissionGroup spaceGroup = permissionGroupRepository
                .save(PermissionGroup.builder().groupName("Admin Space Group").build());
        permissionService.createViewPermissionUser(spaceGroup, userEmailView);
        permissionService.createEditPermissionUser(spaceGroup, userEmailEdit);
        return spaceGroup;
    }
}
