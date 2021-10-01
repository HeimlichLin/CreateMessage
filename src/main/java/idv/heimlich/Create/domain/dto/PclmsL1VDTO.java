package idv.heimlich.Create.domain.dto;

import java.io.File;
import java.util.List;

public class PclmsL1VDTO {

	final File tmpFile;
	final File file;
	private PlcmL1DTO plcmL1DTO;
	private List<PlcmL1T1DTO> t1list;
	private List<PlcmL1T2DTO> t2list;
	boolean needCreateNewFile = false;// 其中一個報單有完整資料就需要建立該檔案

	public PclmsL1VDTO(File tmpFile, File file) {
		super();
		this.tmpFile = tmpFile;
		this.file = file;
	}

	public List<PlcmL1T1DTO> getT1list() {
		return this.t1list;
	}

	public void setT1list(List<PlcmL1T1DTO> t1list) {
		this.t1list = t1list;
	}

	public List<PlcmL1T2DTO> getT2list() {
		return this.t2list;
	}

	public void setT2list(List<PlcmL1T2DTO> t2list) {
		this.t2list = t2list;
	}

	public File getTmpFile() {
		return this.tmpFile;
	}

	public File getFile() {
		return this.file;
	}

	public boolean isNeedCreateNewFile() {
		return this.needCreateNewFile;
	}

	public void setNeedCreateNewFile(boolean needCreateNewFile) {
		this.needCreateNewFile = needCreateNewFile;
	}

	public PlcmL1DTO getPlcmL1DTO() {
		return this.plcmL1DTO;
	}

	public void setPlcmL1DTO(PlcmL1DTO plcmL1DTO) {
		this.plcmL1DTO = plcmL1DTO;
	}

}
