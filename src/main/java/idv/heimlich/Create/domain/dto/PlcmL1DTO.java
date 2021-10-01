package idv.heimlich.Create.domain.dto;

import java.util.Map;

import idv.heimlich.Create.common.dao.RowMap2PoConverter;
import idv.heimlich.Create.common.db.utils.PropertyUtils;

public class PlcmL1DTO {

	public static RowMap2PoConverter<PlcmL1DTO> CONVERTER = var1 -> {
		final Map<?, ?> map = var1.getMap();
		final PlcmL1DTO plcmL1DTO = new PlcmL1DTO();
		PropertyUtils.copy(map, plcmL1DTO);
		return plcmL1DTO;
	};
	private String BOND_NO;
	private String DECL_NO;
	private String STR_TYPE;
	private String MSG_FUN;
	private String MSG_TYPE;
	private String BOX_NO;
	private String AS_TYPE;
	private String RLS_TYPE_1;
	private String RLS_TYPE_2;
	private String XML_RLS_TYPE;

	public static RowMap2PoConverter<PlcmL1DTO> getCONVERTER() {
		return CONVERTER;
	}

	public static void setCONVERTER(RowMap2PoConverter<PlcmL1DTO> cONVERTER) {
		CONVERTER = cONVERTER;
	}

	public String getBOND_NO() {
		return this.BOND_NO;
	}

	public void setBOND_NO(String bOND_NO) {
		this.BOND_NO = bOND_NO;
	}

	public String getDECL_NO() {
		return this.DECL_NO;
	}

	public void setDECL_NO(String dECL_NO) {
		this.DECL_NO = dECL_NO;
	}

	public String getSTR_TYPE() {
		return this.STR_TYPE;
	}

	public void setSTR_TYPE(String sTR_TYPE) {
		this.STR_TYPE = sTR_TYPE;
	}

	public String getMSG_FUN() {
		return this.MSG_FUN;
	}

	public void setMSG_FUN(String mSG_FUN) {
		this.MSG_FUN = mSG_FUN;
	}

	public String getMSG_TYPE() {
		return this.MSG_TYPE;
	}

	public void setMSG_TYPE(String mSG_TYPE) {
		this.MSG_TYPE = mSG_TYPE;
	}

	public String getBOX_NO() {
		return this.BOX_NO;
	}

	public void setBOX_NO(String bOX_NO) {
		this.BOX_NO = bOX_NO;
	}

	public String getAS_TYPE() {
		return this.AS_TYPE;
	}

	public void setAS_TYPE(String aS_TYPE) {
		this.AS_TYPE = aS_TYPE;
	}

	public String getRLS_TYPE_1() {
		return this.RLS_TYPE_1;
	}

	public void setRLS_TYPE_1(String rLS_TYPE_1) {
		this.RLS_TYPE_1 = rLS_TYPE_1;
	}

	public String getRLS_TYPE_2() {
		return this.RLS_TYPE_2;
	}

	public void setRLS_TYPE_2(String rLS_TYPE_2) {
		this.RLS_TYPE_2 = rLS_TYPE_2;
	}

	public String getXML_RLS_TYPE() {
		return this.XML_RLS_TYPE;
	}

	public void setXML_RLS_TYPE(String xML_RLS_TYPE) {
		this.XML_RLS_TYPE = xML_RLS_TYPE;
	}

}
