package com.liziczh.app.sso.api.common;

public class UserConstants {
	public static final String SYS_CODE = "app-sso";
	public static final String SYS_USER = "app-sso";

	/**
	 * 性别
	 */
	public static enum GENDER {
		MALE("male", "男"),
		FEMALE("female", "女"),
		SECRECY("secrecy", "保密");

		private String code;
		private String name;

		private GENDER(String code, String name) {
			this.code = code;
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public String getName() {
			return name;
		}
	}

	/**
	 * 证件类型
	 */
	public static enum ID_CARD_TYPE {
		ID_CARD("id_card", "身份证"),
		PASSPORT("passport", "护照"),
		OTHER("other", "其他");

		private String code;
		private String name;

		private ID_CARD_TYPE(String code, String name) {
			this.code = code;
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public String getName() {
			return name;
		}
	}
}
