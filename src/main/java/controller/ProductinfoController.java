package controller;

import entity.Productinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import serviceimpl.ProductinfoServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductinfoController {
    @Autowired
    ProductinfoServiceImpl pisi;

    @RequestMapping("/getPtype")
    public List<Productinfo> getPtype(){
        return pisi.getPtype();
    }


    @RequestMapping("/getProductByPtype")
    public List<Productinfo> getProductByPtype(@RequestParam String pType){
        return pisi.getProductsByPtype(pType);

    }

    @RequestMapping("/getMy")
    public Map<String,List<Productinfo>> getProductByPtype(){
           Map<String,List<Productinfo>> map=new HashMap<>();
           Productinfo pi1=new Productinfo();
           Productinfo pi2=new Productinfo();
                       pi1.setpName("iphone11");
                       pi1.setBrand("apple");
                       pi2.setpName("s20+");
                       pi2.setBrand("susuang");
            List<Productinfo> list1=new ArrayList<>();
            List<Productinfo> list2=new ArrayList<>();

                      list1.add(pi1);
                      list2.add(pi2);
                      map.put("手机",list1);
                      map.put("电脑",list2);
        return map;
    }




}
