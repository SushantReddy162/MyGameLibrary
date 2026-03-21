package com.MyGameLibrary.demo.service;

import com.MyGameLibrary.demo.entities.Platform;
import com.MyGameLibrary.demo.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformService {
    @Autowired
    PlatformRepository platformRepository;

    public void addPlatform(Platform platform){
        platformRepository.save(platform);
    }
}
