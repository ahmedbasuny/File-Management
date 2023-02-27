package com.stc.filemanagment.services.implementation;

import com.stc.filemanagment.enums.PermissionLevel;
import com.stc.filemanagment.models.Permission;
import com.stc.filemanagment.models.PermissionGroup;
import com.stc.filemanagment.repositories.PermissionRepository;
import com.stc.filemanagment.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PermissionServiceImplementation implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public void createViewPermissionUser(PermissionGroup permissionGroup, String userEmailView) {
        permissionRepository.save(
                Permission.builder()
                        .userEmail(userEmailView)
                        .permissionLevel(PermissionLevel.VIEW)
                        .permissionGroup(permissionGroup)
                        .build()
        );
    }

    @Override
    public void createEditPermissionUser(PermissionGroup permissionGroup, String userEmailEdit) {
        permissionRepository.save(
                Permission.builder()
                        .userEmail(userEmailEdit)
                        .permissionLevel(PermissionLevel.EDIT)
                        .permissionGroup(permissionGroup)
                        .build()
        );

    }
}
