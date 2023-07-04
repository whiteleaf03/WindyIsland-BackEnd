package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.dto.EssayIdDto;
import top.whiteleaf03.blog.modal.dto.InsertEssayDto;
import top.whiteleaf03.blog.modal.dto.UpdateEssayDto;
import top.whiteleaf03.blog.modal.vo.EssayDetailVo;
import top.whiteleaf03.blog.modal.vo.EssayListVo;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface EssayMapper {
    /**
     * 新增随笔
     *
     * @param insertEssayDto 要插入的随笔的内容
     */
    void insert(InsertEssayDto insertEssayDto);

    /**
     * 删除随笔
     *
     * @param essayIdDto 包含随笔id
     */
    void deleteById(EssayIdDto essayIdDto);

    /**
     * 查询随笔列表
     *
     * @return 返回结果
     */
    List<EssayListVo> selectTitleAndDescribeAndCoverAndUpdateTime();

    /**
     * 前台根据id获取随笔内容
     *
     * @param essayIdDto 包含随笔id
     * @return 返回结果
     */
    EssayDetailVo selectTitleAndDescribeAndCoverAndContentAndUpdateTimeById(EssayIdDto essayIdDto);

    /**
     * 前台根据id获取随笔内容
     *
     * @param id 随笔id
     * @return 返回结果
     */
    EssayDetailVo selectTitleAndDescribeAndCoverAndContentAndUpdateTimeById(Long id);

    /**
     * 更新随笔信息
     *
     * @param updateEssayDto 包含id和更新时间，可能包含标题，描述，封面路径
     */
    void updateTitleOrDescribeOrCoverAndUpdateTimeById(UpdateEssayDto updateEssayDto);
}
