package com.naver.cafe.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.naver.cafe.common.Auth;
import com.naver.cafe.common.SessionUtil;
import com.naver.cafe.menu.biz.MenuBiz;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	private MenuBiz menuBiz;

	public void setMenuBiz(MenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String user = (String) SessionUtil.get(request, "_USER_");
		
		System.out.println("==============================================");
		System.out.println(user+ "=======================================");
		
		logger.info("getRequestURI" + request.getRequestURI());
		logger.info("getRequestURL" + request.getRequestURL().toString());

		/**
		 * 방법 1.annotation을 생성하여 controller url별로 auth를 등록한후 사용한다.
		 */
		HandlerMethod controller = null;
		
		if (handler instanceof HandlerMethod) {

			controller = (HandlerMethod) handler;

			// @Auth에 있는 값을 가져옴
			Auth auth = controller.getMethodAnnotation(Auth.class);

			if (auth != null) {
				// String authValue = auth.value();
				String[] authValue = auth.value(); // 여러권한을 등록해서 체크할수있게
													// annotation을 변경해보자

				String myAuth = "USR";
				// 내권한이 Admin이면 다 볼수 있으므로 true바로 리턴
				if (myAuth.equals("ADM")) {
					return true;
				}
				// 그게 아니면..
				// 접근할 권한과 비교해서 같으면 볼수 있도록
				// auth annotation 이 배열이 아닌경우
				/*
				if (myAuth.equals(authValue)) { 
					return true; 
				} 
				else { 
					throw  new RuntimeException("접근 권한이 없습니다."); 
				}
				 */
				// 권한을 배열로 변경해보자 여러 권한을 체크할수 있게..
				boolean isPath = true;
				for (String registAuth : authValue) {
					logger.info("registAuth: " + registAuth);
					if (myAuth.equals(registAuth)) {
						isPath = true;
						break;
					} else {
						throw new RuntimeException("접근 권한이 없습니다.");
						//isPath = false;
						// throw new RuntimeException("접근 권한이 없습니다.");
					}
				}
				return isPath;
			}
		}
		return true;
/**
 * 방법2. 모든 page의 url과 접근 권한을 db에 넣어놓고 (ex:PGATH) RequestMapping에 적었던 url을
 * 가져와서 그 url들을 db값과 비교함 해당 url별 auth가 등록되어 있으므로 비교 하여 체크
 */
/*	//controller에 @RequestMapping("") url가져오기
 *  HandlerMethod controller = (HandlerMethod) handler;
	RequestMapping mapping = controller.getMethodAnnotation(RequestMapping.class);
	logger.info("mapping" + mapping.value()[0]);
	MenuSearchVO menuSearchVO = new MenuSearchVO();
		// menuSearchVO.setAuth("USR");

		List<MenuVO> menuList = menuBiz.getAllMenu(menuSearchVO);

		for (MenuVO menuVO : menuList) {
			// 접속한 url이 menu테이블에 등록된건지 확인
			if (request.getRequestURI().equals("/cafe" + menuVO.getMenuUrl())) {
				// 등록된 URL은 있다면 권한이 맞는지 확인
				if ("USR".equals(menuVO.getAuth())) {
					return true;
				} else {
					// 권한이 다르면 실행 못하게 함 다른 page로 redirect함
					// response.sendRedirect("/cafe"); return false;
					throw new RuntimeException("페이지에 접근할 권한이 없습니다.");
				}
			}
		}
		// false : controller를 수행하지 말아라// true: 수행해라
		return true;
*/
	}
}
