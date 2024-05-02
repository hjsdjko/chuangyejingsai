package com.entity.view;

import com.entity.BaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 报名
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-03
 */
@TableName("baoming")
public class BaomingView extends BaomingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 审核结果的值
		*/
		private String baomingValue;



		//级联表 chuangyexiangmu
			/**
			* 项目标题
			*/
			private String chuangyexiangmuName;
			/**
			* 发布教师
			*/
			private Integer jiaoshiId;
			/**
			* 样本图片
			*/
			private String chuangyexiangmuPhoto;
			/**
			* 项目分类名称
			*/
			private Integer leixTypes;
				/**
				* 项目分类名称的值
				*/
				private String leixValue;
			/**
			* 项目具体内容
			*/
			private String chuangyexiangmuContent;

		//级联表 jiaoshi
			/**
			 * 姓名
			 */
			private String jiaoshiName;
			/**
			* 身份证号
			*/
			private String jiaoshiIdNumber;
			/**
			* 手机号
			*/
			private String jiaoshiPhone;
			/**
			* 照片
			*/
			private String jiaoshiPhoto;

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

	public BaomingView() {

	}

	public BaomingView(BaomingEntity baomingEntity) {
		try {
			BeanUtils.copyProperties(this, baomingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核结果的值
			*/
			public String getBaomingValue() {
				return baomingValue;
			}
			/**
			* 设置： 审核结果的值
			*/
			public void setBaomingValue(String baomingValue) {
				this.baomingValue = baomingValue;
			}
















				//级联表的get和set chuangyexiangmu
					/**
					* 获取： 项目标题
					*/
					public String getChuangyexiangmuName() {
						return chuangyexiangmuName;
					}
					/**
					* 设置： 项目标题
					*/
					public void setChuangyexiangmuName(String chuangyexiangmuName) {
						this.chuangyexiangmuName = chuangyexiangmuName;
					}
					/**
					* 获取： 发布教师
					*/
					public Integer getJiaoshiId() {
						return jiaoshiId;
					}
					/**
					* 设置： 发布教师
					*/
					public void setJiaoshiId(Integer jiaoshiId) {
						this.jiaoshiId = jiaoshiId;
					}
					/**
					* 获取： 样本图片
					*/
					public String getChuangyexiangmuPhoto() {
						return chuangyexiangmuPhoto;
					}
					/**
					* 设置： 样本图片
					*/
					public void setChuangyexiangmuPhoto(String chuangyexiangmuPhoto) {
						this.chuangyexiangmuPhoto = chuangyexiangmuPhoto;
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
					* 获取： 项目具体内容
					*/
					public String getChuangyexiangmuContent() {
						return chuangyexiangmuContent;
					}
					/**
					* 设置： 项目具体内容
					*/
					public void setChuangyexiangmuContent(String chuangyexiangmuContent) {
						this.chuangyexiangmuContent = chuangyexiangmuContent;
					}

	public String getJiaoshiName() {
		return jiaoshiName;
	}

	public void setJiaoshiName(String jiaoshiName) {
		this.jiaoshiName = jiaoshiName;
	}


//级联表的get和set jiaoshi
					/**
					* 获取： 身份证号
					*/
					public String getJiaoshiIdNumber() {
						return jiaoshiIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setJiaoshiIdNumber(String jiaoshiIdNumber) {
						this.jiaoshiIdNumber = jiaoshiIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getJiaoshiPhone() {
						return jiaoshiPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setJiaoshiPhone(String jiaoshiPhone) {
						this.jiaoshiPhone = jiaoshiPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getJiaoshiPhoto() {
						return jiaoshiPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setJiaoshiPhoto(String jiaoshiPhoto) {
						this.jiaoshiPhoto = jiaoshiPhoto;
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
