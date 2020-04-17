/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.test.mysql;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.test.mysql.entity.TblColumnUnderlineFalse;
import com.baomidou.mybatisplus.test.mysql.mapper.TblColumnUnderlineFalseMapper;

/**
 * <p>
 * 数据库字段驼峰命名，属性也是驼峰
 * 增加测试用例
 * </p>
 *
 * @author hubin sjy
 * @Date 2016-01-23
 */
public class ColumnUnderlineFalseTest extends CrudTest {

    @Override
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration gc = super.globalConfiguration();
        /**
         * 设置，自定义 元对象填充器，实现公共字段自动写入
         */
        gc.setMetaObjectHandler(new MyMetaObjectHandler());
        // gc.setCapitalMode(true);
        gc.setDbColumnUnderline(false);
        return gc;
    }

    /**
     * RUN 测试
     * <p>
     * <p>
     * MybatisPlus 加载 SQL 顺序：
     * </p>
     * 1、加载XML中的SQL<br>
     * 2、加载sqlProvider中的SQL<br>
     * 3、xmlSql 与 sqlProvider不能包含相同的SQL<br>
     * <br>
     * 调整后的SQL优先级：xmlSql > sqlProvider > crudSql <br>
     */
    @Test
    public void crudTest() {
        SqlSession session = this.sqlSessionFactory().openSession();
        TblColumnUnderlineFalseMapper userMapper = session.getMapper(TblColumnUnderlineFalseMapper.class);
        List<TblColumnUnderlineFalse> list = userMapper.selectList(null);
        Assert.assertFalse(list.isEmpty());
        TblColumnUnderlineFalse user = list.get(0);
        Assert.assertNotNull(user.getId());
        Assert.assertNotNull(user.getFirstName());
        Assert.assertNotNull(user.getLastName());
        /**
         * 提交
         */
        session.commit();
    }


}
