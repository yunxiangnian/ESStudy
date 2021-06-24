package com.cloud.es.utils;

import com.cloud.es.entities.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author lisw
 * @create 2021/6/24 17:04
 */
@Component
public class HtmlParseUtils {

    public static List<Product> ParseJD(String keywords) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keywords;
        Document document = Jsoup.parse(new URL(url), 20000);
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");

        ArrayList<Product> products = new ArrayList<>();
        Long i = 0L;
        for (Element el : elements){
            i++;
            //网站首先获取不到是因为有些采用了图片懒加载的方式。
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();

            Product product = new Product(i,title,img,price);
            products.add(product);
        }
        return products;
    }
}
