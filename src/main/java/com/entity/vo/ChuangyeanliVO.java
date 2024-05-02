package com.entity.vo;

import com.entity.ChuangyeanliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 创业案例
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-03
 */
@TableName("chuangyeanli")
public class ChuangyeanliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 案例名称
     */

    @TableField(value = "chuangyeanli_name")
    private String chuangyeanliName;


    /**
     * 项目分类名称
     */

    @TableField(value = "leix_types")
    private Integer leixTypes;


    /**
     * 封面
     */

    @TableField(value = "chuangyeanli_photo")
    private String chuangyeanliPhoto;


    /**
     * 视频
     */

    @TableField(value = "chuangyeanli_video")
    private String chuangyeanliVideo;


    /**
     * 案例详情
     */

    @TableField(value = "chuangyeanli_content")
    private String chuangyeanliContent;


    /**
     * 创建时间 show2 show1 photoShow
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
	 * 设置：案例名称
	 */
    public String getChuangyeanliName() {
        return chuangyeanliName;
    }


    /**
	 * 获取：案例名称
	 */

    public void setChuangyeanliName(String chuangyeanliName) {
        this.chuangyeanliName = chuangyeanliName;
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
	 * 设置：封面
	 */
    public String getChuangyeanliPhoto() {
        return chuangyeanliPhoto;
    }


    /**
	 * 获取：封面
	 */

    public void setChuangyeanliPhoto(String chuangyeanliPhoto) {
        this.chuangyeanliPhoto = chuangyeanliPhoto;
    }
    /**
	 * 设置：视频
	 */
    public String getChuangyeanliVideo() {
        return chuangyeanliVideo;
    }


    /**
	 * 获取：视频
	 */

    public void setChuangyeanliVideo(String chuangyeanliVideo) {
        this.chuangyeanliVideo = chuangyeanliVideo;
    }
    /**
	 * 设置：案例详情
	 */
    public String getChuangyeanliContent() {
        return chuangyeanliContent;
    }


    /**
	 * 获取：案例详情
	 */

    public void setChuangyeanliContent(String chuangyeanliContent) {
        this.chuangyeanliContent = chuangyeanliContent;
    }
    /**
	 * 设置：创建时间 show2 show1 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show2 show1 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
