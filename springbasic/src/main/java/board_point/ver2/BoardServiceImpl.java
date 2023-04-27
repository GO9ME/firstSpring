package board_point.ver2;

import customer.ver2.CustomerDAO;
import customer.ver2.CustomerDTO;

public class BoardServiceImpl implements BoardService {
	CustomerDAO dao;
	AbstractPoint ap;

	public BoardServiceImpl(CustomerDAO dao, AbstractPoint ap) {
		this.dao = dao;
		this.ap = ap;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		CustomerDTO dto = dao.getUser(board.getId());
		System.out.println(dto);
		int point = ap.savePoint(dto);
		System.out.println(dto.getName() + "의 포인트는 : " + point);
	}

}
