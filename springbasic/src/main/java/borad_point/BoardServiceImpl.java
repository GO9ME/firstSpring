package borad_point;

import customer.CustomerDAO;
import customer.CustomerDTO;
import customer.MyBatisCustomerDAO;

public class BoardServiceImpl implements BoardService {
	// �ı⸦ ���� ȸ���� ��ȸ�ϱ� ���ؼ� CustomerDAO�� �ʿ�
	CustomerDAO dao = new MyBatisCustomerDAO();
	AbstractPoint ap = new OtherPointImpl();

	@Override
	public void insertBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		CustomerDTO dto  = dao.getUser(board.getId());
		System.out.println(dto);
		int point = ap.savePoint(dto);
		System.out.println(dto.getName()+"�� ����Ʈ�� : " + point);
	}

}
