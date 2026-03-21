package com.MyGameLibrary.demo.Controller;

import com.MyGameLibrary.demo.entities.Platform;
import com.MyGameLibrary.demo.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatformController {

    @Autowired
    PlatformService platformService;

    @PostMapping("/addPlatform")
    public void addPlatform(@RequestBody Platform platform){
        platformService.addPlatform(platform);
    }


}
