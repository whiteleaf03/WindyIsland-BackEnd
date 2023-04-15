package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.dto.ArticleIdDto;
import top.whiteleaf03.blog.modal.dto.EssayIdDto;
import top.whiteleaf03.blog.modal.dto.InsertEssayDto;
import top.whiteleaf03.blog.modal.vo.ArticleDetailVo;
import top.whiteleaf03.blog.modal.vo.ArticleListVo;
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
    EssayDetailVo selectTitleAndDescribeAndCoverAndContentAndUpdateTime(EssayIdDto essayIdDto);

    /**
     * 前台根据id获取随笔内容
     *
     * @param id 随笔id
     * @return 返回结果
     */
    EssayDetailVo selectTitleAndDescribeAndCoverAndContentAndUpdateTime(Long id);
}
