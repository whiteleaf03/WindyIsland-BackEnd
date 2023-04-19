package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.dto.ArticleIdDto;
import top.whiteleaf03.blog.modal.dto.ArticlePageDto;
import top.whiteleaf03.blog.modal.dto.InsertArticleDto;
import top.whiteleaf03.blog.modal.vo.ArticleDetailVo;
import top.whiteleaf03.blog.modal.vo.ArticleListVo;
import top.whiteleaf03.blog.modal.vo.ArticlePageListVo;
import top.whiteleaf03.blog.modal.vo.ArticlePageSizeVo;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface ArticleMapper {
    /**
     * 新增文章
     *
     * @param insertArticleDto 要插入的文章的内容
     * @return 返回文章id
     */
    Long insertArticle(InsertArticleDto insertArticleDto);

    /**
     * 删除文章
     *
     * @param articleIdDto 包含文章id
     */
    void deleteById(ArticleIdDto articleIdDto);

    /**
     * 查询文章列表
     *
     * @return 返回结果
     */
    List<ArticleListVo> selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndPathAndUpdateTime();

    /**
     * 分页查询文章列表
     *
     * @param articlePageDto 分页页号
     * @return 返回结果
     */
    List<ArticlePageListVo> selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndPathAndUpdateTimeInPaging(ArticlePageDto articlePageDto);

    /**
     * 统计分页查询时总页数
     *
     * @return 返回页数
     */
    ArticlePageSizeVo countPageSizeInPaging();

    /**
     * 前台根据id获取文章内容
     *
     * @param articleIdDto 包含文章id
     * @return 返回结果
     */
    ArticleDetailVo selectAuthorAndTitleAndDescribeAndClassificationAndTagsAndCoverAndContentAndFilePathAndUpdateTimeById(ArticleIdDto articleIdDto);

    /**
     * 前台根据id获取文章内容
     *
     * @param id 文章id
     * @return 返回结果
     */
    ArticleDetailVo selectAuthorAndTitleAndDescribeAndClassificationAndTagsAndCoverAndContentAndFilePathAndUpdateTimeById(Long id);
}
