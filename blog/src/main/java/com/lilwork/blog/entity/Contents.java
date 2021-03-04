package com.lilwork.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lil
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Contents implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "cid", type = IdType.AUTO)
      private Integer cid;

    private String title;

    @TableField("titlePic")
    private String titlepic;

    private String slug;

      @TableField(fill = FieldFill.INSERT)
      private Integer created;

      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Integer modified;

      /**
     * 内容文字
     */
      private String content;

    @TableField("authorId")
    private Integer authorid;

    private String type;

    private String status;

    private String tags;

    private String categories;

    private Integer hits;

    @TableField("commentsNum")
    private Integer commentsnum;

    @TableField("allowComment")
    private Boolean allowcomment;

    @TableField("allowPing")
    private Boolean allowping;

    @TableField("allowFeed")
    private Boolean allowfeed;


}
