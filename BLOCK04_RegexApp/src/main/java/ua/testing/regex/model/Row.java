package ua.testing.regex.model;

public enum Row implements RowConstants{	
		
		LAST_NAME(LAST_NAME_REQUEST, LAST_NAME_ROW_NAME, LAST_NAME_REGEX), 
		FIRST_NAME(FIRST_NAME_REQUEST, FIRST_NAME_ROW_NAME, FIRST_NAME_REGEX), 
		PATRONYMIC(PATRONYMIC_REQUEST, PATRONYMIC_ROW_NAME, PATRONYMIC_REGEX), 
		NICKNAME(NICKNAME_REQUEST, NICKNAME_ROW_NAME, NICKNAME_REGEX), 
		COMMENTS(COMMENTS_REQUEST, COMMENTS_ROW_NAME, COMMENTS_REGEX), 
		GROUP(GROUP_REQUEST, GROUP_ROW_NAME, GROUP_REGEX), 
		HOME_PHONE(HOME_PHONE_REQUEST, HOME_PHONE_ROW_NAME, HOME_PHONE_REGEX), 
		PRIMARY_MOBILE(PRIMARY_MOBILE_REQUEST, PRIMARY_MOBILE_ROW_NAME, PRIMARY_MOBILE_REGEX), 
		SECONARY_MOBILE(SECONARY_MOBILE_REQUEST, SECONARY_MOBILE_ROW_NAME, SECONARY_MOBILE_REGEX), 
		EMAIL(EMAIL_REQUEST, EMAIL_ROW_NAME, EMAIL_REGEX), 
		SKYPE(SKYPE_REQUEST, SKYPE_ROW_NAME, SKYPE_REGEX), 
		ADDRESS(ADDRESS_REQUEST, ADDRESS_ROW_NAME, ADDRESS_REGEX), 
		ENTER_DATE(ENTER_DATE_REQUEST, ENTER_DATE_ROW_NAME, ENTER_DATE_REGEX), 
		LAST_UPDATE(LAST_UPDATE_REQUEST, LAST_UPDATE_ROW_NAME, LAST_UPDATE_REGEX)
		;	
		
		private String request;
		private String name;
		private String regex;
		private String value;
		
		private Row(String request, String name, String regex) {
			this.request = request;
			this.name = name;
			this.regex = regex;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public String getRegex() {
			return regex;
		}

		public String getRequest() {
			return request;
		}
	

}
