package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.entity.ArticleTag;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface ArticleTagMapper {
    /**
     * 给博客新增tag
     *
     * @param articleTag 文章 id和tag id
     */
    void insert(ArticleTag articleTag);

    /**
     * 给博客删除tag
     *
     * @param articleTag 文章 id和tag id
     */
    void deleteByArticleIdAndTagId(ArticleTag articleTag);

    /**
     * 根据标签id统计文章数量
     *
     * @param tagId 标签id
     * @return 返回文章数量
     */
    Integer countArticleTotalByTagId(Long tagId);

    /**
     * 根据文章id获取该文章所包含的标签id
     *
     * @param articleId 文章id
     * @return 标签id列表
     */
    List<Long> selectTagIdByArticleId(Long articleId);
}
