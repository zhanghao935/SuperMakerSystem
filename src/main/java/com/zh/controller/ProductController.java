package com.zh.controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.pojo.ProductPo;
import com.zh.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品控制器
 *
 * @author ZHANGHAO
 */
@RestController
@RequestMapping(value = "/apis/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 获取全部商品
     *
     * @return
     */
    @RequestMapping(value = "findList", method = RequestMethod.POST)
    public Object findList() {
        String str = productService.findByDeleteState(1).stream().collect(Collectors.groupingBy(ProductPo::getProductName)).entrySet().stream()
                .map(item -> {
                    String name = item.getKey();
                    Integer count = item.getValue().size();
                    ProductPo itemPo = item.getValue().get(0);
                    JSONObject json = new JSONObject();
                    json.put("name", name);
                    json.put("count", count);
                    json.put("itemPo", itemPo);
                    json.put("price", count * itemPo.getPrice());
                    return json;
                }).min((a, b) -> b.getInteger("price").compareTo(a.getInteger("price")))
                .map(item -> "经过统计" + item.getString("name") + "商品销售量最高,销售了" + item.getInteger("count") + "件,销售额是:" + item.getInteger("price")).orElse(StringUtils.EMPTY);

        List<JSONObject> collect = productService.findList()
                .stream()
                .collect(Collectors.groupingBy(ProductPo::getProductName)).entrySet().stream().map(item -> {
                    JSONObject json = new JSONObject();
                    json.put("name", item.getKey());
                    json.put("count", item.getValue().size());
                    json.put("price", item.getValue().get(0).getPrice());
                    return json;
                }).collect(Collectors.toList());
        JSONObject json = new JSONObject();
        json.put("message", str);
        json.put("collect", collect);
        return json;
    }

    /**
     * 添加商品
     *
     * @return Object
     */
    @RequestMapping(value = "addProduct", method = RequestMethod.POST)
    public Object addProduct(String productName,
                             Integer productPice,
                             String createTime,
                             String endTime) throws Exception {
        ProductPo po = new ProductPo();
        po.setCreateTime(parseDate(createTime));
        po.setEndTime(parseDate(endTime));
        po.setProductName(productName);
        po.setPrice(productPice);
        po.setDeleteState(0);
		return productService.save(po);
    }

    /**
     * 添加购车
     *
     * @return Object
     */
    @RequestMapping(value = "addProductCar", method = RequestMethod.POST)
    public Object addProductCar(String productName) {
        List<ProductPo> list = productService.findByProductName(productName);
        ProductPo po = null;
        if (list.size() != 0) {
            Long id = list.get(0).getId();
            po = productService.findById(id);
            po.setDeleteState(1);
            productService.save(po);
        }
        return po;
    }

    /**
     * 添加购车
     *
     * @return Object
     */
    @RequestMapping(value = "findProduct", method = RequestMethod.POST)
    public Object findProduct(String name) {
        List<ProductPo> list = productService.findByProductName(name).stream().peek(item -> {
            if (new Date().before(item.getEndTime())) {
                item.setIsExprie("否");
            } else {
                item.setIsExprie("是");
            }
        }).collect(Collectors.toList());
        return list;
    }


    private static Date parseDate(String dateStr) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(dateStr);
    }


}
