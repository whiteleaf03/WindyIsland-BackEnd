package top.whiteleaf03.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.whiteleaf03.blog.modal.dto.ArticleIdDto;
import top.whiteleaf03.blog.modal.dto.ArticlePageDto;
import top.whiteleaf03.blog.modal.dto.InsertArticleDto;
import top.whiteleaf03.blog.modal.dto.UpdateArticleDto;
import top.whiteleaf03.blog.service.article.ArticleService;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    /**
     * 新增新文章
     *
     * @param insertArticleDto 新文章内容
     * @return 返回结果
     */
    @PostMapping("")
    ResponseResult insertArticle(@RequestBody InsertArticleDto insertArticleDto) {
        return articleService.insert(insertArticleDto);
    }

    /**
     * 删除文章
     *
     * @param articleIdDto 包含文章id
     * @return 返回结果
     */
    @DeleteMapping("")
    ResponseResult deleteById(@RequestBody ArticleIdDto articleIdDto) {
        return articleService.deleteById(articleIdDto);
    }

    /**
     * 查询文章列表
     *
     * @return 返回结果
     */
    @GetMapping("list")
    ResponseResult selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndUpdateTime() {
        return articleService.selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndUpdateTime();
    }

    /**
     * 分页查询文章列表
     *
     * @param articlePageDto 分页页号
     * @return 返回结果
     */
    @GetMapping("list/page")
    ResponseResult selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndUpdateTimeInPaging(ArticlePageDto articlePageDto) {
        return articleService.selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndUpdateTimeInPaging(articlePageDto);
    }

    /**
     * 统计分页查询时总数
     *
     * @return 返回总数
     */
    @GetMapping("list/page/size")
    ResponseResult countPageSizeInPaging() {
        return articleService.countPageSizeInPaging();
    }

    /**
     * 前台根据id获取文章内容
     *
     * @param articleIdDto 包含文章id
     * @return 返回结果
     */
    @GetMapping("")
    ResponseResult selectAuthorAndTitleAndDescribeAndCoverAndContentAndFilePathAndUpdateTimeById(ArticleIdDto articleIdDto) {
        return articleService.selectAuthorAndTitleAndDescribeAndCoverAndContentAndFilePathAndUpdateTimeById(articleIdDto);
    }

    /**
     * 修改文章信息
     *
     * @param updateArticleDto 修改的信息
     * @return 返回结果
     */
    @PutMapping("")
    public ResponseResult updateTitleOrClassificationIdOrTagIdsOrCoverOrDescribeOrBorderColor(@RequestBody UpdateArticleDto updateArticleDto) {
        return articleService.updateTitleOrClassificationIdOrTagIdsOrCoverOrDescribeOrBorderColor(updateArticleDto);
    }
}
