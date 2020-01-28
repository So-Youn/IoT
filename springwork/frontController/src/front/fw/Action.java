package front.fw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
/*
 * ���� ������ Ŭ������ ����Ÿ��
 * RequestMappingŬ������ ������ Ŭ������ ã�Ƽ� ������ �� ������ Ÿ���� �־�� �ϱ� ������
 * ����Ÿ������ ����� Ŭ���� - ������ �����ϴ� ������ ������ Ŭ����
 */
	
		void run(HttpServletRequest request,
				HttpServletResponse response)
					throws ServletException,IOException;
	}
