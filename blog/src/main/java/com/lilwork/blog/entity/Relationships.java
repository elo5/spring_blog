package com.lilwork.blog.entity;

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
    public class Relationships implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer cid;

    private Integer mid;


}
