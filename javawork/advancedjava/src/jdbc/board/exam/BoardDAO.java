package jdbc.board.exam;

import java.util.ArrayList;

public interface BoardDAO {
	int insert(BoardDTO board);
	int insert(String id, String title, String content);
	int update(String id, int boardNum);
	int delete(int boardNum);
	ArrayList<BoardDTO> select();
}