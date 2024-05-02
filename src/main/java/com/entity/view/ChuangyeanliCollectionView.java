package com.entity.view;

import com.entity.ChuangyeanliCollectionEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 案例收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-03
 */
@TableName("chuangyeanli_collection")
public class ChuangyeanliCollectionView extends ChuangyeanliCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 chuangyeanli
			/**
			* 案例名称
			*/
			private String chuangyeanliName;
			/**
			* 项目分类名称
			*/
			private Integer leixTypes;
				/**
				* 项目分类名称的值
				*/
				private String leixValue;
			/**
			* 封面
			*/
			private String chuangyeanliPhoto;
			/**
			* 视频
			*/
			private String chuangyeanliVideo;
			/**
			* 案例详情
			*/
			private String chuangyeanliContent;

		//级联表 yonghu
			/**
			* 账户
			*/
			private String username;
			/**
			* 密码
			*/
			private String password;
			/**
			* 姓名
			*/
			private String yonghuName;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 照片
			*/
			private String yonghuPhoto;

	public ChuangyeanliCollectionView() {

	}

	public ChuangyeanliCollectionView(ChuangyeanliCollectionEntity chuangyeanliCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, chuangyeanliCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}










				//级联表的get和set chuangyeanli
					/**
					* 获取： 案例名称
					*/
					public String getChuangyeanliName() {
						return chuangyeanliName;
					}
					/**
					* 设置： 案例名称
					*/
					public void setChuangyeanliName(String chuangyeanliName) {
						this.chuangyeanliName = chuangyeanliName;
					}
					/**
					* 获取： 项目分类名称
					*/
					public Integer getLeixTypes() {
						return leixTypes;
					}
					/**
					* 设置： 项目分类名称
					*/
					public void setLeixTypes(Integer leixTypes) {
						this.leixTypes = leixTypes;
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
					/**
					* 获取： 封面
					*/
					public String getChuangyeanliPhoto() {
						return chuangyeanliPhoto;
					}
					/**
					* 设置： 封面
					*/
					public void setChuangyeanliPhoto(String chuangyeanliPhoto) {
						this.chuangyeanliPhoto = chuangyeanliPhoto;
					}
					/**
					* 获取： 视频
					*/
					public String getChuangyeanliVideo() {
						return chuangyeanliVideo;
					}
					/**
					* 设置： 视频
					*/
					public void setChuangyeanliVideo(String chuangyeanliVideo) {
						this.chuangyeanliVideo = chuangyeanliVideo;
					}
					/**
					* 获取： 案例详情
					*/
					public String getChuangyeanliContent() {
						return chuangyeanliContent;
					}
					/**
					* 设置： 案例详情
					*/
					public void setChuangyeanliContent(String chuangyeanliContent) {
						this.chuangyeanliContent = chuangyeanliContent;
					}

























				//级联表的get和set yonghu
					/**
					* 获取： 账户
					*/
					public String getUsername() {
						return username;
					}
					/**
					* 设置： 账户
					*/
					public void setUsername(String username) {
						this.username = username;
					}
					/**
					* 获取： 密码
					*/
					public String getPassword() {
						return password;
					}
					/**
					* 设置： 密码
					*/
					public void setPassword(String password) {
						this.password = password;
					}
					/**
					* 获取： 姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}



}
