package controller;

import entity.Userinfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import serviceimpl.UserinfoServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserinfoController {

    @Autowired
    UserinfoServiceImpl usi;

    @RequestMapping("/register")
    public int registerInsert(@RequestParam String username,@RequestParam String password,@RequestParam String email){
        Userinfo info=usi.selectByUsername(username);
        System.out.println("我为了测试代码的更新");

        if(info==null){
        Userinfo ui=new Userinfo();
        ui.setUsername(username);
        String md5Pwd= DigestUtils.md5Hex(password.getBytes());//密码加密后存入到对象中
        ui.setPassword(md5Pwd);
        ui.setEmail(email);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ui.setRegisterTime(sdf.format(date));
        return usi.insert(ui);
        }else{
            return -1;
        }
    }


@RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, @RequestParam String flag, HttpServletResponse res){
    Userinfo info=usi.selectByUsername(username);
    if(info==null){
        return "empty";
    }else{
     if(info.getPassword().equals(DigestUtils.md5Hex(password.getBytes()))){
         System.out.println("=========="+flag);
         if(flag.equals("yes")){
             Cookie cookie=new Cookie("flag","true");
             cookie.setMaxAge(10000);
             res.addCookie(cookie);

             Cookie c1=new Cookie("username",username);
             c1.setMaxAge(10000);
             res.addCookie(c1);

             Cookie c2=new Cookie("password",password);
             c2.setMaxAge(10000);
             res.addCookie(c2);

         }else{
             Cookie cookie=new Cookie("flag","false");
             cookie.setMaxAge(10000);
             res.addCookie(cookie);
         }
         return "ok";

     }else{
         return "error";
     }



    }


}


}
