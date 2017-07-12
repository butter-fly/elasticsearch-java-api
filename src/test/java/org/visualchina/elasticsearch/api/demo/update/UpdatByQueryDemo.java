package org.visualchina.elasticsearch.api.demo.update;

import org.elasticsearch.action.Action;
import org.elasticsearch.action.search.SearchAction;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.UpdateByQueryAction;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.index.reindex.UpdateByQueryRequestBuilder;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.junit.Test;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.visualchina.elasticsearch.api.demo.BaseDemo;

/**
 * @see <a href='https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-update-by-query.html'></a>
 * @auhthor lei.fang@shijue.me
 * @since . 2017-07-12
 */
public class UpdatByQueryDemo extends BaseDemo {


    @Test
    public void test() throws Exception {
        UpdateByQueryRequestBuilder updateByQueryRequestBuilder = UpdateByQueryAction.INSTANCE.newRequestBuilder(client);
        updateByQueryRequestBuilder
                .script(new Script(ScriptType.INLINE,"painless","ctx_source.likes++",null))
                .source()
                .setQuery(QueryBuilders.termQuery("user","kimchy"))
                .setIndices("twitter")
                .get();
    }
}
