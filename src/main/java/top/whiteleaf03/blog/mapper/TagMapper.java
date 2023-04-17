package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.dto.InsertTagDto;
import top.whiteleaf03.blog.modal.dto.TagIdDto;
import top.whiteleaf03.blog.modal.entity.Tag;
import top.whiteleaf03.blog.modal.vo.TagListVo;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface TagMapper {
    /**
     * 新增标签
     *
     * @param insertTagDto 标签数据
     */
    void insert(InsertTagDto insertTagDto);

    /**
     * 删除标签
     *
     * @param tagIdDto 标签id
     */
    void deleteById(TagIdDto tagIdDto);

    /**
     * 获取所有标签
     *
     * @return 返回标签列表
     */
    List<TagListVo> selectIdAndName();
}
