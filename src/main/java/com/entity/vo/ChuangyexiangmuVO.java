package com.entity.vo;

import com.entity.ChuangyexiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 创业项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-03
 */
@TableName("chuangyexiangmu")
public class ChuangyexiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
