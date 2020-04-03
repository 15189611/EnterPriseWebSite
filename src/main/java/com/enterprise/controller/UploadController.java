package com.enterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload/")

public class UploadController {

    @RequestMapping("test.do")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {


        String msg = "";

        /**
         *
         *
         * 项目服务器地址路径
         */
        String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + request.getContextPath() + "/attached/";

        // 判断文件是否为空，空则返回失败页面
        if (file.isEmpty()) {
            msg = "failed";
        }
        // 获取文件存储路径（绝对路径）

        String path = System.getProperty("evan.webapp") + "/attached";
        // 获取原文件名
        String fileName = file.getOriginalFilename();
        // 创建文件实例
        File filePath = new File(path, fileName);
        // 如果文件目录不存在，创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录" + filePath);
        }
        // 写入文件
        file.transferTo(filePath);
        msg = projectServerPath + fileName;
        return msg;
    }
}
