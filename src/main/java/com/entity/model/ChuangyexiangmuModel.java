package com.entity.model;

import com.entity.ChuangyexiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 创业项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-03
 */
public class ChuangyexiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 项目具体内容
     */
    private String chuangyexiangmuContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：项目标题
	 */
    public String getChuangyexiangmuName() {
        return chuangyexiangmuName;
    }


    /**
	 * 设置：项目标题
	 */
    public void setChuangyexiangmuName(String chuangyexiangmuName) {
        this.chuangyexiangmuName = chuangyexiangmuName;
    }
    /**
	 * 获取：发布教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：发布教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：样本图片
	 */
    public String getChuangyexiangmuPhoto() {
        return chuangyexiangmuPhoto;
    }


    /**
	 * 设置：样本图片
	 */
    public void setChuangyexiangmuPhoto(String chuangyexiangmuPhoto) {
        this.chuangyexiangmuPhoto = chuangyexiangmuPhoto;
    }
    /**
	 * 获取：项目分类名称
	 */
    public Integer getLeixTypes() {
        return leixTypes;
    }


    /**
	 * 设置：项目分类名称
	 */
    public void setLeixTypes(Integer leixTypes) {
        this.leixTypes = leixTypes;
    }
    /**
	 * 获取：项目具体内容
	 */
    public String getChuangyexiangmuContent() {
        return chuangyexiangmuContent;
    }


    /**
	 * 设置：项目具体内容
	 */
    public void setChuangyexiangmuContent(String chuangyexiangmuContent) {
        this.chuangyexiangmuContent = chuangyexiangmuContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
