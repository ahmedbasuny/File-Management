package com.stc.filemanagment.requests;

import lombok.Data;

@Data
public class SpaceRequest {
    private String spaceName;
    private String userEmailView;
    private String userEmailEdit;
}
