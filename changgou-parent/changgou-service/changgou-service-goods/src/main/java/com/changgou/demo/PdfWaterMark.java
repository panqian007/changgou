package com.changgou.demo;


import com.aspose.pdf.*;

import java.awt.*;
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfWaterMark {
    public static void main(String[] args) throws Exception {
        pdfWaterMarkdo("D:\\GoogleDownloads\\pdft.pdf","D:\\GoogleDownloads\\wpdft.pdf");

    }

    public static void pdfWaterMarkdo(String inPath, String outPath) throws Exception {

        String s = "<License>\n"
                + "  <Data>\n"
                + "    <Products>\n"
                + "      <Product>Aspose.Total for Java</Product>\n"
                + "      <Product>Aspose.Words for Java</Product>\n"
                + "    </Products>\n"
                + "    <EditionType>Enterprise</EditionType>\n"
                + "    <SubscriptionExpiry>20991231</SubscriptionExpiry>\n"
                + "    <LicenseExpiry>20991231</LicenseExpiry>\n"
                + "    <SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber>\n"
                + "  </Data>\n"
                + "  <Signature>111</Signature>\n"
                + "</License>";
        ByteArrayInputStream is = new ByteArrayInputStream(s.getBytes());
        License license = new License();
        license.setLicense(is);
        FileOutputStream os =null;
        try {
            File file = new File(outPath); // 新建一个空白pdf文档
            os = new FileOutputStream(file);
            Document doc = new Document(inPath); // Address是将要被转化的word文档
            insertWatermarkText(doc,"潘谦007");
            doc.save(os);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void insertWatermarkText(Document doc, String watermarkText) throws Exception
    {

//        Shape watermark = new Shape(doc, ShapeType.TEXT_PLAIN_TEXT);
        TextStamp textStamp = new TextStamp(watermarkText);
        textStamp.setBackground(true);
//        textStamp.setXIndent(200);
//        textStamp.setYIndent(100);
        textStamp.setRotateAngle(50);
        textStamp.setHeight(100);
        textStamp.setWidth(500);
        textStamp.getTextState().setFont(FontRepository.findFont("SimSun"));
        textStamp.getTextState().setFontSize(34.0F);
        textStamp.getTextState().setFontStyle(FontStyles.Italic);
        textStamp.getTextState().setForegroundColor(com.aspose.pdf.Color.fromRgb(Color.lightGray));

//        TextStamp textStamp1 = new TextStamp(watermarkText);
//        textStamp1.setBackground(true);
//        textStamp1.setXIndent(300);//设置位置
//        textStamp1.setYIndent(300);
//        textStamp1.setRotateAngle(50);//设置旋转角度
//        textStamp1.getTextState().setFont(FontRepository.findFont("SimSun"));
//        textStamp1.getTextState().setFontSize(34.0F);//设置字体大小
//        textStamp1.getTextState().setFontStyle(FontStyles.Italic);
//        textStamp1.getTextState().setForegroundColor(com.aspose.pdf.Color.fromRgb(Color.lightGray));//设置字体颜色
//
//        TextStamp textStamp2 = new TextStamp(watermarkText);
//        textStamp2.setBackground(true);
//        textStamp2.setXIndent(500);
//        textStamp2.setYIndent(500);
//        textStamp2.setRotateAngle(50);
//        textStamp2.getTextState().setFont(FontRepository.findFont("SimSun"));
//        textStamp2.getTextState().setFontSize(34.0F);
//        textStamp2.getTextState().setFontStyle(FontStyles.Italic);
//        textStamp2.getTextState().setForegroundColor(com.aspose.pdf.Color.fromRgb(Color.lightGray));


        PageCollection pages = doc.getPages();
        int size = pages.size();
        for (int i = 1; i <= size; i++) {
            pages.get_Item(i).addStamp(textStamp);
//            pages.get_Item(i).addStamp(textStamp1);
//            pages.get_Item(i).addStamp(textStamp2);
        }
        System.out.println("Watermark Set");
    }



//    private static void insertWatermarkIntoHeader(Paragraph watermarkPara, Section sect, int headerType) throws Exception
//    {
//        HeaderFooter header = sect.getHeadersFooters().getByHeaderFooterType(headerType);
//
//        if (header == null)
//        {
//            header = new HeaderFooter(sect.getDocument(), headerType);
//            sect.getHeadersFooters().add(header);
//        }
//
//        header.appendChild(watermarkPara.deepClone(true));
//    }
}
