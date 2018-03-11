package ua.testing.regex.model;

public interface RowConstants {
	
	String LAST_NAME_REQUEST = "last name (in format: [A-z][a-z]+)";
	String FIRST_NAME_REQUEST = "first name  (in format: [A-z][a-z]+)";
	String PATRONYMIC_REQUEST = "patronymic  (in format: [A-z][a-z]+)";
	String NICKNAME_REQUEST = "nick name  (in format: [w]{3,})";
	String COMMENTS_REQUEST = "comments (up to 100 symbols)";
	String GROUP_REQUEST = "group";
	String HOME_PHONE_REQUEST = "home phone number (in format: XXX-XXX-XX-XX)";
	String PRIMARY_MOBILE_REQUEST = "primary mobile phone number (in format: XXX-XXX-XX-XX)";
	String SECONARY_MOBILE_REQUEST = "secondary mobile phone number (in format: XXX-XXX-XX-XX)";
	String EMAIL_REQUEST = "email";
	String SKYPE_REQUEST = "skype name";
	String ADDRESS_REQUEST = "address";
	String ENTER_DATE_REQUEST = "enter date";
	String LAST_UPDATE_REQUEST = "last update";
	
	String LAST_NAME_ROW_NAME = "last name";
	String FIRST_NAME_ROW_NAME = "first name";
	String PATRONYMIC_ROW_NAME = "patronymic";
	String NICKNAME_ROW_NAME = "nick name";
	String COMMENTS_ROW_NAME = "comments";
	String GROUP_ROW_NAME = "group";
	String HOME_PHONE_ROW_NAME = "home phone number";
	String PRIMARY_MOBILE_ROW_NAME = "primary mobile phone";
	String SECONARY_MOBILE_ROW_NAME = "secondary mobile phone number";
	String EMAIL_ROW_NAME = "email";
	String SKYPE_ROW_NAME = "skype name";
	String ADDRESS_ROW_NAME = "address";
	String ENTER_DATE_ROW_NAME = "enter date";
	String LAST_UPDATE_ROW_NAME = "last update";
	
	String LAST_NAME_REGEX = "[A-Z]{1}[a-z]+";
	String FIRST_NAME_REGEX = "[A-Z]{1}[a-z]+";
	String PATRONYMIC_REGEX = "[A-Z]{1}[a-z]+";
	String NICKNAME_REGEX = "\\w{3,}";
	String COMMENTS_REGEX = "[\\w\\s.,'\"?!@#$%&;:]{1,100}";
	String GROUP_REGEX = "\\w+";
	String HOME_PHONE_REGEX = "\\d{3}-\\d{3}-\\d\\d-\\d\\d";
	String PRIMARY_MOBILE_REGEX = "\\d{3}-\\d{3}-\\d\\d-\\d\\d";
	String SECONARY_MOBILE_REGEX = "\\d{3}-\\d{3}-\\d\\d-\\d\\d";
	String EMAIL_REGEX = "\\w+.?\\w*@\\w+.?\\w*.\\w+";
	String SKYPE_REGEX = "[\\w\\s]+";
	String ADDRESS_REGEX = "\\w*";
	String ENTER_DATE_REGEX = "\\w*";
	String LAST_UPDATE_REGEX = "\\w*";
	

}
