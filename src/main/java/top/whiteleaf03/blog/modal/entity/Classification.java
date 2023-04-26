package top.whiteleaf03.blog.modal.entity;

/**
 * @author WhiteLeaf03
 */
public class Classification {
    /**
     * 主键自增
     */
    private Long id;

    /**
     * 分类名
     */
    private String name;

    /**
     * 分类封面
     */
    private String cover;

    /**
     * 上传时间
     */
    private Long updateTime;

    /**
     * 是否删除
     */
    private Boolean isDelete;
}
