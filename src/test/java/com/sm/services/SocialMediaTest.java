package com.sm.services;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SocialMediaTest {
	static SocialMediaService mediaService = null;

	@BeforeClass
	public static void setup() {
		mediaService = new SocialMediaService();
	}

	@Test
	public void testAddUser() {
		mediaService.addUser("1", "debi", "prasad");
		mediaService.addUser("2", "xylo", "prasad");
		mediaService.addUser("3", "form", "data");
		mediaService.addUser("4", "andrew", "prasad");
		mediaService.addUser("5", "robin", "hoof");
		mediaService.addUser("6", "debi", "prasad");
		mediaService.addUser("7", "abcd", "defh");
		mediaService.addUser("8", "debi", "prasad");
		mediaService.addUser("9", "fff", "prasad");
		mediaService.addUser("10", "xyz", "prasad");
		mediaService.addUser("11", "debi", "prasad");
		mediaService.addUser("12", "debi", "prasad");
	}

	@Test
	public void testCreatePost() {
		boolean isSuccess = false;
		isSuccess = mediaService.createPost("1", "1", "fgajfgjgasf");
		Assert.assertEquals(isSuccess, true);
		isSuccess = mediaService.createPost("1", "2", "fgajfgjgasf");
		Assert.assertEquals(isSuccess, true);
		isSuccess = mediaService.createPost("1", "3", "fgajfgjgasf");
		Assert.assertEquals(isSuccess, true);
		isSuccess = mediaService.createPost("2", "4", "fgajfgjgasf");
		Assert.assertEquals(isSuccess, true);
		isSuccess = mediaService.createPost("3", "5", "fgajfgjgasf");
		Assert.assertEquals(isSuccess, true);
		isSuccess = mediaService.createPost("2", "6", "fgajfgjgasf");
		Assert.assertEquals(isSuccess, true);
		isSuccess = mediaService.createPost("3", "7", "fgajfgjgasf");
		Assert.assertEquals(isSuccess, true);
	}

	@Test
	public void testFollow() {
		boolean isSuccess = false;
		isSuccess = mediaService.follow("1", "2");
		Assert.assertEquals(isSuccess, true);
		isSuccess = mediaService.follow("1", "3");
		Assert.assertEquals(isSuccess, true);
		isSuccess = mediaService.follow("2", "3");
		Assert.assertEquals(isSuccess, true);
		isSuccess = mediaService.follow("2", "4");
		Assert.assertEquals(isSuccess, true);
	}
	
	@Test
	public void testUnFollow() {
		boolean isSuccess = false;
		isSuccess = mediaService.unfollow("1", "2");
		Assert.assertEquals(isSuccess, true);
	}
	
	@Test
	public void testGetNewsFeed() {
		List<String> postIds = mediaService.getNewsFeed("2");
		Assert.assertNotNull(postIds);
	}
	
	@Test
	public void testGetNewsFeed1() {
		List<String> postIds = mediaService.getNewsFeed("");
	}

}
