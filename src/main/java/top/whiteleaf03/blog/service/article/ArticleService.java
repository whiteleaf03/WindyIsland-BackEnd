package top.whiteleaf03.blog.service.article;

import top.whiteleaf03.blog.modal.dto.ArticleIdDto;
import top.whiteleaf03.blog.modal.dto.InsertArticleDto;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface ArticleService {
    /**
     * 新增新文章
     *
     * @param insertArticleDto 新文章内容
     * @return 返回结果
     */
    ResponseResult insert(InsertArticleDto insertArticleDto);

    /**
     * 删除文章
     *
     * @param articleIdDto 包含文章id
     * @return 返回结果
     */
    ResponseResult deleteById(ArticleIdDto articleIdDto);

    /**
     * 查询文章列表
     *
     * @return 返回结果
     */
    ResponseResult selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndUpdateTime();

    /**
     * 前台根据id获取文章内容
     *
     * @param articleIdDto 包含文章id
     * @return 返回结果
     */
    ResponseResult selectAuthorAndTitleAndDescribeAndCoverAndContentAndFilePathAndUpdateTimeById(ArticleIdDto articleIdDto);
}
