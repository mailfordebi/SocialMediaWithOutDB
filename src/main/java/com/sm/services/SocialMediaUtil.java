package com.sm.services;

import java.util.ArrayList;
import java.util.List;

public class SocialMediaUtil {
	List<ArrayList<String>> users = null;
	List<ArrayList<String>> posts = null;
	List<ArrayList<String>> follows = null;

	public SocialMediaUtil() {
		users = new ArrayList<ArrayList<String>>();
		posts = new ArrayList<ArrayList<String>>();
		follows = new ArrayList<ArrayList<String>>();
	}

	public void addUser(String userid, String fname, String lname) {
		ArrayList<String> user = new ArrayList<String>();
		user.add(userid);
		user.add(fname);
		user.add(lname);
		users.add(user);
	}

	public void createPost(String postid, String userid, String content, String date) {
		ArrayList<String> post = new ArrayList<String>();
		post.add(postid);
		post.add(userid);
		post.add(content);
		post.add(date);
		posts.add(post);
		
	}

	public void addFollow(String followerId, String followeeId) {
		ArrayList<String> follow = new ArrayList<String>();
		follow.add(followerId);
		follow.add(followeeId);
		follows.add(follow);
		System.out.println(follows);
	}

	public List<ArrayList<String>> getUsers() {
		return users;
	}

	public List<ArrayList<String>> getPosts() {
		return posts;
	}

	public List<ArrayList<String>> getFollows() {
		return follows;
	}

}
