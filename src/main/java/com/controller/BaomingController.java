package com.controller;


import java.net.Inet4Address;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.BaomingEntity;

import com.service.BaomingService;
import com.entity.view.BaomingView;
import com.service.ChuangyexiangmuService;
import com.entity.ChuangyexiangmuEntity;
import com.service.JiaoshiService;
import com.entity.JiaoshiEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 报名
 * 后端接口
 * @author
 * @email
 * @date 2021-04-03
*/
@RestController
@Controller
@RequestMapping("/baoming")
public class BaomingController {
    private static final Logger logger = LoggerFactory.getLogger(BaomingController.class);

    @Autowired
    private BaomingService baomingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private ChuangyexiangmuService chuangyexiangmuService;
    @Autowired
    private JiaoshiService jiaoshiService;
    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = baomingService.queryPage(params);

        //字典表数据转换
        List<BaomingView> list =(List<BaomingView>)page.getList();
        for(BaomingView c:list){
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
        BaomingEntity baoming = baomingService.selectById(id);
        if(baoming !=null){
            //entity转view
            BaomingView view = new BaomingView();
            BeanUtils.copyProperties( baoming , view );//把实体数据重构到view中

            //级联表
            ChuangyexiangmuEntity chuangyexiangmu = chuangyexiangmuService.selectById(baoming.getChuangyexiangmuId());
            if(chuangyexiangmu != null){
                BeanUtils.copyProperties( chuangyexiangmu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setChuangyexiangmuId(chuangyexiangmu.getId());
            }
            //级联表
            JiaoshiEntity jiaoshi = jiaoshiService.selectById(baoming.getJiaoshiId());
            if(jiaoshi != null){
                BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJiaoshiId(jiaoshi.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(baoming.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody BaomingEntity baoming, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,baoming:{}",this.getClass().getName(),baoming.toString());
        Wrapper<BaomingEntity> queryWrapper = new EntityWrapper<BaomingEntity>()
            .eq("bianhao", baoming.getBianhao())
            .eq("chuangyexiangmu_id", baoming.getChuangyexiangmuId())
            .eq("yonghu_id", baoming.getYonghuId())
            .eq("baoming_phone", baoming.getBaomingPhone())
            .eq("jiaoshi_id", baoming.getJiaoshiId())
            .eq("baoming_types", baoming.getBaomingTypes())
            .eq("baoming_pingfen", baoming.getBaomingPingfen())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaomingEntity baomingEntity = baomingService.selectOne(queryWrapper);
        if(baomingEntity==null){
            baoming.setInsertTime(new Date());
            baoming.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      baoming.set
        //  }
            baomingService.insert(baoming);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BaomingEntity baoming, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,baoming:{}",this.getClass().getName(),baoming.toString());
        //根据字段查询是否有相同数据
        Wrapper<BaomingEntity> queryWrapper = new EntityWrapper<BaomingEntity>()
            .notIn("id",baoming.getId())
            .andNew()
            .eq("bianhao", baoming.getBianhao())
            .eq("chuangyexiangmu_id", baoming.getChuangyexiangmuId())
            .eq("yonghu_id", baoming.getYonghuId())
            .eq("baoming_phone", baoming.getBaomingPhone())
            .eq("jiaoshi_id", baoming.getJiaoshiId())
            .eq("baoming_types", baoming.getBaomingTypes())
            .eq("baoming_pingfen", baoming.getBaomingPingfen())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaomingEntity baomingEntity = baomingService.selectOne(queryWrapper);
        if(baomingEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      baoming.set
            //  }
            baomingService.updateById(baoming);//根据id更新
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
        baomingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 审核 报名
    */
    @RequestMapping("/shenhe")
    public R shenhe(String pingfen, Integer id,Integer shenhe){
        BaomingEntity baoming = baomingService.selectById(id);
        if(baoming == null){
            return R.error();
        }
        if(shenhe == 2){
            baoming.setBaomingPingfen(-100);
        }else{
            if(pingfen != ""){
                baoming.setBaomingPingfen(Integer.parseInt(pingfen));
            }else{
                baoming.setBaomingPingfen(null);
            }

        }
        baoming.setBaomingTypes(shenhe);
        boolean b = baomingService.updateById(baoming);
        if(b){
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
        PageUtils page = baomingService.queryPage(params);

        //字典表数据转换
        List<BaomingView> list =(List<BaomingView>)page.getList();
        for(BaomingView c:list){
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
    BaomingEntity baoming = baomingService.selectById(id);
        if(baoming !=null){
            //entity转view
    BaomingView view = new BaomingView();
            BeanUtils.copyProperties( baoming , view );//把实体数据重构到view中

            //级联表
                ChuangyexiangmuEntity chuangyexiangmu = chuangyexiangmuService.selectById(baoming.getChuangyexiangmuId());
            if(chuangyexiangmu != null){
                BeanUtils.copyProperties( chuangyexiangmu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setChuangyexiangmuId(chuangyexiangmu.getId());
            }
            //级联表
                JiaoshiEntity jiaoshi = jiaoshiService.selectById(baoming.getJiaoshiId());
            if(jiaoshi != null){
                BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJiaoshiId(jiaoshi.getId());
            }
            //级联表
                YonghuEntity yonghu = yonghuService.selectById(baoming.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
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
    public R add(@RequestBody BaomingEntity baoming, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,baoming:{}",this.getClass().getName(),baoming.toString());
        Wrapper<BaomingEntity> queryWrapper = new EntityWrapper<BaomingEntity>()
            .eq("bianhao", baoming.getBianhao())
            .eq("chuangyexiangmu_id", baoming.getChuangyexiangmuId())
            .eq("yonghu_id", baoming.getYonghuId())
            .eq("baoming_phone", baoming.getBaomingPhone())
            .eq("jiaoshi_id", baoming.getJiaoshiId())
            .eq("baoming_types", baoming.getBaomingTypes())
            .eq("baoming_pingfen", baoming.getBaomingPingfen())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    BaomingEntity baomingEntity = baomingService.selectOne(queryWrapper);
        if(baomingEntity==null){
                baoming.setInsertTime(new Date());
                baoming.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      baoming.set
        //  }
    baomingService.insert(baoming);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}

