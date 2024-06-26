package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.BaomingEntity;
import com.entity.YonghuEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ChuangyexiangmuEntity;

import com.entity.view.ChuangyexiangmuView;
import com.entity.JiaoshiEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 创业项目
 * 后端接口
 * @author
 * @email
 * @date 2021-04-03
*/
@RestController
@Controller
@RequestMapping("/chuangyexiangmu")
public class ChuangyexiangmuController {
    private static final Logger logger = LoggerFactory.getLogger(ChuangyexiangmuController.class);

    @Autowired
    private BaomingService baomingService;

    @Autowired
    private ChuangyexiangmuService chuangyexiangmuService;


    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private JiaoshiService jiaoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "学生".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        if(StringUtil.isNotEmpty(role) && "教师".equals(role)){
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = chuangyexiangmuService.queryPage(params);

        //字典表数据转换
        List<ChuangyexiangmuView> list =(List<ChuangyexiangmuView>)page.getList();
        for(ChuangyexiangmuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuangyexiangmuEntity chuangyexiangmu = chuangyexiangmuService.selectById(id);
        if(chuangyexiangmu !=null){
            //entity转view
            ChuangyexiangmuView view = new ChuangyexiangmuView();
            BeanUtils.copyProperties( chuangyexiangmu , view );//把实体数据重构到view中

            //级联表
            JiaoshiEntity jiaoshi = jiaoshiService.selectById(chuangyexiangmu.getJiaoshiId());
            if(jiaoshi != null){
                BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJiaoshiId(jiaoshi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChuangyexiangmuEntity chuangyexiangmu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuangyexiangmu:{}",this.getClass().getName(),chuangyexiangmu.toString());
        Wrapper<ChuangyexiangmuEntity> queryWrapper = new EntityWrapper<ChuangyexiangmuEntity>()
            .eq("chuangyexiangmu_name", chuangyexiangmu.getChuangyexiangmuName())
            .eq("jiaoshi_id", chuangyexiangmu.getJiaoshiId())
            .eq("leix_types", chuangyexiangmu.getLeixTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuangyexiangmuEntity chuangyexiangmuEntity = chuangyexiangmuService.selectOne(queryWrapper);
        if(chuangyexiangmuEntity==null){
            chuangyexiangmu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      chuangyexiangmu.set
        //  }
            chuangyexiangmuService.insert(chuangyexiangmu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuangyexiangmuEntity chuangyexiangmu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chuangyexiangmu:{}",this.getClass().getName(),chuangyexiangmu.toString());
        //根据字段查询是否有相同数据
        Wrapper<ChuangyexiangmuEntity> queryWrapper = new EntityWrapper<ChuangyexiangmuEntity>()
            .notIn("id",chuangyexiangmu.getId())
            .andNew()
            .eq("chuangyexiangmu_name", chuangyexiangmu.getChuangyexiangmuName())
            .eq("jiaoshi_id", chuangyexiangmu.getJiaoshiId())
            .eq("leix_types", chuangyexiangmu.getLeixTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuangyexiangmuEntity chuangyexiangmuEntity = chuangyexiangmuService.selectOne(queryWrapper);
        if("".equals(chuangyexiangmu.getChuangyexiangmuPhoto()) || "null".equals(chuangyexiangmu.getChuangyexiangmuPhoto())){
                chuangyexiangmu.setChuangyexiangmuPhoto(null);
        }
        if(chuangyexiangmuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      chuangyexiangmu.set
            //  }
            chuangyexiangmuService.updateById(chuangyexiangmu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chuangyexiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
    * 报名
    */
    @RequestMapping("/baoming")
    public R baoming(Integer ids, HttpServletRequest request){
        Integer userId = (Integer)request.getSession().getAttribute("userId");
        ChuangyexiangmuEntity chuangyexiangmu = chuangyexiangmuService.selectById(ids);
        if(chuangyexiangmu == null){
            return R.error();
        }
        YonghuEntity yonghu = yonghuService.selectById(userId);
        if(yonghu == null){
            return R.error();
        }
        long time = new Date().getTime();

        BaomingEntity baoming = new BaomingEntity();
        baoming.setBianhao(String.valueOf(time));
        baoming.setCreateTime(new Date());
        baoming.setInsertTime(new Date());
        baoming.setChuangyexiangmuId(chuangyexiangmu.getId());
        baoming.setYonghuId(userId);
        baoming.setBaomingPhone(yonghu.getYonghuPhone());
        baoming.setJiaoshiId(chuangyexiangmu.getJiaoshiId());
        Wrapper<BaomingEntity> queryWrapper = new EntityWrapper<BaomingEntity>()
                .eq("chuangyexiangmu_id", baoming.getChuangyexiangmuId())
                .eq("yonghu_id", baoming.getYonghuId())
                .eq("jiaoshi_id", baoming.getJiaoshiId())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaomingEntity baomingEntity = baomingService.selectOne(queryWrapper);
        if(baomingEntity!=null){
            return R.error("你已经报名这个项目了");
        }
        boolean insert = baomingService.insert(baoming);
        if(insert){
            return R.ok();
        }
        return R.error();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = chuangyexiangmuService.queryPage(params);

        //字典表数据转换
        List<ChuangyexiangmuView> list =(List<ChuangyexiangmuView>)page.getList();
        for(ChuangyexiangmuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
    ChuangyexiangmuEntity chuangyexiangmu = chuangyexiangmuService.selectById(id);
        if(chuangyexiangmu !=null){
            //entity转view
    ChuangyexiangmuView view = new ChuangyexiangmuView();
            BeanUtils.copyProperties( chuangyexiangmu , view );//把实体数据重构到view中

            //级联表
                JiaoshiEntity jiaoshi = jiaoshiService.selectById(chuangyexiangmu.getJiaoshiId());
            if(jiaoshi != null){
                BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJiaoshiId(jiaoshi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChuangyexiangmuEntity chuangyexiangmu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chuangyexiangmu:{}",this.getClass().getName(),chuangyexiangmu.toString());
        Wrapper<ChuangyexiangmuEntity> queryWrapper = new EntityWrapper<ChuangyexiangmuEntity>()
            .eq("chuangyexiangmu_name", chuangyexiangmu.getChuangyexiangmuName())
            .eq("jiaoshi_id", chuangyexiangmu.getJiaoshiId())
            .eq("leix_types", chuangyexiangmu.getLeixTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    ChuangyexiangmuEntity chuangyexiangmuEntity = chuangyexiangmuService.selectOne(queryWrapper);
        if(chuangyexiangmuEntity==null){
                chuangyexiangmu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      chuangyexiangmu.set
        //  }
    chuangyexiangmuService.insert(chuangyexiangmu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}

