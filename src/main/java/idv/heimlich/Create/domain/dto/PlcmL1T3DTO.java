package idv.heimlich.Create.domain.dto;

import org.apache.commons.lang.StringUtils;

public class PlcmL1T3DTO {

	private String DECLNO;// 報單號碼 (DeclNo) Character (14) 14
	private String ITEMNO;// 報單項次 (ItemNo) Numeric (4) 4
	private String VEHICLENO;// 車身號碼 (VehicleNo) Character (18) 18

	public String getDECLNO() {
		return this.DECLNO;
	}

	public void setDECLNO(String dECLNO) {
		this.DECLNO = dECLNO;
	}

	public String getITEMNO() {
		return this.ITEMNO;
	}

	public void setITEMNO(String iTEMNO) {
		this.ITEMNO = iTEMNO;
	}

	public String getVEHICLENO() {
		return this.VEHICLENO;
	}

	public void setVEHICLENO(String vEHICLENO) {
		this.VEHICLENO = vEHICLENO;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append(this.rightPad("T3", 2));
		builder.append(this.rightPad(this.getDECLNO(), 14));// 報單號碼 (DeclNo)
		builder.append(this.rightPad(this.getITEMNO(), 4));// 報單項次 (ItemNo)
		builder.append(this.rightPad(this.getVEHICLENO(), 18));// 車身號碼 (VehicleNo)
		return builder.toString();

	}

	public String rightPad(String value, int size) {
		final String defaultString = StringUtils.defaultString(value);
		return StringUtils.rightPad(defaultString, size);
	}

}
