package lf.melo.com.errors;

public class NotFoundError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundError(String msg) {
		super(msg);
	}
}
