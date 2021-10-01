package idv.heimlich.Create.domain.type;

import idv.heimlich.Create.domain.PclmsL1;

public class PclmsL1U extends PclmsL1 implements PclmsL1Execute {
	private static final String SQL1 = " SELECT DISTINCT                                        "
			+ "        DECLAR.BONDNO   AS BOND_NO,                     "
			+ "        SENDLOG.DECLNO  AS DECL_NO,                     "
			+ "        SENDLOG.STRTYPE AS STR_TYPE,                    "
			+ "        SENDLOG.MSGFUN  AS MSG_FUN,                     "
			+ "        SENDLOG.MSGTYPE AS MSG_TYPE,                    "
			+ "        DECLAR.BOXNO    AS BOX_NO,                      "
			+ "        DECLAR.ASTYPE   AS AS_TYPE,                     "
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
			+ " WHERE   WAREHSE.RECV_FLAG = 'U'                        "
			+ "   AND  WAREHSE.BONDNO <> 'XXXXX'                       "
			+ "    AND WAREHSE.AUTHORITY IN ('B', 'D', 'W')            "
			+ "    AND SENDLOG.BONDNO = WAREHSE.BONDNO                 "
			+ "    AND SENDLOG.SENDFLAG = 'N'                          "
			+ "    AND SENDLOG.BONDNO = DECLAR.BONDNO                  "
			+ "    AND SENDLOG.DECLNO = DECLAR.DECLNO         		 "
			+ "    AND SENDLOG.MSGTYPE = DECLAR.MSGTYPE                "
			+ "    AND SENDLOG.STRTYPE = DECLAR.STRTYPE                "
			+ "    AND SENDLOG.ASTYPE = DECLAR.ASTYPE                  "
			+ "  ORDER BY DECLAR.BONDNO,SENDLOG.DECLNO, SENDLOG.MSGFUN ";

	private static final String SQLT1 = "SELECT DECLAR.BOXNO                                           AS HWKBOXNO,      "
			+ "       DECLAR.DECLTYPE                                        AS HWKDECLTYPE,   "
			+ "       TO_CHAR(DECLAR.IMPORTDATE,'YYYYMMDD')                  AS HWKIMPORTDATE, "
			+ "       TO_CHAR(DECLAR.DECLDATE,'YYYYMMDD')                    AS HWKDECLDATE,   "
			+ "       DECLAR.STGPLACE                                        AS HWKSTGPLACE,   "
			+ "       TO_CHAR(NVL(N.RLSTIME, NVL(A.RLSTIME, S.RLSTIME)), 'YYYYMMDDHH24MISS') AS HWKRLSTIME,     "
			+ "       LPAD(NVL(N.RLSPKG, NVL(a.RLSPKG, S.RLSPKG)), 8, '0') AS HWKRLSPKG,       "
			+ "       SUBSTR(NVL(N.EXTRACOND, NVL(A.EXTRACOND, S.EXTRACOND)), 1, 1) AS HWKEXTRACOND,  "
			+ "       NVL(NVL(N.PKGUNIT, NVL(A.PKGUNIT, S.PKGUNIT)), DECLAR.PKGUNIT) AS HWKPKGUNIT,    "
			+ "       SUBSTR(TO_CHAR(DECLAR.GWGT,'00000000000000.000000'),2) AS HWKGWGT,       "
			+ "       NVL(N.VESSELSIGN, NVL(A.VESSELSIGN, S.VESSELSIGN)) AS HWKVESSELSIGN, "
			+ "       NVL(N.VOYAGENO, NVL(A.VOYAGENO, S.VOYAGENO)) AS HWKVOYAGENO,   "
			+ "       DECLAR.OWNERBAN                                        AS HWKSHIPCODE,   "
			+ "       NVL(N.EXPORTER, NVL(A.EXPORTER, S.EXPORTER)) AS HWKEXPORTER,   "
			+ "       NVL(N.CLEARTYPE, NVL(A.CLEARTYPE, S.CLEARTYPE)) AS HWKCLEARTYPE,  "
			+ "       DECLAR.REFBILLNO                                       AS HWKREFBILLNO,  "
			+ "       DECLAR.INBONDNO                                        AS HWKINBONDNO,   "
			+ "       DECLAR.OUTBONDNO                                       AS HWKOUTBONDNO,  "
			+ "       DECLAR.MAWBNO                                          AS HWKMAWBNO,     "
			+ "       DECLAR.HAWBNO                                          AS HWKHAWBNO,     "
			+ "       LPAD(DECLAR.NOPKG,8,'0')                               AS HWKNOPKG,      "
			+ "       SUBSTR(DECLAR.MARK,0,8)                                AS HWKMARK,       "
			+ "       DECLAR.VRNO                                            AS HWKVRNO,       "
			+ "       DECLAR.SONO                                            AS HWKSONO        "
			+ "  FROM DECLAR,                                                                  "
			+ "      (SELECT *                                                                 "
			+ "          FROM (SELECT * FROM RELEASE                                           "
			+ "             WHERE DECLNO = ?                                                   "
			+ "              AND MSGTYPE = ? ORDER BY RLSTIME DESC)                            "
			+ "        WHERE ROWNUM = 1) A,                                                    "
			+ "      (SELECT *                                                                 "
			+ "          FROM (SELECT * FROM RELEASE                                           "
			+ "             WHERE DECLNO = ?                                                   "
			+ "              AND MSGTYPE = ? ORDER BY RLSTIME DESC)                            "
			+ "        WHERE ROWNUM = 1) S,                                                    "
			+ "       (SELECT *                                                                "
			+ "          FROM (SELECT * FROM RELEASE                                           "
			+ "             WHERE DECLNO = ?                                                   "
			+ "              AND MSGTYPE = ? ORDER BY RLSTIME DESC)                            "
			+ "        WHERE ROWNUM = 1) N                                                     "
			+ " WHERE DECLAR.DECLNO = N.DECLNO(+)                                              "
			+ "	   AND DECLAR.ASTYPE = N.ASTYPE(+)                                            "
			+ "	   AND DECLAR.DECLNO = A.DECLNO(+)                                            "
			+ "	   AND DECLAR.ASTYPE = A.ASTYPE(+)                                            "
			+ "	   AND DECLAR.DECLNO = S.DECLNO(+)                                            "
			+ "	   AND DECLAR.ASTYPE = S.ASTYPE(+)                                            "
			+ "	   AND DECLAR.BONDNO = ?                                                      "
			+ "	   AND DECLAR.DECLNO = ?                                                      "
			+ "	   AND DECLAR.MSGTYPE = ?                                                     "
			+ "	   AND DECLAR.BOXNO = ?                                         "
			+ "	   AND DECLAR.ASTYPE = ?                                                      "
			+ "     AND ROWNUM = 1                                                             ";
	private static final String SQLT2 = " SELECT LPAD(ITEMNO,4,'0')                                                AS HWKITEMNO,     "
			+ "        PRDTNO                                                            AS HWKPRDTNO,     "
			+ "        SUBSTRB(REPLACE(REPLACE(DESCRIP, CHR(13), ''), CHR(10), ''),0,70) AS HWKDESCRIP,    "
			+ "        BRAND                                                             AS HWKBRAND,      "
			+ "        MODEL                                                             AS HWKMODEL,      "
			+ "        SPEC                                                              AS HWKSPEC,       "
			+ "        SUBSTR(TO_CHAR(NWGHT,'0000000000.000000'),2)                      AS HWKNWGHT,      "
			+ "        SUBSTR(TO_CHAR(QTY,'00000000000000.000000'),2)                    AS HWKQTY,        "
			+ "        UNIT                                                              AS HWKUNIT,       "
			+ "        ODECLNO                                                           AS HWKODECLNO,    "
			+ "        LPAD(OITEMNO,4,'0')                                               AS HWKOITEMNO,    "
			+ "        CCCCODE                                                           AS HWKCCCCODE,    "
			+ "        LPAD(VALUEAMT,14,'0')                                             AS HWKVALUEAMT,   "
			+ "        SUBSTR(TO_CHAR(DUTYRATE,'0000000000.00000'),2)                    AS HWKDUTYRATE,   "
			+ "        SUBSTR(TO_CHAR(COMDTAXRATE,'0000000000.00000'),2)                 AS HWKCOMDTAXRATE,"
			+ "        SUBSTR(TO_CHAR(UPRICE,'000000000000.000000'),2)                   AS HWKUPRICE,     "
			+ "        NVL(CUR,'TWD')                                                    AS HWKCUR,        "
			+ "        D8DATE                                                            AS HWKD8DATE,     "
			+ "        REPLACE(REPLACE(DESCRIP, CHR(13), ''), CHR(10), '')               AS HWKDESCRIP390, "
			+ "        SUBSTR(STATMODE,0,2)                                              AS HWKSTATMODE,   "
			+ "        SUBSTR(PRODCOUNTRY,0,2)                                           AS HWKPRODCOUNTRY "
			+ "   FROM DECLDETAIL                                                                          "
			+ "  WHERE DECLNO  = ?                                                                         "
			+ "    AND BONDNO  = ?                                                                         "
			+ "    AND MSGTYPE = ?                                                                         ";
	private static final String SQLT3 = " SELECT DECLNO, ITEMNO, VEHICLENO"
			+ "   FROM VEHICLE                  "
			+ "  WHERE DECLNO = ?               "
			+ "    AND BONDNO = ?               ";

	private static final String SQLT4 = "SELECT DECLNO,    "
			+ "       CONTRNO,   " + "       CONTRTYPE, " + "       TRANSMODE  "
			+ "  FROM CONTAINER  " + " WHERE DECLNO =?  "
			+ "   AND BONDNO = ? ";

	private static final String UPDATESENDLOG = " UPDATE SENDLOG                                       "
			+ " SET SENDTIME = SYSDATE, SENDFLAG = 'Y', CONTROLNO = ? "
			+ " WHERE DECLNO = ?                                      "
			+ " AND BONDNO = ?                                        "
			+ " AND MSGTYPE = ?                                       "
			+ " AND ASTYPE = ?                                        "
			+ " AND SENDFLAG = 'N'                                    ";

	public static void main(String[] args) {
		final PclmsL1U pclms_L1_Y = new PclmsL1U();
		pclms_L1_Y.process();
	}

	/**
	 * @Description 產檔
	 * @author Aaron Pan 2015/10/22
	 */
	@Override
	public void process() {
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rset = null;
//		FileOutputStream fos = null;
//		BufferedOutputStream bs = null;
//		final SimpleDateFormat sdFormat = new SimpleDateFormat(
//				"yyyyMMddHHmmss");
//		final Date current = new Date();
//		final String dateStr = sdFormat.format(current);
//		try {
//			// Class.forName(DRIVER_NAEM).newInstance();
//			conn = DbFactory.open();
//			conn.setAutoCommit(false); // 2015/12/16 aaron pan
//			// ///////////////////////////////SQ1 來源區塊
//			// start////////////////////////////////////////////////////
//			stmt = conn.prepareStatement(SQL1);
//			rset = stmt.executeQuery();
//			HashMap<String, String> valueMap = new HashMap<String, String>();
//			List<Map<String, String>> list = new LinkedList<Map<String, String>>();
//			final Map<String, Object> keyMap = new HashMap<String, Object>();
//
//			while (rset.next()) {
//				final String BOND_NO = rset.getString("BOND_NO");
//				final String DECL_NO = rset.getString("DECL_NO");
//				final String STR_TYPE = rset.getString("STR_TYPE");
//				final String MSG_FUN = rset.getString("MSG_FUN");
//				final String MSG_TYPE = rset.getString("MSG_TYPE");
//				final String BOX_NO = rset.getString("BOX_NO");
//				final String AS_TYPE = rset.getString("AS_TYPE");
//				final String RLS_TYPE_1 = rset.getString("RLS_TYPE_1");
//				final String RLS_TYPE_2 = rset.getString("RLS_TYPE_2");
//				final String XML_RLS_TYPE = rset.getString("XML_RLS_TYPE");
//
//				if (keyMap.containsKey(BOND_NO)) {
//					valueMap = new HashMap<String, String>();
//					valueMap.put("BOND_NO", BOND_NO);
//					valueMap.put("DECL_NO", DECL_NO);
//					valueMap.put("STR_TYPE", STR_TYPE);
//					valueMap.put("MSG_FUN", MSG_FUN);
//					valueMap.put("MSG_TYPE", MSG_TYPE);
//					valueMap.put("BOX_NO", BOX_NO);
//					valueMap.put("AS_TYPE", AS_TYPE);
//					valueMap.put("RLS_TYPE_1", RLS_TYPE_1);
//					valueMap.put("RLS_TYPE_2", RLS_TYPE_2);
//					valueMap.put("XML_RLS_TYPE", XML_RLS_TYPE);
//					list.add(valueMap);
//					keyMap.put(BOND_NO, list);
//				} else {
//					list = new LinkedList<Map<String, String>>();
//					valueMap = new HashMap<String, String>();
//					valueMap.put("BOND_NO", BOND_NO);
//					valueMap.put("DECL_NO", DECL_NO);
//					valueMap.put("STR_TYPE", STR_TYPE);
//					valueMap.put("MSG_FUN", MSG_FUN);
//					valueMap.put("MSG_TYPE", MSG_TYPE);
//					valueMap.put("BOX_NO", BOX_NO);
//					valueMap.put("AS_TYPE", AS_TYPE);
//					valueMap.put("RLS_TYPE_1", RLS_TYPE_1);
//					valueMap.put("RLS_TYPE_2", RLS_TYPE_2);
//					valueMap.put("XML_RLS_TYPE", XML_RLS_TYPE);
//					list.add(valueMap);
//					keyMap.put(BOND_NO, list);
//				}
//
//			}
//			if (rset != null) {
//				try {
//					rset.close();
//				} catch (final SQLException e) {
//					logger.error("error", e);
//				}
//			}
//
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (final SQLException e) {
//					logger.error("error", e);
//				}
//			}
//			// /////////////////////////////////SQ1 來源區塊
//			// end////////////////////////////////////////////////////
//
//			// ////////////////////////////////檔案處理區塊////////////////////////////////////
//			for (final Map.Entry<String, Object> entry : keyMap.entrySet()) {
//
//				final List<Map<String, String>> mapList = (List<Map<String, String>>) keyMap
//						.get(entry.getKey());
//				final String fileName = M_DOCNAME + entry.getKey()
//						+ dateStr.substring(4);// 20151216
//				// aaron
//				// pan
//				// String controlNo = M_DOCNAME + entry.getKey() +
//				// dateStr.substring(4);//20151216 aaron pan
//				final File fileTmp = new File(FILE_PATHS, fileName + ".tmp");
//				final File file = new File(FILE_PATHS, fileName);
//				logger.info("OutPutFile = " + fileTmp.getAbsolutePath());
//
//				fos = null;
//				bs = null;
//				// /////////////////////////T1產檔區 end///////////////////////
//				for (final Map<String, String> map : mapList) {
//					final String BOND_NO = map.get("BOND_NO");
//					final String DECL_NO = map.get("DECL_NO");
//					final String STR_TYPE = map.get("STR_TYPE");
//					final String MSG_FUN = map.get("MSG_FUN");
//					final String MSG_TYPE = map.get("MSG_TYPE");
//					final String BOX_NO = map.get("BOX_NO");
//					final String AS_TYPE = map.get("AS_TYPE");
//					final String RLS_TYPE_1 = map.get("RLS_TYPE_1");
//					final String RLS_TYPE_2 = map.get("RLS_TYPE_2");
//					final String XML_RLS_TYPE = map.get("XML_RLS_TYPE");
//
//					// /////////////////////////////判斷T1與T2是否有值相關後序處理start(2015/12/16
//					// aaron pan)//////////////
//					final PreparedStatement chkT1Stmt = conn
//							.prepareStatement(SQLT1);
//
//					chkT1Stmt.setString(1, DECL_NO);
//					chkT1Stmt.setString(2, RLS_TYPE_1);
//					chkT1Stmt.setString(3, DECL_NO);
//					chkT1Stmt.setString(4, RLS_TYPE_2);
//					chkT1Stmt.setString(5, DECL_NO);
//					chkT1Stmt.setString(6, XML_RLS_TYPE);
//					chkT1Stmt.setString(7, BOND_NO);
//					chkT1Stmt.setString(8, DECL_NO);
//					chkT1Stmt.setString(9, MSG_TYPE);
//					chkT1Stmt.setString(10, BOX_NO);
//					chkT1Stmt.setString(11, AS_TYPE);
//					final ResultSet chkT1Rest = chkT1Stmt.executeQuery();
//					final boolean chkT1Flag = chkT1Rest.next();
//					if (null != chkT1Rest) {
//						try {
//							chkT1Rest.close();
//						} catch (final SQLException e) {
//							logger.error("error", e);
//						}
//					}
//					if (null != chkT1Stmt) {
//						try {
//							chkT1Stmt.close();
//						} catch (final SQLException e) {
//							logger.error("error", e);
//						}
//					}
//
//					final PreparedStatement chkT2Stmt = conn
//							.prepareStatement(SQLT2);
//					chkT2Stmt.setString(1, DECL_NO);
//					chkT2Stmt.setString(2, BOND_NO);
//					chkT2Stmt.setString(3, MSG_TYPE);
//					final ResultSet chkT2Rest = chkT2Stmt.executeQuery();
//					final boolean chkT2Flag = chkT2Rest.next();
//					if (chkT2Rest != null) {
//						try {
//							rset.close();
//						} catch (final SQLException e) {
//							logger.error("error", e);
//						}
//					}
//
//					if (chkT2Stmt != null) {
//						try {
//							stmt.close();
//						} catch (final SQLException e) {
//							logger.error("error", e);
//						}
//					}
//					if (chkT1Flag && chkT2Flag) {
//						PreparedStatement stmt3 = null;
//						try {
//							stmt3 = conn.prepareStatement(UPDATESENDLOG);
//							stmt3.setString(1, fileName);
//							stmt3.setString(2, DECL_NO);
//							stmt3.setString(3, BOND_NO);
//							stmt3.setString(4, MSG_TYPE);
//							stmt3.setString(5, AS_TYPE);
//							final int sqlUpdateCnt = stmt3.executeUpdate();
//							logger.info(
//									"UPDATESENDLOG Count : " + sqlUpdateCnt);
//						} catch (final Exception e1) {
//							logger.error("error", e1);
//							continue;
//						} finally {
//							if (stmt3 != null) {
//								try {
//									stmt3.close();
//								} catch (final SQLException e) {
//									logger.error("error", e);
//								}
//							}
//						}
//					} else {
//						if (!chkT1Flag) {
//							logger.info("BONDNO : " + BOND_NO + ", DECLNO : "
//									+ DECL_NO + ",查無報單主檔資料。");
//						} else if (!chkT2Flag) {
//							logger.info("BONDNO : " + BOND_NO + ", DECLNO : "
//									+ DECL_NO + ",報單沒有明細資料。");
//						} else {
//							logger.info("BONDNO : " + BOND_NO + ", DECLNO : "
//									+ DECL_NO + ",報單資料異常。");
//						}
//						continue;
//					}
//
//					// /////////////////////////////判斷T2是否有值相關後序處理
//					// end(2015/12/16 aaron pan)//////////////
//					boolean t1Flag = false;
//					boolean t2Flag = false;
//					stmt = conn.prepareStatement(SQLT1);
//					stmt.setString(1, DECL_NO);
//					stmt.setString(2, RLS_TYPE_1);
//					stmt.setString(3, DECL_NO);
//					stmt.setString(4, RLS_TYPE_2);
//					stmt.setString(5, DECL_NO);
//					stmt.setString(6, XML_RLS_TYPE);
//					stmt.setString(7, BOND_NO);
//					stmt.setString(8, DECL_NO);
//					stmt.setString(9, MSG_TYPE);
//					stmt.setString(10, BOX_NO);
//					stmt.setString(11, AS_TYPE);
//					rset = stmt.executeQuery();
//
//					while (rset.next()) {
//						if (fos == null) {
//							fos = new FileOutputStream(fileTmp);
//						}
//						if (bs == null) {
//							bs = new BufferedOutputStream(fos);
//						}
//						String valueT1 = "";
//						final String T1 = new String("T1".getBytes(CHARSET),
//								CHARSET);// new
//						// String("T1".getBytes("Big5"),
//						// "Big5");
//						// length:2
//						final String MSG_FUN_T1 = getRealLengthStr(MSG_FUN, 3); // 異動別3
//						// length:5
//						final String BOND_NO_T1 = getRealLengthStr(BOND_NO, 12); // 海關監管編號5
//						// ;
//						// length:17
//						final String STR_TYPE_T1 = getRealLengthStr(STR_TYPE,
//								1); // 進出倉別
//						// 1
//						// ;
//						// length:18
//						final String HWKBOXNO = getRealLengthStr(
//								rset.getString("HWKBOXNO"), 4); // 報關行箱號
//						// (BoxNo)
//						// Character
//						// (4)
//						// length:22
//						final String HWKDECLTYPE = getRealLengthStr(
//								rset.getString("HWKDECLTYPE"), 2); // 報單類別
//																												// (DeclType)
//																												// Character
//																												// (2)
//																												// length:24
//						final String DECL_NO_T1 = getRealLengthStr(DECL_NO, 14); // 報單號碼
//						// (DeclNo)
//						// Character
//						// (14)
//						// length:38
//						final String HWKIMPORTDATE = getRealLengthStr(
//								rset.getString("HWKIMPORTDATE"), 8); // 進口日期
//																													// (ImportDate)
//																													// Date
//																													// 8
//																													// length:46
//						final String HWKDECLDATE = getRealLengthStr(
//								rset.getString("HWKDECLDATE"), 8);// 申報日期
//						// (DeclDate)
//						// Date
//						// 8
//						// length:54
//						final String HWKSTGPLACE = getRealLengthStr(
//								rset.getString("HWKSTGPLACE"), 8);// 存放處所
//						// (StgPlace)
//						// Character
//						// (8)
//						// 8
//						// length:62
//						final String HWKRLSTIME = getRealLengthStr(
//								rset.getString("HWKRLSTIME"), 14);// 放行時間
//						// (RlsTime)
//						// Date
//						// 14
//						// length:76
//						final String HWKRLSPKG = getRealLengthStr(
//								rset.getString("HWKRLSPKG"), 8);// 放行件數
//						// (RlsPkg)
//						// Numeric
//						// (8)
//						// 8
//						// length:84
//						final String HWKEXTRACOND = getRealLengthStr(
//								rset.getString("HWKEXTRACOND"), 1);// 放行附帶條件
//						// (ExtraCond)
//						// Character
//						// (1)
//						// 1
//						// length:85
//						final String HWKPKGUNIT = getRealLengthStr(
//								rset.getString("HWKPKGUNIT"), 3);// 件數單位
//						// (PkgUnit)
//						// Character
//						// (3)
//						// 3
//						// length:88
//						final String HWKGWGT = getRealLengthStr(
//								rset.getString("HWKGWGT"), 21);// 總重量
//																										// (GWgt)
//																										// Numeric
//																										// (12,2)
//																										// 12
//																										// length:109
//						final String HWKVESSELSIGN = getRealLengthStr(
//								rset.getString("HWKVESSELSIGN"), 12);// 船舶呼號
//																													// (VesselSign)
//																													// Character
//																													// (6)
//																													// 6
//																													// length:121
//						final String HWKVOYAGENO = getRealLengthStr(
//								rset.getString("HWKVOYAGENO"), 12);// 航次
//																												// (VoyageNo)
//																												// Character
//																												// (12)
//																												// 12
//																												// length:133
//						final String HWKSHIPCODE = getRealLengthStr(
//								rset.getString("HWKSHIPCODE"), 14);// 船公司代碼
//																												// (ShipCode)
//																												// Character
//																												// (7)
//																												// 7
//																												// length:147
//						final String HWKEXPORTER = getRealLengthStr(
//								rset.getString("HWKEXPORTER"), 160);// 貨物輸出人
//						// (Exporter)
//						// Character
//						// (70)
//						// 70
//						// length:307
//						final String HWKCLEARTYPE = getRealLengthStr(
//								rset.getString("HWKCLEARTYPE"), 3);// 通關方式
//						// (ClearType)
//						// Character
//						// (2)
//						// 2
//						// length:310
//						final String HWKREFBILLNO = getRealLengthStr(
//								rset.getString("HWKREFBILLNO"), 14);// 參考單號
//						// (RefBillNo)
//						// Character
//						// (14)
//						// 14
//						// length:324
//						final String HWKINBONDNO = getRealLengthStr(
//								rset.getString("HWKINBONDNO"), 12);// 進倉保稅業者代碼
//																												// (InbondNo)
//																												// Character
//																												// (8)
//																												// 8
//																												// length:336
//						final String HWKOUTBONDNO = getRealLengthStr(
//								rset.getString("HWKOUTBONDNO"), 12);// 出倉保稅業者代碼
//						// (OutbondNo)
//						// Character
//						// (8)
//						// 8
//						// length:348
//						final String HWKMAWBNO = getRealLengthStr(
//								rset.getString("HWKMAWBNO"), 35);// 主提單號(MawbNo)
//																											// Character
//																											// (16)
//																											// 16
//																											// length:383
//						final String HWKHAWBNO = getRealLengthStr(
//								rset.getString("HWKHAWBNO"), 35);// 分提單號(HawbNo)
//																											// Character
//																											// (16)
//																											// 16
//																											// length:418
//						final String HWKNOPKG = getRealLengthStr(
//								rset.getString("HWKNOPKG"), 8);// 件數(NoPkg)
//						// Character
//						// (8)
//						// 8
//						// length:426
//						final String HWKMARK = getRealLengthStr(
//								rset.getString("HWKMARK"), 8);// HWKMARK
//						// Character
//						// (8)
//						// 8
//						// length:434
//						final String HWKVRNO = getRealLengthStr(
//								rset.getString("HWKVRNO"), 6);// 海掛(VRNO)
//						// Character
//						// (6)
//						// 6
//						// length:440
//						final String HWKSONO = getRealLengthStr(
//								rset.getString("HWKSONO"), 4);// 艙單或裝貨單號(Manifest或SONO)
//						// Character
//						// (4)
//						// 4
//						// length:444
//						valueT1 = T1 + MSG_FUN_T1 + BOND_NO_T1 + STR_TYPE_T1
//								+ HWKBOXNO + HWKDECLTYPE + DECL_NO_T1
//								+ HWKIMPORTDATE + HWKDECLDATE + HWKSTGPLACE
//								+ HWKRLSTIME + HWKRLSPKG + HWKEXTRACOND
//								+ HWKPKGUNIT + HWKGWGT + HWKVESSELSIGN
//								+ HWKVOYAGENO + HWKSHIPCODE + HWKEXPORTER
//								+ HWKCLEARTYPE + HWKREFBILLNO + HWKINBONDNO
//								+ HWKOUTBONDNO + HWKMAWBNO + HWKHAWBNO
//								+ HWKNOPKG
//								+ (BOND_NO.equals("CL998") ? HWKMARK
//										: getRealLengthStr("", 8))
//								+ HWKVRNO + HWKSONO + "\r\n";
//						bs.write(valueT1.getBytes(CHARSET));
//						bs.flush();
//						t1Flag = true;
//						logger.info("BONDNO : " + BOND_NO_T1 + ", DECL_NO : "
//								+ DECL_NO_T1 + " T1 OK");
//					}
//
//					if (rset != null) {
//						try {
//							rset.close();
//						} catch (final SQLException e) {
//							logger.error("error", e);
//						}
//					}
//
//					if (stmt != null) {
//						try {
//							stmt.close();
//						} catch (final SQLException e) {
//
//							logger.error("error", e);
//						}
//					}
//					// /////////////////////////T1產檔區 end///////////////////////
//
//					// ////////////////////////////////////////////T2產檔區
//					// start/////////////////////////////////////////////
//					if (t1Flag) {
//						stmt = conn.prepareStatement(SQLT2);
//						stmt.setString(1, DECL_NO);
//						stmt.setString(2, BOND_NO);
//						stmt.setString(3, MSG_TYPE);
//						rset = stmt.executeQuery();
//
//						while (rset.next()) {
//							t2Flag = true;
//							String valueT2 = "";
//							final String T2 = new String("T2".getBytes(CHARSET),
//									CHARSET);
//							;// new String("T1".getBytes("Big5"), "Big5");
//							final String DECL_NO_T2 = getRealLengthStr(DECL_NO,
//									14); // 報單號碼
//							// (DeclNo)
//							// Character
//							// (14)
//							// 14
//							final String HWKITEMNO = getRealLengthStr(
//									rset.getString("HWKITEMNO"), 4); // 報單項次(ItemNo)
//																												// Numeric
//																												// (4)
//																												// 4
//							final String HWKPRDTNO = getRealLengthStr(
//									rset.getString("HWKPRDTNO"), 60); // 料號
//							// (PrdtNo)
//							// Character
//							// (15)
//							// 15
//							// String HWKDESCRIP =
//							// getRealLengthStr(rset.getString("HWKDESCRIP"),
//							// 70); //貨名 (Descrip) Character (70) 70
//							final String HWKDESCRIP = (new String(
//									"".getBytes(CHARSET), CHARSET)); // 貨名
//																											// (Descrip)
//																											// Character
//																											// (70)
//																											// 70
//							final String HWKBRAND = getRealLengthStr(
//									rset.getString("HWKBRAND"), 50); // 廠牌
//							// (Brand)
//							// Character
//							// (15)15
//							final String HWKMODEL = getRealLengthStr(
//									rset.getString("HWKMODEL"), 80); // 型號
//							// (Model)
//							// Character
//							// (15)
//							// 15
//							final String HWKSPEC = getRealLengthStr(
//									rset.getString("HWKSPEC"), 350); // 規格
//							// (Spec)
//							// Character
//							// (40)
//							// 40
//							final String HWKNWGHT = getRealLengthStr(
//									rset.getString("HWKNWGHT"), 17); // 淨重
//							// (NWght)
//							// Numeric
//							// (12,2)
//							// 12
//							final String HWKQTY = getRealLengthStr(
//									rset.getString("HWKQTY"), 21); // 數量
//							// (Qty)
//							// Numeric
//							// (14,4)
//							// 14
//							final String HWKUNIT = getRealLengthStr(
//									rset.getString("HWKUNIT"), 3); // 單位
//																											// (Unit)
//																											// Character
//																											// (3)
//																											// 3
//							final String HWKODECLNO = getRealLengthStr(
//									rset.getString("HWKODECLNO"), 14); // 原進倉報單號碼
//							// (ODeclNo)
//							// Character
//							// (14)
//							// 14
//							final String HWKOITEMNO = getRealLengthStr(
//									rset.getString("HWKOITEMNO"), 4); // 原進倉報單項次
//							// (OItemNo)
//							// Numeric
//							// (4)
//							// 4
//							final String HWKCCCCODE = getRealLengthStr(
//									rset.getString("HWKCCCCODE"), 11); // 稅則號列(CccCode)
//							// Character
//							// (11)
//							// 11
//							final String HWKVALUEAMT = getRealLengthStr(
//									rset.getString("HWKVALUEAMT"), 14); // 完稅價格(ValueAmt)
//							// Character
//							// (12)
//							// 12
//							final String HWKDUTYRATE = getRealLengthStr(
//									rset.getString("HWKDUTYRATE"), 16); // 進口稅率(DutyRate)
//							// Character
//							// (9)
//							// 9
//							final String HWKCOMDTAXRATE = getRealLengthStr(
//									rset.getString("HWKCOMDTAXRATE"), 16); // 貨物稅率(ComdTaxRate)
//							// Character
//							// (9)
//							// 9
//							final String HWKUPRICE = getRealLengthStr(
//									rset.getString("HWKUPRICE"), 19); // 單價(UPrice)
//							// Character
//							// (18)
//							// 18
//							final String HWKCUR = getRealLengthStr(
//									rset.getString("HWKCUR"), 3); // 幣別(Cur)
//							// Character
//							// (3)
//							// 3
//							final String HWKD8DATE = getRealLengthStr(
//									rset.getString("HWKD8DATE"), 8); // D8原進倉日期(D8date)
//																												// Character
//																												// (8)
//																												// 8
//							final String HWKDESCRIP390 = getRealLengthStr(
//									rset.getString("HWKDESCRIP390"), 512); // 390碼貨名
//							// (Descrip)
//							// Character
//							// (390)
//							// 390
//							final String HWKSTATMODE = getRealLengthStr(
//									rset.getString("HWKSTATMODE"), 2); // 統計方式
//																													// Character
//																													// (2)
//																													// 2
//							final String HWKPRODCOUNTRY = getRealLengthStr(
//									rset.getString("HWKPRODCOUNTRY"), 2); // 生產國別(產地)
//							// Character
//							// (2)
//							// 2
//
//							valueT2 = T2 + DECL_NO_T2 + HWKITEMNO + HWKPRDTNO
//									+ HWKDESCRIP390 + HWKBRAND + HWKMODEL
//									+ HWKSPEC + HWKNWGHT + HWKQTY + HWKUNIT
//									+ HWKODECLNO + HWKOITEMNO + HWKCCCCODE
//									+ HWKVALUEAMT + HWKDUTYRATE + HWKCOMDTAXRATE
//									+ HWKUPRICE + HWKCUR + HWKD8DATE
//									+ HWKSTATMODE + HWKPRODCOUNTRY + "\r\n";
//
//							bs.write(valueT2.getBytes(CHARSET));
//							bs.flush();
//							logger.info("DECL_NO : " + DECL_NO_T2
//									+ ", ITEMNO : " + HWKITEMNO + " T2 OK");
//						}
//
//						if (rset != null) {
//							try {
//								rset.close();
//							} catch (final SQLException e) {
//								logger.error("error", e);
//							}
//						}
//
//						if (stmt != null) {
//							try {
//								stmt.close();
//							} catch (final SQLException e) {
//								logger.error("error", e);
//							}
//						}
//						// //////////////////////////////////////////////T2產檔區
//						// end/////////////////////////////////////////////
//						// ////////////////////////////////////////////T3產檔區
//						// start/////////////////////////////////////////////
//						if (t2Flag) {
//							stmt = conn.prepareStatement(SQLT3);
//							stmt.setString(1, DECL_NO);
//							stmt.setString(2, BOND_NO);
//							rset = stmt.executeQuery();
//							while (rset.next()) {
//								String valueT3 = "";
//								final String T3 = new String(
//										"T3".getBytes(CHARSET), CHARSET);
//								;// new String("T1".getBytes("Big5"), "Big5");
//								final String DECLNO = getRealLengthStr(
//										rset.getString("DECLNO"), 14);// 報單號碼
//								// (DeclNo)
//								// Character
//								// (14)
//								final String ITEMNO = getRealLengthStr(
//										rset.getString("ITEMNO"), 4);// Numeric
//								// (4)
//								// 4
//								final String VEHICLENO = getRealLengthStr(
//										rset.getString("VEHICLENO"), 18);// Character
//																													// (18)
//																													// 18
//								valueT3 = T3 + DECLNO + ITEMNO + VEHICLENO
//										+ "\r\n";
//								bs.write(valueT3.getBytes(CHARSET));
//								bs.flush();
//								logger.info(
//										"DECL_NO : " + DECLNO + ", ITEM_NO : "
//												+ ITEMNO + ", VEHICLE_NO : "
//												+ VEHICLENO + " T3 OK");
//							}
//
//							if (rset != null) {
//								try {
//									rset.close();
//								} catch (final SQLException e) {
//									logger.error("error", e);
//								}
//							}
//
//							if (stmt != null) {
//								try {
//									stmt.close();
//								} catch (final SQLException e) {
//									logger.error("error", e);
//								}
//							}
//						}
//						// ////////////////////////////////////////////T3產檔區
//						// end/////////////////////////////////////////////
//
//						// //////////////////////////////////////////T4產檔區
//						// start////////////////////////////////////////////
//						if (t1Flag) {
//							stmt = conn.prepareStatement(SQLT4);
//							stmt.setString(1, DECL_NO);
//							stmt.setString(2, BOND_NO);
//							rset = stmt.executeQuery();
//
//							while (rset.next()) {
//								String valueT4 = "";
//								final String T4 = new String(
//										"T4".getBytes(CHARSET), CHARSET);
//								;// new String("T1".getBytes("Big5"), "Big5");
//								final String DECLNO = getRealLengthStr(
//										rset.getString("DECLNO"), 14);// 報單號碼
//								// (DeclNo)
//								// Character
//								// (14)
//								// 14
//								final String CONTRNO = getRealLengthStr(
//										rset.getString("CONTRNO"), 17);// 貨櫃號碼
//																												// (ContrNo)
//																												// Character
//																												// (12)
//																												// 12
//								final String CONTRTYPE = getRealLengthStr(
//										rset.getString("CONTRTYPE"), 4);// 貨櫃種類
//								// (ContrType)
//								// Character
//								// (4)
//								// 4
//								final String TRANSMODE = getRealLengthStr(
//										rset.getString("TRANSMODE"), 1);// 貨櫃裝運方式
//								// (TransMode)
//								// Character
//								// (1)
//								// 1
//								valueT4 = T4 + DECLNO + CONTRNO + CONTRTYPE
//										+ TRANSMODE + "\r\n";
//								bs.write(valueT4.getBytes(CHARSET));
//								bs.flush();
//								logger.info("DECL_NO : " + DECLNO
//										+ ", CONTRNO : " + CONTRNO + " T4 OK");
//							}
//
//							if (rset != null) {
//								try {
//									rset.close();
//								} catch (final SQLException e) {
//									logger.error("error", e);
//								}
//							}
//
//							if (stmt != null) {
//								try {
//									stmt.close();
//								} catch (final SQLException e) {
//									logger.error("error", e);
//								}
//							}
//						}
//						// //////////////////////////////////////////T4產檔區
//						// end////////////////////////////////////////////
//					}
//
//				}
//
//				// /////////////////////////20151216 aaron pan
//				// start//////////////////////
//				if (bs != null) {
//					try {
//						bs.flush();
//					} catch (final IOException e) {
//						logger.error("error", e);
//					}
//				}
//				if (fos != null) {
//					try {
//						fos.flush();
//					} catch (final IOException e) {
//						logger.error("error", e);
//					}
//				}
//
//				if (bs != null) {
//					try {
//						bs.close();
//					} catch (final IOException e) {
//						logger.error("error", e);
//					}
//				}
//				if (fos != null) {
//					try {
//						fos.flush();
//					} catch (final IOException e) {
//						logger.error("error", e);
//					}
//				}
//				// /////////////////////////20151216 aaron pan
//				// end//////////////////////
//
//				logger.info(fileTmp.getAbsolutePath() + " Rename To "
//						+ file.getAbsolutePath());
//				logger.info("renameTo = " + fileTmp.renameTo(file));
//
//				// //////////////////////// 產出FLG檔 BEGIN
//				// ////////////////////////////////////////////
//				final File flgFileTmp = new File(FILE_PATHS, fileName + ".flg");
//				if (file.exists() && !flgFileTmp.exists()) {// 20151216 aaron
//															// pan file.exists()
//															// &&
//					final boolean isCreateNewFile = flgFileTmp.createNewFile();
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
//			conn.commit();// 2015/12/16 aaron pan
//
//		} catch (final Exception e) {// SQLException e
//			logger.error("error", e);
//			try {
//				conn.rollback();
//			} catch (final SQLException e1) {
//				logger.error("error", e1);
//			}
//		} finally {
//			if (bs != null) {
//				try {
//					bs.close();
//				} catch (final IOException e) {
//					logger.error("error", e);
//				}
//			}
//			if (fos != null) {
//				try {
//					fos.flush();
//				} catch (final IOException e) {
//					logger.error("error", e);
//				}
//			}
//
//			if (rset != null) {
//				try {
//					rset.close();
//				} catch (final SQLException e) {
//					logger.error("error", e);
//				}
//			}
//
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (final SQLException e) {
//					logger.error("error", e);
//				}
//			}
//
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (final SQLException e) {
//					logger.error("error", e);
//				}
//			}
//
//			DbFactory.close();
//		}
	}
}
