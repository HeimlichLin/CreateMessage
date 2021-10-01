package idv.heimlich.Create.domain.service.impl;

import java.util.EnumSet;

import idv.heimlich.Create.domain.dto.PClmsL1MainDTO;
import idv.heimlich.Create.domain.service.PclmsL1Service;
import idv.heimlich.Create.domain.type.L1Type;

//import com.tradevan.commons.logger.MyLoggerFactory;
//import com.tradevan.commons.logger.Mylogs;
//import com.tradevan.commons.logging.Logger;

/**
 * 訊息服務實作
 */
public class PclmsL1ServiceImpl implements PclmsL1Service {

	private static PclmsL1Service INSTANCT = new PclmsL1ServiceImpl();

//	protected final static Logger LOGGER = MyLoggerFactory.getLogger(Mylogs.clprocL1);

	public static PclmsL1Service getPclmsL1Service() {

		return INSTANCT;
	}

	// == [static Constructor] Block Stop
	// ================================================
	// == [Constructors] Block Start

	private PclmsL1ServiceImpl() {

	}

	@Override
	public void process(PClmsL1MainDTO pClmsL1MainDTO) {
		final EnumSet<L1Type> enumSet = pClmsL1MainDTO.getEnumSet();
//		LOGGER.info("L1 type size:" + enumSet.size());
//		LOGGER.info("L1 type :[" + enumSet + "]");
		for (final L1Type type : enumSet) {
//			LOGGER.info("Call type:" + type.name());
			type.exe();
		}

	}

}
