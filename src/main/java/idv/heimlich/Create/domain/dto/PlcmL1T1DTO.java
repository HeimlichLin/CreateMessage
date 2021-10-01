package idv.heimlich.Create.domain.dto;

import org.apache.commons.lang.StringUtils;

public class PlcmL1T1DTO {

	private static final String CL998 = "CL998";

	private String MSGFUN;// 異動別 (MsgFun)
	private String BONDNO;// 海關監管編號 (BondNo)
	private String STRTYPE;// 進出倉別 (StrType)
	private String HWKBOXNO; // 報關行箱號 (BoxNo)
	private String HWKDECLTYPE; // 報單類別 (DeclType)
	private String DECLNO;// 報單號碼 (DeclNo)
	private String HWKIMPORTDATE; // 進口日期 (ImportDate)
	private String HWKDECLDATE; // 申報日期 (DeclDate)
	private String HWKSTGPLACE;// 存放處所 (StgPlace)
	private String HWKRLSTIME; // 放行時間 (RlsTime)
	private String HWKRLSPKG; // 放行件數 (RlsPkg)
	private String HWKEXTRACOND; // 放行附帶條件 (ExtraCond)
	private String HWKPKGUNIT; // 件數單位 (PkgUnit)
	private String HWKGWGT; // 總重量 (GWgt)
	private String HWKVESSELSIGN;// 船舶呼號 (VesselSign)
	private String HWKVOYAGENO; // 航次 (VoyageNo)
	private String HWKSHIPCODE; // 船公司代碼 (ShipCode)
	private String HWKEXPORTER; // 貨物輸出人 (Exporter)
	private String HWKCLEARTYPE; // 通關方式 (ClearType)
	private String HWKREFBILLNO; // 參考單號 (RefBillNo)
	private String HWKINBONDNO; // 進倉保稅業者代碼 (InbondNo)
	private String HWKOUTBONDNO; // 出倉保稅業者代碼 (OutbondNo)
	private String HWKMAWBNO; // 主提單號(MawbNo)
	private String HWKHAWBNO; // 分提單號(HawbNo)
	private String HWKNOPKG; // 件數(NoPkg)
	private String HWKMARK; // 貨主代碼(OwnerID )借用Mark欄位取前八碼(需另行個別設定)
	private String HWKVRNO;// 海掛(VRNO)
	private String HWKSONO; // 艙單或裝貨單號(Manifest或SONO)
	private String HWKEXCHANGERATE; // 外幣匯率 (EXCHANGE_RATE)
	private String HWKTOTFOBVALUE; // 總離岸價格(TOT_FOB_VALUE)
	private String HWKLOADPORTCODE; // 裝貨港代碼(LOAD_PORT_CODE)
	private String HWKINSURANCEFEE;// 保險費 (INSURANCE_FEE)
	private String HWKFREIGHTFEE; // 運費 (FREIGHT_FEE) //

	public void merger(PlcmL1DTO plcmL1DTO) {
		this.MSGFUN = plcmL1DTO.getMSG_FUN();
		this.BONDNO = plcmL1DTO.getBOND_NO();
		this.STRTYPE = plcmL1DTO.getSTR_TYPE();
		this.DECLNO = plcmL1DTO.getDECL_NO();
	}

	public String getHWKBOXNO() { //
		return this.HWKBOXNO;
	}

	public void setHWKBOXNO(String hWKBOXNO) {
		this.HWKBOXNO = hWKBOXNO;
	}

	public String getHWKDECLTYPE() {
		return this.HWKDECLTYPE;
	}

	public void setHWKDECLTYPE(String hWKDECLTYPE) {
		this.HWKDECLTYPE = hWKDECLTYPE;
	}

	public String getHWKIMPORTDATE() {
		return this.HWKIMPORTDATE;
	}

	public void setHWKIMPORTDATE(String hWKIMPORTDATE) {
		this.HWKIMPORTDATE = hWKIMPORTDATE;
	}

	public String getHWKDECLDATE() {
		return this.HWKDECLDATE;
	}

	public void setHWKDECLDATE(String hWKDECLDATE) {
		this.HWKDECLDATE = hWKDECLDATE;
	}

	public String getHWKSTGPLACE() {
		return this.HWKSTGPLACE;
	}

	public void setHWKSTGPLACE(String hWKSTGPLACE) {
		this.HWKSTGPLACE = hWKSTGPLACE;
	}

	public String getHWKRLSTIME() {
		return this.HWKRLSTIME;
	}

	public void setHWKRLSTIME(String hWKRLSTIME) {
		this.HWKRLSTIME = hWKRLSTIME;
	}

	public String getHWKRLSPKG() {
		return this.HWKRLSPKG;
	}

	public void setHWKRLSPKG(String hWKRLSPKG) {
		this.HWKRLSPKG = hWKRLSPKG;
	}

	public String getHWKEXTRACOND() {
		return this.HWKEXTRACOND;
	}

	public void setHWKEXTRACOND(String hWKEXTRACOND) {
		this.HWKEXTRACOND = hWKEXTRACOND;
	}

	public String getHWKPKGUNIT() {
		return this.HWKPKGUNIT;
	}

	public void setHWKPKGUNIT(String hWKPKGUNIT) {
		this.HWKPKGUNIT = hWKPKGUNIT;
	}

	public String getHWKGWGT() {
		return this.HWKGWGT;
	}

	public void setHWKGWGT(String hWKGWGT) {
		this.HWKGWGT = hWKGWGT;
	}

	public String getHWKVESSELSIGN() {
		return this.HWKVESSELSIGN;
	}

	public void setHWKVESSELSIGN(String hWKVESSELSIGN) {
		this.HWKVESSELSIGN = hWKVESSELSIGN;
	}

	public String getHWKVOYAGENO() {
		return this.HWKVOYAGENO;
	}

	public void setHWKVOYAGENO(String hWKVOYAGENO) {
		this.HWKVOYAGENO = hWKVOYAGENO;
	}

	public String getHWKSHIPCODE() {
		return this.HWKSHIPCODE;
	}

	public void setHWKSHIPCODE(String hWKSHIPCODE) {
		this.HWKSHIPCODE = hWKSHIPCODE;
	}

	public String getHWKEXPORTER() {
		return this.HWKEXPORTER;
	}

	public void setHWKEXPORTER(String hWKEXPORTER) {
		this.HWKEXPORTER = hWKEXPORTER;
	}

	public String getHWKCLEARTYPE() {
		return this.HWKCLEARTYPE;
	}

	public void setHWKCLEARTYPE(String hWKCLEARTYPE) {
		this.HWKCLEARTYPE = hWKCLEARTYPE;
	}

	public String getHWKREFBILLNO() {
		return this.HWKREFBILLNO;
	}

	public void setHWKREFBILLNO(String hWKREFBILLNO) {
		this.HWKREFBILLNO = hWKREFBILLNO;
	}

	public String getHWKINBONDNO() {
		return this.HWKINBONDNO;
	}

	public void setHWKINBONDNO(String hWKINBONDNO) {
		this.HWKINBONDNO = hWKINBONDNO;
	}

	public String getHWKOUTBONDNO() {
		return this.HWKOUTBONDNO;
	}

	public void setHWKOUTBONDNO(String hWKOUTBONDNO) {
		this.HWKOUTBONDNO = hWKOUTBONDNO;
	}

	public String getHWKMAWBNO() {
		return this.HWKMAWBNO;
	}

	public void setHWKMAWBNO(String hWKMAWBNO) {
		this.HWKMAWBNO = hWKMAWBNO;
	}

	public String getHWKHAWBNO() {
		return this.HWKHAWBNO;
	}

	public void setHWKHAWBNO(String hWKHAWBNO) {
		this.HWKHAWBNO = hWKHAWBNO;
	}

	public String getHWKNOPKG() {
		return this.HWKNOPKG;
	}

	public void setHWKNOPKG(String hWKNOPKG) {
		this.HWKNOPKG = hWKNOPKG;
	}

	public String getHWKMARK() {
		return this.HWKMARK;
	}

	public void setHWKMARK(String hWKMARK) {
		this.HWKMARK = hWKMARK;
	}

	public String getHWKVRNO() {
		return this.HWKVRNO;
	}

	public void setHWKVRNO(String hWKVRNO) {
		this.HWKVRNO = hWKVRNO;
	}

	public String getHWKSONO() {
		return this.HWKSONO;
	}

	public void setHWKSONO(String hWKSONO) {
		this.HWKSONO = hWKSONO;
	}

	public String getHWKEXCHANGERATE() {
		return this.HWKEXCHANGERATE;
	}

	public void setHWKEXCHANGERATE(String hWKEXCHANGERATE) {
		this.HWKEXCHANGERATE = hWKEXCHANGERATE;
	}

	public String getHWKTOTFOBVALUE() {
		return this.HWKTOTFOBVALUE;
	}

	public void setHWKTOTFOBVALUE(String hWKTOTFOBVALUE) {
		this.HWKTOTFOBVALUE = hWKTOTFOBVALUE;
	}

	public String getHWKLOADPORTCODE() {
		return this.HWKLOADPORTCODE;
	}

	public void setHWKLOADPORTCODE(String hWKLOADPORTCODE) {
		this.HWKLOADPORTCODE = hWKLOADPORTCODE;
	}

	public String getHWKINSURANCEFEE() {
		return this.HWKINSURANCEFEE;
	}

	public void setHWKINSURANCEFEE(String hWKINSURANCEFEE) {
		this.HWKINSURANCEFEE = hWKINSURANCEFEE;
	}

	public String getHWKFREIGHTFEE() {
		return this.HWKFREIGHTFEE;
	}

	public void setHWKFREIGHTFEE(String hWKFREIGHTFEE) {
		this.HWKFREIGHTFEE = hWKFREIGHTFEE;
	}

	// == [instance variables] Block Stop
	// ================================================
	// == [static Constructor] Block Start
	// == [static Constructor] Block Stop
	// ================================================
	// == [Constructors] Block Start
	// == [Constructors] Block Stop
	// ================================================
	// == [Static Method] Block Start
	// == [Static Method] Block Stop
	// ================================================
	// == [Accessor] Block Start

	public String getMSGFUN() {
		return this.MSGFUN;
	}

	public void setMSGFUN(String mSGFUN) {
		this.MSGFUN = mSGFUN;
	}

	public String getBONDNO() {
		return this.BONDNO;
	}

	public void setBONDNO(String bONDNO) {
		this.BONDNO = bONDNO;
	}

	public String getSTRTYPE() {
		return this.STRTYPE;
	}

	public void setSTRTYPE(String sTRTYPE) {
		this.STRTYPE = sTRTYPE;
	}

	public String getDECLNO() {
		return this.DECLNO;
	}

	public void setDECLNO(String dECLNO) {
		this.DECLNO = dECLNO;
	}

	// == [Accessor] Block Stop
	// ================================================
	// == [Overrided JDK Method] Block Start (Ex. toString / equals+hashCode)
	// == [Overrided JDK Method] Block Stop
	// ================================================
	// == [Method] Block Start
	// ####################################################################
	// ## [Method] sub-block :
	// ###################################################################
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append(this.rightPad("T1", 2));// 主檔資料 (T1) Character (2) 2
		builder.append(this.rightPad(this.getMSGFUN(), 3));// 異動別 (MsgFun) Character (3) 3
		builder.append(this.rightPad(this.getBONDNO(), 12));// 海關監管編號 (BondNo) Character (12) 12
		builder.append(this.rightPad(this.getSTRTYPE(), 1));// 進出倉別 (StrType) Character (1) 1
		builder.append(this.rightPad(this.getHWKBOXNO(), 4));// 報關行箱號 (BoxNo) Character (4) 4
		builder.append(this.rightPad(this.getHWKDECLTYPE(), 2));// 報單類別 (DeclType) Character (2) 2
		builder.append(this.rightPad(this.getDECLNO(), 14));// 報單號碼 (DeclNo) Character (14) 14
		builder.append(this.rightPad(this.getHWKIMPORTDATE(), 8));// 進口日期 (ImportDate) Character (8) 8
		builder.append(this.rightPad(this.getHWKDECLDATE(), 8));// 申報日期 (DeclDate) Character (8) 8
		builder.append(this.rightPad(this.getHWKSTGPLACE(), 8));// 存放處所 (StgPlace) Character (8) 8
		builder.append(this.rightPad(this.getHWKRLSTIME(), 14));// 放行時間 (RlsTime) Character (14) 14
		builder.append(this.rightPad(this.getHWKRLSPKG(), 8));// 放行件數 (RlsPkg) Numeric (8) 8
		builder.append(this.rightPad(this.getHWKEXTRACOND(), 1));// 放行附帶條件 (ExtraCond) Character (1) 1
		builder.append(this.rightPad(this.getHWKPKGUNIT(), 3));// 件數單位 (PkgUnit) Character (3) 3
		builder.append(this.rightPad(this.getHWKGWGT(), 21));// 總重量 (GWgt) *NUMBER(20,6) 21
		builder.append(this.rightPad(this.getHWKVESSELSIGN(), 12));// 船舶呼號 (VesselSign) Character (12) 12
		builder.append(this.rightPad(this.getHWKVOYAGENO(), 12));// 航次 (VoyageNo) Character (12) 12
		builder.append(this.rightPad(this.getHWKSHIPCODE(), 14));// 船公司代碼 (ShipCode) Character (14) 14
		builder.append(this.rightPad(this.getHWKEXPORTER(), 160));// 貨物輸出人 (Exporter) Character (160) 160
		builder.append(this.rightPad(this.getHWKCLEARTYPE(), 3));// 通關方式 (ClearType) Character (3) 3
		builder.append(this.rightPad(this.getHWKREFBILLNO(), 14));// 參考單號 (RefBillNo) Character (14) 14
		builder.append(this.rightPad(this.getHWKINBONDNO(), 12));// 進倉保稅業者代碼 (InbondNo) Character (12) 12
		builder.append(this.rightPad(this.getHWKOUTBONDNO(), 12));// 出倉保稅業者代碼 (OutbondNo) Character (12) 12
		builder.append(this.rightPad(this.getHWKMAWBNO(), 35));// 主提單號(MawbNo) Character (35) 35
		builder.append(this.rightPad(this.getHWKHAWBNO(), 35));// 分提單號(HawbNo) Character (35) 35
		builder.append(this.rightPad(this.getHWKNOPKG(), 8));// 件數(NoPkg) Character (8) 8
		builder.append((this.getBONDNO().equals(CL998)
				? this.rightPad(this.getHWKMARK(), 8)
				: this.rightPad("", 8)));// 貨主代碼(OwnerID )// 借用Mark欄位取前八碼// (需另行個別設定) Character (8) 8
		builder.append(this.rightPad(this.getHWKVRNO(), 6));// 海掛(VRNO) Character (6) 6
		builder.append(this.rightPad(this.getHWKSONO(), 4));// 艙單或裝貨單號(Manifest或SONO) Character(4) 4
		builder.append(this.rightPad(this.getHWKEXCHANGERATE(), 15));// 外幣匯率 (EXCHANGE_RATE) NUMBER(14,5) 15
		builder.append(this.rightPad(this.getHWKTOTFOBVALUE(), 18));// 總離岸價格(TOT_FOB_VALUE) NUMBER(17,2) 18
		builder.append(this.rightPad(this.getHWKLOADPORTCODE(), 5));// 裝貨港代碼(LOAD_PORT_CODE) VARCHAR2(5 CHAR) 5
		builder.append(this.rightPad(this.getHWKINSURANCEFEE(), 17));// 保險費 (INSURANCE_FEE) NUMBER(16,2) 17
		builder.append(this.rightPad(this.getHWKFREIGHTFEE(), 4));// 運費 (FREIGHT_FEE) NUMBER(16,2) 17
		return builder.toString();
	}

	public String rightPad(String value, int size) {
		final String defaultString = StringUtils.defaultString(value);
		return StringUtils.rightPad(defaultString, size);
	}

	// == [Method] Block Stop
	// ================================================
	// == [Inner Class] Block Start
	// == [Inner Class] Block Stop
	// ================================================

}
