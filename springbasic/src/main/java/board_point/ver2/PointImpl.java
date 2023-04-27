package board_point.ver2;

import customer.ver2.CustomerDTO;

public class PointImpl implements AbstractPoint {

	@Override
	public int savePoint(CustomerDTO user) {
		// TODO Auto-generated method stub
		int result = 0;
		String grade = user.getGrade();
		if ( grade.equals("VVIP")) {
			result = 2000;
		} else {
			result = 0;
		}
		return result;
	}

}
