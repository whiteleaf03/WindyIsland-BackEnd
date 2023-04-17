package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.entity.ArticleTag;

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
     * @param InsertArticleTagDto 文章 id和tag id
     */
    void deleteByArticleIdAndTagId(InsertArticleTagDto InsertArticleTagDto);
}
