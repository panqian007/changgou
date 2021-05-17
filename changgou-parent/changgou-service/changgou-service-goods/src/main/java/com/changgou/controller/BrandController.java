package com.changgou.controller;/**
 * @Author panqian
 * @Date 2020/9/1 9:51
 * @Version 1.0.0
 */

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import com.changgou.demo.WordToPdf;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Author panqian
 * @Date 2020/9/1 9:51
 * @Version 1.0.0
 */
@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService brandService;

    @ResponseBody
    @RequestMapping(value = "/showPdf", method = {RequestMethod.POST, RequestMethod.GET})
    public void showPpf(HttpServletRequest request, HttpServletResponse response) throws Exception {

        InputStream fis =null;
        OutputStream os = null;
        WordToPdf.doc2pdf("D:\\GoogleDownloads\\doct.doc","D:\\GoogleDownloads\\pdf.pdf");
        fis = new FileInputStream("D:\\GoogleDownloads\\pdft.pdf");
        byte[] b = new byte[1024];
        response.setContentType("application/pdf");
        os = response.getOutputStream();
        while ((fis.read(b)) != -1) {
            os.write(b);
        }

        os.close();
        fis.close();
    }

    @ResponseBody
    @RequestMapping(value = "/showImg", method = {RequestMethod.POST, RequestMethod.GET})
    public void showImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File("D:\\GoogleDownloads\\t1.JPG");
        FileInputStream fis =null;
        OutputStream os = null;
        fis = new FileInputStream(file);
        byte[] b = new byte[1024];
        response.setContentType("application/img");
        os = response.getOutputStream();
        while ((fis.read(b)) != -1) {
            os.write(b);
        }
        os.close();
        fis.close();
    }

    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand,@PathVariable(value = "page")Integer page,
                                            @PathVariable(value = "size")Integer size){
        PageInfo<Brand> pageInfo = brandService.findPage(brand,page, size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"分页查询！",pageInfo.getList());
    }
    @GetMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page")Integer page,
                                            @PathVariable(value = "size")Integer size){
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"分页查询！",pageInfo.getList());
    }
    @PostMapping("/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
       List<Brand> brands = brandService.findList(brand);
        return new Result<List<Brand>>(true,StatusCode.OK,"条件查询成功",brands);
    }
    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") Integer id){
        brandService.delete(id);

        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 根据id修改
     * @param id
     * @param brand
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable(value = "id") Integer id,@RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    @GetMapping
    public Result<List<Brand>> findAll(){
        //查询所有
        List<Brand> brands = brandService.findAll();
        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功",brands);

    }
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable(value = "id")Integer id){
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true,StatusCode.OK,"查询成功",brand);
    }

}
