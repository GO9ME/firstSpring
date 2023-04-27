package board_point.ver2;

import customer.ver2.CustomerDAO;
import customer.ver2.MyBatisCustomerDAO;

public class BoardFactory {
	public AbstractPoint getAbstractPoint() {
		return new OtherPointImpl();
	}
	public BoardService getBoardService() {
		CustomerDAO dao = new MyBatisCustomerDAO();
		return new BoardServiceImpl(dao,getAbstractPoint());
	}
}
