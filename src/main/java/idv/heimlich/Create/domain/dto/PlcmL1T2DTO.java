package idv.heimlich.Create.domain.dto;

import org.apache.commons.lang.StringUtils;

public class PlcmL1T2DTO {

	// 細項資料 (T2) Character (2) 2
	private String DECLNO;// 報單號碼 (DeclNo) Character (14) 14
	private String HWKITEMNO; // 報單項次(ItemNo) Numeric (4) 4
	private String HWKPRDTNO; // 料號 (PrdtNo) Character (60) 60
	private String HWKDESCRIP; // 貨名 (Descrip) Character (512) 512
	private String HWKBRAND; // 廠牌 (Brand) Character (50) 50
	private String HWKMODEL; // 型號 (Model) Character (80) 80
	private String HWKSPEC; // 規格 (Spec) Character (350) 350
	private String HWKNWGHT; // 淨重 (NWght) *UMBER(16,6) 17
	private String HWKQTY; // 數量 (Qty) *UMBER(20,6) 21
	private String HWKUNIT; // 單位 (Unit) Character (3) 3
	private String HWKODECLNO; // 原進倉報單號碼 (ODeclNo) Character (14) 14
	private String HWKOITEMNO; // 原進倉報單項次 (OItemNo) Numeric (4) 4
	private String HWKCCCCODE; // 稅則號列(CccCode) Character (11) 11
	private String HWKVALUEAMT; // 完稅價格(ValueAmt) Character (14) 14
	private String HWKDUTYRATE; // 進口稅率(DutyRate) *UMBER(15,5) 16
	private String HWKCOMDTAXRATE; // 貨物稅率(ComdTaxRate) *UMBER(15,5) 16
	private String HWKUPRICE; // 單價(UPrice) *UMBER(18,6) 19
	private String HWKCUR; // 幣別(Cur) Character (3) 3
	private String HWKD8DATE; // D8原進倉日期(D8date) Character (8) 8
	private String HWKDESCRIP390; // 貨名 (Descrip) Character (512) 512
	private String HWKSTATMODE; // 統計方式 Character (2) 2
	private String HWKPRODCOUNTRY; // 生產國別(產地) Character (2) 2
	private String HWKOEXDECLNO; // 原出口報單號碼 Character (14) 14
	private String HWKOEXITEMNO; // 原出口報單項次 Numeric (4) 4

	public void merger(PlcmL1T1DTO t1) {
		this.DECLNO = t1.getDECLNO();
	}

	public String getDECLNO() {
		return this.DECLNO;
	}

	public void setDECLNO(String dECLNO) {
		this.DECLNO = dECLNO;
	}

	public String getHWKITEMNO() {
		return this.HWKITEMNO;
	}

	public void setHWKITEMNO(String hWKITEMNO) {
		this.HWKITEMNO = hWKITEMNO;
	}

	public String getHWKPRDTNO() {
		return this.HWKPRDTNO;
	}

	public void setHWKPRDTNO(String hWKPRDTNO) {
		this.HWKPRDTNO = hWKPRDTNO;
	}

	public String getHWKDESCRIP() {
		return this.HWKDESCRIP;
	}

	public void setHWKDESCRIP(String hWKDESCRIP) {
		this.HWKDESCRIP = hWKDESCRIP;
	}

	public String getHWKBRAND() {
		return this.HWKBRAND;
	}

	public void setHWKBRAND(String hWKBRAND) {
		this.HWKBRAND = hWKBRAND;
	}

	public String getHWKMODEL() {
		return this.HWKMODEL;
	}

	public void setHWKMODEL(String hWKMODEL) {
		this.HWKMODEL = hWKMODEL;
	}

	public String getHWKSPEC() {
		return this.HWKSPEC;
	}

	public void setHWKSPEC(String hWKSPEC) {
		this.HWKSPEC = hWKSPEC;
	}

	public String getHWKNWGHT() {
		return this.HWKNWGHT;
	}

	public void setHWKNWGHT(String hWKNWGHT) {
		this.HWKNWGHT = hWKNWGHT;
	}

	public String getHWKQTY() {
		return this.HWKQTY;
	}

	public void setHWKQTY(String hWKQTY) {
		this.HWKQTY = hWKQTY;
	}

	public String getHWKUNIT() {
		return this.HWKUNIT;
	}

	public void setHWKUNIT(String hWKUNIT) {
		this.HWKUNIT = hWKUNIT;
	}

	public String getHWKODECLNO() {
		return this.HWKODECLNO;
	}

	public void setHWKODECLNO(String hWKODECLNO) {
		this.HWKODECLNO = hWKODECLNO;
	}

	public String getHWKOITEMNO() {
		return this.HWKOITEMNO;
	}

	public void setHWKOITEMNO(String hWKOITEMNO) {
		this.HWKOITEMNO = hWKOITEMNO;
	}

	public String getHWKCCCCODE() {
		return this.HWKCCCCODE;
	}

	public void setHWKCCCCODE(String hWKCCCCODE) {
		this.HWKCCCCODE = hWKCCCCODE;
	}

	public String getHWKVALUEAMT() {
		return this.HWKVALUEAMT;
	}

	public void setHWKVALUEAMT(String hWKVALUEAMT) {
		this.HWKVALUEAMT = hWKVALUEAMT;
	}

	public String getHWKDUTYRATE() {
		return this.HWKDUTYRATE;
	}

	public void setHWKDUTYRATE(String hWKDUTYRATE) {
		this.HWKDUTYRATE = hWKDUTYRATE;
	}

	public String getHWKCOMDTAXRATE() {
		return this.HWKCOMDTAXRATE;
	}

	public void setHWKCOMDTAXRATE(String hWKCOMDTAXRATE) {
		this.HWKCOMDTAXRATE = hWKCOMDTAXRATE;
	}

	public String getHWKUPRICE() {
		return this.HWKUPRICE;
	}

	public void setHWKUPRICE(String hWKUPRICE) {
		this.HWKUPRICE = hWKUPRICE;
	}

	public String getHWKCUR() {
		return this.HWKCUR;
	}

	public void setHWKCUR(String hWKCUR) {
		this.HWKCUR = hWKCUR;
	}

	public String getHWKD8DATE() {
		return this.HWKD8DATE;
	}

	public void setHWKD8DATE(String hWKD8DATE) {
		this.HWKD8DATE = hWKD8DATE;
	}

	public String getHWKDESCRIP390() {
		return this.HWKDESCRIP390;
	}

	public void setHWKDESCRIP390(String hWKDESCRIP390) {
		this.HWKDESCRIP390 = hWKDESCRIP390;
	}

	public String getHWKSTATMODE() {
		return this.HWKSTATMODE;
	}

	public void setHWKSTATMODE(String hWKSTATMODE) {
		this.HWKSTATMODE = hWKSTATMODE;
	}

	public String getHWKPRODCOUNTRY() {
		return this.HWKPRODCOUNTRY;
	}

	public void setHWKPRODCOUNTRY(String hWKPRODCOUNTRY) {
		this.HWKPRODCOUNTRY = hWKPRODCOUNTRY;
	}

	public String getHWKOEXDECLNO() {
		return this.HWKOEXDECLNO;
	}

	public void setHWKOEXDECLNO(String hWKOEXDECLNO) {
		this.HWKOEXDECLNO = hWKOEXDECLNO;
	}

	public String getHWKOEXITEMNO() {
		return this.HWKOEXITEMNO;
	}

	public void setHWKOEXITEMNO(String hWKOEXITEMNO) {
		this.HWKOEXITEMNO = hWKOEXITEMNO;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append(this.rightPad("T2", 2));// 細項資料 (T2) Character (2) 2
		builder.append(this.rightPad(this.getDECLNO(), 14)); // 報單號碼 (DeclNo) Character
		// (14) 14
		builder.append(this.rightPad(this.getHWKITEMNO(), 4));// 報單項次(ItemNo) Numeric (4) 4
		builder.append(this.rightPad(this.getHWKPRDTNO(), 60));// 料號 (PrdtNo) Character
		// (60) 60
		builder.append(this.rightPad(this.getHWKDESCRIP390(), 512));// 貨名 (Descrip)
		// Character (512)
		// 512
		builder.append(this.rightPad(this.getHWKBRAND(), 50));// 廠牌 (Brand) Character (50)
		// 50
		builder.append(this.rightPad(this.getHWKMODEL(), 80));// 型號 (Model) Character (80)
		// 80
		builder.append(this.rightPad(this.getHWKSPEC(), 350));// 規格 (Spec) Character (350)
		// 350
		builder.append(this.rightPad(this.getHWKNWGHT(), 17));// 淨重 (NWght) *UMBER(16,6) 17
		builder.append(this.rightPad(this.getHWKQTY(), 21));// 數量 (Qty) *UMBER(20,6) 21
		builder.append(this.rightPad(this.getHWKUNIT(), 3));// 單位 (Unit) Character (3) 3
		builder.append(this.rightPad(this.getHWKODECLNO(), 14));// 原進倉報單號碼 (ODeclNo)
		// Character (14) 14
		builder.append(this.rightPad(this.getHWKOITEMNO(), 4));// 原進倉報單項次 (OItemNo) Numeric
		// (4) 4
		builder.append(this.rightPad(this.getHWKCCCCODE(), 11));// 稅則號列(CccCode) Character
		// (11) 11
		builder.append(this.rightPad(this.getHWKVALUEAMT(), 14));// 完稅價格(ValueAmt)
		// Character (14) 14
		builder.append(this.rightPad(this.getHWKDUTYRATE(), 16));// 進口稅率(DutyRate)
		// *UMBER(15,5) 16
		builder.append(this.rightPad(this.getHWKCOMDTAXRATE(), 16));// 貨物稅率(ComdTaxRate)
		// *UMBER(15,5) 16
		builder.append(this.rightPad(this.getHWKUPRICE(), 19));// 單價(UPrice) *UMBER(18,6)
		// 19
		builder.append(this.rightPad(this.getHWKCUR(), 3));// 幣別(Cur) Character (3) 3
		builder.append(this.rightPad(this.getHWKD8DATE(), 8));// D8原進倉日期(D8date) Character
		// (8) 8
		builder.append(this.rightPad(this.getHWKSTATMODE(), 2));// 統計方式 Character (2) 2
		builder.append(this.rightPad(this.getHWKPRODCOUNTRY(), 2));// 生產國別(產地) Character
		// (2) 2
		builder.append(this.rightPad(this.getHWKOEXDECLNO(), 14));// 原出口報單號碼 Character (14)
		// 14
		builder.append(this.rightPad(this.getHWKOEXITEMNO(), 4));// 原出口報單項次 Numeric (4) 4
		return builder.toString();
	}

	public String rightPad(String value, int size) {
		final String defaultString = StringUtils.defaultString(value);
		return StringUtils.rightPad(defaultString, size);
	}

}
