package top.whiteleaf03.blog.utils;

import cn.hutool.core.io.file.FileWriter;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import top.whiteleaf03.blog.modal.vo.EssayDetailVo;
import top.whiteleaf03.blog.modal.vo.EssayListVo;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
public class EssayJsonUtil {
    /**
     * 写入目录
     *
     * @param essayPath 存储路径
     * @param essayListVos 随笔目录
     */
    public static void writeDirectory(String essayPath, List<EssayListVo> essayListVos) {
        FileWriter essayDirectoryWriter = new FileWriter(essayPath + "directory.json");
        essayDirectoryWriter.write(JSONUtil.toJsonPrettyStr(essayListVos));
    }

    /**
     * 写入随笔
     *
     * @param essayPath 存储路径
     * @param essayDetailVo 随笔详情
     */
    public static void writeEssay(String essayPath, EssayDetailVo essayDetailVo) {
        FileWriter fileWriter = new FileWriter(essayPath + DigestUtil.md5Hex(essayDetailVo.getTitle()) + "_" + essayDetailVo.getUpdateTime() + ".json");
        fileWriter.write(JSONUtil.toJsonPrettyStr(essayDetailVo));
    }
}
