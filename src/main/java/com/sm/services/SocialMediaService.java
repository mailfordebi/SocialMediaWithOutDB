package com.sm.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SocialMediaService {
	SocialMediaUtil socialMediaUtil = null;

	public SocialMediaService() {
		socialMediaUtil = new SocialMediaUtil();
	}

	public boolean createPost(String userId, String postId, String content) {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		socialMediaUtil.createPost(postId, userId, content, strDate);
		return true;
	}

	public List<String> getNewsFeed(String userId) {
		List<String> postIds=null;
		List<ArrayList<String>> newsFeedPost = new ArrayList<ArrayList<String>>();
		if (userId != null && !userId.isEmpty()) {
			List<String> followeeIds = new ArrayList<String>();
			List<ArrayList<String>> follows = socialMediaUtil.getPosts();
			if (follows != null && !follows.isEmpty()) {
				for (ArrayList<String> follow : follows) {
					if (userId.equals(follow.get(0))) {
						followeeIds.add(follow.get(0));
					}
				}
			}

			List<ArrayList<String>> posts = socialMediaUtil.getPosts();
			if (posts != null && !posts.isEmpty()) {
				for (ArrayList<String> post : posts) {
					if (userId.equals(post.get(1))) {
						newsFeedPost.add(post);
					}
					for (String f : followeeIds) {
						if (f.equals(post.get(1))) {
							newsFeedPost.add(post);
						}
					}
				}
			}
		}

		Collections.sort(newsFeedPost, new DateComarator());
		postIds = new ArrayList<String>();
		for (int i = 0; i < Math.min(20, newsFeedPost.size()); i++) {
			postIds.add(newsFeedPost.get(0).get(0));
		}
		return postIds;

	}

	public boolean follow(String followerId, String followeeId) {
		if (followerId != null && followeeId != null) {
			List<ArrayList<String>> users = socialMediaUtil.getUsers();
			boolean userFound = false;
			if (users != null && !users.isEmpty()) {
				for (ArrayList<String> user : users) {
					if (followerId.equals(user.get(0))) {
						userFound = true;
					}
					if (followeeId.equals(user.get(0))) {
						userFound = userFound && true;
					}
				}
			}
			if (userFound) {
				socialMediaUtil.addFollow(followerId, followeeId);
				return true;
			}

		}
		return false;
	}

	public boolean unfollow(String followerId, String followeeId) {
		if (followerId != null && followeeId != null) {
			List<ArrayList<String>> users = socialMediaUtil.getUsers();
			boolean userFound = false;
			if (users != null && !users.isEmpty()) {
				for (ArrayList<String> user : users) {
					if (followerId.equals(user.get(0))) {
						userFound = true;
					}
					if (followeeId.equals(user.get(0))) {
						userFound = userFound && true;
					}
				}
			}
			if (userFound) {
				List<ArrayList<String>> follows = socialMediaUtil.getFollows();
				ArrayList<String> unfollow = new ArrayList<String>();
				unfollow.add(followerId);
				unfollow.add(followeeId);
				follows.remove(unfollow);
				System.out.println(follows);
				return true;
			}
		}
		return false;
	}

	public void addUser(String userid, String fname, String lname) {
		socialMediaUtil.addUser(userid, fname, lname);
	}
}
