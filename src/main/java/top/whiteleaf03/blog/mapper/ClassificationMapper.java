package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.dto.ClassificationIdDto;
import top.whiteleaf03.blog.modal.dto.InsertClassificationDto;
import top.whiteleaf03.blog.modal.vo.ClassificationListVo;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface ClassificationMapper {
    /**
     * 新增分类
     *
     * @param insertClassificationDto 新增分类的数据
     */
    void insert(InsertClassificationDto insertClassificationDto);

    /**
     * 新增分类
     *
     * @param classificationIdDto 分类id
     */
    void deleteById(ClassificationIdDto classificationIdDto);

    /**
     * 获取所有分类
     *
     * @return 返回
     */
    List<ClassificationListVo> selectIdAndNameAndCover();

    /**
     * 根据id获取分类名
     *
     * @param id 分类id
     * @return 分类名
     */
    String selectNameById(Long id);
}
