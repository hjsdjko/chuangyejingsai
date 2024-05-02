package com.entity.view;

import com.entity.ChuangyeanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 创业案例
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-03
 */
@TableName("chuangyeanli")
public class ChuangyeanliView extends ChuangyeanliEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 项目分类名称的值
		*/
		private String leixValue;



	public ChuangyeanliView() {

	}

	public ChuangyeanliView(ChuangyeanliEntity chuangyeanliEntity) {
		try {
			BeanUtils.copyProperties(this, chuangyeanliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 项目分类名称的值
			*/
			public String getLeixValue() {
				return leixValue;
			}
			/**
			* 设置： 项目分类名称的值
			*/
			public void setLeixValue(String leixValue) {
				this.leixValue = leixValue;
			}













}
