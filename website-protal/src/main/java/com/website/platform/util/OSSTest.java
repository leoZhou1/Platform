package com.website.platform.util;

import java.io.File;
import java.util.UUID;

import org.junit.Test;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

public class OSSTest {
	private static final OSSClient ossClient = new OSSClient("oss-cn-hangzhou.aliyuncs.com", "2NaVWPsm31rnSU4j",
			"19UTa7o42oiuv5LfVeXBaEcXC9X7Ui");
	private static final String BUCKET = "static-medialab";

	@Test
	public void test() {
		String pic = UUID.randomUUID().toString();
		System.out.println(pic);
		PutObjectResult result = ossClient.putObject(BUCKET, pic + ".jpg",
				new File("D:/test/images/00ed69e5-d643-4a72-aace-0ecf4dfd80ef.jpg"));
	}
}
