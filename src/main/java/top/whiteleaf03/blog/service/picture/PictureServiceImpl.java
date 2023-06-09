package top.whiteleaf03.blog.service.picture;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.whiteleaf03.blog.config.GlobalConfig;
import top.whiteleaf03.blog.mapper.PictureMapper;
import top.whiteleaf03.blog.modal.dto.PictureIdDto;
import top.whiteleaf03.blog.modal.entity.Picture;
import top.whiteleaf03.blog.modal.vo.PictureDetailVo;
import top.whiteleaf03.blog.utils.ResponseResult;

import java.io.File;
import java.util.List;

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
            PictureDetailVo pictureDetailVo = pictureMapper.selectNameById(pictureIdDto);
            String picturePath = globalConfig.getPicturePath() + pictureDetailVo.getName();
            FileUtil.del(picturePath);
        } catch (Exception e) {
            log.error("删除图片文件失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        try {
            pictureMapper.deleteById(pictureIdDto);
        } catch (RuntimeException e) {
            log.error("删除图片数据失败");
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
        List<PictureDetailVo> pictureDetailVoList;
        try {
            pictureDetailVoList = pictureMapper.selectIdAndNameAndUpdateTime();
        } catch (RuntimeException e) {
            log.error("查询图片详细信息列表失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(pictureDetailVoList);
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
            name = originalFilename.split("\\.")[0] + "_" + updateTime + "." + originalFilename.split("\\.")[1];
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
