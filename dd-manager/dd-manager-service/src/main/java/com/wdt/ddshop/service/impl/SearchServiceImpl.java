package com.wdt.ddshop.service.impl;

import com.wdt.ddshop.dao.SearchItemDao;
import com.wdt.ddshop.dao.TbItemSearchCustomMapper;
import com.wdt.ddshop.pojo.vo.TbItemSearchCustom;
import com.wdt.ddshop.pojo.vo.TbSearchItemResult;
import com.wdt.ddshop.service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private TbItemSearchCustomMapper tbItemSearchCustomDao;
    @Autowired
    private SearchItemDao searchItemDao;
    @Autowired
    private SolrServer solrServer;

    @Override
    public boolean importAllItem() {
        List<TbItemSearchCustom> list = tbItemSearchCustomDao.listSearchItem();
        for (TbItemSearchCustom itemSearch : list) {
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id", itemSearch.getId());
            document.addField("item_title", itemSearch.getTitle());
            document.addField("item_sell_point", itemSearch.getSellPoint());
            document.addField("item_price", itemSearch.getPrice());
            document.addField("item_image", itemSearch.getImage());
            document.addField("item_category_name", itemSearch.getCatName());
            try {
                solrServer.add(document);
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            solrServer.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public TbSearchItemResult search(String keyword, Integer page, int rows) {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery(keyword);
        if (page <= 0)
            page = 1;

        solrQuery.setStart((page - 1) * rows);
        //设置检索每页数
        solrQuery.setRows(rows);
        //设置搜索域
        solrQuery.set("df", "item_keywords");
        solrQuery.setHighlight(true);
        //高亮字段
        solrQuery.addHighlightField("item_title");
        //设置前缀
        solrQuery.setHighlightSimplePre("<em style='color:red'>");
        //设置后缀
        solrQuery.setHighlightSimplePost("</em>");
        TbSearchItemResult searchResult = searchItemDao.search(solrQuery);
        long recordCount = searchResult.getRecordCount();
        int totalPages = (int) ((recordCount + rows - 1) / rows);
        searchResult.setTotalPages(totalPages);
        return searchResult;
    }
}
