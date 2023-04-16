package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.dto.PictureIdDto;
import top.whiteleaf03.blog.modal.entity.Picture;
import top.whiteleaf03.blog.modal.vo.PictureDetailVo;
import top.whiteleaf03.blog.modal.vo.PictureListVo;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface PictureMapper {
    /**
     * 新增图片
     *
     * @param picture 图片信息
     */
    void insert(Picture picture);

    /**
     * 删除图片
     *
     * @param pictureIdDto 图片id
     */
    void deleteById(PictureIdDto pictureIdDto);

    /**
     * 查询图片详细信息列表
     *
     * @return 返回结果
     */
    PictureDetailVo selectIdAndNameAndUpdateTime();

    /**
     * 根据id查询图片信息及图片内容
     *
     * @param pictureIdDto 图片id
     * @return 返回结果
     */
    PictureListVo selectNameAndUpdateTimeById(PictureIdDto pictureIdDto);
}
