package com.multi.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//BoardDAO의 메소드를 호출
//=> 컨트롤러에서 받은 데이터를 가공해서 DAO로 넘기거나 DAO에서 받은 데이터를 가공해서 컨트롤러로넘기는 작업
//=> 비즈니스 로직
//=> 트랜잭션 처리
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

	BoardDAO dao;

	public BoardServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int insert(BoardDTO board) {
		// TODO Auto-generated method stub

		return dao.insert(board);
	}

	@Override
	@Transactional
	public int insert(BoardDTO board, List<BoardFileDTO> boardfiledtolist) {
		// TODO Auto-generated method stub
		int result = 0;
		dao.insert(board);
		dao.insertFile(boardfiledtolist);
		return result;
	}

	@Override
	public List<BoardDTO> boardList() {
		// TODO Auto-generated method stub
		return dao.boardList();
	}

	@Override
	public BoardDTO getBoardInfo(String board_no) {
		// TODO Auto-generated method stub
		return dao.read(board_no);
	}

	@Override
	public int update(BoardDTO board) {
		// TODO Auto-generated method stub
		return dao.update(board);
	}

	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return dao.delete(board_no);
	}

	@Override
	public List<BoardDTO> search(String data) {
		// TODO Auto-generated method stub
		return dao.search(data);
	}

	@Override
	public List<BoardDTO> search(String tag, String data) {
		// TODO Auto-generated method stub
		return dao.search(tag, data);
	}

	@Override
	public List<BoardDTO> findByCategory(String category) {
		// TODO Auto-generated method stub
		return dao.findByCategory(category);
	}

	@Override
	public BoardFileDTO getFile(BoardFileDTO inputdata) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardFileDTO> getFileList(String boardno) {
		// TODO Auto-generated method stub
		return null;
	}

}
