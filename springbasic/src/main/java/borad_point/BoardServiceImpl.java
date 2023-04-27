package borad_point;

import customer.CustomerDAO;
import customer.CustomerDTO;
import customer.MyBatisCustomerDAO;

public class BoardServiceImpl implements BoardService {
	// 후기를 남긴 회원을 조회하기 위해서 CustomerDAO가 필요
	CustomerDAO dao = new MyBatisCustomerDAO();
	AbstractPoint ap = new OtherPointImpl();

	@Override
	public void insertBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		CustomerDTO dto  = dao.getUser(board.getId());
		System.out.println(dto);
		int point = ap.savePoint(dto);
		System.out.println(dto.getName()+"의 포인트는 : " + point);
	}

}
