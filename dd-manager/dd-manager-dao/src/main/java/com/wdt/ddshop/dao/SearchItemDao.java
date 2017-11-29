package com.wdt.ddshop.dao;

import com.wdt.ddshop.pojo.vo.TbItemSearchCustom;
import com.wdt.ddshop.pojo.vo.TbSearchItemResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SearchItemDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SolrServer solrServer;

    public TbSearchItemResult search(SolrQuery query) {

        TbSearchItemResult result = null;
        try {
            //根据query查询索引库
            QueryResponse queryResponse = solrServer.query(query);
            //获得查询结果   得的文档域对象
            SolrDocumentList solrdocumentList = queryResponse.getResults();
            //获得所有库
            long numFound = solrdocumentList.getNumFound();
            result = new TbSearchItemResult();
            result.setRecordCount(numFound);
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
            List<TbItemSearchCustom> itemList=new ArrayList<>();
            for(SolrDocument document:solrdocumentList){
TbItemSearchCustom item=new TbItemSearchCustom();
                item.setId((String) document.get("id"));
                item.setCatName((String) document.get("item_category_name"));
                item.setImage((String) document.get("item_image"));
                item.setPrice((long) document.get("item_price"));
                item.setSellPoint((String) document.get("item_sell_point"));
                List<String> list = highlighting.get(document.get("id")).get("item_title");

                String title = "";

                if (list != null && list.size() > 0) {
                    //高亮部分
                    title = list.get(0);
                } else {
                    //无高亮部分
                    title = (String) document.get("item_title");
                }
                item.setTitle(title);
                //添加到商品列表
                itemList.add(item);
            }
            result.setItemList(itemList);
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        //返回结果sta

        return result;
    }
}
