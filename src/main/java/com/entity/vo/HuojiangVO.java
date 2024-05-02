package com.entity.vo;

import com.entity.HuojiangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 获奖项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-03
 */
@TableName("huojiang")
public class HuojiangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
