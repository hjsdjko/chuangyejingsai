package com.entity.model;

import com.entity.ChuangyeanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 创业案例
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-03
 */
public class ChuangyeanliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 案例名称
     */
    private String chuangyeanliName;


    /**
     * 项目分类名称
     */
    private Integer leixTypes;


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


    /**
     * 创建时间 show2 show1 photoShow
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
	 * 获取：案例名称
	 */
    public String getChuangyeanliName() {
        return chuangyeanliName;
    }


    /**
	 * 设置：案例名称
	 */
    public void setChuangyeanliName(String chuangyeanliName) {
        this.chuangyeanliName = chuangyeanliName;
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
	 * 获取：封面
	 */
    public String getChuangyeanliPhoto() {
        return chuangyeanliPhoto;
    }


    /**
	 * 设置：封面
	 */
    public void setChuangyeanliPhoto(String chuangyeanliPhoto) {
        this.chuangyeanliPhoto = chuangyeanliPhoto;
    }
    /**
	 * 获取：视频
	 */
    public String getChuangyeanliVideo() {
        return chuangyeanliVideo;
    }


    /**
	 * 设置：视频
	 */
    public void setChuangyeanliVideo(String chuangyeanliVideo) {
        this.chuangyeanliVideo = chuangyeanliVideo;
    }
    /**
	 * 获取：案例详情
	 */
    public String getChuangyeanliContent() {
        return chuangyeanliContent;
    }


    /**
	 * 设置：案例详情
	 */
    public void setChuangyeanliContent(String chuangyeanliContent) {
        this.chuangyeanliContent = chuangyeanliContent;
    }
    /**
	 * 获取：创建时间 show2 show1 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 show1 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
