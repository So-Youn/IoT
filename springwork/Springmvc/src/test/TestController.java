package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//�⺻ web���� �ۼ��ϴ� �������� ������ ������ �ϴ� Ŭ����
//spring������ �̷��� ������ controller��� �θ���.
//- DispatcherServlet���� ȣ��Ǵ� Ŭ����
//- ���������� �ߴ� �� ó�� dao�� �޼ҵ带 ȣ��.
//- ������ ����(�������� ������)
public class TestController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("��Ʈ�ѷ� ��û �Ϸ�");
		//������ ��� �Ѱ��� ���������� ������ ���� �信���� ������ ��� �ִ� spring��ü
		ModelAndView mav = new ModelAndView();
		
		//���������� ����
		//request.setAttribute("msg","��������Ʈ�ѷ����� �ѱ� ������")
		mav.addObject("msg","��������Ʈ�ѷ����� �ѱ� ������");
		
		//forward�� ���� ������ ���� - �⺻�� forward.
		mav.setViewName("test/result");
		
		return mav;
	}

}