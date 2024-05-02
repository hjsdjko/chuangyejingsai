package com.dao;

import com.entity.ChuangyexiangmuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuangyexiangmuCollectionView;

/**
 * 项目收藏 Dao 接口
 *
 * @author 
 * @since 2021-04-03
 */
public interface ChuangyexiangmuCollectionDao extends BaseMapper<ChuangyexiangmuCollectionEntity> {

   List<ChuangyexiangmuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
