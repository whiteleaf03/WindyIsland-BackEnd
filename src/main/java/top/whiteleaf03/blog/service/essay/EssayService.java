package top.whiteleaf03.blog.service.essay;

import top.whiteleaf03.blog.modal.dto.EssayIdDto;
import top.whiteleaf03.blog.modal.dto.InsertEssayDto;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface EssayService {
    /**
     * 新增随笔
     * 
     * @param insertEssayDto 新增随笔的内容
     * @return 返回结果
     */
    ResponseResult insert(InsertEssayDto insertEssayDto);

    /**
     * 删除随笔
     *
     * @param essayIdDto 包含随笔id
     * @return 返回结果
     */
    ResponseResult deleteById(EssayIdDto essayIdDto);

    /**
     * 查询随笔列表
     *
     * @return 返回结果
     */
    ResponseResult selectTitleAndDescribeAndCoverAndUpdateTime();

    /**
     * 前台根据id获取随笔内容
     *
     * @param essayIdDto 包含随笔id
     * @return 返回结果
     */
    ResponseResult selectTitleAndDescribeAndCoverAndContentAndUpdateTimeById(EssayIdDto essayIdDto);
}
