package com.reconx.upload.controller;

import com.reconx.upload.entity.UploadedFile;
import com.reconx.upload.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public UploadedFile upload(
            @RequestParam("file") MultipartFile file
    ) {

        return fileUploadService.upload(
                file,
                "SYSTEM_USER"
        );
    }
}
