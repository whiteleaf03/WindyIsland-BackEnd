package top.whiteleaf03.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.whiteleaf03.blog.modal.dto.PictureIdDto;
import top.whiteleaf03.blog.service.picture.PictureService;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/api/picture")
public class PictureController {
    private final PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    /**
     * 删除图片
     *
     * @param pictureIdDto 图片id
     * @return 返回结果
     */
    @DeleteMapping("")
    ResponseResult deleteById(@RequestBody PictureIdDto pictureIdDto) {
        return pictureService.deleteById(pictureIdDto);
    }

    /**
     * 查询图片详细信息列表
     *
     * @return 返回结果
     */
    @GetMapping("list")
    ResponseResult selectIdAndNameAndUpdateTime() {
        return pictureService.selectIdAndNameAndUpdateTime();
    }

    /**
     * 上传图片
     *
     * @param multipartFile 图片文件
     * @return 返回结果
     */
    @PostMapping("upload")
    public ResponseResult uploadPicture(@RequestParam("file") MultipartFile multipartFile) {
        return pictureService.upload(multipartFile);
    }
}
