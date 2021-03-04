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
    public class Logs implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 主键编号
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 事件
     */
      private String action;

      /**
     * 数据
     */
      private String data;

      /**
     * 作者编号
     */
      @TableField("authorId")
    private Integer authorid;

      /**
     * ip地址
     */
      private String ip;

      @TableField(fill = FieldFill.INSERT)
      private Integer created;


}
