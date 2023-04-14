package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.dto.ArticleIdDto;
import top.whiteleaf03.blog.modal.dto.InsertArticleDto;
import top.whiteleaf03.blog.modal.vo.ArticleDetailVo;
import top.whiteleaf03.blog.modal.vo.ArticleListVo;

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
     */
    void insertArticle(InsertArticleDto insertArticleDto);

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
    List<ArticleListVo> selectIdAndAuthorAndTitleAndDescribeAndClassificationAndTagsAndBorderColorAndCoverAndViewAndCommentAndPathAndUpdateTime();

    /**
     * 前台根据id获取文章内容
     *
     * @param articleIdDto 包含文章id
     * @return 返回结果
     */
    ArticleDetailVo selectAuthorAndTitleAndDescribeAndClassificationAndTagsAndCoverAndContentAndFilePathAndUpdateTimeById(ArticleIdDto articleIdDto);

    /**
     * 获取所有分类
     *
     * @return 返回分类
     */
    String[] selectClassificationDistinct();
}