package com.stc.filemanagment.requests;

import lombok.Data;

@Data
public class FolderRequest {
    private String folderName;
    private String userEmail;
}
