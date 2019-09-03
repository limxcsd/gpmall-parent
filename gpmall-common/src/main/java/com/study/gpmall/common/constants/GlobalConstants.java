package com.study.gpmall.common.constants;

/**
 * @ClassName: GlobalConstants
 * @Description:
 * @author: limingxing
 * @Date: 2019-08-27 19:29
 */
public class GlobalConstants {

    public final static String HEADER_PANEL_CACHE_KEY="header_panel"; //导航栏板块缓存

    public final static int HEADER_PANEL_ID=0;//导航栏板块表id

    public final static int RECOMMEND_PANEL_ID=6;//推荐商品板块表id
    public final static String RECOMMEND_PANEL_CACHE_KEY="recommend_panel";//推荐商品板块缓存key
    public final static int RECOMMEND_CACHE_EXPIRE = 1;

    public final static String PRODUCT_ITEM_CACHE_KEY = "product_item";//商品详情缓存前缀
    public final static int PRODUCT_ITEM_EXPIRE_TIME = 1; //过期时间  单位 day

    public final static String PRODUCT_CATE_CACHE_KEY = "product_cate";//商品分类缓存前缀
    public final static int PRODUCT_CATE_EXPIRE_TIME = 1; //过期时间  单位 day

    public final static String HOMEPAGE_CACHE_KEY="home_page";//商品详情缓存前缀
    public final static int HOMEPAGE_EXPIRE_TIME=1; //过期时间


    public final static String CART_ITEM_CACHE_PREFIX="cart_item";
}
