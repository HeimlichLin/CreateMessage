package idv.heimlich.Create.domain.code;

public enum Charset {
	BIG5("BIG5"), //
	UTF8("UTF-8"),

	;//

	final String code;

	private Charset(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

}
