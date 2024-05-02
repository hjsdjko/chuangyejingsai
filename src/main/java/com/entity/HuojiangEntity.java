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
 * 获奖项目
 *
 * @author 
 * @email
 * @date 2021-04-03
 */
@TableName("huojiang")
public class HuojiangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuojiangEntity() {

	}

	public HuojiangEntity(T t) {
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
     * 获奖项目
     */
    @TableField(value = "huojiang_name")

    private String huojiangName;


    /**
     * 参与人员
     */
    @TableField(value = "canyurenyuan")

    private String canyurenyuan;


    /**
     * 项目图片
     */
    @TableField(value = "huojiang_photo")

    private String huojiangPhoto;


    /**
     * 项目详情
     */
    @TableField(value = "huojiang_content")

    private String huojiangContent;


    /**
     * 创建时间
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
	 * 设置：获奖项目
	 */
    public String getHuojiangName() {
        return huojiangName;
    }


    /**
	 * 获取：获奖项目
	 */

    public void setHuojiangName(String huojiangName) {
        this.huojiangName = huojiangName;
    }
    /**
	 * 设置：参与人员
	 */
    public String getCanyurenyuan() {
        return canyurenyuan;
    }


    /**
	 * 获取：参与人员
	 */

    public void setCanyurenyuan(String canyurenyuan) {
        this.canyurenyuan = canyurenyuan;
    }
    /**
	 * 设置：项目图片
	 */
    public String getHuojiangPhoto() {
        return huojiangPhoto;
    }


    /**
	 * 获取：项目图片
	 */

    public void setHuojiangPhoto(String huojiangPhoto) {
        this.huojiangPhoto = huojiangPhoto;
    }
    /**
	 * 设置：项目详情
	 */
    public String getHuojiangContent() {
        return huojiangContent;
    }


    /**
	 * 获取：项目详情
	 */

    public void setHuojiangContent(String huojiangContent) {
        this.huojiangContent = huojiangContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Huojiang{" +
            "id=" + id +
            ", huojiangName=" + huojiangName +
            ", canyurenyuan=" + canyurenyuan +
            ", huojiangPhoto=" + huojiangPhoto +
            ", huojiangContent=" + huojiangContent +
            ", createTime=" + createTime +
        "}";
    }
}
