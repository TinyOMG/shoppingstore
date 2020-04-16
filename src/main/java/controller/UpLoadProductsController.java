package controller;

import entity.Productinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import serviceimpl.ProductinfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
public class UpLoadProductsController {
    @Autowired
    ProductinfoServiceImpl psi;

    @RequestMapping("/addProducts")

    public String addProducts(@RequestParam Integer p_code, @RequestParam String p_name, @RequestParam String p_type,
                              @RequestParam String brand, @RequestParam Integer p_num, @RequestParam Double price,
                              @RequestParam String intro, @RequestParam(value = "pic")MultipartFile multipartFile, HttpServletRequest req) throws IOException {

        //localshot:8080/shopping/image/a.jpg

        String originalFilename=multipartFile.getOriginalFilename();//获取图片原始的名称
        System.out.println("=======我上传的图片名称是:"+originalFilename);

        long l=System.currentTimeMillis();//获取当前毫秒数
        String newName=l+originalFilename;
        System.out.println("=======毫秒数+原始名称:"+newName);

        String lastName="/image/"+newName;//最终存储在数据库中的值(pic)
        String realPath=req.getSession().getServletContext().getRealPath("/");//获取到项目名/
        InputStream inputStream=multipartFile.getInputStream();//输入流,用来读取图片

        //在项目根目录下创建image文件夹.用来保存上传的图片
        File file=new File(realPath+"/image/");
        if(!file.exists()){
            file.mkdir();//如果这个文件不存在,创建文件夹
        }


      if(!multipartFile.isEmpty()){
         FileOutputStream fos=new FileOutputStream(realPath+"/image/"+newName);
         int length=0;
         while((length=inputStream.read())!=-1){
             fos.write(length);
         }
         fos.flush();
         fos.close();
         inputStream.close();



      }


        Productinfo pi=new Productinfo();
      pi.setpCode(p_code);
      pi.setpName(p_name);
      pi.setpType(p_type);
      pi.setBrand(brand);
      pi.setpNum(p_num);
      pi.setPrice(price);
      pi.setIntro(intro);
      pi.setPic(lastName);
      int index=psi.insert(pi);
      if(index>0){
          return "ok";
      }else{
          return "no";
      }










    }
}
