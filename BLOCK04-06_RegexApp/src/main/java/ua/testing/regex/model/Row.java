package ua.testing.regex.model;

import static ua.testing.regex.view.ViewConstants.*;

public enum Row {	
		
		LOGIN(LOGIN_REQUEST, LOGIN_REGEX),
		LAST_NAME(LAST_NAME_REQUEST, LAST_NAME_REGEX), 
		FIRST_NAME(FIRST_NAME_REQUEST, FIRST_NAME_REGEX), 
		PATRONYMIC(PATRONYMIC_REQUEST, PATRONYMIC_REGEX), 
		NICKNAME(NICKNAME_REQUEST, NICKNAME_REGEX),
		COMMENTS(COMMENTS_REQUEST, COMMENTS_REGEX), 
		GROUP(GROUP_REQUEST, GROUP_REGEX), 
		HOME_PHONE(HOME_PHONE_REQUEST, HOME_PHONE_REGEX), 
		PRIMARY_MOBILE(PRIMARY_MOBILE_REQUEST, PRIMARY_MOBILE_REGEX), 
		SECONARY_MOBILE(SECONARY_MOBILE_REQUEST, SECONARY_MOBILE_REGEX), 
		EMAIL(EMAIL_REQUEST, EMAIL_REGEX), 
		SKYPE(SKYPE_REQUEST, SKYPE_REGEX), 
		ADDRESS_ZIP(ADDRESS_ZIP_REQUEST, ADDRESS_ZIP_REGEX),
		ADDRESS_LOCALITY(ADDRESS_LOCALITY_REQUEST, ADDRESS_LOCALITY_REGEX),
		ADDRESS_STREET(ADDRESS_STREET_REQUEST, ADDRESS_STREET_REGEX),
		ADDRESS_BUILDING(ADDRESS_BUILDING_REQUEST, ADDRESS_BUILDING_REGEX),
		ADDRESS_APARTMENT(ADDRESS_APARTMENT_REQUEST, ADDRESS_APARTMENT_REGEX)
		;	
		
		private String request;
		private String regex;
		private String value;
		
		private Row(String request, String regex) {
			this.request = request;
			this.regex = regex;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) throws NotUniqueLoginException {
			checkUniqueLogin(value);
			this.value = value;
		}

		private void checkUniqueLogin(String login) throws NotUniqueLoginException {
			if (this.name().equals(LOGIN.name())) {
				for (DBEmulation DBRecord : DBEmulation.values()) {
					if (DBRecord.getLogin().equals(login)) {
						throw new NotUniqueLoginException("Login: " + login + " isn't unique.");
					}
				}
			}
			
		}

		public String getRegex() {
			return regex;
		}

		public String getRequest() {
			return request;
		}

}
