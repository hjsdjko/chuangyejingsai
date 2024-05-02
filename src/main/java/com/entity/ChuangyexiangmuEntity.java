package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 创业项目
 *
 * @author 
 * @email
 * @date 2021-04-03
 */
@TableName("chuangyexiangmu")
public class ChuangyexiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuangyexiangmuEntity() {

	}

	public ChuangyexiangmuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 项目标题
     */
    @TableField(value = "chuangyexiangmu_name")

    private String chuangyexiangmuName;


    /**
     * 发布教师
     */
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 样本图片
     */
    @TableField(value = "chuangyexiangmu_photo")

    private String chuangyexiangmuPhoto;


    /**
     * 项目分类名称
     */
    @TableField(value = "leix_types")

    private Integer leixTypes;


    /**
     * 项目具体内容
     */
    @TableField(value = "chuangyexiangmu_content")

    private String chuangyexiangmuContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：项目标题
	 */
    public String getChuangyexiangmuName() {
        return chuangyexiangmuName;
    }


    /**
	 * 获取：项目标题
	 */

    public void setChuangyexiangmuName(String chuangyexiangmuName) {
        this.chuangyexiangmuName = chuangyexiangmuName;
    }
    /**
	 * 设置：发布教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：发布教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：样本图片
	 */
    public String getChuangyexiangmuPhoto() {
        return chuangyexiangmuPhoto;
    }


    /**
	 * 获取：样本图片
	 */

    public void setChuangyexiangmuPhoto(String chuangyexiangmuPhoto) {
        this.chuangyexiangmuPhoto = chuangyexiangmuPhoto;
    }
    /**
	 * 设置：项目分类名称
	 */
    public Integer getLeixTypes() {
        return leixTypes;
    }


    /**
	 * 获取：项目分类名称
	 */

    public void setLeixTypes(Integer leixTypes) {
        this.leixTypes = leixTypes;
    }
    /**
	 * 设置：项目具体内容
	 */
    public String getChuangyexiangmuContent() {
        return chuangyexiangmuContent;
    }


    /**
	 * 获取：项目具体内容
	 */

    public void setChuangyexiangmuContent(String chuangyexiangmuContent) {
        this.chuangyexiangmuContent = chuangyexiangmuContent;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chuangyexiangmu{" +
            "id=" + id +
            ", chuangyexiangmuName=" + chuangyexiangmuName +
            ", jiaoshiId=" + jiaoshiId +
            ", chuangyexiangmuPhoto=" + chuangyexiangmuPhoto +
            ", leixTypes=" + leixTypes +
            ", chuangyexiangmuContent=" + chuangyexiangmuContent +
            ", createTime=" + createTime +
        "}";
    }
}
