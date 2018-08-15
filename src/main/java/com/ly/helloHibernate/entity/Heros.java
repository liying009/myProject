package com.ly.helloHibernate.entity;

import java.util.Date;

/**
 * 英雄实体类
 * @author lenovo
 *
 */
public class Heros {

	private int id;
	private String name;
	private String nickname;
	private int sex;
	private String first;
	private String second;
	private String Q;
	private String W;
	private String E;
	private String R;
	private String passivity;
	private String img;
	private Date birthday;
	
	public Heros() {}

	public Heros(int id, String name, String nickname, int sex, String first, String second, String q, String w,
			String e, String r, String passivity, String img, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.sex = sex;
		this.first = first;
		this.second = second;
		Q = q;
		W = w;
		E = e;
		R = r;
		this.passivity = passivity;
		this.img = img;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getQ() {
		return Q;
	}

	public void setQ(String q) {
		Q = q;
	}

	public String getW() {
		return W;
	}

	public void setW(String w) {
		W = w;
	}

	public String getE() {
		return E;
	}

	public void setE(String e) {
		E = e;
	}

	public String getR() {
		return R;
	}

	public void setR(String r) {
		R = r;
	}

	public String getPassivity() {
		return passivity;
	}

	public void setPassivity(String passivity) {
		this.passivity = passivity;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Heros [id=" + id + ", name=" + name + ", nickname=" + nickname + ", sex=" + sex + ", first=" + first
				+ ", second=" + second + ", Q=" + Q + ", W=" + W + ", E=" + E + ", R=" + R + ", passivity=" + passivity
				+ ", img=" + img + ", birthday=" + birthday + "]\n";
	}
}
