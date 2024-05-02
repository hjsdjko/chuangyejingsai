package com.entity.view;

import com.entity.HuojiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 获奖项目
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-03
 */
@TableName("huojiang")
public class HuojiangView extends HuojiangEntity implements Serializable {
    private static final long serialVersionUID = 1L;



	public HuojiangView() {

	}

	public HuojiangView(HuojiangEntity huojiangEntity) {
		try {
			BeanUtils.copyProperties(this, huojiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
















}
