package com.baomidou.mybatisplus.test.mysql.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

/**
 * <p>
 * </p>
 *
 * @author yuxiaobin
 * @date 2020/4/17
 */
@TableName("tbl_column_underline_false")
@Data
public class TblColumnUnderlineFalse {

    @TableId("id")
    private Long id;

    private String firstName;

    private String lastName;

}
