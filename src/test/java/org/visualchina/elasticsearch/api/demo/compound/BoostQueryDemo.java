package org.visualchina.elasticsearch.api.demo.compound;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.visualchina.elasticsearch.api.demo.BaseDemo;

/**
 * @see <a href='https://www.elastic.co/guide/en/elasticsearch/client/java-api/5.5/java-compound-queries.html'></a>
 * @auhthor lei.fang@shijue.me
 * @since . 2017-07-08
 */
public class BoostQueryDemo extends BaseDemo {

    @Test
    public void testForClient() throws Exception {
        QueryBuilder qb = QueryBuilders.boostingQuery(
                QueryBuilders.termQuery("name","kimchy"),
                QueryBuilders.termQuery("name","dadoonet"))
                .negativeBoost(0.2f);
        client.prepareSearch().setQuery(qb).execute().actionGet();
    }
}
