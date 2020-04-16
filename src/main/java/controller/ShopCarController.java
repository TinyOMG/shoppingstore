package controller;

import entity.Productinfo;
import entity.Userinfo;
import entity.WebInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import serviceimpl.ProductinfoServiceImpl;
import serviceimpl.UserinfoServiceImpl;
import serviceimpl.WebInfoServiceImpl;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
public class ShopCarController {
    @Autowired
    JedisPool jedisPool;

    @Autowired
    ProductinfoServiceImpl psi;

    @Autowired
    UserinfoServiceImpl usi;

    @Autowired
    WebInfoServiceImpl wsi;


    @RequestMapping("/addCar")
    public String addCar(@RequestParam String username,@RequestParam String pid){
        Jedis jedis=jedisPool.getResource();
         Map<String,String> map=jedis.hgetAll(username);//先从redis里取出来
         if(map.isEmpty()){
             map.put(pid,"1");
             String str1=jedis.hmset(username,map);//存入redis里
             if(str1.equals("OK")){
                 return "yes";
             }else{
                 return "no";
             }
         }else{

             if(map.containsKey(pid)){//值为true,表示购物车已经有当前添加的商品,只需给商品数量加1即可
             map.put(pid,String.valueOf(Integer.parseInt(map.get(pid))+1));
                 String str2=jedis.hmset(username,map);//存入redis里
                 if(str2.equals("OK")){
                     return "yes";
                 }else{
                     return "no";
                 }
             }else{
                 map.put(pid,"1");
                 String str3=jedis.hmset(username,map);//存入redis里
                 if(str3.equals("OK")){
                     return "yes";
                 }else{
                     return "no";
                 }
             }

         }

    }


    @RequestMapping("/getCar")
    public List<Productinfo> getCar(@RequestParam String username){
      //1.从redis里取出pid,num
        Jedis jedis=jedisPool.getResource();
        Map<String,String> map=jedis.hgetAll(username);
         List<Productinfo> list=new ArrayList<Productinfo>();
         if(!map.isEmpty()){
             for(Map.Entry<String,String> entry:map.entrySet()){
                 Productinfo pi=psi.selectByPrimaryKey(Integer.parseInt(entry.getKey()));
                             pi.setpNum(Integer.parseInt(entry.getValue()));
                             list.add(pi);

             }
             return list;
         }


           return null;
    }


    @RequestMapping("/sendEmail")
    public String sendEmail(@RequestParam String username, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Userinfo ui=usi.selectByUsername(username);
        int randomNum=(int)((Math.random()*9+1)*100000);
        sendEmail(ui.getEmail(),randomNum,req,resp);

        return String.valueOf(randomNum);

    }


    public  void sendEmail(String emailCount, int randomNum, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String from="2091485927@qq.com";//你自己的邮箱
        String host="smtp.qq.com";//本机地址
        //Properties可以确定系统的属性,就是为了寻找我们的host
        Properties properties=System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "25");
        properties.put("mail.smtp.auth","true");//开启代理

        Authenticator aut=new Authenticator() {//创建Authenticator内部类来填入代理的用户名前缀和密码

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("2091485927","qxolkwgrmbmfiafd");//填用户名和代理密码

            }

        };

        //创建Session会话,Session是java.mail API最高入口
        Session session=Session.getDefaultInstance(properties,aut);
        //MimeMessage获取session对象,就可以创建要发送的邮箱内容和标题
        MimeMessage message=new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));//设置你自己的邮箱
            message.addRecipients(Message.RecipientType.TO, emailCount);//设置接受邮箱
            message.setSubject("验证码");//设置邮箱标题
            message.setText("您本次的验证码是:"+randomNum);//邮箱内容
            Transport.send(message);//发送邮箱

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/removeItems")
    public String removeItems(@RequestParam String username,@RequestParam Integer pid,@RequestParam Integer pnum){



        return "yes";
    }


    @RequestMapping("/getWebData")
    public List<WebInfo> getWebData(){

        return wsi.selectAll();
    }



}
