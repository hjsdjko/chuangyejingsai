package com.dao;

import com.entity.HuojiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuojiangView;

/**
 * 获奖项目 Dao 接口
 *
 * @author 
 * @since 2021-04-03
 */
public interface HuojiangDao extends BaseMapper<HuojiangEntity> {

   List<HuojiangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
