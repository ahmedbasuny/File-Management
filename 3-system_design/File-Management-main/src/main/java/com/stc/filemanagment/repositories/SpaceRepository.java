package com.stc.filemanagment.repositories;

import com.stc.filemanagment.enums.PermissionLevel;
import com.stc.filemanagment.models.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SpaceRepository extends JpaRepository<Space, UUID> {

    @Query(value = " SELECT COUNT(i.name) FROM item i "
            + " JOIN permission_group pg ON (i.permission_group_id = pg.id) "
            + " JOIN permission p ON (pg.id = p.permission_group_id) "
            + " WHERE i.id = :id AND p.user_email = :userEmail AND p.permission_level = :permissionLevel "
            , nativeQuery = true)
    Integer checkSpaceUserPermission(@Param("id") UUID id, @Param("userEmail") String userEmail,
                                     @Param("permissionLevel") String permissionLevel);
}
