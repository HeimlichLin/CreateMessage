package idv.heimlich.Create.domain.type;

import idv.heimlich.Create.domain.PclmsL1;

public class PClmsL1Cl040 extends PclmsL1 implements PclmsL1Execute {
	private static final String SQL1 = " SELECT DISTINCT                                        "
			+ "        DECLAR.BONDNO                 AS BOND_NO,       "
			+ "        SENDLOG.DECLNO                AS DECL_NO,       "
			+ "        SENDLOG.STRTYPE               AS STR_TYPE,      "
			+ "        SENDLOG.MSGFUN                AS MSG_FUN,       "
			+ "        SENDLOG.MSGTYPE               AS MSG_TYPE,      "
			+ "        SUBSTR(DECLAR.BOXNO, 1, 3)    AS BOX_NO,        "
			+ "        DECLAR.ASTYPE                 AS AS_TYPE,       "
			+ "        DECODE(SENDLOG.MSGTYPE,                         "
			+ "          '5105',  '5116',                              "
			+ "          '5105A', '5116',                              "
			+ "          '5105S', '5116S',                             "
			+ "          '5203',  '5204',                              "
			+ "          '5203A', '5204',                              "
			+ "          '5203S', '5204S',                             "
			+ "          'N5203', '5204',                              "
			+ "          'NX5105','5116') AS RLS_TYPE_1,               "
			+ "        DECODE(SENDLOG.MSGTYPE,                         "
			+ "          '5105',  '5116',                              "
			+ "          '5105A', '5116',                              "
			+ "          '5105S', '5116S',                             "
			+ "          '5203',  '5204',                              "
			+ "          '5203A', '5204',                              "
			+ "          '5203S', '5204S',                             "
			+ "          'N5203', '5204S',                             "
			+ "          'NX5105','5116S') AS RLS_TYPE_2,              "
			+ "        DECODE( SENDLOG.MSGTYPE,                        "
			+ "          '5105',  'N5116',                             "
			+ "          '5105A', 'N5116',                             "
			+ "          '5105S', 'N5116',                             "
			+ "          '5203',  'N5204',                             "
			+ "          '5203A', 'N5204',                             "
			+ "          'N5203', 'N5204',                             "
			+ "          'NX5105','N5116') AS XML_RLS_TYPE    		 "
			+ "   FROM SENDLOG, DECLAR, WAREHSE               		 "
			+ " WHERE   WAREHSE.RECV_FLAG = 'Y'                        "
			+ "   AND  WAREHSE.BONDNO = 'CL040'                       "
			+ "    AND WAREHSE.AUTHORITY IN ('B', 'D', 'W')            "
			+ "    AND SENDLOG.BONDNO = WAREHSE.BONDNO                 "
			+ "    AND SENDLOG.SENDFLAG = 'N'                          "
			+ "    AND SENDLOG.BONDNO = DECLAR.BONDNO                  "
			+ "    AND SENDLOG.DECLNO = DECLAR.DECLNO         		 "
			+ "    AND SENDLOG.MSGTYPE = DECLAR.MSGTYPE                "
			+ "    AND SENDLOG.STRTYPE = DECLAR.STRTYPE                "
			+ "  ORDER BY DECLAR.BONDNO,SENDLOG.DECLNO, SENDLOG.MSGFUN ";

	private static final String SQLT1 = "SELECT DECLAR.BOXNO                                           AS HWKBOXNO,      "
			+ "       DECLAR.DECLTYPE                                        AS HWKDECLTYPE,   "
			+ "       TO_CHAR(DECLAR.IMPORTDATE,'YYYYMMDD')                  AS HWKIMPORTDATE, "
			+ "       TO_CHAR(DECLAR.DECLDATE,'YYYYMMDD')                    AS HWKDECLDATE,   "
			+ "       DECLAR.STGPLACE                                        AS HWKSTGPLACE,   "
			+ "       TO_CHAR(RELEASE.RLSTIME,'YYYYMMDDHH24MISS')            AS HWKRLSTIME,    "
			+ "       LPAD(RELEASE.RLSPKG,8,'0')                             AS HWKRLSPKG,     "
			+ "       SUBSTR(RELEASE.EXTRACOND, 1, 1)                        AS HWKEXTRACOND,  "
			+ "       NVL(RELEASE.PKGUNIT, DECLAR.PKGUNIT)                   AS HWKPKGUNIT,    "
			+ "       SUBSTR(TO_CHAR(DECLAR.GWGT,'0000000000.0'),2)          AS HWKGWGT,       "
			+ "       RELEASE.VESSELSIGN                                     AS HWKVESSELSIGN, "
			+ "       RELEASE.VOYAGENO                                       AS HWKVOYAGENO,   "
			+ "       DECLAR.OWNERBAN                                        AS HWKSHIPCODE,   "
			+ "       RELEASE.EXPORTER                                       AS HWKEXPORTER,   "
			+ "       RELEASE.CLEARTYPE                                      AS HWKCLEARTYPE,  "
			+ "       DECLAR.REFBILLNO                                       AS HWKREFBILLNO,  "
			+ "       DECLAR.INBONDNO                                        AS HWKINBONDNO,   "
			+ "       DECLAR.OUTBONDNO                                       AS HWKOUTBONDNO  "
			+
			//"       DECLAR.MAWBNO                                          AS HWKMAWBNO,     "+
			//"       DECLAR.HAWBNO                                          AS HWKHAWBNO,     "+
			//"       LPAD(DECLAR.NOPKG,8,'0')                               AS HWKNOPKG,      "+
			//"       SUBSTR(DECLAR.MARK,0,8)                                AS HWKMARK        "+
			"   FROM DECLAR, RELEASE                                                         "
			+ "  WHERE DECLAR.DECLNO    = RELEASE.DECLNO                                       "
			+ "    AND DECLAR.BONDNO    = ?                                                    "
			+ "    AND DECLAR.DECLNO    = ?                                                    "
			+ "    AND DECLAR.MSGTYPE   = ?                                                    "
			+ "    AND SUBSTR(DECLAR.BOXNO, 1, 3)     = ?                                      "
			+ "    AND DECLAR.ASTYPE    = ?                                                    "
			+ "    AND ( RELEASE.MSGTYPE = ? OR RELEASE.MSGTYPE = ? OR RELEASE.MSGTYPE = ? )   "
			+ "    AND ROWNUM = 1                                                              "
			+ " ORDER BY RELEASE.RLSTIME DESC                                                  ";
	private static final String SQLT2 = " SELECT LPAD(ITEMNO,4,'0')                                                AS HWKITEMNO,     "
			+ "        PRDTNO                                                            AS HWKPRDTNO,     "
			+ "        SUBSTRB(REPLACE(REPLACE(DESCRIP, CHR(13), ''), CHR(10), ''),0,70) AS HWKDESCRIP,    "
			+ "        SUBSTR(BRAND, 0, 15)                                              AS HWKBRAND,      "
			+ "        SUBSTR(MODEL, 0, 15)                                              AS HWKMODEL,      "
			+ "        SPEC                                                              AS HWKSPEC,       "
			+ "        SUBSTR(TO_CHAR(NWGHT,'0000000000.0'),2)                      	   AS HWKNWGHT,      "
			+ "        SUBSTR(TO_CHAR(QTY,'000000000.0000'),2)                           AS HWKQTY,        "
			+ "        UNIT                                                              AS HWKUNIT,       "
			+ "        ODECLNO                                                           AS HWKODECLNO,    "
			+ "        LPAD(OITEMNO,4,'0')                                               AS HWKOITEMNO,    "
			+
			//"        CCCCODE                                                           AS HWKCCCCODE,    "+
			"        LPAD(VALUEAMT,12,'0')                                             AS HWKVALUEAMT,   "
			+ "        SUBSTR(TO_CHAR(ValueQty,'000000000.0000'),2)                      AS HWKVALUEQTY,   "
			+ "        SUBSTR(TO_CHAR(DUTYRATE,'00000.0000'),2)                          AS HWKDUTYRATE,   "
			+ "        SUBSTR(TO_CHAR(UnitDuty,'00000.00'),2)                            AS HWKUNITDUTY,   "
			+
			//"        SUBSTR(TO_CHAR(COMDTAXRATE,'0000000000.00000'),2)                 AS HWKCOMDTAXRATE,"+
			"        SUBSTR(TO_CHAR(UPRICE,'000000000000.000000'),2)                   AS HWKUPRICE,     "
			+ "        NVL(CUR,'TWD')                                                    AS HWKCUR,        "
			+
			//"        D8DATE                                                            AS HWKD8DATE,     "+
			"        SUBSTR(REPLACE(REPLACE(DESCRIP, CHR(13), ''), CHR(10), ''), 0, 390)               AS HWKDESCRIP390, "
			+ "        SUBSTR(STATMODE,0,2)                                              AS HWKSTATMODE,   "
			+ "        SUBSTR(PRODCOUNTRY,0,2)                                           AS HWKPRODCOUNTRY "
			+ "   FROM DECLDETAIL                                                                          "
			+ "  WHERE DECLNO  = ?                                                                         "
			+ "    AND BONDNO  = ?                                                                         "
			+ "    AND MSGTYPE = ?                                                                         ";
	/*
	 * private static final String SQLT3 =" SELECT DECLNO, ITEMNO, VEHICLENO"+
	 * "   FROM VEHICLE                  "+ "  WHERE DECLNO = ?               "+
	 * "    AND BONDNO = ?               ";
	 */

	private static final String SQLT3 = "SELECT  CONTRNO,   "
			+ "       CONTRTYPE, " + "       TRANSMODE  " + "  FROM CONTAINER  "
			+ " WHERE DECLNO =?  " + "   AND BONDNO = ? ";

	private static final String UPDATESENDLOG = " UPDATE SENDLOG                                       "
			+ " SET SENDTIME = SYSDATE, SENDFLAG = 'Y', CONTROLNO = ? "
			+ " WHERE DECLNO = ?                                      "
			+ " AND BONDNO = ?                                        "
			+ " AND MSGTYPE = ?                                       "
			+ " AND ASTYPE = ?                                        "
			+ " AND SENDFLAG = 'N'                                    ";

	/**
	 * @Description 產檔
	 * @author Aaron Pan 2015/10/22
	 */
	@Override
	public void process() {
//		Connection conn=null;
//		PreparedStatement stmt = null;
//		ResultSet rset = null;
//		FileOutputStream fos=null;			 				 
//		BufferedOutputStream bs=null;		
//		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        Date current = new Date();		 
//	    String dateStr=sdFormat.format(current);				
//		try {			
////			conn = DbFactory.open();
//			
//     /////////////////////////////////SQ1 來源區塊  start////////////////////////////////////////////////////
//			stmt = conn.prepareStatement(SQL1);			
//			rset = stmt.executeQuery();			   
//			 HashMap<String, String> valueMap=new  HashMap<String, String>(); 
//			 List<Map<String, String>> list=new LinkedList<Map<String,String>>();
//			 Map<String, Object>keyMap=new  HashMap<String, Object>();  
//			 
//			while (rset.next()) {				
//				 String BOND_NO      =rset.getString("BOND_NO");           
//				 String DECL_NO     	=rset.getString("DECL_NO");           
//				 String STR_TYPE    	=rset.getString("STR_TYPE");          
//				 String MSG_FUN     	=rset.getString("MSG_FUN");           
//				 String MSG_TYPE    	=rset.getString("MSG_TYPE");          
//				 String BOX_NO      	=rset.getString("BOX_NO");            
//				 String AS_TYPE     	=rset.getString("AS_TYPE");           
//				 String RLS_TYPE_1    	=rset.getString("RLS_TYPE_1");
//				 String RLS_TYPE_2    	=rset.getString("RLS_TYPE_2");
//				 String XML_RLS_TYPE	=rset.getString("XML_RLS_TYPE");
//				
//				 if(keyMap.containsKey(BOND_NO)){					 
//					 valueMap=new  HashMap<String, String>();
//					 valueMap.put("BOND_NO", BOND_NO);
//					 valueMap.put("DECL_NO", DECL_NO);
//					 valueMap.put("STR_TYPE", STR_TYPE);
//					 valueMap.put("MSG_FUN", MSG_FUN);
//					 valueMap.put("MSG_TYPE", MSG_TYPE);
//					 valueMap.put("BOX_NO", BOX_NO);
//					 valueMap.put("AS_TYPE", AS_TYPE);
//					 valueMap.put("RLS_TYPE_1", RLS_TYPE_1);
//					 valueMap.put("RLS_TYPE_2", RLS_TYPE_2);
//					 valueMap.put("XML_RLS_TYPE", XML_RLS_TYPE);					 
//					 list.add(valueMap);					 
//					 keyMap.put(BOND_NO, list);
//				 }else{
//					 list=new LinkedList<Map<String,String>>();					 
//					 valueMap=new  HashMap<String, String>();
//					 valueMap.put("BOND_NO", BOND_NO);
//					 valueMap.put("DECL_NO", DECL_NO);
//					 valueMap.put("STR_TYPE", STR_TYPE);
//					 valueMap.put("MSG_FUN", MSG_FUN);
//					 valueMap.put("MSG_TYPE", MSG_TYPE);
//					 valueMap.put("BOX_NO", BOX_NO);
//					 valueMap.put("AS_TYPE", AS_TYPE);
//					 valueMap.put("RLS_TYPE_1", RLS_TYPE_1);
//					 valueMap.put("RLS_TYPE_2", RLS_TYPE_2);
//					 valueMap.put("XML_RLS_TYPE", XML_RLS_TYPE);					 
//					 list.add(valueMap);						 
//					 keyMap.put(BOND_NO, list);
//				 }
//				 
//			}			
//			if (rset != null) {
//				try {
//					rset.close();
//				} catch (SQLException e) {
//					logger.error("error", e);
//				}
//			}
//			
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					logger.error("error", e);
//				}
//			}
//	///////////////////////////////////SQ1 來源區塊  end////////////////////////////////////////////////////
//			
//	//////////////////////////////////檔案處理區塊////////////////////////////////////		
//			for (Map.Entry<String,Object> entry : keyMap.entrySet()) {								
//				  List<Map<String, String>> mapList=( List<Map<String, String>>)keyMap.get(entry.getKey());				  
//				  String fileName = M_DOCNAME + entry.getKey() + dateStr.substring(4);
//				  File fileTmp = new File( FILE_PATHS, fileName + ".tmp" );
//				  File file = new File( FILE_PATHS, fileName );
//				  logger.info( "OutPutFile = " + fileTmp.getAbsolutePath() ); 			   
//				  fos=new FileOutputStream(fileTmp); 
//				  bs=new BufferedOutputStream(fos);
//				  
//				   
//					    
//				   
//				   
//				 ///////////////////////////T1產檔區 end/////////////////////// 
//				  for(Map<String, String> map:mapList){
//					  ArrayList<String> t1ValueList=new ArrayList<String>();
//					  ArrayList<String> t2ValueList=new ArrayList<String>();
//					  ArrayList<String> t3ValueList=new ArrayList<String>();
//					  String BOND_NO     =  map.get("BOND_NO");
//					  String DECL_NO     =	map.get("DECL_NO");
//					  String STR_TYPE    =	map.get("STR_TYPE");
//					  String MSG_FUN     =	map.get("MSG_FUN");
//					  String MSG_TYPE    =	map.get("MSG_TYPE");		 
//					  String BOX_NO      =	map.get("BOX_NO");
//					  String AS_TYPE     =	map.get("AS_TYPE");
//					  String RLS_TYPE_1  =	map.get("RLS_TYPE_1");
//					  String RLS_TYPE_2  =	map.get("RLS_TYPE_2");
//					  String XML_RLS_TYPE=	map.get("XML_RLS_TYPE");	
//					  boolean t1Flag=false;
//					  boolean t2Flag=false;
//					  stmt = conn.prepareStatement(SQLT1);
//					  stmt.setString(1, BOND_NO);
//					  stmt.setString(2, DECL_NO);
//					  stmt.setString(3, MSG_TYPE);
//					  stmt.setString(4, BOX_NO);
//					  stmt.setString(5, AS_TYPE);
//					  stmt.setString(6, RLS_TYPE_1);
//					  stmt.setString(7, RLS_TYPE_2);
//					  stmt.setString(8, XML_RLS_TYPE);
//					  rset = stmt.executeQuery();
//					  
//					  while (rset.next()) {	  
//						  String valueT1="";
//						  String MSG_FUN_T1 =getRealLengthStr(MSG_FUN        ,3);  //異動別3
//						  String BOND_NO_T1     =  getRealLengthStr(BOND_NO       ,5); //海關監管編號5 ;
//						  String STR_TYPE_T1=  getRealLengthStr(STR_TYPE      ,1); //進出倉別 1 ;				
//						  String HWKBOXNO      =          getRealLengthStr(rset.getString("HWKBOXNO")        ,4); //報關行箱號 (BoxNo)	Character (4)			
//						  String HWKDECLTYPE   =			getRealLengthStr(rset.getString("HWKDECLTYPE")     ,2); //報單類別 (DeclType)	Character (2)
//						  String DECL_NO_T1 =				getRealLengthStr(DECL_NO        ,14);  //報單號碼 (DeclNo)	Character (14)		
//						  String HWKIMPORTDATE =			getRealLengthStr(rset.getString("HWKIMPORTDATE")   ,8); //進口日期 (ImportDate)	Date	8
//						  String HWKDECLDATE   =			getRealLengthStr(rset.getString("HWKDECLDATE")    ,8);//申報日期 (DeclDate)	Date	8
//						  String HWKSTGPLACE   =			getRealLengthStr(rset.getString("HWKSTGPLACE")     ,8);				//存放處所 (StgPlace)	Character (8)	8
//						  String HWKRLSTIME    =			getRealLengthStr(rset.getString("HWKRLSTIME")      ,14);//放行時間 (RlsTime)	Date	14
//						  String HWKRLSPKG     =			getRealLengthStr(rset.getString("HWKRLSPKG")       ,8);//放行件數 (RlsPkg)	Numeric (8)	8
//						  String HWKEXTRACOND  =			getRealLengthStr(rset.getString("HWKEXTRACOND")    ,1);//放行附帶條件 (ExtraCond)	Character (1)	1	
//						  String HWKPKGUNIT    =			getRealLengthStr(rset.getString("HWKPKGUNIT")      ,3);//件數單位 (PkgUnit)	Character (3)	3
//						  String HWKGWGT       =			getRealLengthStr(rset.getString("HWKGWGT")          ,12);//總重量 (GWgt)	Numeric (12,2)	12
//						  String HWKVESSELSIGN =			getRealLengthStr(rset.getString("HWKVESSELSIGN")   ,6);//船舶呼號 (VesselSign)	Character (6)	6
//						  String HWKVOYAGENO   =			getRealLengthStr(rset.getString("HWKVOYAGENO")    ,12);//航次 (VoyageNo)	Character (12)	12
//						  String HWKSHIPCODE   =			getRealLengthStr(rset.getString("HWKSHIPCODE")     ,7);//船公司代碼 (ShipCode)	Character (7)	7
//						  String HWKEXPORTER   =			getRealLengthStr(rset.getString("HWKEXPORTER")     ,70);//貨物輸出人 (Exporter)	Character (70)	70
//						  String HWKCLEARTYPE  =			getRealLengthStr(rset.getString("HWKCLEARTYPE")    ,2);//通關方式 (ClearType)	Character (2)	2
//						  String HWKREFBILLNO  =			getRealLengthStr(rset.getString("HWKREFBILLNO")    ,14);//參考單號 (RefBillNo)	Character (14)	14
//						  String HWKINBONDNO   =			getRealLengthStr(rset.getString("HWKINBONDNO")     ,8);//進倉保稅業者代碼 (InbondNo)	Character (8)	8
//						  String HWKOUTBONDNO  =			getRealLengthStr(rset.getString("HWKOUTBONDNO")    ,8);//出倉保稅業者代碼 (OutbondNo)	Character (8)	8
//						  //String HWKMAWBNO     =			getRealLengthStr(rset.getString("HWKMAWBNO")       ,35);//主提單號(MawbNo)	Character (16)	16
//						  //String HWKHAWBNO     =			getRealLengthStr(rset.getString("HWKHAWBNO")       ,35);//分提單號(HawbNo)	Character (16)	16
//						  //String HWKNOPKG      =			getRealLengthStr(rset.getString("HWKNOPKG")         ,8);//件數(NoPkg)	Character (8)	8
//						  //String HWKMARK      =			getRealLengthStr(rset.getString("HWKMARK")         ,8);//HWKMARK	Character (8)	8									
//						  /*
//						  valueT1=T1+MSG_FUN_T1+BOND_NO_T1+STR_TYPE_T1+HWKBOXNO+HWKDECLTYPE+DECL_NO_T1+HWKIMPORTDATE+HWKDECLDATE+HWKSTGPLACE+HWKRLSTIME+HWKRLSPKG
//							         +HWKEXTRACOND+HWKPKGUNIT+HWKGWGT+HWKVESSELSIGN+HWKVOYAGENO+HWKSHIPCODE+HWKEXPORTER+HWKCLEARTYPE+HWKREFBILLNO+HWKINBONDNO
//							         +HWKOUTBONDNO+HWKMAWBNO+HWKHAWBNO+HWKNOPKG+(BOND_NO.equals("CL998")?HWKMARK:(new String("".getBytes(CHARSET), CHARSET))) +"\r\n";
//						  */ 						  
//						  valueT1=MSG_FUN_T1+BOND_NO_T1+STR_TYPE_T1+HWKBOXNO+HWKDECLTYPE+DECL_NO_T1+HWKIMPORTDATE+HWKDECLDATE+HWKSTGPLACE+HWKRLSTIME+HWKRLSPKG
//							         +HWKEXTRACOND+HWKPKGUNIT+HWKGWGT+HWKVESSELSIGN+HWKVOYAGENO+HWKSHIPCODE+HWKEXPORTER+HWKCLEARTYPE+HWKREFBILLNO+HWKINBONDNO
//							         +HWKOUTBONDNO;
//						  System.out.println(valueT1);
//						  t1ValueList.add(valueT1);						
//						  t1Flag=true;					 
//					}
//					  
//					if (rset != null) {
//						try {
//							rset.close();
//						} catch (SQLException e) {
//							logger.error("error", e);
//						}
//					}
//					
//					if (stmt != null) {
//						try {
//							stmt.close();
//						} catch (SQLException e) {
//							logger.error("error", e);
//						}
//					}				    
//				///////////////////////////T1產檔區 end///////////////////////
//					
////////////////////////////////////////////////T2產檔區 start/////////////////////////////////////////////					
//					 if(t1Flag){						  
//						 stmt = conn.prepareStatement(SQLT2);
//						 stmt.setString(1, DECL_NO);
//						 stmt.setString(2, BOND_NO);
//						 stmt.setString(3, MSG_TYPE);							 
//						 rset = stmt.executeQuery();
//						 
//						 while (rset.next()) {	
//							 String valueT2="";
//							 //String T2=new String("T2".getBytes(CHARSET), CHARSET);;// new String("T1".getBytes("Big5"), "Big5");	
//							 //String DECL_NO_T2 =getRealLengthStr(DECL_NO       ,14);  //報單號碼 (DeclNo)	Character (14)	14			 
//							 String HWKITEMNO      =  getRealLengthStr(rset.getString("HWKITEMNO"),4 );  // 報單項次(ItemNo)	Numeric (4)	4
//							 String HWKPRDTNO      =  getRealLengthStr(rset.getString("HWKPRDTNO"), 15); //料號 (PrdtNo)	Character (15)	15
//							 String HWKDESCRIP     =  getRealLengthStr(rset.getString("HWKDESCRIP"), 30); //貨名 (Descrip)	Character (30)	30
//							 //String HWKDESCRIP     =  (new String("".getBytes(CHARSET), CHARSET)); //貨名 (Descrip)	Character (70)	70
//							 String HWKBRAND       =  getRealLengthStr(rset.getString("HWKBRAND"),15 ); //廠牌 (Brand)	Character (15)15
//							 String HWKMODEL       =  getRealLengthStr(rset.getString("HWKMODEL"),15 ); //型號 (Model)	Character (15)	15
//							 String HWKSPEC        =  getRealLengthStr(rset.getString("HWKSPEC"),40 ); //規格 (Spec)	Character (40)	40
//							 String HWKNWGHT       =  getRealLengthStr(rset.getString("HWKNWGHT"),12 ); //淨重 (NWght)	Numeric (12,2)	12
//							 String HWKQTY         =  getRealLengthStr(rset.getString("HWKQTY"),14 ); //數量 (Qty)	Numeric (14,4)	14
//							 String HWKUNIT        =  getRealLengthStr(rset.getString("HWKUNIT"),3 ); //單位 (Unit)	Character (3)	3
//							 String HWKUPRICE      =  getRealLengthStr(rset.getString("HWKUPRICE"), 19); //單價(UPrice)	Character (19)	19
//							 String HWKCUR         =  getRealLengthStr(rset.getString("HWKCUR"),3 ); //幣別(Cur)	Character (3)	3
//							 String HWKVALUEAMT    =  getRealLengthStr(rset.getString("HWKVALUEAMT"),12 ); //完稅價格(ValueAmt)	Character (12)	12
//							 String HWKVALUEQTY    =  getRealLengthStr(rset.getString("HWKVALUEQTY"),14 ); //完稅數量(ValueQty)	Character (14)	14
//							 String HWKDUTYRATE    =  getRealLengthStr(rset.getString("HWKDUTYRATE"),10 ); //進口稅率(DutyRate)	Character (10)	10
//							 String HWKUNITDUTY    =  getRealLengthStr(rset.getString("HWKUNITDUTY"),8 ); //單位稅額(UnitDuty)	Character (8)	8
//							 String HWKODECLNO     =  getRealLengthStr(rset.getString("HWKODECLNO"), 14); //原進倉報單號碼 (ODeclNo)	Character (14)	14
//							 String HWKOITEMNO     =  getRealLengthStr(rset.getString("HWKOITEMNO"), 4); //原進倉報單項次 (OItemNo)	Numeric (4)	4
//							 //String HWKCCCCODE     =  getRealLengthStr(rset.getString("HWKCCCCODE"),11 ); //稅則號列(CccCode)	Character (11)	11
//							 //String HWKCOMDTAXRATE =  getRealLengthStr(rset.getString("HWKCOMDTAXRATE"), 16); //貨物稅率(ComdTaxRate)	Character (9)	9
//							 //String HWKD8DATE      =  getRealLengthStr(rset.getString("HWKD8DATE"), 8); //D8原進倉日期(D8date)	Character (8)	8	
//							 String HWKDESCRIP390  =  getRealLengthStr(rset.getString("HWKDESCRIP390"), 390); //390碼貨名 (Descrip)	Character (390)	390
//							 //String HWKSTATMODE    =  getRealLengthStr(rset.getString("HWKSTATMODE"),2 ); //統計方式	Character (2)	2
//							 //String HWKPRODCOUNTRY =  getRealLengthStr(rset.getString("HWKPRODCOUNTRY"),2 ); //生產國別(產地)	Character (2)	2
//							 String HWKSPACE  =  getRealLengthStr("", 4); //因原始規格長度為626，故補入空白。
//								
////							 valueT2=T2+DECL_NO_T2+HWKITEMNO+HWKPRDTNO+HWKDESCRIP+HWKBRAND+HWKMODEL+HWKSPEC+HWKNWGHT+HWKQTY+HWKUNIT
////								         +HWKODECLNO+HWKOITEMNO+HWKCCCCODE+HWKVALUEAMT+HWKDUTYRATE+HWKCOMDTAXRATE+HWKUPRICE+HWKCUR
////								         +HWKD8DATE+HWKDESCRIP390+HWKSTATMODE+HWKPRODCOUNTRY+"\r\n";
//							
//							 //valueT2=T2+DECL_NO_T2+HWKITEMNO+HWKPRDTNO+HWKDESCRIP390+HWKBRAND+HWKMODEL+HWKSPEC+HWKNWGHT+HWKQTY+HWKUNIT
//					         //		+HWKODECLNO+HWKOITEMNO+HWKCCCCODE+HWKVALUEAMT+HWKDUTYRATE+HWKCOMDTAXRATE+HWKUPRICE+HWKCUR
//					         //		+HWKD8DATE+HWKSTATMODE+HWKPRODCOUNTRY+"\r\n";
//							 
//							 valueT2=HWKITEMNO+HWKPRDTNO+HWKDESCRIP+HWKBRAND+HWKMODEL+HWKSPEC+HWKNWGHT+HWKQTY+HWKUNIT
//									 +HWKUPRICE+HWKCUR+HWKVALUEAMT+HWKVALUEQTY+HWKDUTYRATE+HWKUNITDUTY+HWKODECLNO
//									 +HWKOITEMNO+HWKDESCRIP390+HWKSPACE;
//							 t2ValueList.add(valueT2);
//							 System.out.println(valueT2);
//							  t2Flag=true;
//						 }
//							
//						 if (rset != null) {
//							 try {
//								 rset.close();
//							 } catch (SQLException e) {
//									logger.error("error", e);
//							 }
//						 }
//							
//						 if (stmt != null) {
//							 try {
//								 stmt.close();
//							 } catch (SQLException e) {
//									logger.error("error", e);
//							 }
//						 }
//////////////////////////////////////////////////T2產檔區 end/////////////////////////////////////////////
//						 
//////////////////////////////////////////////T3產檔區 start////////////////////////////////////////////						 						 
//						 if(t2Flag){
//							 stmt = conn.prepareStatement(SQLT3);
//							 stmt.setString(1, DECL_NO);
//							 stmt.setString(2, BOND_NO);										 
//							 rset = stmt.executeQuery();
//								
//							 while (rset.next()) {										 
//								 String valueT3="";
//								 //String T4=new String("T4".getBytes(CHARSET), CHARSET);;// new String("T1".getBytes("Big5"), "Big5");	
//								 //String DECLNO    =getRealLengthStr(rset.getString("DECLNO"    ),14);//   報單號碼 (DeclNo)	Character (14)	14         
//								 String CONTRNO   =getRealLengthStr(rset.getString("CONTRNO"   ),12);//  貨櫃號碼 (ContrNo)	Character (12)	12        
//								 String CONTRTYPE =getRealLengthStr(rset.getString("CONTRTYPE" ),4);//   貨櫃種類 (ContrType)	Character (4)	4        
//								 String TRANSMODE =getRealLengthStr(rset.getString("TRANSMODE" ),1);//  貨櫃裝運方式 (TransMode)	Character (1)	1           								   
//								 valueT3=CONTRNO+CONTRTYPE+TRANSMODE+"\r\n";
//								 System.out.println(valueT3);
//								 t3ValueList.add(valueT3);
//							 }
//							 
//							 if(null != t1ValueList && null != t2ValueList){
//								 
//								 for(int t1Cont=0; t1Cont < t1ValueList.size(); ++t1Cont){
//									 for(int t2Cont=0; t2Cont < t2ValueList.size(); ++t2Cont){
//										 if(null != t3ValueList && !t3ValueList.isEmpty()){
//											 for(int t3Cont=0; t3Cont < t3ValueList.size(); ++t3Cont){
//												 bs.write(t1ValueList.get(t1Cont).getBytes(CHARSET));
//												 bs.write(t2ValueList.get(t2Cont).getBytes(CHARSET));
//												 bs.write(t3ValueList.get(t3Cont).getBytes(CHARSET));
//											 }
//										 }else{
//											 bs.write(t1ValueList.get(t1Cont).getBytes(CHARSET));
//											 bs.write(t2ValueList.get(t2Cont).getBytes(CHARSET));
//											 bs.write("\r\n".getBytes(CHARSET));
//										 }
//									 }
//								 }	
//							 }	
//								
//							 if (rset != null) {
//								 try {
//									 rset.close();
//								 } catch (SQLException e) {
//										logger.error("error", e);
//								 }
//							 }
//								
//							 if (stmt != null) {
//								 try {
//									 stmt.close();
//								 } catch (SQLException e) {
//										logger.error("error", e);
//								 }
//							 }
//						 }
//						 
//						 if(t2Flag && t1Flag){
//								PreparedStatement stmt3= null;
//								try {			
//									stmt3=conn.prepareStatement(UPDATESENDLOG);
//									stmt3.setString(1, fileName);
//									stmt3.setString(2, DECL_NO);
//									stmt3.setString(3, BOND_NO);	
//									stmt3.setString(4, MSG_TYPE);	
//									stmt3.setString(5, AS_TYPE);	
//									int sqlUpdateCnt = stmt3.executeUpdate();
//									logger.info("UPDATESENDLOG Count : " + sqlUpdateCnt);
//								} catch (Exception e1) {
//									logger.error("error",e1);
//									continue;
//								}finally{
//									if (stmt3 != null) {
//										try {
//											stmt3.close();
//										} catch (SQLException e) {
//											logger.error("error", e);
//										}
//									}
//								}
//							  }else{
//								  if(!t1Flag) {
//									  logger.info("BONDNO : " + BOND_NO + ", DECLNO : " + DECL_NO + ",查無報單主檔資料。");
//								  } else if (!t2Flag){
//									  logger.info("BONDNO : " + BOND_NO + ", DECLNO : " + DECL_NO + ",報單沒有明細資料。");
//								  } else {
//									  logger.info("BONDNO : " + BOND_NO + ", DECLNO : " + DECL_NO + ",報單資料異常。");
//								  }
//								  continue;
//							  }
//						 
//////////////////////////////////////////////T3產檔區 end////////////////////////////////////////////						 
//					 } 					  
//						
//				  }		
//				 
//				  
//				  
//				  bs.flush();
//				  fos.flush();
//				  bs.close();
//				  fos.close();
//				logger.info( fileTmp.getAbsolutePath() + " Rename To " + file.getAbsolutePath() );
//				System.out.println( "renameTo = " + fileTmp.renameTo( file ) );
//
//				// ////////////////////////產出FLG檔 BEGIN
//				// ////////////////////////////////////////////
//				File flgFileTmp = new File(FILE_PATHS, fileName + ".flg");
//				if (file.exists() && !flgFileTmp.exists()) {// 20151216 aaron
//															// pan file.exists()
//															// &&
//					boolean isCreateNewFile = flgFileTmp.createNewFile();
//					if (!isCreateNewFile) {
//						logger.info("IsCreateNewFile : " + isCreateNewFile);
//					} else {
//						logger.info("IsCreateNewFile : " + isCreateNewFile
//								+ " OK ! ");
//					}
//				}
//				// ////////////////////////產出FLG檔 END
//				// //////////////////////////////////////////////
//
//			}
//			 
//   
//		} catch (Exception e) {//SQLException e
//			// TODO Auto-generated catch block
//			logger.error("error", e);
//			 
//		} finally{
//			 if(bs!=null){
//				  try {
//					bs.close();
//				} catch (IOException e) {
//					logger.error("error", e);
//				}
//			  }
//			  if(fos!=null){
//				  try {
//					fos.flush();
//				} catch (IOException e) {
//					logger.error("error", e);
//				}  
//			  }
//			
//			if (rset != null) {
//				try {
//					rset.close();
//				} catch (SQLException e) {
//					logger.error("error", e);
//				}
//			}
//			
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					logger.error("error", e);
//				}
//			}
//			 
//			
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					logger.error("error", e);
//				}
//			}
//			
//			DbFactory.close();
//		}
	}

}
