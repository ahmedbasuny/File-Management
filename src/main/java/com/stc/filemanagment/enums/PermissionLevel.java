package com.stc.filemanagment.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum PermissionLevel {
    CREATE("1", "Create", ""),
    VIEW("2", "View", ""),
    EDIT("3", "Edit", ""),
    DELETE("4", "Delete", "");

    private String id;
    private String displayName;
    private String description;

    PermissionLevel(String id, String displayName, String description) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
    }

    private static final Map<String, PermissionLevel> values = new LinkedHashMap<>();

    static {
        for (PermissionLevel merchantStatus : PermissionLevel.values()) {
            values.put(merchantStatus.id, merchantStatus);
        }
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }
}
