package idv.heimlich.Create.domain.type;

public enum L1Type {
	CL040(PClmsL1Cl040.class), //
	U(PclmsL1U.class), //
	V(PclmsL1V.class), //

	;

	private PclmsL1Execute pclmsL1Type;

	public PclmsL1Execute getType() {
		return this.pclmsL1Type;
	}

	L1Type(final Class<? extends PclmsL1Execute> type) {
		try {
			this.pclmsL1Type = type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public void exe() {
		this.getType().process();
	}

}
