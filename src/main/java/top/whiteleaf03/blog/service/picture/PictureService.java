package top.whiteleaf03.blog.service.picture;

import org.springframework.web.multipart.MultipartFile;
import top.whiteleaf03.blog.modal.dto.PictureIdDto;
import top.whiteleaf03.blog.modal.entity.Picture;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface PictureService {
    /**
     * 新增图片
     *
     * @param picture 图片信息
     * @return 返回结果
     */
    ResponseResult insert(Picture picture);

    /**
     * 删除图片
     *
     * @param pictureIdDto 图片id
     * @return 返回结果
     */
    ResponseResult deleteById(PictureIdDto pictureIdDto);

    /**
     * 查询图片详细信息列表
     *
     * @return 返回结果
     */
    ResponseResult selectIdAndNameAndUpdateTime();

    /**
     * 根据id查询图片信息及图片内容
     *
     * @param pictureIdDto 图片id
     * @return 返回结果
     */
    ResponseResult selectNameAndUpdateTimeById(PictureIdDto pictureIdDto);

    /**
     * 上传图片
     *
     * @param multipartFile 图片文件
     * @return 返回结果
     */
    ResponseResult upload(MultipartFile multipartFile);
}
