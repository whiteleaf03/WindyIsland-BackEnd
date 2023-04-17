package top.whiteleaf03.blog.service.tag;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whiteleaf03.blog.mapper.ArticleTagMapper;
import top.whiteleaf03.blog.mapper.TagMapper;
import top.whiteleaf03.blog.modal.dto.InsertTagDto;
import top.whiteleaf03.blog.modal.dto.TagIdDto;
import top.whiteleaf03.blog.modal.entity.ArticleTag;
import top.whiteleaf03.blog.modal.vo.TagListVo;
import top.whiteleaf03.blog.modal.vo.TagIdAndNameAndArticleTotalVo;
import top.whiteleaf03.blog.utils.ResponseResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class TagServiceImpl implements TagService {
    private final TagMapper tagMapper;
    private final ArticleTagMapper articleTagMapper;

    @Autowired
    public TagServiceImpl(TagMapper tagMapper, ArticleTagMapper articleTagMapper) {
        this.tagMapper = tagMapper;
        this.articleTagMapper = articleTagMapper;
    }

    /**
     * 新增标签
     *
     * @param insertTagDto 标签数据
     * @return 返回结果
     */
    @Override
    public ResponseResult insert(InsertTagDto insertTagDto) {
        insertTagDto.generateTagInfo();
        try {
            tagMapper.insert(insertTagDto);
        } catch (RuntimeException e) {
            log.error("新增标签失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 删除标签
     *
     * @param tagIdDto 标签数据
     * @return 返回结果
     */
    @Override
    public ResponseResult deleteById(TagIdDto tagIdDto) {
        try {
            tagMapper.deleteById(tagIdDto);
        } catch (RuntimeException e) {
            log.error("删除标签失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 获取所有标签
     *
     * @return 返回
     */
    @Override
    public ResponseResult selectName() {
        List<TagListVo> tagList;
        try {
            tagList = tagMapper.selectIdAndName();
        } catch (RuntimeException e) {
            log.error("获取所有标签失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(tagList);
    }

    /**
     * 给文章分配标签
     *
     * @param articleTag 文章id和标签id
     * @return 返回结果
     */
    @Override
    public ResponseResult insertArticleTag(ArticleTag articleTag) {
        try {
            articleTagMapper.insert(articleTag);
        } catch (RuntimeException e) {
            log.error("给文章分配标签失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 获取标签名及包含该标签的文章数量
     *
     * @return 返回
     */
    @Override
    public ResponseResult selectTagNameAndArticleTotal() {
        List<TagIdAndNameAndArticleTotalVo> tagIdAndNameAndArticleTotalVoList = new ArrayList<>();
        try {
            List<TagListVo> tagListVos = tagMapper.selectIdAndName();
            for (TagListVo tagListVo : tagListVos) {
                tagIdAndNameAndArticleTotalVoList.add(new TagIdAndNameAndArticleTotalVo(tagListVo.getId(), tagListVo.getName(), articleTagMapper.countArticleTotalByTagId(tagListVo.getId())));
            }
        } catch (RuntimeException e) {
            log.error("获取标签名及包含该标签的文章数量");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(tagIdAndNameAndArticleTotalVoList);
    }
}
