package com.itheima.controller;
import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Slf4j
@RestController
public class UploadController {
    /*@PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{},{},{}",username,age,image);


        String originalFilename = image.getOriginalFilename();

        int index = originalFilename.lastIndexOf('.');
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString()+extname;

        image.transferTo(new File("/Users/potato/Desktop/"+newFileName));

        return Result.success();

    }*/

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传：{}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，url:{}",url);


        return Result.success(url);

    }
}
