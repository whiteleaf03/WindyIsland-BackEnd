package top.whiteleaf03.blog.service.picture;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.whiteleaf03.blog.config.GlobalConfig;
import top.whiteleaf03.blog.mapper.PictureMapper;
import top.whiteleaf03.blog.modal.dto.PictureIdDto;
import top.whiteleaf03.blog.modal.entity.Picture;
import top.whiteleaf03.blog.utils.ResponseResult;

import java.io.File;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class PictureServiceImpl implements PictureService {
    private final PictureMapper pictureMapper;
    private final GlobalConfig globalConfig;

    @Autowired
    public PictureServiceImpl(PictureMapper pictureMapper, GlobalConfig globalConfig) {
        this.pictureMapper = pictureMapper;
        this.globalConfig = globalConfig;
    }

    /**
     * 新增图片
     *
     * @param picture 图片信息
     * @return 返回结果
     */
    @Override
    public ResponseResult insert(Picture picture) {
        try {
            pictureMapper.insert(picture);
        } catch (RuntimeException e) {
            log.error("新增图片失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 删除图片
     *
     * @param pictureIdDto 图片id
     * @return 返回结果
     */
    @Override
    public ResponseResult deleteById(PictureIdDto pictureIdDto) {
        try {
            pictureMapper.deleteById(pictureIdDto);
        } catch (RuntimeException e) {
            log.error("删除图片失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 查询图片详细信息列表
     *
     * @return 返回结果
     */
    @Override
    public ResponseResult selectIdAndNameAndUpdateTime() {
        try {
            pictureMapper.selectIdAndNameAndUpdateTime();
        } catch (RuntimeException e) {
            log.error("查询图片详细信息列表失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 根据id查询图片信息及图片内容
     *
     * @param pictureIdDto 图片id
     * @return 返回结果
     */
    @Override
    public ResponseResult selectNameAndUpdateTimeById(PictureIdDto pictureIdDto) {
        try {
            pictureMapper.selectNameAndUpdateTimeById(pictureIdDto);
        } catch (RuntimeException e) {
            log.error("根据id查询图片信息及图片内容失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 上传图片
     *
     * @param multipartFile 图片文件
     * @return 返回结果
     */
    @Override
    public ResponseResult upload(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        Long updateTime = System.currentTimeMillis();
        String name = null;
        if (originalFilename != null) {
            name = originalFilename.split("\\.")[0] + "_" + updateTime + originalFilename.split("\\.")[1];
        }
        try {
            //保存文件
            multipartFile.transferTo(new File(globalConfig.getPicturePath() + name));
        } catch (Exception e) {
            log.error("保存图片文件失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return this.insert(new Picture(name, updateTime));
    }
}
