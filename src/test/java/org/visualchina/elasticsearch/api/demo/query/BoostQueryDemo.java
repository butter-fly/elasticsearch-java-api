package org.visualchina.elasticsearch.api.demo.query;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.visualchina.elasticsearch.api.demo.BaseDemo;

/**
 * @auhthor lei.fang@shijue.me
 * @since . 2017-07-14
 */
public class BoostQueryDemo extends BaseDemo {

    @Test
    public void test() throws Exception {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.termQuery("","")).boost(100)
                .should(QueryBuilders.termQuery("","").boost(1));

        client.prepareSearch("indexName").setQuery(boolQueryBuilder).execute().get();
    }
}
