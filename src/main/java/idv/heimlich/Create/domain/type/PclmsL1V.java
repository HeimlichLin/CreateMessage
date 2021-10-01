package idv.heimlich.Create.domain.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import idv.heimlich.Create.common.dao.RowMap2PoConverter;
import idv.heimlich.Create.common.db.IDBSession;
import idv.heimlich.Create.common.db.utils.PropertyUtils;
import idv.heimlich.Create.domain.code.Charset;
import idv.heimlich.Create.domain.dto.PclmsL1VDTO;
import idv.heimlich.Create.domain.dto.PlcmL1DTO;
import idv.heimlich.Create.domain.dto.PlcmL1T1DTO;
import idv.heimlich.Create.domain.dto.PlcmL1T2DTO;
import idv.heimlich.Create.domain.dto.PlcmL1T3DTO;
import idv.heimlich.Create.domain.dto.PlcmL1T4DTO;

public class PclmsL1V implements PclmsL1Execute {

	// == [static variables] Block Start
	private static final String NEW_LINE = "\n";
	private final Charset charset = Charset.UTF8;
	private static final String SQL_CLMS_L1_L1_V_SQL = "sql/clmsL1/L1.v.sql";
	private static final String SQL_CLMS_L1_L1_T1_V_SQL = "sql/clmsL1/L1.t1.v.sql";
	private static final String SQL_CLMS_L1_L1_T2_V_SQL = "sql/clmsL1/L1.t2.v.sql";
	private static final String SQL_CLMS_L1_L1_T3_V_SQL = "sql/clmsL1/L1.t3.v.sql";
	private static final String SQL_CLMS_L1_L1_T4_V_SQL = "sql/clmsL1/L1.t4.v.sql";

//	protected static String M_ORIDIR = ApContext.getContext().getSetting("m_oriDir_EnqL");

//	protected static String M_DOCNAME = ApContext.getContext().getSetting("m_docName_EnqL1");

//	protected static String FILE_PATHS = M_ORIDIR;

//	protected final static Logger LOGGER = MyLoggerFactory.getLogger(Mylogs.clprocL1);

	final static RowMap2PoConverter<PlcmL1DTO> PLCML1DTO_CONVERTER = var1 -> {
		final Map<?, ?> map = var1.getMap();
		final PlcmL1DTO dto = new PlcmL1DTO();
		PropertyUtils.copy(map, dto);
		return dto;
	};
	final static RowMap2PoConverter<PlcmL1T1DTO> PLCMT1DTO_CONVERTER = var1 -> {
		final Map<?, ?> map = var1.getMap();
		final PlcmL1T1DTO dto = new PlcmL1T1DTO();
		PropertyUtils.copy(map, dto);
		return dto;
	};
	final static RowMap2PoConverter<PlcmL1T2DTO> PLCMT2DTO_CONVERTER = var1 -> {
		final Map<?, ?> map = var1.getMap();
		final PlcmL1T2DTO dto = new PlcmL1T2DTO();
		PropertyUtils.copy(map, dto);
		return dto;
	};
	final static RowMap2PoConverter<PlcmL1T3DTO> PLCMT3DTO_CONVERTER = var1 -> {
		final Map<?, ?> map = var1.getMap();
		final PlcmL1T3DTO dto = new PlcmL1T3DTO();
		PropertyUtils.copy(map, dto);
		return dto;
	};
	final static RowMap2PoConverter<PlcmL1T4DTO> PLCMT4DTO_CONVERTER = var1 -> {
		final Map<?, ?> map = var1.getMap();
		final PlcmL1T4DTO dto = new PlcmL1T4DTO();
		PropertyUtils.copy(map, dto);
		return dto;
	};

	/**
	 * @Description 產檔
	 * @author Aaron Pan 2015/10/22
	 */
	@Override
	public void process() {
//		final DoXdaoSession doXdaoSession = XdaoSessionManager.getDoXdaoSession();
//		try {
//			doXdaoSession.beginTransaction();
//			final List<PlcmL1DTO> l1DTOs = this.queryL1(doXdaoSession);
//			final Map<String, List<PlcmL1DTO>> l1Map = this.classifiy(l1DTOs);
//			LOGGER.info("class size:" + l1Map.size());
//			for (final Map.Entry<String, List<PlcmL1DTO>> entry : l1Map.entrySet()) {
//				LOGGER.info("execute bond:" + entry.getKey());
//				this.makeFiles(doXdaoSession, entry.getKey(), entry.getValue());
//				doXdaoSession.commit();
//			}
//		} catch (final Exception e) {
//			LOGGER.error("error ", e);
//		}

	}

	public List<PlcmL1DTO> queryL1(IDBSession doXdaoSession) {
//		return doXdaoSession.getSqlSelect().select(PLCML1DTO_CONVERTER, new SqlBuider(PclmsL1V.class, SQL_CLMS_L1_L1_V_SQL));
		return null;
	}

	public List<PlcmL1T1DTO> queryT1(IDBSession doXdaoSession,
			PlcmL1DTO plcmL1DTO) {
//		final Map<String, String> map = new HashMap<String, String>();
//		map.put("DECLNO1", plcmL1DTO.getDECL_NO());
//		map.put("MSGTYPE1", plcmL1DTO.getRLS_TYPE_1());
//		map.put("DECLNO2", plcmL1DTO.getDECL_NO());
//		map.put("MSGTYPE2", plcmL1DTO.getRLS_TYPE_2());
//		map.put("DECLNO3", plcmL1DTO.getDECL_NO());
//		map.put("MSGTYPE3", plcmL1DTO.getXML_RLS_TYPE());
//		map.put("BONDNO", plcmL1DTO.getBOND_NO());
//		map.put("DECLNO", plcmL1DTO.getDECL_NO());
//		map.put("MSGTYPE", plcmL1DTO.getMSG_TYPE());
//		map.put("BOXNO", plcmL1DTO.getBOX_NO());
//		map.put("ASTYPE", plcmL1DTO.getAS_TYPE());
//
//		final List<PlcmL1T1DTO> plcmL1T1DTOs = doXdaoSession.getSqlSelect().select(PLCMT1DTO_CONVERTER, new SqlBuider(PclmsL1V.class, SQL_CLMS_L1_L1_T1_V_SQL, map));
//		if (CollectionUtil.isEmpty(plcmL1T1DTOs)) {
//			for (final PlcmL1T1DTO l1t1dto : plcmL1T1DTOs) {
//				l1t1dto.merger(plcmL1DTO);
//			}
//		}
//		return plcmL1T1DTOs;
		return null;
	}

	public List<PlcmL1T2DTO> queryT2(IDBSession doXdaoSession,
			PlcmL1DTO plcmL1DTO) {
//		final Map<String, String> map = new HashMap<String, String>();
//		map.put("DECLNO", plcmL1DTO.getDECL_NO());
//		map.put("BONDNO", plcmL1DTO.getBOND_NO());
//		map.put("MSGTYPE", plcmL1DTO.getMSG_TYPE());
//		final SqlBuider sqlBuider = new SqlBuider(PclmsL1V.class, SQL_CLMS_L1_L1_T2_V_SQL, map);
//		final List<PlcmL1T2DTO> plcmL1T2DTOs = doXdaoSession.getSqlSelect().select(PLCMT2DTO_CONVERTER, sqlBuider);
//		return plcmL1T2DTOs;
		return null;
	}

	public List<PlcmL1T3DTO> queryT3(IDBSession doXdaoSession, String declno,
			String bondno) {
//		final Map<String, String> map = new HashMap<String, String>();
//		map.put("DECLNO", declno);
//		map.put("BONDNO", bondno);
//		final SqlBuider sqlBuider = new SqlBuider(PclmsL1V.class, SQL_CLMS_L1_L1_T3_V_SQL, map);
//		final List<PlcmL1T3DTO> plcmL1T2DTOs = doXdaoSession.getSqlSelect().select(PLCMT3DTO_CONVERTER, sqlBuider);
//		return plcmL1T2DTOs;
		return null;
	}

	public List<PlcmL1T4DTO> queryT4(IDBSession doXdaoSession, String declno) {
//		final Map<String, String> map = new HashMap<String, String>();
//		map.put("DECLNO", declno);
//		final SqlBuider sqlBuider = new SqlBuider(PclmsL1V.class, SQL_CLMS_L1_L1_T4_V_SQL, map);
//		final List<PlcmL1T4DTO> plcmL1T4DTOs = doXdaoSession.getSqlSelect().select(PLCMT4DTO_CONVERTER, sqlBuider);
//		return plcmL1T4DTOs;
		return null;
	}
	// == [Method] Block Stop
	// ================================================
	// == [Inner Class] Block Start
	// == [Inner Class] Block Stop
	// ================================================

	/**
	 * 更新傳送紀錄
	 * 
	 * @param doXdaoSession
	 * @param plcmL1DTO
	 * @param file
	 * @return
	 */
	public int updateSendLog(IDBSession doXdaoSession, PlcmL1DTO plcmL1DTO,
			final String file) {

//		final StringBuffer sql = new StringBuffer();
//		sql.append(" UPDATE SENDLOG  "); //
//		sql.append(" SET SENDTIME = SYSDATE, SENDFLAG = 'Y', CONTROLNO = ? "); //
//		sql.append(" WHERE DECLNO = ?                                      "); //
//		sql.append(" AND BONDNO = ?                                        "); //
//		sql.append(" AND MSGTYPE = ?                                       "); //
//		sql.append(" AND ASTYPE = ?                                        "); //
//		sql.append(" AND SENDFLAG = 'N'                                    "); // ;
//
//		final String[] value = { //
//				file, //
//				plcmL1DTO.getDECL_NO(), plcmL1DTO.getBOND_NO(), ///
//				plcmL1DTO.getMSG_TYPE(), //
//				plcmL1DTO.getAS_TYPE() };//
//		try {
//			return doXdaoSession.executeUpdate(sql.toString(), value);
//		} catch (final XdaoException e) {
//			throw new ApBusinessException(String.format("更新異常SendLog DECLNO:%s  BONDNO:%s", plcmL1DTO.getDECL_NO(), plcmL1DTO.getBOND_NO()), e);
//		}
		return 0;
	}

	/**
	 * 建立檔案每個監管編號各自檔案，有明細與主檔存在時才會寫入檔案
	 * 
	 * @param doXdaoSession
	 * @param entry
	 */
	private void makeFiles(IDBSession doXdaoSession, String bondno,
			List<PlcmL1DTO> plcmL1DTOs) {

//		final String fileName = this.getFileName(bondno);
//		final File file = new File(FILE_PATHS, fileName);
//		final File tmpFile = new File(FILE_PATHS, fileName + ".tmp");
//		final PclmsL1VDTO l1DTO = new PclmsL1VDTO(tmpFile, file);
//		try {
//			for (final PlcmL1DTO plcmL1DTO : plcmL1DTOs) {
//				this.executeL1(doXdaoSession, l1DTO, plcmL1DTO);
//			}
//			if (l1DTO.isNeedCreateNewFile()) {
//				final boolean renameTo = l1DTO.getTmpFile().renameTo(file);
//				LOGGER.info(String.format(" tmp[%s] > file[%s] is [%b]",
//						l1DTO.getTmpFile(), l1DTO.getFile(), renameTo));
//				new File(FILE_PATHS, fileName + ".flg").createNewFile();
//			}
//
//		} catch (final Exception e) {
//			doXdaoSession.rollback();
//			LOGGER.info("執行錯誤", e);
//		} finally {
//			l1DTO.getTmpFile().deleteOnExit();
//		}

	}

	private void executeL1(IDBSession doXdaoSession, final PclmsL1VDTO l1DTO,
			final PlcmL1DTO plcmL1DTO) {
//		l1DTO.setPlcmL1DTO(plcmL1DTO);
//
//		final List<PlcmL1T1DTO> plcmL1T1DTOs = this.queryT1(doXdaoSession,
//				plcmL1DTO);
//		l1DTO.setT1list(plcmL1T1DTOs);
//		if (CollectionUtils.isEmpty(plcmL1T1DTOs)) {
//			LOGGER.warn(//
//					String.format("not data Decalr[declno:%s,bondno:%s]", //
//							plcmL1DTO.getDECL_NO(), //
//							plcmL1DTO.getBOND_NO()));
//		} else {
//			final List<PlcmL1T2DTO> plcmL1T2DTOs = this.queryT2(doXdaoSession,
//					plcmL1DTO);
//			l1DTO.setT2list(plcmL1T2DTOs);
//			LOGGER.info(String.format("DECLDETAIL[declno:%s,bondno:%s] size:%d",
//					plcmL1DTO.getDECL_NO(), plcmL1DTO.getBOND_NO(),
//					plcmL1T2DTOs.size()));
//			if (CollectionUtils.isEmpty(plcmL1T2DTOs)) {
//				LOGGER.warn(String.format(
//						"not data DECLDETAIL[declno:%s,bondno:%s]", //
//						plcmL1DTO.getDECL_NO(), ///
//						plcmL1DTO.getBOND_NO()));//
//			} else {
//				l1DTO.setNeedCreateNewFile(true);
//				final List<String> lines = this.writeToLines(doXdaoSession,
//						l1DTO);
//				final FileWrite fileWrite = FileWrite
//						.getFileWrite(this.charset);
//				fileWrite.writeIsApppend(l1DTO.getTmpFile(), lines);// 寫檔案至暫存
//			}
//		}
	}

	/**
	 * 產出待寫入檔案
	 * 
	 * @param doXdaoSession
	 * @param l1vdto
	 * @return
	 */
	private List<String> writeToLines(IDBSession doXdaoSession,
			PclmsL1VDTO l1vdto) {//
//		final List<String> buffer = new ArrayList<String>();
//		final PlcmL1DTO plcmL1DTO = l1vdto.getPlcmL1DTO();
//		final PlcmL1T1DTO t1 = l1vdto.getT1list().get(0);
//		t1.merger(plcmL1DTO);
//		buffer.add(t1.toString() + NEW_LINE);
//
//		for (final PlcmL1T2DTO t2 : l1vdto.getT2list()) {
//			t2.merger(t1);
//			LOGGER.info(String.format("write t2[declno:%s item:%s]",
//					t2.getDECLNO(), t2.getHWKITEMNO()));
//			buffer.add(t2.toString() + NEW_LINE);
//		}
//		final List<PlcmL1T3DTO> plcmL1T3DTOs = this.queryT3(doXdaoSession,
//				plcmL1DTO.getDECL_NO(), plcmL1DTO.getBOND_NO());
//		for (final PlcmL1T3DTO plcmL1T3DTO : plcmL1T3DTOs) {
//			LOGGER.info(String.format(
//					"write t3[declno:%s item:%s VEHICLENO:%s]",
//					plcmL1T3DTO.getITEMNO(), plcmL1T3DTO.getVEHICLENO()));
//			buffer.add(plcmL1T3DTO.toString() + NEW_LINE);
//		}
//
//		final List<PlcmL1T4DTO> plcmL1T4DTOs = this.queryT4(doXdaoSession,
//				plcmL1DTO.getDECL_NO());
//
//		for (final PlcmL1T4DTO plcmL1T4DTO : plcmL1T4DTOs) {
//			LOGGER.info(
//					String.format("write t3[declno:%s declno:%s CONTRNO:%s]",
//							plcmL1T4DTO.getDECLNO(), plcmL1T4DTO.getCONTRNO()));
//			buffer.add(plcmL1T4DTO.toString() + NEW_LINE);
//		}
//
//		final String fileName = l1vdto.getFile().getName();
//		final int updateSendLog = this.updateSendLog(doXdaoSession, plcmL1DTO,
//				fileName);
//		LOGGER.info(String.format("update sendlog　declno:%s　 size:%d",
//				plcmL1DTO.getDECL_NO(), updateSendLog));
//
//		return buffer;
		return null;
	}

	/**
	 * 檔名
	 * 
	 * @param entry
	 * @return
	 */
	private String getFileName(String bondno) {
//		final SimpleDateFormat sdFormat = new SimpleDateFormat(
//				"yyyyMMddHHmmss");
//		final Date current = new Date();
//		final String dateStr = sdFormat.format(current);
//		final String fileName = M_DOCNAME + bondno + dateStr.substring(4);
//		return fileName;
		return null;
	}

	/**
	 * 根據監管編號分類
	 * 
	 * @param l1dtOs
	 * @return
	 */
	private Map<String, List<PlcmL1DTO>> classifiy(List<PlcmL1DTO> l1dtOs) {
		final Map<String, List<PlcmL1DTO>> map = new LinkedHashMap<String, List<PlcmL1DTO>>();
		for (final PlcmL1DTO plcmL1DTO : l1dtOs) {
			final String bondNo = plcmL1DTO.getBOND_NO();
			List<PlcmL1DTO> list = null;
			if (map.containsKey(bondNo)) {
				list = map.get(bondNo);

			} else {
				list = new ArrayList<PlcmL1DTO>();
			}
			list.add(plcmL1DTO);
			map.put(bondNo, list);

		}
		return Collections.unmodifiableMap(map);
	}
}
