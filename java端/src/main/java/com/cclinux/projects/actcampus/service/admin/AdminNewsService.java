package com.cclinux.projects.actcampus.service.admin;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cclinux.framework.core.domain.PageParams;
import com.cclinux.framework.core.domain.PageResult;
import com.cclinux.framework.core.mapper.UpdateWhere;
import com.cclinux.framework.core.mapper.Where;
import com.cclinux.projects.actcampus.mapper.NewsMapper;
import com.cclinux.projects.actcampus.model.ActivityModel;
import com.cclinux.projects.actcampus.model.NewsModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Notes: 资讯模块后台管理
 * @Author: wxid_ly1r09e297e722 (weixin)
 * @Date:  2/16 9:35
 * @Ver: ccminicloud-framework 3.2.1
 */

@Service("ActCampusAdminNewsService")
public class AdminNewsService extends BaseMyAdminService {

    @Resource(name = "ActCampusNewsMapper")
    private NewsMapper newsMapper;


    /** 添加资讯*/
    public Long insertNews(NewsModel news) {
//        appError("{校园活动}该功能暂不开放，如有需要请加作者微信：wxid_ly1r09e297e722");
        return Long.valueOf(this.newsMapper.insert(news));
    }

    /** 修改资讯 */
    public void editNews(NewsModel news) {

//        appError("{校园活动}该功能暂不开放，如有需要请加作者微信：wxid_ly1r09e297e722");
        this.newsMapper.updateById(news);

    }


    /** 资讯列表 */
    public PageResult getAdminNewsList(PageParams pageRequest) {

        Where<NewsModel> where = new Where<>();


        // 关键字查询
        String search = pageRequest.getSearch();
        if (StrUtil.isNotEmpty(search)) {
            where.and(
                    wrapper -> {
                        wrapper.or().like("NEWS_TITLE", search);
                        wrapper.or().like("NEWS_OBJ", search);
                    }
            );
        }

        // 条件查询
        String sortType = pageRequest.getSortType();
        String sortVal = pageRequest.getSortVal();
        if (StrUtil.isNotEmpty(sortType) && StrUtil.isNotEmpty(sortVal)) {
            switch (sortType) {
                case "cateId": {
                    where.eq("NEWS_CATE_ID", Convert.toLong(sortVal));
                    break;
                }
                case "status": {
                    where.eq("NEWS_STATUS", Convert.toInt(sortVal));
                    break;
                }
                case "vouch": {
                    where.eq("NEWS_VOUCH", 1);
                    break;
                }
                case "top": {
                    where.eq("NEWS_ORDER", 0);
                    break;
                }
                case "sort": {
                    where.fmtOrderBySort(sortVal, "");
                    break;
                }
            }

        }

        // 排序
        where.orderByAsc("NEWS_ORDER");
        where.orderByDesc("NEWS_ID");


        Page page = new Page(pageRequest.getPage(), pageRequest.getSize());
        return newsMapper.getPageList(page, where, "*");
    }

    /** 删除资讯 */
    public void delNews(long id) {
//        appError("{校园活动}该功能暂不开放，如有需要请加作者微信：wxid_ly1r09e297e722");
        this.newsMapper.delete(id);
    }


    /** 获取单个资讯 */
    public Map<String, Object> getNewsDetail(long id) {
        return newsMapper.getOneMap(id);
    }

    /**
     * 修改资讯状态
     */
    public void statusNews(long id, int status) {
//        appError("{校园活动}该功能暂不开放，如有需要请加作者微信：wxid_ly1r09e297e722");
        UpdateWhere<NewsModel> uw = new UpdateWhere<>();
        uw.eq("NEWS_ID", id);
        uw.set("NEWS_STATUS", status);
        this.newsMapper.edit(uw);
    }

    /** 资讯排序设定 */
    public void orderNews(long id, int order) {
//        appError("{校园活动}该功能暂不开放，如有需要请加作者微信：wxid_ly1r09e297e722");
        UpdateWhere<NewsModel> uw = new UpdateWhere<>();
        uw.eq("NEWS_ID", id);
        uw.set("NEWS_ORDER", order);
        this.newsMapper.edit(uw);
    }


    /** 资讯首页设定 */
    public void vouchNews(long id, int vouch) {
//        appError("{校园活动}该功能暂不开放，如有需要请加作者微信：wxid_ly1r09e297e722");
        UpdateWhere<NewsModel> uw = new UpdateWhere<>();
        uw.eq("NEWS_ID", id);
        uw.set("NEWS_VOUCH", vouch);
        this.newsMapper.edit(uw);
    }
}
