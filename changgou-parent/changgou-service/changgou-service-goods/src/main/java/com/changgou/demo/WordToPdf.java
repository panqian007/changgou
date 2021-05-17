package com.changgou.demo;

import com.aspose.words.*;
import com.aspose.words.Shape;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class WordToPdf {
    public static void main(String[] args) throws Exception {
        doc2pdf("D:\\GoogleDownloads\\doct.doc","D:\\GoogleDownloads\\pdf.pdf");

    }


    public static void doc2pdf(String inPath, String outPath) throws Exception {

        String s = "<License>\n" +
                "\n" +
                "\n" +
                "<Data>\n" +
                "\n" +
                "\n" +
                "<Products>\n" +
                "\n" +
                "<Product>Aspose.Total for Java</Product>\n" +
                "\n" +
                "<Product>Aspose.Words for Java</Product>\n" +
                "\n" +
                "</Products>\n" +
                "\n" +
                "<EditionType>Enterprise</EditionType>\n" +
                "\n" +
                "<SubscriptionExpiry>20991231</SubscriptionExpiry>\n" +
                "\n" +
                "<LicenseExpiry>20991231</LicenseExpiry>\n" +
                "\n" +
                "<SerialNumber>23dcc79f-44ec-4a23-be3a-03c1632404e9</SerialNumber>\n" +
                "\n" +
                "</Data>\n" +
                "\n" +
                "<Signature>2sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature>\n" +
                "\n" +
                "</License>";
        ByteArrayInputStream is = new ByteArrayInputStream(s.getBytes());
        License license = new License();
        license.setLicense(is);
        FileOutputStream os =null;
        try {
            File file = new File(outPath); // 新建一个空白pdf文档
            os = new FileOutputStream(file);
            Document doc = new Document(inPath); // Address是将要被转化的word文档
            insertWatermarkText(doc,"潘谦007");
            doc.save(os, SaveFormat.PDF);
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

        Shape watermark = new Shape(doc, ShapeType.TEXT_PLAIN_TEXT);


        //水印内容
        watermark.getTextPath().setText(watermarkText);
        //水印字体
        watermark.getTextPath().setFontFamily("宋体");
        //水印宽度
        watermark.setWidth(500);
        //水印高度
        watermark.setHeight(100);
        //旋转水印
        watermark.setRotation(-40);
        //水印颜色
        watermark.getFill().setColor(Color.lightGray);
        watermark.setStrokeColor(Color.lightGray);

        watermark.setRelativeHorizontalPosition(RelativeHorizontalPosition.PAGE);
        watermark.setRelativeVerticalPosition(RelativeVerticalPosition.PAGE);
        watermark.setWrapType(WrapType.NONE);
        watermark.setVerticalAlignment(VerticalAlignment.CENTER);
        watermark.setHorizontalAlignment(HorizontalAlignment.CENTER);

        Paragraph watermarkPara = new Paragraph(doc);
        watermarkPara.appendChild(watermark);

        for (Section sect : doc.getSections())
        {
            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_PRIMARY);
            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_FIRST);
            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_EVEN);
        }
        System.out.println("Watermark Set");
    }



    private static void insertWatermarkIntoHeader(Paragraph watermarkPara, Section sect, int headerType) throws Exception
    {
        HeaderFooter header = sect.getHeadersFooters().getByHeaderFooterType(headerType);

        if (header == null)
        {
            header = new HeaderFooter(sect.getDocument(), headerType);
            sect.getHeadersFooters().add(header);
        }

        header.appendChild(watermarkPara.deepClone(true));
    }
}
