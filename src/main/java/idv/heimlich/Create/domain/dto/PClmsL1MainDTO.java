package idv.heimlich.Create.domain.dto;

import java.util.EnumSet;

import idv.heimlich.Create.domain.type.L1Type;

public class PClmsL1MainDTO {

	private EnumSet<L1Type> enumSet = EnumSet.noneOf(L1Type.class);

	public EnumSet<L1Type> getEnumSet() {
		return this.enumSet;
	}

	public void setEnumSet(EnumSet<L1Type> enumSet) {
		this.enumSet = enumSet;
	}

}
