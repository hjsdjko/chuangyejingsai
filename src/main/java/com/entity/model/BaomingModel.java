package com.entity.model;

import com.entity.BaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-03
 */
public class BaomingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 竞赛编号
     */
    private String bianhao;


    /**
     * 竞赛名称
     */
    private Integer chuangyexiangmuId;


    /**
     * 申请学生
     */
    private Integer yonghuId;


    /**
     * 电话
     */
    private String baomingPhone;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 教师
     */
    private Integer jiaoshiId;


    /**
     * 审核结果
     */
    private Integer baomingTypes;


    /**
     * 评分
     */
    private Integer baomingPingfen;


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
	 * 获取：竞赛编号
	 */
    public String getBianhao() {
        return bianhao;
    }


    /**
	 * 设置：竞赛编号
	 */
    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }
    /**
	 * 获取：竞赛名称
	 */
    public Integer getChuangyexiangmuId() {
        return chuangyexiangmuId;
    }


    /**
	 * 设置：竞赛名称
	 */
    public void setChuangyexiangmuId(Integer chuangyexiangmuId) {
        this.chuangyexiangmuId = chuangyexiangmuId;
    }
    /**
	 * 获取：申请学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：申请学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：电话
	 */
    public String getBaomingPhone() {
        return baomingPhone;
    }


    /**
	 * 设置：电话
	 */
    public void setBaomingPhone(String baomingPhone) {
        this.baomingPhone = baomingPhone;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：审核结果
	 */
    public Integer getBaomingTypes() {
        return baomingTypes;
    }


    /**
	 * 设置：审核结果
	 */
    public void setBaomingTypes(Integer baomingTypes) {
        this.baomingTypes = baomingTypes;
    }
    /**
	 * 获取：评分
	 */
    public Integer getBaomingPingfen() {
        return baomingPingfen;
    }


    /**
	 * 设置：评分
	 */
    public void setBaomingPingfen(Integer baomingPingfen) {
        this.baomingPingfen = baomingPingfen;
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
