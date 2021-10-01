package idv.heimlich.Create.domain;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public abstract class PclmsL1 {

	protected static final String CHARSET = "BIG5";

	public abstract void process() throws Exception;

	/**
	 * @Description 取得完整資料(正確資料長度)
	 * @author Aaron Pan 2015/10/22
	 * @param val
	 * @param len
	 *            資料長度
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getRealLengthStr(final String val, final int length)
			throws Exception {
		final byte[] ouput = new byte[length];
		Arrays.fill(ouput, (byte) 0x20);
		if (length < 1 || null == val || "".equals(val.trim())) {
			return new String(ouput, CHARSET);
		}
		final byte[] source = val.getBytes(CHARSET);
		System.arraycopy(source, 0, ouput, 0,
				(source.length > length) ? length : source.length);
		return new String(ouput, CHARSET);
	}

}
