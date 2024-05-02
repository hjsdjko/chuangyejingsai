package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.ChuangyexiangmuCollectionDao;
import com.entity.ChuangyexiangmuCollectionEntity;
import com.service.ChuangyexiangmuCollectionService;
import com.entity.view.ChuangyexiangmuCollectionView;

/**
 * 项目收藏 服务实现类
 * @author 
 * @since 2021-04-03
 */
@Service("chuangyexiangmuCollectionService")
@Transactional
public class ChuangyexiangmuCollectionServiceImpl extends ServiceImpl<ChuangyexiangmuCollectionDao, ChuangyexiangmuCollectionEntity> implements ChuangyexiangmuCollectionService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChuangyexiangmuCollectionView> page =new Query<ChuangyexiangmuCollectionView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
