package top.whiteleaf03.blog.service.tag;

import top.whiteleaf03.blog.modal.dto.InsertTagDto;
import top.whiteleaf03.blog.modal.dto.TagIdDto;
import top.whiteleaf03.blog.modal.entity.ArticleTag;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface TagService {
    /**
     * 新增标签
     *
     * @param insertTagDto 标签数据
     * @return 返回结果
     */
    ResponseResult insert(InsertTagDto insertTagDto);

    /**
     * 删除标签
     *
     * @param tagIdDto 标签数据
     * @return 返回结果
     */
    ResponseResult deleteById(TagIdDto tagIdDto);

    /**
     * 获取所有标签
     *
     * @return 返回
     */
    ResponseResult selectName();

    /**
     * 给文章分配标签
     *
     * @param articleTag 文章id和标签id
     * @return 返回结果
     */
    ResponseResult insertArticleTag(ArticleTag articleTag);

    /**
     * 获取标签名及包含该标签的文章数量
     *
     * @return 返回
     */
    ResponseResult selectTagNameAndArticleTotal();
}
