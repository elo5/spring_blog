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
    public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "uid", type = IdType.AUTO)
      private Integer uid;

    private String username;

    private String password;

    private String email;

    @TableField("homeUrl")
    private String homeurl;

    @TableField("screenName")
    private String screenname;

      @TableField(fill = FieldFill.INSERT)
      private Integer created;

    private Integer activated;

    private Integer logged;

    @TableField("groupName")
    private String groupname;


}
