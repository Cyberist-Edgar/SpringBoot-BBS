package com.edgar.bbs.controller;

import com.edgar.bbs.dao.FilesDao;
import com.edgar.bbs.dao.info.SearchFilesInfo;
import com.edgar.bbs.service.FileService;
import com.edgar.bbs.service.UserService;
import com.edgar.bbs.utils.RedisUtils;
import com.edgar.bbs.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@Api("文件相关")
@RequestMapping("/api/file")
public class FileController {
    @Resource
    private FileService fileService;

    @Resource
    private FilesDao filesDao;


    @ApiOperation(value = "下载文件")
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public Result downloadFile(@Param(value = "file_id") Long file_id, HttpServletResponse response) throws IOException {
        return fileService.getFile (response, file_id);
    }

    @ApiOperation(value="获取全部文件")
    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public List<SearchFilesInfo> getAll(){
        return filesDao.getAll();
    }


    @ApiOperation(value = "上传文件")
    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public Result uploadFile(MultipartHttpServletRequest request, HttpSession session) throws IOException {
        String username = session.getAttribute("username").toString();
        if(username ==null){
            return new Result(400, "请先进行登录");
        }
        return fileService.uploadFile(Objects.requireNonNull(request.getFile("file")), request.getParameter("type"), request.getParameter("description"), username);
    }
}
