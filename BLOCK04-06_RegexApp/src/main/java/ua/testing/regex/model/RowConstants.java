package ua.testing.regex.model;

public interface RowConstants {
	
	String LAST_NAME_REGEX = "[A-Z]{1}[a-z]+[- ]?([A-Z]{1}[a-z]*)?";
	String FIRST_NAME_REGEX = "[A-Z]{1}[a-z]+[- ]?([A-Z]{1}[a-z]*)?";
	String PATRONYMIC_REGEX = "[A-Z]{1}[a-z]+";
	String NICKNAME_REGEX = "\\w{3,}";
	String LOGIN_REGEX = "\\w{3,}";
	String COMMENTS_REGEX = "[\\w\\s.,'\"?!@#$%&;:]{1,100}";
	String GROUP_REGEX = "customer|admin";
	String HOME_PHONE_REGEX = "\\d{3}-\\d{3}-\\d\\d-\\d\\d";
	String PRIMARY_MOBILE_REGEX = "\\d{3}-\\d{3}-\\d\\d-\\d\\d";
	String SECONARY_MOBILE_REGEX = "(\\d{3}-\\d{3}-\\d\\d-\\d\\d)|(-)";
	String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	String SKYPE_REGEX = "[\\w\\s]+";
	String ADDRESS_ZIP_REGEX = "\\d{5}";
	String ADDRESS_LOCALITY_REGEX = "[A-Z]{1}[a-z]+[- ]?([A-Z]{1}[a-z]*)?";
	String ADDRESS_STREET_REGEX = "\\w+[- ]?\\w+";
	String ADDRESS_BUILDING_REGEX = "\\d+[- ]?(\\w+)?";
	String ADDRESS_APPARTMENT_REGEX = "\\d+";
	
	String LAST_NAME_REQUEST = "last name";
	String FIRST_NAME_REQUEST = "first name";
	String PATRONYMIC_REQUEST = "patronymic";
	String NICKNAME_REQUEST = "nick name (no less than 3 characters)";
	String LOGIN_REQUEST = "login (try 'qwerty' for Exception)";
	String COMMENTS_REQUEST = "comments (up to 100 symbols)";
	String GROUP_REQUEST = "group (types 'customer' ore 'admin' are available";
	String HOME_PHONE_REQUEST = "home phone number (in format: XXX-XXX-XX-XX)";
	String PRIMARY_MOBILE_REQUEST = "primary mobile phone number (in format: XXX-XXX-XX-XX)";
	String SECONARY_MOBILE_REQUEST = "secondary mobile phone number if not exists - type '-' (number in format: XXX-XXX-XX-XX)";
	String EMAIL_REQUEST = "email"; 
	String SKYPE_REQUEST = "skype name";
	String ADDRESS_ZIP_REQUEST = "ZIP code (5 numbers)";
	String ADDRESS_LOCALITY_REQUEST = "locality";
	String ADDRESS_STREET_REQUEST = "street";
	String ADDRESS_BUILDING_REQUEST = "building number";
	String ADDRESS_APARTMENT_REQUEST = "appartment number";

}
