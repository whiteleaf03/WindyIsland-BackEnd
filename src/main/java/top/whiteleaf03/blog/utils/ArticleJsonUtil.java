package top.whiteleaf03.blog.utils;

import cn.hutool.core.io.file.FileWriter;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import top.whiteleaf03.blog.modal.vo.ArticleDetailVo;
import top.whiteleaf03.blog.modal.vo.ArticleListVo;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
public class ArticleJsonUtil {
    /**
     * 写入目录
     *
     * @param articlePath 文章存储路径
     * @param articleListVos 文章目录
     */
    public static void writeDirectory(String articlePath, List<ArticleListVo> articleListVos) {
        FileWriter articleDirectoryWriter = new FileWriter(articlePath + "directory.json");
        articleDirectoryWriter.write(JSONUtil.toJsonPrettyStr(articleListVos));
    }

    public static void writeClassifications(String articlePath, String[] classifications) {
        FileWriter classificationsWriter = new FileWriter(articlePath + "classifications.json");
        classificationsWriter.write(JSONUtil.toJsonPrettyStr(classifications));
    }

    /**
     * 写入文章
     *
     * @param articlePath 文章存储路径
     * @param articleDetailVo 文章详情
     */
    public static void writeArticle(String articlePath, ArticleDetailVo articleDetailVo) {
        FileWriter fileWriter = new FileWriter(articlePath + articleDetailVo.getTitle() + "_" + articleDetailVo.getUpdateTime() + ".json");
        fileWriter.write(JSONUtil.toJsonPrettyStr(articleDetailVo));
    }
}
