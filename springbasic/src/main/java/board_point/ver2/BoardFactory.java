package board_point.ver2;

import customer.ver2.CustomerDAO;
import customer.ver2.MyBatisCustomerDAO;

public class BoardFactory {
	public AbstractPoint getAbstractPoint() {
		return new PointImpl();
	}
	public BoardService getBoardService() {
		CustomerDAO dao = new MyBatisCustomerDAO();
//		AbstractPoint ap = getAbstractPoint();
		return new BoardServiceImpl(dao,getAbstractPoint());
//		return new BoardServiceImpl(dao,ap);
	}
}
