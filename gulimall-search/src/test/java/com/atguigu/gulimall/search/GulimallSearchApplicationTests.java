package com.atguigu.gulimall.search;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.gulimall.search.config.GulimallEsHighRestClistConfig;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class GulimallSearchApplicationTests {

	@Autowired
	private RestHighLevelClient restHighLevelClient;


	@Test
	public void testSaveOrUpdate() throws IOException {

		IndexRequest request = new IndexRequest("users");
		request.id("1");
//		String jsonString = "{" +
//				"\"user\":\"kimchy\"," +
//				"\"postDate\":\"2013-01-30\"," +
//				"\"message\":\"trying out Elasticsearch\"" +
//				"}";
		User user = new User();
		user.setAge(10);
		user.setName("zs");
		String jsonString = JSONObject.toJSONString(user);
		request.source(jsonString, XContentType.JSON);

		IndexResponse index = restHighLevelClient.index(request, GulimallEsHighRestClistConfig.COMMON_OPTIONS);

		System.out.println(index);


	}

	class User{

		private int age;
		private String name;

		public void setAge(int age) {
			this.age = age;
		}

		public void setName(String name) {
			this.name = name;
		}
	}


	@Test
	public void contextLoads() {

		System.out.println(restHighLevelClient);

	}

}
