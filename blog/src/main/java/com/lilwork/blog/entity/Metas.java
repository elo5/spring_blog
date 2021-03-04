package com.lilwork.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    public class Metas implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "mid", type = IdType.AUTO)
      private Integer mid;

    private String name;

    private String slug;

    private String type;

    @TableField("contentType")
    private String contenttype;

    private String description;

    private Integer sort;

    private Integer parent;


}
