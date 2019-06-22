/**
 * Copyright 2018 人人开源 http://www.renren.io
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

package io.renren.common.utils;

import com.baomidou.mybatisplus.plugins.Page;
import io.renren.common.xss.SQLFilter;
import org.apache.commons.lang.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 *
 * @author Mark sunlightcs@gmail.com
 * @since 2.0.0 2017-03-14
 */
public class Query<T> extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private int currentPage = 0;
    /**
     * 每页条数
     */
    private int pageSize = 30;

    public Query(Map<String, Object> params){
        this.putAll(params);

        //分页参数
        if(params.get("currentPage") != null){
            currentPage = Integer.parseInt((String)params.get("currentPage"));
        }
        if(params.get("pageSize") != null){
            pageSize = Integer.parseInt((String)params.get("pageSize"));
        }

        this.put("offset", (currentPage - 1) * pageSize);
        this.put("currentPage", currentPage);
        this.put("pageSize", pageSize);

        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String order = SQLFilter.sqlInject((String)params.get("sort"));
        this.put("sort", order);

        //mybatis-plus分页
        this.page = new Page<>(currentPage, pageSize);

        //排序
        if("asc".equals(order)){
            this.page.setAsc("ASC".equalsIgnoreCase(order));
        }else{
            this.page.setAsc(false);
        }


    }

    public Page<T> getPage() {
        return page;
    }

    public int getCurrPage() {
        return currentPage;
    }

    public int getLimit() {
        return pageSize;
    }
}
