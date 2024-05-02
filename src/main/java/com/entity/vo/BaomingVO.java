package com.entity.vo;

import com.entity.BaomingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-03
 */
@TableName("baoming")
public class BaomingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 竞赛编号
     */

    @TableField(value = "bianhao")
    private String bianhao;


    /**
     * 竞赛名称
     */

    @TableField(value = "chuangyexiangmu_id")
    private Integer chuangyexiangmuId;


    /**
     * 申请学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 电话
     */

    @TableField(value = "baoming_phone")
    private String baomingPhone;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 教师
     */

    @TableField(value = "jiaoshi_id")
    private Integer jiaoshiId;


    /**
     * 审核结果
     */

    @TableField(value = "baoming_types")
    private Integer baomingTypes;


    /**
     * 评分
     */

    @TableField(value = "baoming_pingfen")
    private Integer baomingPingfen;


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
	 * 设置：竞赛编号
	 */
    public String getBianhao() {
        return bianhao;
    }


    /**
	 * 获取：竞赛编号
	 */

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }
    /**
	 * 设置：竞赛名称
	 */
    public Integer getChuangyexiangmuId() {
        return chuangyexiangmuId;
    }


    /**
	 * 获取：竞赛名称
	 */

    public void setChuangyexiangmuId(Integer chuangyexiangmuId) {
        this.chuangyexiangmuId = chuangyexiangmuId;
    }
    /**
	 * 设置：申请学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：申请学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：电话
	 */
    public String getBaomingPhone() {
        return baomingPhone;
    }


    /**
	 * 获取：电话
	 */

    public void setBaomingPhone(String baomingPhone) {
        this.baomingPhone = baomingPhone;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：审核结果
	 */
    public Integer getBaomingTypes() {
        return baomingTypes;
    }


    /**
	 * 获取：审核结果
	 */

    public void setBaomingTypes(Integer baomingTypes) {
        this.baomingTypes = baomingTypes;
    }
    /**
	 * 设置：评分
	 */
    public Integer getBaomingPingfen() {
        return baomingPingfen;
    }


    /**
	 * 获取：评分
	 */

    public void setBaomingPingfen(Integer baomingPingfen) {
        this.baomingPingfen = baomingPingfen;
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
