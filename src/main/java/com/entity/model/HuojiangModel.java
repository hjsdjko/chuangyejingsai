package com.entity.model;

import com.entity.HuojiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 获奖项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-03
 */
public class HuojiangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 获奖项目
     */
    private String huojiangName;


    /**
     * 参与人员
     */
    private String canyurenyuan;


    /**
     * 项目图片
     */
    private String huojiangPhoto;


    /**
     * 项目详情
     */
    private String huojiangContent;


    /**
     * 创建时间
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
	 * 获取：获奖项目
	 */
    public String getHuojiangName() {
        return huojiangName;
    }


    /**
	 * 设置：获奖项目
	 */
    public void setHuojiangName(String huojiangName) {
        this.huojiangName = huojiangName;
    }
    /**
	 * 获取：参与人员
	 */
    public String getCanyurenyuan() {
        return canyurenyuan;
    }


    /**
	 * 设置：参与人员
	 */
    public void setCanyurenyuan(String canyurenyuan) {
        this.canyurenyuan = canyurenyuan;
    }
    /**
	 * 获取：项目图片
	 */
    public String getHuojiangPhoto() {
        return huojiangPhoto;
    }


    /**
	 * 设置：项目图片
	 */
    public void setHuojiangPhoto(String huojiangPhoto) {
        this.huojiangPhoto = huojiangPhoto;
    }
    /**
	 * 获取：项目详情
	 */
    public String getHuojiangContent() {
        return huojiangContent;
    }


    /**
	 * 设置：项目详情
	 */
    public void setHuojiangContent(String huojiangContent) {
        this.huojiangContent = huojiangContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
