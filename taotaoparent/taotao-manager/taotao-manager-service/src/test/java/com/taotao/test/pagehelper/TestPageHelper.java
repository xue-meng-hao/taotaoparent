package com.taotao.test.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {

    @Test
    public void testHelper() {
        //2.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        //3.获取Mapper的代理对象
        TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
        //1.设置分页信息
        PageHelper.startPage(1, 4);//3行,紧跟着的第一个查询才会被分页
        TbItemExample tbItemExample = new TbItemExample();
        //4.调用mapper的方法查询数据
        List<TbItem> tbItems = itemMapper.selectByExample(tbItemExample);
        List<TbItem> tbItems2 = itemMapper.selectByExample(tbItemExample);
        System.out.println("第一个List长度:" + tbItems.size());
        System.out.println("第二个List长度:" + tbItems2.size());
        //取分页信息
        PageInfo<TbItem> info = new PageInfo<TbItem>(tbItems);
        System.out.println("查询的总记录数:" + info.getTotal());
        //5.遍历结果
        for (TbItem tbItem : tbItems) {
            System.out.println(tbItem.getId() + ">>" + tbItem.getTitle());
        }
    }
}
