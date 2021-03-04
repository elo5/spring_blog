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
    public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "coid", type = IdType.AUTO)
      private Integer coid;

    private Integer cid;

      @TableField(fill = FieldFill.INSERT)
      private Integer created;

    private String author;

    @TableField("authorId")
    private Integer authorid;

    @TableField("ownerId")
    private Integer ownerid;

    private String mail;

    private String url;

    private String ip;

    private String agent;

    private String content;

    private String type;

    private String status;

    private Integer parent;


}
