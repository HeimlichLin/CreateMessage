package idv.heimlich.Create.domain.controller;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Function;

import idv.heimlich.Create.domain.dto.PClmsL1MainDTO;
import idv.heimlich.Create.domain.service.PclmsL1Service;
import idv.heimlich.Create.domain.service.impl.PclmsL1ServiceImpl;
import idv.heimlich.Create.domain.type.L1Type;

/**
 * L1訊息產生控制器
 */
public class PclmsL1Controller {

	/**
	 * 訊息處理
	 */
	private final PclmsL1Service pclmsL1Service = PclmsL1ServiceImpl
			.getPclmsL1Service();

	private final PClmsL1MainDTO dto = new PClmsL1MainDTO();

	public PclmsL1Controller(String[] args,
			Function<String[], EnumSet<L1Type>> operator) {
		this.dto.setEnumSet(operator.apply(args));
	}

	public static void main(String[] args) {
		final PclmsL1Controller controller = new PclmsL1Controller(args,
				PclmsL1Controller::getType);
		controller.doProcess();
	}

	/**
	 * 取得所有屬性
	 * 
	 * @param args
	 * @return
	 */
	public static EnumSet<L1Type> getType(String[] args) {

		if (args.length == 0) {//
			return EnumSet.allOf(L1Type.class);
		} else {
			final EnumSet<L1Type> enumSet = EnumSet.noneOf(L1Type.class);
			final List<String> types = Arrays.asList(args);
			for (final String type : types) {
				final L1Type valueOf = L1Type.valueOf(type);
				enumSet.add(valueOf);
			}
			return enumSet;
		}
	}

	public void doProcess() {
		this.pclmsL1Service.process(this.dto);
	}

}
