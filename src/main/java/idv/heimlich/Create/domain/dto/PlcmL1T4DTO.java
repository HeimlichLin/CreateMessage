package idv.heimlich.Create.domain.dto;

import java.util.function.Function;

import org.apache.commons.lang.StringUtils;

public class PlcmL1T4DTO {

	/**
	 * 訊息格式
	 */
	private static Function<PlcmL1T4DTO, String> MESSAGE = new Function<PlcmL1T4DTO, String>() {

		@Override
		public String apply(PlcmL1T4DTO t) {
			final StringBuilder builder = new StringBuilder();
			builder.append(this.rightPad("T4", 2));// 細項資料 (T4) Character (2) 2
			builder.append(this.rightPad(t.getDECLNO(), 14));// 報單號碼 (DeclNo)
			builder.append(this.rightPad(t.getCONTRNO(), 17));// 貨櫃號碼 (ContrNo) 17
			builder.append(this.rightPad(t.getCONTRTYPE(), 4));// 貨櫃種類 (ContrType) 4
			builder.append(this.rightPad(t.getTRANSMODE(), 1));// 貨櫃裝運方式 (TransMode)1
			return builder.toString();
		}

		public String rightPad(String value, int size) {
			final String defaultString = StringUtils.defaultString(value);
			return StringUtils.rightPad(defaultString, size);
		}
	};

	private String DECLNO;// 報單號碼 (DeclNo) Character (14) 14
	private String CONTRNO;// 貨櫃號碼 (ContrNo) Character (12) 17
	private String CONTRTYPE;// 貨櫃種類 (ContrType) Character (4) 4
	private String TRANSMODE;// 貨櫃裝運方式 (TransMode) Character (1) 1

	@Override
	public String toString() {
		return MESSAGE.apply(this);
	}

	public String getDECLNO() {
		return this.DECLNO;
	}

	public void setDECLNO(String dECLNO) {
		this.DECLNO = dECLNO;
	}

	public String getCONTRNO() {
		return this.CONTRNO;
	}

	public void setCONTRNO(String cONTRNO) {
		this.CONTRNO = cONTRNO;
	}

	public String getCONTRTYPE() {
		return this.CONTRTYPE;
	}

	public void setCONTRTYPE(String cONTRTYPE) {
		this.CONTRTYPE = cONTRTYPE;
	}

	public String getTRANSMODE() {
		return this.TRANSMODE;
	}

	public void setTRANSMODE(String tRANSMODE) {
		this.TRANSMODE = tRANSMODE;
	}

}
