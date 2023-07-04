package top.whiteleaf03.blog.service.system;

import cn.hutool.crypto.digest.DigestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import top.whiteleaf03.blog.config.GlobalConfig;
import top.whiteleaf03.blog.mapper.*;
import top.whiteleaf03.blog.modal.vo.*;
import top.whiteleaf03.blog.utils.ArticleJsonUtil;
import top.whiteleaf03.blog.utils.EssayJsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class SystemServiceImpl implements ApplicationRunner {
    private final ArticleMapper articleMapper;
    private final EssayMapper essayMapper;
    private final GlobalConfig globalConfig;
    private final ClassificationMapper classificationMapper;
    private final ArticleClassificationMapper articleClassificationMapper;
    private final TagMapper tagMapper;
    private final ArticleTagMapper articleTagMapper;

    @Autowired
    public SystemServiceImpl(ArticleMapper articleMapper, EssayMapper essayMapper, GlobalConfig globalConfig, ClassificationMapper classificationMapper, ArticleClassificationMapper articleClassificationMapper, TagMapper tagMapper, ArticleTagMapper articleTagMapper) {
        this.articleMapper = articleMapper;
        this.essayMapper = essayMapper;
        this.globalConfig = globalConfig;
        this.classificationMapper = classificationMapper;
        this.articleClassificationMapper = articleClassificationMapper;
        this.tagMapper = tagMapper;
        this.articleTagMapper = articleTagMapper;
    }

    @Override
    public void run(ApplicationArguments args) {
        log.info("系统初始化中...");
        this.generateArticleStaticFileAndDirectory();
        this.generateEssayStaticFileAndDirectory();
        log.info("系统初始化完毕!");
    }

    public void generateArticleStaticFileAndDirectory() {
        //目录写入
        log.info("目录写入...");
        List<ArticleListVo> articleListVos;
        try {
            articleListVos = articleMapper.selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndPathAndUpdateTime();
            for (ArticleListVo articleListVo: articleListVos) {
                Long classificationId = articleClassificationMapper.selectClassificationIdByArticleId(articleListVo.getId());
                String classification = classificationMapper.selectNameById(classificationId);
                articleListVo.setClassification(classification);
                articleListVo.setFilename(DigestUtil.md5Hex(articleListVo.getTitle()));
            }
            ArticleJsonUtil.writeDirectory(globalConfig.getArticlePath(), articleListVos);
        } catch (Exception e) {
            log.info("文章目录写入失败!");
            e.printStackTrace();
            return;
        }
        //类别写入
        log.info("类别写入...");
        try {
            List<ClassificationIdAndNameAndCoverAndTotalVo> classificationIdAndNameAndCoverAndTotalVos = new ArrayList<>();
            List<ClassificationListVo> classificationListVos = classificationMapper.selectIdAndNameAndCover();
            for (ClassificationListVo classificationListVo : classificationListVos) {
                classificationIdAndNameAndCoverAndTotalVos.add(new ClassificationIdAndNameAndCoverAndTotalVo(classificationListVo.getId(), classificationListVo.getName(), classificationListVo.getCover(), articleClassificationMapper.countArticleTotalByClassificationId(classificationListVo.getId())));
            }
            ArticleJsonUtil.writeClassifications(globalConfig.getArticlePath(), classificationIdAndNameAndCoverAndTotalVos);
        } catch (Exception e) {
            log.error("类别写入失败!");
            e.printStackTrace();
            return;
        }
        //文章写入
        log.info("文章写入...");
        for (ArticleListVo articleListVo : articleListVos) {
            try {
                Long articleId = articleListVo.getId();
                Long classificationId = articleClassificationMapper.selectClassificationIdByArticleId(articleId);
                List<Long> tagIds = articleTagMapper.selectTagIdByArticleId(articleId);
                List<String> tags = new ArrayList<>();
                for (Long tagId : tagIds) {
                    tags.add(tagMapper.selectNameById(tagId));
                }
                ArticleDetailVo articleDetailVo = articleMapper.selectAuthorAndTitleAndDescribeAndClassificationAndTagsAndCoverAndContentAndFilePathAndUpdateTimeById(articleListVo.getId());
                articleDetailVo.setTags(tags);
                articleDetailVo.setClassification(classificationMapper.selectNameById(classificationId));
                ArticleJsonUtil.writeArticle(globalConfig.getArticlePath(), articleDetailVo);
            } catch (Exception e) {
                log.info("文章[{}]写入失败!", articleListVo.getTitle() + articleListVo.getUpdateTime() + ".json");
                e.printStackTrace();
            }
        }
        log.info("生成完毕!共加载了{}篇文章", articleListVos.size());
    }

    public void generateEssayStaticFileAndDirectory() {
        //目录写入
        log.info("随笔目录写入...");
        List<EssayListVo> essayListVos;
        try {
            essayListVos = essayMapper.selectTitleAndDescribeAndCoverAndUpdateTime();
            for (EssayListVo essayListVo : essayListVos) {
                essayListVo.setFilename(DigestUtil.md5Hex(essayListVo.getTitle()));
            }
            EssayJsonUtil.writeDirectory(globalConfig.getEssayPath(), essayListVos);
        } catch (Exception e) {
            log.error("随笔目录写入失败!");
            e.printStackTrace();
            return;
        }
        //随笔写入
        for (EssayListVo essayListVo : essayListVos) {
            try {
                EssayJsonUtil.writeEssay(globalConfig.getEssayPath(), essayMapper.selectTitleAndDescribeAndCoverAndContentAndUpdateTimeById(essayListVo.getId()));
            } catch (Exception e) {
                log.info("随笔[{}]写入失败!", essayListVo.getTitle() + essayListVo.getUpdateTime() + ".json");
                e.printStackTrace();
            }
        }
        log.info("随笔生成完毕!共加载了{}篇文章", essayListVos.size());
    }
}
